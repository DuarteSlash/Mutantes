package co.com.ml.adapter;

import co.com.ml.domain.Mutant;
import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class MutantControllerTest extends TestCase {

    @Autowired
    MutantController mutantController;

    @Autowired
    HttpServletResponse httpServletResponse;

    public void setUp() throws Exception {
        super.setUp();
        mutantController =new MutantController();

    }

    @Test
    public void testGetMutant() throws IOException {
        String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        Mutant mutant = new Mutant();
        mutant.setDna(dna);
        mutantController.getMutant(httpServletResponse,mutant);
    }
}