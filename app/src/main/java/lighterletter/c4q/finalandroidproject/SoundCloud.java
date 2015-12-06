package lighterletter.c4q.finalandroidproject;

import retrofit.RestAdapter;

/**
 * Created by c4q-john on 12/5/15.
 */
public class SoundCloud {

    private static final RestAdapter REST_ADAPTER = new RestAdapter.Builder().setEndpoint(Config.API_URL).build();
    private static final SoundCloudService SERVICE = REST_ADAPTER.create(SoundCloudService.class);

    public static SoundCloudService getService(){
        return SERVICE;
    }
}
