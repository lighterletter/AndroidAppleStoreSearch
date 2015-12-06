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
public class ItemAdapter extends BaseAdapter {
    private Context mContext;
    private List<SearchItem> mSearchItems;

    public ItemAdapter(Context context, List<SearchItem> searchItems) {
        mContext = context;
        mSearchItems = searchItems;
    }

    @Override
    public int getCount() {
        return mSearchItems.size();
    }

    @Override
    public SearchItem getItem(int position) {
        return mSearchItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        SearchItem searchItem = getItem(position);

        ViewHolder holder;
        if (convertView == null) {

            convertView = LayoutInflater.from(mContext).inflate(R.layout.track_list_row, parent, false);
            holder = new ViewHolder();
            holder.trackImageView = (ImageView) convertView.findViewById(R.id.track_image);
            holder.titleTextView = (TextView) convertView.findViewById(R.id.track_title);
            holder.artist_name = (TextView) convertView.findViewById(R.id.artist_name);
            holder.collectionName = (TextView) convertView.findViewById(R.id.collection_title);
            convertView.setTag(holder);

        } else {

            holder = (ViewHolder) convertView.getTag();

        }

        holder.titleTextView.setText(searchItem.getTrackName());
        holder.artist_name.setText(searchItem.getArtistName());
        holder.collectionName.setText(searchItem.getCollectionName());
        //Trigger download asynchonously into the image view.
        Picasso.with(mContext).load(searchItem.getArtworkUrl100()).into(holder.trackImageView);

        return convertView;

    }

    static class ViewHolder {

        ImageView trackImageView;
        TextView titleTextView;
        TextView artist_name;
        TextView collectionName;

    }
}
