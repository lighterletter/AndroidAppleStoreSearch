package lighterletter.c4q.finalandroidproject;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by c4q-john on 12/5/15.
 */
public interface ITunesService {

    @GET("/search")
    public void getRecentTracks(@Query("created_at[from]") String date,
                                @Query("media") String mediaType,
                                @Query("term") String searchTerm,
                                Callback<QueryResponse> cb);

}
