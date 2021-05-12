package co.com.ml.domain;

import co.com.ml.utils.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class MutantValidHorizontal {


    @Autowired
    Utilities utilities;

    public MutantValidHorizontal(){
        utilities = new Utilities();
    }

    public boolean validHorizontalDNA(String[] dna) {

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


            //Reviso que al recorrer la cadena horizontal, las letras tengan 4 consecutivas iguales
            if (caracteres[contarfilas][contarcolumnas].matches(caracteres[contarfilas][contarcolumnas + 1])
                    && caracteres[contarfilas][contarcolumnas].matches(caracteres[contarfilas][contarcolumnas + 2])
                    && caracteres[contarfilas][contarcolumnas].matches(caracteres[contarfilas][contarcolumnas+ 3])) {
                return true;
            }
        }
    }
        return false;
}
}
