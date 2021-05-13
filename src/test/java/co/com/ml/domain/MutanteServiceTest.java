package co.com.ml.domain;

import co.com.ml.domain.MutantValidHorizontal;
import co.com.ml.domain.MutantValidTransversal;
import co.com.ml.domain.MutantValidVertical;
import co.com.ml.domain.MutanteService;
import co.com.ml.utils.Utilities;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;


import java.io.IOException;
import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;


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
