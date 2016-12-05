package analyzedbytescom;

import java.io.Serializable;

/**
 * Created by arm on 12/5/16.
 */
public class Bizcast {
    private Serializable title;
    private String publicationDate;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }
}

