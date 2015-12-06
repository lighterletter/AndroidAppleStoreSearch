package lighterletter.c4q.finalandroidproject;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "MainActivity";
    private List<SearchItem> mlistItems;
    private ItemAdapter mAdapter;

    EditText searchTerm;
    String mediaType = "all";
    String mediaQuery = "all";
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(mediaType);


        mlistItems = new ArrayList<SearchItem>();
        ListView listView = (ListView) findViewById(R.id.track_list_view);
        mAdapter = new ItemAdapter(this, mlistItems);
        listView.setAdapter(mAdapter);


        searchTerm = (EditText) findViewById(R.id.search_field);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (searchTerm != null) {
                    mediaQuery = searchTerm.getText().toString();
                    if (!mediaQuery.equals(null)) {
                        makeCall(mediaType, mediaQuery);
                    }
                }
            }
        });
        makeCall(mediaType, mediaQuery);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    public void makeCall(String mediaType, String mediaQuery) {

        ITunesService SCservice = ITunesRestAdapter.getService();
        SCservice.getRecentTracks(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()),
                mediaType,
                mediaQuery,
                new Callback<QueryResponse>() {
                    @Override
                    public void success(QueryResponse queryResponse, Response response) {
                        List<SearchItem> searchItems = queryResponse.getResults();
                        loadTracks(searchItems);
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Log.d(TAG, "RF Error: " + error);
                    }
                });

    }

    private void loadTracks(List<SearchItem> searchItems) {
        mlistItems.clear();
        mlistItems.addAll(searchItems);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            mediaType = "music";
            makeCall(mediaType, mediaQuery);
            this.toolbar.setTitle("Bumpin Beats!");

        } else if (id == R.id.nav_gallery) {
            mediaType = "software";
            makeCall(mediaType, mediaQuery);
            toolbar.setTitle("Download All The Things!");

        } else if (id == R.id.nav_slideshow) {
            mediaType = "movie";
            makeCall(mediaType, mediaQuery);
            toolbar.setTitle("Such Drama Wow!");

        } else if (id == R.id.nav_manage) {
            mediaType = "podcast";
            makeCall(mediaType, mediaQuery);
            toolbar.setTitle("People Talking!");

        } else if (id == R.id.nav_share) {
            mediaType = "audiobook";
            makeCall(mediaType, mediaQuery);
            toolbar.setTitle("Longest Songs Ever!");

        } else if (id == R.id.nav_send) {
            mediaType = "tvShow";
            makeCall(mediaType, mediaQuery);
            toolbar.setTitle("Watch All The Things!");

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
