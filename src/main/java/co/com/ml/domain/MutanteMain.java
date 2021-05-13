package co.com.ml.domain;

import java.io.IOException;

public class MutanteMain {
        public static void main(String[] args) throws IOException {

            String[] dna = {"ATGCGA","CTGTGC","TTATGT","AGAAAG","CGCCTA","TCACTG"};

            //"TCACTG"

            MutanteService mutanteService = new MutanteService();

            if(mutanteService.isMutant(dna))
                System.out.println("La persona es un Mutante");
            else
                System.out.println("La persona no es un Mutante");

        }





}
