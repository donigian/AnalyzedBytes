package analyzedbytescom.fixtures;

import analyzedbytescom.*;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by arm on 12/5/16.
 */
public class PresentBizCastUseCaseTest {

    private PresentBizcastUseCase useCase;
    private User user;
    private Bizcast bizcast;

    @Before
    public void setUp() {
        Context.gateway = new MockGateway();
        bizcast = new Bizcast();
        user = new User("User");
        useCase = new PresentBizcastUseCase();
    }

    @Test
    public void userWithoutViewLicense_cannotViewBizcast() throws Exception {
        assertFalse(useCase.isLicensedToViewBizcast(user, bizcast));
    }

    @Test
    public void userWithViewLicense_canViewBizcast() throws Exception {
        License viewLicense = new License(user, bizcast);
        Context.gateway.save(viewLicense);
        assertTrue(useCase.isLicensedToViewBizcast(user, bizcast));
    }

    @Test
    public void userWithViewLicense_canntViewOtherUsersBizcast() throws Exception {
        User otherUser = new User("OtherUser");
        Context.gateway.save(otherUser);

        License viewLicense = new License(user, bizcast);
        Context.gateway.save(viewLicense);
        assertFalse(useCase.isLicensedToViewBizcast(otherUser, bizcast));
    }

}
