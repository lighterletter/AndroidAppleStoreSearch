package lighterletter.c4q.finalandroidproject;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by c4q-john on 12/5/15.
 */
public interface SoundCloudService {
    @GET("/search?media=" + Config.media_type + "&term=" + Config.searchTerm)
    public void getRecentTracks(@Query("created_at[from]")String date, Callback<QueryResponse> cb);
}
