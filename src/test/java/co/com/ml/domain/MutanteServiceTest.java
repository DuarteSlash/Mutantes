package co.com.ml.domain;

import co.com.ml.utils.Utilities;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;


import java.io.IOException;


public class MutanteServiceTest {

    @Autowired
    MutanteService mutanteService;

    @Mock
    MutantValidHorizontal mutantValidHorizontal;

    @Autowired
    MutantValidVertical mutantValidVertical;

    @Autowired
    MutantValidTransversal mutantValidTransversal ;

    @Mock
    Utilities utilities;


    public MutanteServiceTest() throws IOException {
        mutanteService = new MutanteService();
        mutantValidHorizontal = new MutantValidHorizontal();
        mutantValidVertical = new MutantValidVertical();
        mutantValidTransversal = new MutantValidTransversal();
    }

        @Test
        public void WhenNosequencetestisMutant() {
            String[] dna = {"ATGCGA","AAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
            boolean valid = true;
            Boolean mutante = mutanteService.isMutant(dna);
            Assert.assertTrue(mutante);
        }

    @Test
    public void WhenErrorsequencetestisMutant() {
        String[] dna = {"ATGCGA","AAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        boolean valid = true;
        Boolean mutante = mutanteService.isMutant(dna);
    }




}
