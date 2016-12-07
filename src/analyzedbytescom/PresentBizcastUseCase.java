package analyzedbytescom;

import analyzedbytescom.fixtures.BizcastPresentation;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static analyzedbytescom.License.LicenseType.*;

/**
 * Created by arm on 12/5/16.
 */
public class PresentBizcastUseCase {
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("M/dd/yyyy");

    public List<PresentableBizcast> presentBizcasts(User loggedInUser) {
        ArrayList<PresentableBizcast> presentableBizcasts = new ArrayList<PresentableBizcast>();
        List<Bizcast> allBizcasts = Context.gateway.findAllBizcastsSortedChronologically();
        for (Bizcast bizcast : allBizcasts)
            presentableBizcasts.add(formatCodecast(loggedInUser, bizcast));

        return presentableBizcasts;
    }


    private PresentableBizcast formatCodecast(User loggedInUser, Bizcast bizcast) {
        PresentableBizcast cc = new PresentableBizcast();
        cc.title = bizcast.getTitle();
        cc.publicationDate = dateFormat.format(bizcast.getPublicationDate());
        cc.isViewable = isLicensedFor(VIEWING, loggedInUser, bizcast);
        cc.isDownloadable = isLicensedFor(DOWNLOADING, loggedInUser, bizcast);
        return cc;
    } 

    public boolean isLicensedFor(License.LicenseType licenseType, User user, Bizcast codecast) {
        List<License> licenses = Context.gateway.findLicensesForUserAndBizcast(user, codecast);
        for (License l : licenses) {
            if (l.getType() == licenseType)
                return true;
        }
        return false;
    }
}

