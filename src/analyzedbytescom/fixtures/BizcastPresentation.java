package analyzedbytescom.fixtures;

import analyzedbytescom.*;

import java.util.ArrayList;
import java.util.List;

import static analyzedbytescom.Context.gateway;

/**
 * Created by arm on 12/5/16.
 */
public class BizcastPresentation {
    private PresentBizcastUseCase useCase = new PresentBizcastUseCase();

    private GateKeeper gateKeeper = new GateKeeper();

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

    public boolean createLicenseForViewing(String user, String bizcast) {
        return false;
    }

    public String presentationUser() {
        return gateKeeper.getLoggedInUser().getUserName();
    }

    public boolean clearBizcasts() {
        List<Bizcast> bizcasts = Context.gateway.findAllBizcasts();
        for (Bizcast bizcast : new ArrayList<Bizcast>(bizcasts)) {
            Context.gateway.delete(bizcast);
        }
        return Context.gateway.findAllBizcasts().size() == 0;
    }

    public int countOfBizcastsPresented() {
        List<PresentableBizcast> presentations = useCase.presentBizcasts(gateKeeper.getLoggedInUser());
        return presentations.size();
    }
}
