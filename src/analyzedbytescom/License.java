package analyzedbytescom;

import sun.jvm.hotspot.utilities.BitMap;

/**
 * Created by arm on 12/5/16.
 */
public class License {
    private User user;
    private Bizcast bizcast;

    public License(User user, Bizcast bizcast) {
        this.user = user;
        this.bizcast = bizcast;
    }

    public User getUser() {
        return user;
    }

    public Bizcast getBizcast() {
        return bizcast;
    }
}

