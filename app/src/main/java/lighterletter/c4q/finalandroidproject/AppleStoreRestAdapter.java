package lighterletter.c4q.finalandroidproject;

/**
 * Created by c4q-john on 12/5/15.
 */
public class AppleStoreRestAdapter {

    private static final retrofit.RestAdapter REST_ADAPTER = new retrofit.RestAdapter.Builder().setEndpoint(Config.API_URL).build();
    private static final AppleStoreService SERVICE = REST_ADAPTER.create(AppleStoreService.class);
    public static AppleStoreService getService(){
        return SERVICE;
    }

}
