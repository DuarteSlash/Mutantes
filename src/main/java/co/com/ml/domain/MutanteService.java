package co.com.ml.domain;

import org.springframework.stereotype.Service;

@Service
public class MutanteService implements IMutanteService {

    @Override
    public boolean isMutant(String[] dna) throws RuntimeException{
        try {
            Boolean isMutant;
            MutantValidHorizontal mutantValidHorizontal = new MutantValidHorizontal();
            MutantValidVertical mutantValidVertical = new MutantValidVertical();
            MutantValidTransversal mutantValidTransversal = new MutantValidTransversal();
            isMutant = mutantValidHorizontal.validHorizontalDNA(dna) || mutantValidVertical.validVerticalDNA(dna)
                    || mutantValidTransversal.validTransversalDNA(dna);
            return isMutant;
        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }
        return false;
    }

}
