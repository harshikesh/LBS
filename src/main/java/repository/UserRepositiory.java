package repository;

import com.mongodb.client.MongoCollection;
import doument.UserDocument;
import mongo.ConnectionManager;
import org.bson.Document;
import pojo.User;

import static utils.Constants.USER_DB;

/**
 * Created by harshikesh.kumar on 23/06/16.
 */
public class UserRepositiory {


    public static String USER_LOCATION_COLLECTION = "user_location_collection";


    public void insertUserInfo(User user) {
        Document doc = new Document();
        doc.put(UserDocument.name, user.getName());
        doc.put(UserDocument.number, user.getNumber());
        doc.put(UserDocument.lat, user.getLat());
        doc.put(UserDocument.lon, user.getLon());
        doc.put(UserDocument.device_id, user.getDeviceId());
        doc.put(UserDocument.user_gcm_id, user.getUserGcmId());

        MongoCollection mongoCollec = ConnectionManager.getInstance().getDb(USER_DB).getCollection(USER_LOCATION_COLLECTION);
        if (mongoCollec.find(new Document().append(UserDocument.device_id, user.getDeviceId())) != null) {
            mongoCollec.replaceOne(new Document().append(UserDocument.device_id, user.getDeviceId()), doc);
        } else {
            mongoCollec.insertOne(doc);
        }
    }

    public void getUserInfo(User user) {

//        ConnectionManager.getInstance().getDb(USER_DB).getCollection(USER_LOCATION_COLLECTION)
//                .find({});
    }
}
