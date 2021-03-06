package analyzedbytescom.fixtures;

import analyzedbytescom.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
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
        user = Context.gateway.save(new User("User"));
        bizcast = Context.gateway.save(new Bizcast());
        useCase = new PresentBizcastUseCase();
    }

    @Test
    public void userWithoutViewLicense_cannotViewBizcast() throws Exception {
        assertFalse(useCase.isLicensedFor(License.LicenseType.VIEWING, user, bizcast));
    }

    @Test
    public void userWithViewLicense_canViewBizcast() throws Exception {
        License viewLicense = new License(License.LicenseType.VIEWING, user, bizcast);
        Context.gateway.save(viewLicense);
        assertTrue(useCase.isLicensedFor(License.LicenseType.VIEWING, user, bizcast));
    }

    @Test
    public void userWithoutViewLicense_cannotViewOtherUsersBizcast() throws Exception {
        User otherUser = Context.gateway.save(new User("OtherUser"));

        License viewLicense = new License(License.LicenseType.VIEWING, user, bizcast);
        Context.gateway.save(viewLicense);
        assertFalse(useCase.isLicensedFor(License.LicenseType.VIEWING, otherUser, bizcast));
    }

    @Test
    public void presentingNoBizcasts() throws Exception {
        Context.gateway.delete(bizcast);
        List<PresentableBizcast> presentableBizcasts = useCase.presentBizcasts(user);
        assertEquals(0, presentableBizcasts.size());
    }

    @Test
    public void presentOneBizcast() throws Exception {
        bizcast.setTitle("Some Title");
        Date now = new GregorianCalendar(2014, 4, 19).getTime();
        bizcast.setPublicationDate(now);
        List<PresentableBizcast> presentableBizcasts = useCase.presentBizcasts(user);
        assertEquals(1, presentableBizcasts.size());
        PresentableBizcast presentableBizcast = presentableBizcasts.get(0);
        assertEquals("Some Title", presentableBizcast.title);
        assertEquals("5/19/2014", presentableBizcast.publicationDate);
    }

    @Test
    public void presentedBizcastIsNotViewableIfNoLicense() throws Exception {
        List<PresentableBizcast> presentableBizcasts = useCase.presentBizcasts(user);
        PresentableBizcast presentableBizcast = presentableBizcasts.get(0);
        assertFalse(presentableBizcast.isViewable);
    }

    @Test
    public void presentedBizcastIsViewableIfLicenseExists() throws Exception {
        Context.gateway.save(new License(License.LicenseType.VIEWING, user, bizcast));
        List<PresentableBizcast> presentableBizcasts = useCase.presentBizcasts(user);
        PresentableBizcast presentableBizcast = presentableBizcasts.get(0);
        assertTrue(presentableBizcast.isViewable);
    }

    @Test
    public void presentedBizcastIsDownloadableIfDownloadLicenseExists() {
        License downloadLicense = new License(License.LicenseType.DOWNLOADING,user, bizcast);
        Context.gateway.save(downloadLicense);
        List<PresentableBizcast> presentableBizcasts = useCase.presentBizcasts(user);
        PresentableBizcast presentableBizcast = presentableBizcasts.get(0);
        assertTrue(presentableBizcast.isDownloadable);
        assertFalse(presentableBizcast.isViewable);
    }
}
