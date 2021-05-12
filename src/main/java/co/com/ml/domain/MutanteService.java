package co.com.ml.domain;

import org.springframework.stereotype.Service;

@Service
public class MutanteService implements IMutanteService {

    @Override
    public boolean isMutant(String[] dna) {
        Boolean isMutant = false;
        MutantValidHorizontal mutantValidHorizontal = new MutantValidHorizontal();
        MutantValidVertical mutantValidVertical = new MutantValidVertical();
        MutantValidTransversal mutantValidTransversal = new MutantValidTransversal();

        if(mutantValidHorizontal.validHorizontalDNA(dna) || mutantValidVertical.validVerticalDNA(dna)
                || mutantValidTransversal.validTransversalDNA(dna)){
            isMutant = true;
        }

        return isMutant;
    }

}
