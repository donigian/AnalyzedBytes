package analyzedbytescom;

import java.sql.Timestamp;

/**
 * Created by arm on 12/5/16.
 */
public class User {
    private final String userName;

    public User(String username) {
        this.userName = username;
    }

    public String getUserName() {
        return userName;
    }
}
