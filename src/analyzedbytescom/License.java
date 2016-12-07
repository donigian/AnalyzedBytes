package analyzedbytescom;

/**
 * Created by arm on 12/5/16.
 */
public class License extends Entity {

    public enum LicenseType {DOWNLOADING, VIEWING}

    private User user;
    private Bizcast bizcast;
    private LicenseType type;

    public License(LicenseType type, User user, Bizcast bizcast) {
        this.user = user;
        this.bizcast = bizcast;
        this.type = type;
    }

    public LicenseType getType() {
        return type;
    }

    public User getUser() {
        return user;
    }

    public Bizcast getBizcast() {
        return bizcast;
    }

}

