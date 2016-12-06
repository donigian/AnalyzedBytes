package analyzedbytescom;

import analyzedbytescom.User;

/**
 * Created by arm on 12/5/16.
 */
public class GateKeeper {
    private User loggedInUser;

    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }
}
