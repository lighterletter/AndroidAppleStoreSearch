package lighterletter.c4q.finalandroidproject;

import retrofit.RestAdapter;

/**
 * Created by c4q-john on 12/5/15.
 */
public class ITunesRestAdapter {

    private static final retrofit.RestAdapter REST_ADAPTER = new retrofit.RestAdapter.Builder().setEndpoint(Config.API_URL).build();
    private static final ITunesService SERVICE = REST_ADAPTER.create(ITunesService.class);
    public static ITunesService getService(){
        return SERVICE;
    }

}
