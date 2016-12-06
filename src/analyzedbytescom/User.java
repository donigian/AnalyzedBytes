package analyzedbytescom;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by arm on 12/5/16.
 */
public class User {
    private final String userName;
    private String id;

    public User(String username) {
        this.userName = username;
    }

    public String getUserName() {
        return userName;
    }

    public boolean isSame(User user) {
        return Objects.equals(id, user.id);
    }

    public void setId(String id) {

        this.id = id;
    }

    public String getId() {
        return id;
    }
}
