package analyzedbytescom.fixtures;

import analyzedbytescom.Entity;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by arm on 12/5/16.
 */
public class EntityTest {
    @Test
    public void twoDiffUsersAreNotTheSame() throws  Exception {
        Entity e1 = new Entity();
        Entity e2 = new Entity();

        e1.setId("u1ID");
        e2.setId("u2ID");


        assertFalse(e1.isSame(e2));
    }

    @Test
    public void oneUserIsTheSameAsItself() throws Exception {
        Entity e1 = new Entity();
        e1.setId("e1ID");
        assertTrue(e1.isSame(e1));
    }

    @Test
    public void usersWithTheSameIdAreTheSame() throws Exception {
        Entity e1 = new Entity();
        Entity e2 = new Entity();

        e1.setId("u1ID");
        e2.setId("u1ID");

        assertTrue(e1.isSame(e2));
    }

    @Test
    public void usersWithNullIdsAreNeverSame() throws Exception {
        Entity e1 = new Entity();
        Entity e2 = new Entity();
        assertFalse(e1.isSame(e2));

    }
}
