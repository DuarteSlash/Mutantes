package co.com.ml.domain;

import java.util.List;

import co.com.ml.utils.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MutantValidVertical{

    @Autowired
    Utilities utilities;

    public MutantValidVertical(){
        utilities = new Utilities();
    }

    public boolean validVerticalDNA(String[] dna) {



            List listaletra = utilities.alistardigitos();
            String[][] caracteres = utilities.changeToMatrix(dna);


            //valido que la matriz tenga 6 digitos
            if (caracteres.length < 6)
                return true;
            int contarcolumnas = 0;
            int contarrepetidos = 1;
            String siguiente;

            for (int contarfilas = 0; contarfilas < caracteres.length; contarfilas++) {

                String anterior = caracteres[contarcolumnas][contarfilas];

                for (contarcolumnas = 0; contarcolumnas < caracteres[0].length-3; contarcolumnas++) {

                    //Verifico que la letra se encuentre en el listado de letras validas
                    if (!listaletra.contains(anterior))
                        return false;
                    System.out.println(caracteres[contarcolumnas][contarfilas]);
                    //Reviso que al recorrer la cadena vertical, las letras tengan 4 consecutivas iguales
                    if (caracteres[contarcolumnas][contarfilas].matches(caracteres[contarcolumnas+1][contarfilas])
                            && caracteres[contarcolumnas][contarfilas].matches(caracteres[contarcolumnas+2][contarfilas])
                            && caracteres[contarcolumnas][contarfilas].matches(caracteres[contarcolumnas+3][contarfilas])) {
                        return true;
                    }
                }
                System.out.println("\n");
            }
            return false;
        }


}
