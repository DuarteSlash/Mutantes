package co.com.ml.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utilities {

    public List alistardigitos(){
        List listaletra= new ArrayList();
        listaletra.add("A");
        listaletra.add("T");
        listaletra.add("G");
        listaletra.add("C");
        return listaletra;
    }

    public String[][] changeToMatrix(String[] dna) {

        return Arrays.stream(dna)
                .map(e -> Arrays.stream(e.split("\\s*\\s*"))
                        .toArray(String[]::new)).toArray(String[][]::new);
    }

}
