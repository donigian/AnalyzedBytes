package analyzedbytescom.fixtures;


import analyzedbytescom.PresentBizcastUseCase;
import analyzedbytescom.PresentableBizcast;
import analyzedbytescom.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by arm on 12/6/16.
 */
public class OfBizcasts {
    private List<Object> list(Object... objects) {
        return Arrays.asList(objects);
    }

    public List<Object> query() {
        User loggedInUser = BizcastPresentation.gateKeeper.getLoggedInUser();
        PresentBizcastUseCase useCase = new PresentBizcastUseCase();
        List<PresentableBizcast> presentableCodecasts = useCase.presentBizcasts(loggedInUser);
        List<Object> queryResponse = new ArrayList<Object>();
        for (PresentableBizcast pbz : presentableCodecasts)
            queryResponse.add(makeRow(pbz.title, pbz.title, pbz.title, pbz.isViewable, false));
        return queryResponse;

    }

    private List<Object> makeRow(String title, String picture, String description, boolean viewable, boolean downloadable) {
        return list(
                new Object[]{list("title", title),
                        list("picture", picture),
                        list("description", description),
                        list("viewable", viewable ? "+" : "-"),
                        list("downloadable", downloadable ? "+" : "-")}
        );
    }
}
