package com.bbdrools;

import com.bbdrools.healthcheck.BBDroolsHealthCheck;
import com.bbdrools.resources.BBDroolsProductResource;
import com.bbdrools.resources.BBDroolsResource;
import com.bbdrools.resources.ProductDiscountResource;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class BBDroolsApplication extends Application<BBDroolsConfiguration>{

	public static void main(String[] args) throws Exception {
        new BBDroolsApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-bigbasket";
    }

    @Override
    public void initialize(Bootstrap<BBDroolsConfiguration> bootstrap) {
        // nothing to do yet
    }

	@Override
	public void run(BBDroolsConfiguration configuration, Environment environment)
			throws Exception {

		final BBDroolsResource resource = new BBDroolsResource(
				configuration.getTemplate(),
				configuration.getDefaultName());
		
		final BBDroolsProductResource productResource = new BBDroolsProductResource(
				configuration.getTemplate());
		
		final ProductDiscountResource productDiscountResource = new ProductDiscountResource(
				configuration.getTemplate());
		
		final BBDroolsHealthCheck healthCheck =
		        new BBDroolsHealthCheck(configuration.getTemplate());
		    environment.healthChecks().register("template", healthCheck);
		    
		environment.jersey().register(resource);
		environment.jersey().register(productResource);
		environment.jersey().register(productDiscountResource);
	}

}
