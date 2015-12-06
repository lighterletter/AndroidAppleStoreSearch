package lighterletter.c4q.finalandroidproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by c4q-john on 12/5/15.
 */
public class TrackAdapter extends BaseAdapter {
    private Context mContext;
    private List<Track> mTracks;

    public TrackAdapter(Context context, List<Track> tracks){
        mContext = context;
        mTracks = tracks;
    }

    @Override
    public int getCount(){
        return mTracks.size();
    }

    @Override
    public Track getItem(int position){
        return mTracks.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        Track track = getItem(position);

        ViewHolder holder;
        if (convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.track_list_row,parent,false);
            holder = new ViewHolder();
            holder.trackImageView = (ImageView) convertView.findViewById(R.id.track_image);
            holder.titleTextView = (TextView) convertView.findViewById(R.id.track_title);
            holder.artist_name = (TextView) convertView.findViewById(R.id.artist_name);


            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.titleTextView.setText(track.getTrackName());
        holder.artist_name.setText(track.getArtistName());
        //Trigger download asynchonously into the image view.
        Picasso.with(mContext).load(track.getArtworkUrl100()).into(holder.trackImageView);

        return convertView;

    }

    static class ViewHolder {
        ImageView trackImageView;
        TextView titleTextView;
        TextView artist_name;

    }
}
