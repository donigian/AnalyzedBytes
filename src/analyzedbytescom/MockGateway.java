package analyzedbytescom;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arm on 12/5/16.
 */
public class MockGateway implements Gateway {

    private ArrayList<Bizcast> bizcasts;
    public ArrayList<User> users;

    public MockGateway() {
        bizcasts = new ArrayList<Bizcast>();
        users = new ArrayList<User>();
    }

    public List<Bizcast> findAllBizcasts() {
        return bizcasts;
    }

    public void delete(Bizcast bizcast) {
        bizcasts.remove(bizcast);
    }

    public void save(Bizcast bizcast) {
        bizcasts.add(bizcast);
    }

    public void save(User user) {
        users.add(user);
    }

    public User findUser(String username) {
        for (User user: users) {
            if (user.getUserName().equals(username)) {
                return user;
            }
        }
        return null;
    }
}
