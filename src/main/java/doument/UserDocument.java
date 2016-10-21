package doument;

import org.bson.Document;

/**
 * Created by harshikesh.kumar on 23/06/16.
 */
public class UserDocument extends Document {

    public static String name = "name" ;
    public static String number = "number";
    public static String lat = "lat";
    public static String lon = "lon";
    public static String device_id = "device_id";
    public static String user_gcm_id = "user_gcm_id";

    @Override
    public Document append(String key, Object value) {

        return super.append(key, value);
    }
}
