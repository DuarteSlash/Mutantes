package co.com.ml.domain;

import co.com.ml.utils.Utilities;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MutantValidTransversal {

    @Autowired
    Utilities utilities;

    public MutantValidTransversal(){
        utilities = new Utilities();
    }

    public boolean validTransversalDNA(String[] dna) {


        List listaletra = utilities.alistardigitos();
        String[][] caracteres = utilities.changeToMatrix(dna);



        //valido que la matriz tenga 6 digitos
        if (caracteres.length < 6)
            return true;
        int contarcolumnas = 0;
        int contarrepetidos = 1;
        String siguiente;

        for (int contarfilas = 0; contarfilas < caracteres.length; contarfilas++) {

            String anterior = caracteres[contarfilas][contarcolumnas];

            for (contarcolumnas = 0; contarcolumnas < caracteres[0].length-3; contarcolumnas++) {

                //Verifico que la letra se encuentre en el listado de letras validas
                if (!listaletra.contains(anterior))
                    return false;

                //System.out.println(caracteres[contarfilas][contarcolumnas]);


                //Reviso que al recorrer la cadena transversal, las letras tengan 4 consecutivas iguales
                if (caracteres[contarfilas][contarcolumnas].matches(caracteres[contarfilas+1][contarcolumnas + 1])
                        && caracteres[contarfilas][contarcolumnas].matches(caracteres[contarfilas+2][contarcolumnas + 2])
                        && caracteres[contarfilas][contarcolumnas].matches(caracteres[contarfilas+3][contarcolumnas+ 3])) {
                    return true;
                }
            }
        }
        return false;
    }
}
