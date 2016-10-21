package resource;

import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import com.mongodb.util.JSON;
import com.wordnik.swagger.annotations.ApiOperation;
import org.json.simple.JSONObject;
import pojo.User;
import repository.UserRepositiory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by harshikesh.kumar on 21/06/16.
*/


@Path("/users")
public class UserResource {

    @Path("list")
    @GET
    public String getUserList() {
        return "hello";
    }

    @Path("userloc")
    @POST
    @Consumes()
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "For userlist data")
    public JSONObject postUserList(JSONObject jsp) {
        UserRepositiory urepo = new UserRepositiory();
        Gson gson = new Gson();
        User user = gson.fromJson(jsp.toJSONString(),User.class);
        System.out.println("lat " +user.getLat());
       // urepo.insertUserInfo(user);

        JSONObject js = new JSONObject();
        js.put("Key", "SUCCESS");
        return js;
    }

    @Path("getfriendsloc")
    @GET
    @Consumes()
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "For getting my friendsLocation")
    public JSONObject getUserList(JSONObject jsp) {
        UserRepositiory urepo = new UserRepositiory();
        Gson gson = new Gson();
        User user = gson.fromJson(jsp.toJSONString(),User.class);
        System.out.println("lat " +user.getLat());
        urepo.getUserInfo(user);

        JSONObject js = new JSONObject();
        js.put("Key", "SUCCESS");
        return js;
    }



}
