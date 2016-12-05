package analyzedbytescom.fixtures;

import analyzedbytescom.Bizcast;
import analyzedbytescom.Context;
import analyzedbytescom.MockGateway;

/**
 * Created by arm on 12/5/16.
 */
public class GivenBizcasts {
    private String title;
    private String publicationDate;
    private MockGateway mockGateway = new MockGateway();

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublished(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public void execute() {
        Bizcast bizcast = new Bizcast();
        bizcast.setTitle(title);
        bizcast.setPublicationDate(publicationDate);
//      Context.gateway.save(bizcast);
        mockGateway.save(bizcast);
    }
}
