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

    public List<Bizcast> findAllBizcastsSortedChronologically(){
        List<Bizcast> sortedBizcasts = new ArrayList<Bizcast>(bizcasts);
        Collections.sort(sortedBizcasts, new Comparator<Bizcast>() {
            public int compare(Bizcast o1, Bizcast o2) {
                return o1.getPublicationDate().compareTo(o2.getPublicationDate());
            }
        });
        return sortedBizcasts;
    }

    public void delete(Bizcast bizcast) {
        bizcasts.remove(bizcast);
    }

    public Bizcast save(Bizcast bizcast) {
        bizcasts.add((Bizcast)establishId(bizcast));
        return bizcast;
    }

    public User save(User user) {
        users.add((User)establishId(user));
        return user;
    }

    private Entity establishId(Entity entity) {
        if (entity.getId() == null)
            entity.setId(UUID.randomUUID().toString());
        return entity;
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

    public List<License> findLicensesForUserAndBizcast(User user, Bizcast bizcast) {
        List<License> results = new ArrayList<License>();
        for(License license : licenses){
            if (license.getUser().isSame(user) && license.getBizcast().isSame(bizcast)) {
                results.add(license);
            }
        }
        return results;
    }
}
