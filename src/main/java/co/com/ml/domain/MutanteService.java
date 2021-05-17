package co.com.ml.domain;

import co.com.ml.adapter.MongoDB;
import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.codecs.configuration.CodecConfigurationException;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;

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
    public MutantStatistics getStatistics() throws Exception {
        this.db = new MongoDB();
        MongoCollection<Document> mongoCollection = db.getDb().getCollection("statistics");

        Document findMutante = new Document("mutante", true);
        Document findHuman = new Document("mutante", false);
        MutantStatistics mutantStatistics = new MutantStatistics();

        //mongoCollection.find(Filters.eq("mutante",true)).forEach((Consumer<Document>) (Document d) -> { System.out.println(d.toJson()); });
        mutantStatistics.setCount_mutant_dna(mongoCollection.countDocuments(findMutante));
        mutantStatistics.setCount_human_dna(mongoCollection.countDocuments(Filters.eq("mutante", false)));
        mutantStatistics.setRatio(mutantStatistics.getCount_human_dna() / mutantStatistics.getCount_mutant_dna());

        System.out.println("count_human_dna: " + mutantStatistics.getCount_human_dna());
        System.out.println("count_mutant_dna: " + mutantStatistics.getCount_mutant_dna());
        System.out.println("ratio: " + mutantStatistics.getRatio());

        return mutantStatistics;
    }

    @Override
    public void save(Mutant dna,boolean mutante) {
        try {
            this.db = new MongoDB();
            MongoCollection<Document> mongoCollection = db.getDb().getCollection("statistics");
            Document doc = new Document("dna", Arrays.stream(dna.getDna()).distinct());
            //mongoCollection.find(Filters.eq("dna",dna.getDna())).forEach((Consumer<Document>) (Document d) -> { System.out.println(d.toJson()); });
            //if(Collections.binarySearch(mongoCollection.find().cursor().forEachRemaining().containsValue(doc)?1:0){
                MutantDB doc1 = new MutantDB();
                doc1.set_id(new ObjectId());
                doc1.setDna(dna.getDna());
                doc1.setMutante(mutante);
                db.getDb().save(doc1, "statistics");
            //}
        }catch(CodecConfigurationException e){
            e.printStackTrace();
        }
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
