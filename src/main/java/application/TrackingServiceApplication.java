package application;

import conf.MyConfiguration;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import resource.UserResource;

public class TrackingServiceApplication extends Application<MyConfiguration>{

	public static void main(String[] args) {
		try {
			System.out.println(args);
			new TrackingServiceApplication().run(args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run(MyConfiguration arg0, Environment env) throws Exception {
		// TODO Auto-generated method stub
		env.jersey().register(new UserResource());
	}

}
