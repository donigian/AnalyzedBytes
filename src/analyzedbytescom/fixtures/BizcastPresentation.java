package analyzedbytescom.fixtures;

import analyzedbytescom.*;

import java.util.ArrayList;
import java.util.List;

import static com.sun.applet2.preloader.event.DownloadEvent.DOWNLOADING;

/**
 * Created by arm on 12/5/16.
 */
public class BizcastPresentation {
    private PresentBizcastUseCase useCase = new PresentBizcastUseCase();

    public static GateKeeper gateKeeper = new GateKeeper();

    public BizcastPresentation(){
        Context.gateway = new MockGateway();
    }

    public boolean addUser(String username) {
        Context.gateway.save(new User(username));
        return true;
    }

    public boolean loginUser(String username) {
        User user = Context.gateway.findUser(username);
        if(user != null) {
            gateKeeper.setLoggedInUser(user);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean createLicenseForViewing(String username, String bizcastTitle) {
        User user = Context.gateway.findUser(username);
        Bizcast bizcast = Context.gateway.findBizcastByTitle(bizcastTitle);
        License license = new License(License.LicenseType.VIEWING, user, bizcast);
        Context.gateway.save(license);
        return useCase.isLicensedFor(License.LicenseType.VIEWING, user, bizcast);
    }

    public boolean createLicenseForDownloading(String username, String codecastTitle) {
        User user = Context.gateway.findUser(username);
        Bizcast codecast = Context.gateway.findBizcastByTitle(codecastTitle);
        License license = new License(License.LicenseType.DOWNLOADING, user, codecast);
        Context.gateway.save(license);
        return useCase.isLicensedFor(License.LicenseType.DOWNLOADING, user, codecast);
    }

    public String presentationUser() {
        return gateKeeper.getLoggedInUser().getUserName();
    }

    public boolean clearBizcasts() {
        List<Bizcast> bizcasts = Context.gateway.findAllBizcastsSortedChronologically();
        for (Bizcast bizcast : new ArrayList<Bizcast>(bizcasts)) {
            Context.gateway.delete(bizcast);
        }
        return Context.gateway.findAllBizcastsSortedChronologically().size() == 0;
    }

    public int countOfBizcastsPresented() {
        List<PresentableBizcast> presentations = useCase.presentBizcasts(gateKeeper.getLoggedInUser());
        return presentations.size();
    }
}
