package co.com.ml.domain;

import junit.framework.TestCase;
import org.junit.Test;

public class MutantTest extends TestCase {

    @Test
    public void testGetDna() {
        String[] dna= {};
        Mutant mutant = new Mutant();
        mutant.setDna(dna);
        assertNotNull(mutant);
        assertTrue(mutant.getDna().equals(dna));

    }
}