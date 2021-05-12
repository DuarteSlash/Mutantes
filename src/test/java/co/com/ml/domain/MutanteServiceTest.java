package co.com.ml.domain;

import junit.framework.TestCase;
import org.junit.Test;
import org.mockito.InjectMocks;

public class MutanteServiceTest extends TestCase {

    @InjectMocks
    MutanteService mutanteService;

    @Test
    public void testIsMutant() {
        String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAAG","CGCCTA","TCACTG"};
        mutanteService.isMutant(dna);
    }
}