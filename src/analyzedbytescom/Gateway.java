package analyzedbytescom;

import java.util.List;

/**
 * Created by arm on 12/5/16.
 */
public interface Gateway {
    List<Bizcast> findAllBizcasts();

    void delete(Bizcast bizcast);

    void save(Bizcast bizcast);

    void save(User user);

    User findUser(String username);

}
