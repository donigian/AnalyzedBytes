package analyzedbytescom.fixtures;

import analyzedbytescom.Bizcast;
import analyzedbytescom.Context;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by arm on 12/5/16.
 */
public class GivenBizcasts {
    private String title;
    private String publicationDate;
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublished(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public void execute() throws ParseException {
        Bizcast bizcast = new Bizcast();
        bizcast.setTitle(title);
//        System.out.println(publicationDate);
//        System.out.println(dateFormat.parse(publicationDate));
        bizcast.setPublicationDate(dateFormat.parse(publicationDate));
        Context.gateway.save(bizcast);
    }
}
