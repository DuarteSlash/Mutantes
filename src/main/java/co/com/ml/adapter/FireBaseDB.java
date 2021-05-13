package co.com.ml.adapter;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import java.io.IOException;

public class FireBaseDB {

    private Firestore db;

    public FireBaseDB() throws IOException {
        GoogleCredentials credentials = GoogleCredentials.getApplicationDefault();
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(credentials)
                .setProjectId("mutantes-52091")
                .build();
        FirebaseApp.initializeApp(options);

        this.db = FirestoreClient.getFirestore();
    }

    public FireBaseDB(String projectId) throws Exception {
        // [START fs_initialize_project_id]
        // [START firestore_setup_client_create_with_project_id]
        FirestoreOptions firestoreOptions =
                FirestoreOptions.getDefaultInstance().toBuilder()
                        .setProjectId(projectId)
                        .setCredentials(GoogleCredentials.getApplicationDefault())
                        .build();
        Firestore db = firestoreOptions.getService();
        // [END firestore_setup_client_create_with_project_id]
        // [END fs_initialize_project_id]
        this.db = db;
    }

    public Firestore getDb() {
        return db;
    }




}
