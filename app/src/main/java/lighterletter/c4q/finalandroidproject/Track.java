package lighterletter.c4q.finalandroidproject;

import com.google.gson.annotations.SerializedName;

/**
 * Created by c4q-john on 12/5/15.
 */
public class Track {
    private String artistName;
    private String trackId;
    private String artistViewUrl;
    private String artworkUrl100;
    private String trackName;

    public String getTrackName() {
        return trackName;
    }

    public String getArtistName() {
        return artistName;
    }
    public String getTrackId() {
        return trackId;
    }
    public String getArtistViewUrl() {
        return artistViewUrl;
    }
    public String getArtworkUrl100() {
        return artworkUrl100;
    }

}
