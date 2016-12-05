package analyzedbytescom.fixtures;

import analyzedbytescom.MockGateway;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by arm on 12/5/16.
 */
public class GivenBizcastsTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void execute() throws Exception {
        GivenBizcasts givenBizcasts = new GivenBizcasts();
        givenBizcasts.execute();
    }

}