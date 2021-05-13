import co.com.ml.domain.MutantValidHorizontal;
import co.com.ml.domain.MutantValidTransversal;
import co.com.ml.domain.MutantValidVertical;
import co.com.ml.domain.MutanteService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;


public class MutanteServiceTest {

    @InjectMocks
    MutanteService mutanteService;

    @Mock
    MutantValidHorizontal mutantValidHorizontal;

    @Mock
    MutantValidVertical mutantValidVertical;

    @Mock
    MutantValidTransversal mutantValidTransversal;

    public MutanteServiceTest(){
        mutantValidHorizontal = new MutantValidHorizontal();
        mutantValidVertical = new MutantValidVertical();
        mutantValidTransversal = new MutantValidTransversal();
    }

        @Test
        public void WhenNosequencetestisMutant() {
            String[] dna = {"ATGCGA","AAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
            boolean valid = true;
            when(mutantValidHorizontal.validHorizontalDNA(dna)).thenReturn(valid);


            Boolean mutante = mutanteService.isMutant(dna);

            Assert.assertTrue(mutante);
        }

    @Test
    public void WhenNosequenceVerticaltestisMutant() {
        String[] dna = {"ATGCGA","AAGTGC","TTATGT","AGAAGG","CCACTA","TCACTG"};

        when(mutantValidVertical.validVerticalDNA(dna)).thenCallRealMethod();


        Boolean mutante = mutanteService.isMutant(dna);

        Assert.assertTrue(mutante);
    }

    @Test
    public void WhenNosequenceTransversaltestisMutant() {
        String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAAG","CGCCTA","TCACTG"};

        when(mutantValidTransversal.validTransversalDNA(dna)).thenCallRealMethod();

        Boolean mutante = mutanteService.isMutant(dna);

        Assert.assertTrue(mutante);
    }


    @Test
    public void WhenSequenceFirsttestisMutant() {
        String[] dna = {"ATGCGA","AAGTGC","TTATGT","AGAAGG","CCACTA","TCACTG"};
        when(mutanteService.isMutant(dna)).thenReturn(true);

    }

}
