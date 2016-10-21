package repository;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.UpdateResult;
import doument.UserDocument;
import mongo.ConnectionManager;
import org.bson.Document;
import org.bson.types.Code;
import pojo.Friends;
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
        doc.put(UserDocument.number, "8897");
        doc.put(UserDocument.lat, user.getLat());
        doc.put(UserDocument.lon, user.getLon());
        doc.put(UserDocument.friends,"");
        doc.put(UserDocument.lon, user.getLon());

        MongoCollection mongoCollec = ConnectionManager.getInstance().getDb(USER_DB).getCollection(USER_LOCATION_COLLECTION);
        if (mongoCollec.find(new Document().append(UserDocument.number, "8897")) != null) {
            mongoCollec.replaceOne(new Document().append(UserDocument.number, "8897"), doc);
        } else {
            mongoCollec.insertOne(doc);
        }
    }

    public void insertFriendsInfo(Friends friends) {
        Document doc = new Document();
        doc.put(UserDocument.number, friends.getMynumber());
        doc.put(UserDocument.friends, friends.getNumbers());
        BasicDBObject newDocument = new BasicDBObject();
        newDocument.append("$set", new BasicDBObject().append(UserDocument.friends, friends.getNumbers()));

        BasicDBObject searchQuery = new BasicDBObject().append(UserDocument.number, friends.getMynumber());

        MongoCollection mongoCollec = ConnectionManager.getInstance().getDb(USER_DB).getCollection(USER_LOCATION_COLLECTION);
        UpdateResult updateRes = mongoCollec.updateOne(searchQuery, newDocument);
        System.out.println("total modified count : " + updateRes.getModifiedCount());
        if (updateRes.getModifiedCount() > 0) {
            for (int i = 0; i < friends.getNumbers().size(); i++) {
                BasicDBObject searchQ = new BasicDBObject().append(UserDocument.number, friends.getNumbers().get(i));
            }
        }

    }

    public void getUserInfo(User user) {

//        ConnectionManager.getInstance().getDb(USER_DB).getCollection(USER_LOCATION_COLLECTION)
//                .find({});
    }
}
