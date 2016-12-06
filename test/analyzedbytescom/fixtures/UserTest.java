package analyzedbytescom.fixtures;

import analyzedbytescom.User;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by arm on 12/5/16.
 */
public class UserTest {
    @Test
    public void twoDiffUsersAreNotTheSame() throws  Exception {
        User u1 = new User("u1");
        User u2 = new User("u2");

        u1.setId("u1ID");
        u2.setId("u2ID");

        assertFalse(u1.isSame(u2));
    }

    @Test
    public void oneUserIsTheSameAsItself() throws Exception {
        User u1 = new User("u1");
        assertTrue(u1.isSame(u1));
    }

    @Test
    public void usersWithTheSameIdAreTheSame() throws Exception {
        User u1 = new User("u1");
        User u2 = new User("u2");

        u1.setId("u1ID");
        u2.setId("u1ID");

        assertTrue(u1.isSame(u2));
    }
}
