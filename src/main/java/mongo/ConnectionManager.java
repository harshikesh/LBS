package mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import doument.UserDocument;
import org.bson.Document;
import pojo.User;

/**
 * Created by harshikesh.kumar on 23/06/16.
 */
public class ConnectionManager {

    MongoClient mongoClient = new MongoClient();
    private static ConnectionManager mConnectionManager;

    /*
        MongoClient mongoClient = new MongoClient( "localhost" );
        // or
        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
        // or, to connect to a replica set, with auto-discovery of the primary, supply a seed list of members
        MongoClient mongoClient = new MongoClient(Arrays.asList(new ServerAddress("localhost", 27017),
                new ServerAddress("localhost", 27018),
                new ServerAddress("localhost", 27019)));
    */
    public static ConnectionManager getInstance() {
        if (mConnectionManager == null)
            return mConnectionManager = new ConnectionManager();
        else {
            return mConnectionManager;
        }
    }

    public MongoDatabase getDb(String dbname) {
        MongoDatabase db = mongoClient.getDatabase(dbname);
        return db;
    }

    public void getDefaultDb() {

    }

    public void check() {

    }
}
