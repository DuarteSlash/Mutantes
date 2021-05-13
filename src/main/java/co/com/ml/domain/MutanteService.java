package co.com.ml.domain;

import co.com.ml.adapter.MongoDB;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class MutanteService implements IMutanteService {


    private MongoDB db;

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

    @Override
    public MutantStatistics getStatistics() throws ExecutionException, InterruptedException {

        MongoCollection<Document> mongoCollection = db.getDb().getCollection("statistics");

        List<MutantDB> statistics = new ArrayList();
        for (Document document : db.getDb().listCollections()) {

            MutantDB mutant = new MutantDB();
            mutant.setDna(document.getString("dna").split(","));
            mutant.setMutante(document.getBoolean("mutante"));
            statistics.add(mutant);
        }
        MutantStatistics mutantStatistics = new MutantStatistics();
        long count_mutant_dna = statistics.stream().filter(X-> X.isMutante()).count();
        long count_human_dna = statistics.stream().filter(X-> !X.isMutante()).count();
        mutantStatistics.setCount_mutant_dna(count_mutant_dna);
        mutantStatistics.setCount_human_dna(count_human_dna);
        mutantStatistics.setRatio(mutantStatistics.getCount_human_dna()/mutantStatistics.getCount_mutant_dna());

        System.out.println("count_human_dna: " + mutantStatistics.getCount_human_dna());
        System.out.println("count_mutant_dna: " + mutantStatistics.getCount_mutant_dna());
        System.out.println("ratio: " + mutantStatistics.getRatio());
         return mutantStatistics;
    }

    @Override
    public void save(Mutant dna,boolean mutante) {
        this.db = new MongoDB();
        MongoCollection<Document> collection = db.getDb().getCollection("stadistics");

        Document doc1 = new Document();
        doc1.append("dna",dna.getDna());
        doc1.append("mutante",mutante);
        collection.insertOne(doc1);
    }

/*
    @Override
    public void save(Mutant dna,boolean mutante) throws Exception {
        this.db = new FireBaseDB("mutantes-52091");
        DocumentReference docRef = db.getDb().collection("statistics").document("DocumentoX");
        // Add document data  with id "alovelace" using a hashmap
        Map<String, Object> data = new HashMap<>();
        data.put("dna", dna.getDna());
        data.put("mutante", mutante);
        //asynchronously write data
        ApiFuture<WriteResult> result = docRef.set(data);
        // ...
        // result.get() blocks on response
        System.out.println("Update DB time : " + result.get().getUpdateTime());

    }
*/
}
