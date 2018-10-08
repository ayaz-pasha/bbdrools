/**
 * 
 */
package com.bbdrools.resources;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.bbdrools.model.CampaignDiscount;
import com.bbdrools.service.IJavelinPricingService;
import com.bbdrools.service.impl.JavelinPricingServiceImpl;
import com.codahale.metrics.annotation.Timed;

/**
 * APIs for upload time validation
 * 
 * @author ayazpasha
 *
 */
@Path("/javelin/api/price")
@Produces(MediaType.APPLICATION_JSON)
public class JavelinPricingResource {

	private final String template;

    public JavelinPricingResource(String template) {
        this.template = template;
    }
	
	@POST
    @Timed
    @Path("/")
    public Response compute(CampaignDiscount campaignDiscount) {
    	IJavelinPricingService service = 
				new JavelinPricingServiceImpl();
		
    	CampaignDiscount response = 
    			service.compute(campaignDiscount);
		
		return Response.status(200).entity(response).build();
    }
	
}
