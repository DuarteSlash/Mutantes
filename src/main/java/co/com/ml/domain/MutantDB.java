package co.com.ml.domain;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;


@Component
@Getter
@Setter
@Document(collection = "statistics")
public class MutantDB {
    ObjectId _id;
    String[] dna;
    boolean mutante;
}
