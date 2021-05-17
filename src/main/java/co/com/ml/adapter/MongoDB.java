package co.com.ml.adapter;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Slf4j
@Configuration
public class MongoDB extends AbstractMongoClientConfiguration{
    //private static final String MONGODB_URI = "";
    //private static final String MONGODB = "";

    public static final String MONGODB_URI = "mongodb+srv://duarteslash:Mongo2021@cluster0.ayp0q.mongodb.net/Mutante?retryWrites=true&w=majority";
    public static final String MONGODB = "Mutante";



    //private MongoTemplate db;
    private MongoTemplate db;

    public MongoDB(MongoTemplate db) {
        this.db = db;
    }

    public MongoDB(){


        ConnectionString connectionString = new ConnectionString(MONGODB_URI);
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        MongoClient mongoClient = null;

        try {
            //TrustStore.trustAllCerts();
            mongoClient = MongoClients.create(mongoClientSettings);

            db = new MongoTemplate(mongoClient,MONGODB);
        } catch (Exception e) {
            log.error(""+ e.getCause());
        }
    }

    public MongoTemplate getDb() {
        return db;
    }

    @Override
    protected String getDatabaseName() {
        return "Mutante";
    }
}
