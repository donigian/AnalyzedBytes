package analyzedbytescom;

import analyzedbytescom.fixtures.BizcastPresentation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arm on 12/5/16.
 */
public class PresentBizcastUseCase {
    public List<PresentableBizcast> presentBizcasts(User loggedInUser) {
        ArrayList<PresentableBizcast> presentableBizcasts = new ArrayList<PresentableBizcast>();
        List<Bizcast> allBizcasts = Context.gateway.findAllBizcasts();

        for (Bizcast bizcast : allBizcasts) {
            PresentableBizcast bc = new PresentableBizcast();
            bc.title = bizcast.getTitle();
            bc.publicationDate = bizcast.getPublicationDate();
            bc.isViewable = isLicensedToViewBizcast(loggedInUser, bizcast);
            presentableBizcasts.add(bc);
        }

        return presentableBizcasts;
    }

    public boolean isLicensedToViewBizcast(User user, Bizcast bizcast) {
        List<License> licenses = Context.gateway.findLicensesForUserAndBizcast(user, bizcast);
        return !licenses.isEmpty();
    }
}

