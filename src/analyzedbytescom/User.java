package analyzedbytescom;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by arm on 12/5/16.
 */
public class User extends Entity {
    private final String userName;

    public User(String username) {
        this.userName = username;
    }

    public String getUserName() {
        return userName;
    }

}
