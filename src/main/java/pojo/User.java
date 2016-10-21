package pojo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * Created by harshikesh.kumar on 21/06/16.
 */
public class User {
    private String name;
    private String number;
    private double lat;
    private double lon;
    private String device_id;
    private String user_gcm_id;

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public String getDeviceId() {
        return device_id;
    }

    public String getUserGcmId() {
        return user_gcm_id;
    }
}
