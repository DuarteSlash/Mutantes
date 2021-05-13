package co.com.ml.adapter;

import com.google.cloud.firestore.Firestore;
import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClientSettings;
import org.bson.Document;

public class MongoDB {


    private MongoDatabase db;

     public MongoDB(){

        /*MongoClientURI uri = new MongoClientURI(
                "mongodb+srv://duarteslash:<password>@cluster0.ayp0q.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase("test");*/

        ConnectionString connString = new ConnectionString(
                "mongodb+srv://duarteslash:Mongo2021@cluster0.ayp0q.mongodb.net/Mutante?retryWrites=true&w=majority"
        );
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connString)
                .retryWrites(true)
                .build();
        MongoClient mongoClient = MongoClients.create(settings);
        db = mongoClient.getDatabase("Mutante");
    }

    public MongoDatabase getDb() {
        return db;
    }
}
