package analyzedbytescom.fixtures;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by arm on 12/5/16.
 */
public class BizcastPresentationTest {

    @Test
    public void clearBizcasts() throws Exception {
        BizcastPresentation bizcastPresentation = new BizcastPresentation();
        bizcastPresentation.clearBizcasts();
    }

}