package analyzedbytescom;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by arm on 12/5/16.
 */
public class Bizcast extends Entity {
    private String title;
    private Date publicationDate = new Date();

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getTitle() {
        return title;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }
}

