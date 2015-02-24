package solutions.ticker.core;

import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;

import solutions.ticker.core.tools.CORSResponseFilter;

public class TickerApp extends ResourceConfig  {

	public TickerApp(){
		packages("solutions.ticker.core");
		register(CORSResponseFilter.class);
		register(MultiPartFeature.class);
	}
}
