package co.com.ml.domain;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class MutanteMainTest {

    @InjectMocks
    MutanteMain mutanteMain;

    @Mock
    MutanteService mutanteService;

    @Test
    public void testMain() {
        String[] args = new String[0];
        mutanteMain.main(args);
        Assert.assertNotNull(args);
    }
}