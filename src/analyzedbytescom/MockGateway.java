package analyzedbytescom;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arm on 12/5/16.
 */
public class MockGateway implements Gateway {

    private ArrayList<Bizcast> bizcasts;

    public MockGateway() {
        bizcasts = new ArrayList<Bizcast>();
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
}
