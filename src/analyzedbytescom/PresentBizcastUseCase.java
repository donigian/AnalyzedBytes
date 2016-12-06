package analyzedbytescom;

import analyzedbytescom.fixtures.BizcastPresentation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arm on 12/5/16.
 */
public class PresentBizcastUseCase {
    public List<PresentableBizcast> presentBizcasts(User loggedInUser) {
        return new ArrayList<PresentableBizcast>();
    }

    public boolean isLicensedToViewBizcast(User user, Bizcast bizcast) {
        List<License> licenses = Context.gateway.findAllLicensesForUserAndBizcast(user, bizcast);
        return !licenses.isEmpty();
    }
}

