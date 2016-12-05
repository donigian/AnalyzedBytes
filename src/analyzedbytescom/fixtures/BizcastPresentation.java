package analyzedbytescom.fixtures;

import analyzedbytescom.Bizcast;
import analyzedbytescom.Context;
import analyzedbytescom.MockGateway;

import java.util.ArrayList;
import java.util.List;

import static analyzedbytescom.Context.gateway;

/**
 * Created by arm on 12/5/16.
 */
public class BizcastPresentation {

    public BizcastPresentation(){
        Context.gateway = new MockGateway();
    }
    public boolean loginUser(String username) {
        return false;
    }

    public boolean createLicenseForViewing(String user, String bizcast) {
        return false;
    }

    public String presentationUser() {
        return "TILT";
    }

    public boolean clearBizcasts() {
        List<Bizcast> bizcasts = Context.gateway.findAllBizcasts();
        for (Bizcast bizcast : new ArrayList<Bizcast>(bizcasts)) {
            Context.gateway.delete(bizcast);
        }
        return Context.gateway.findAllBizcasts().size() == 0;
    }

    public int countOfBizcastsPresented() {
        return -1;
    }
}
