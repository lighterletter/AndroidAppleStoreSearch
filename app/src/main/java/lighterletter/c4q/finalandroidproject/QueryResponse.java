package lighterletter.c4q.finalandroidproject;

import java.util.List;

/**
 * Created by c4q-john on 12/5/15.
 */
public class QueryResponse {
    private List<Track> results;
    private int resultCount;

    public List<Track> getResults() {
        return results;
    }

    public int getResultCount() {
        return resultCount;
    }
}
