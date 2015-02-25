package solutions.ticker.core;

import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.message.GZipEncoder;
import org.glassfish.jersey.message.filtering.EntityFilteringFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.EncodingFilter;

import solutions.ticker.core.tools.CORSResponseFilter;

public class TickerApp extends ResourceConfig  {

	public TickerApp(){
		packages("solutions.ticker.core");
		register(CORSResponseFilter.class);
		register(MultiPartFeature.class);
		register(EntityFilteringFeature.class);
		EncodingFilter.enableFor(this, GZipEncoder.class);
	}
}
