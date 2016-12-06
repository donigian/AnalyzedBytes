package analyzedbytescom;

import java.util.*;

/**
 * Created by arm on 12/5/16.
 */
public class MockGateway implements Gateway {

    private ArrayList<Bizcast> bizcasts;
    private ArrayList<User> users;
    private ArrayList<License> licenses;

    public MockGateway() {
        bizcasts = new ArrayList<Bizcast>();
        users = new ArrayList<User>();
        licenses = new ArrayList<License>();
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
        establishId(user);
        users.add(user);
    }

    private void establishId(User user) {
        if (user.getId() == null) {
            user.setId(UUID.randomUUID().toString());
        }
    }

    public void save(License license) {
        licenses.add(license);
    }

    public User findUser(String username) {
        for (User user: users) {
            if (user.getUserName().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public Bizcast findBizcastByTitle(String bizcastTitle) {
        for (Bizcast bizcast : bizcasts) {
            if (bizcast.getTitle().equals(bizcastTitle)) {
                return bizcast;
            }
        }
        return null;
    }

    public List<License> findAllLicensesForUserAndBizcast(User user, Bizcast bizcast) {
        List<License> results = new ArrayList<License>();
        for(License license : licenses){
            if (license.getUser().isSame(user) && license.getBizcast().isSame(bizcast)) {
                results.add(license);
            }
        }
        return results;
    }
}
