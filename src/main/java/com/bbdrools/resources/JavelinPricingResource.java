/**
 * 
 */
package com.bbdrools.resources;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.validator.constraints.NotEmpty;

import com.bbdrools.api.Saying;
import com.bbdrools.dto.PricingResponseDTO;
import com.bbdrools.model.CampaignDiscount;
import com.bbdrools.model.JavelinPrice;
import com.bbdrools.service.IJavelinPricingService;
import com.bbdrools.service.impl.JavelinPricingServiceImpl;
import com.bbdrools.util.JavelinConstants;
import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;

import io.dropwizard.validation.Validated;

/**
 * APIs for upload time validation
 * 
 * @author ayazpasha
 *
 */
@Path("/javelin/api")
@Produces(MediaType.APPLICATION_JSON)
public class JavelinPricingResource {

	private final String template;
	private static final String defaultName = JavelinConstants.RULE_ENGINE;
	private final AtomicLong counter;
	
	/**
	 * arg-constructor
	 * 
	 * @param template
	 */
    public JavelinPricingResource(String template) {
        this.template = template;
        this.counter = new AtomicLong();
    }
	
	@POST
    @Timed
    @Path("/price")
    public Response compute(@NotNull @NotEmpty @Validated List<CampaignDiscount> campaignDiscount) {
    	IJavelinPricingService service = 
				new JavelinPricingServiceImpl();
		
    	JavelinPrice response = 
    			service.compute(campaignDiscount);
		
		return Response.status(200).entity(response).build();
    }
	
	@POST
    @Timed
    @Path("/price/new")
    public Response computeNew(@NotNull @NotEmpty @Validated Map<String, 
    		List<CampaignDiscount>> campaignDiscount) {
    	
		IJavelinPricingService service = 
				new JavelinPricingServiceImpl();

		Map<String, JavelinPrice> response = 
				new HashMap<String, JavelinPrice>();
		
    	Iterator<String> it = 
    			campaignDiscount.keySet().iterator();
		
		while(it.hasNext()) {
			
			String skuId = it.next();
			response.put(skuId, 
					service.compute(campaignDiscount.get(skuId)));
		}
		
		PricingResponseDTO resp = new PricingResponseDTO();
		resp.setStatus(JavelinConstants.SUCCESS);
		resp.setStatusMsg(JavelinConstants.SUCCESS_MSG_PRICING);
		resp.setData(response);
		
		return Response.status(200).entity(resp).build();
    }

	
    @GET
    @Timed
    @Path("/")
    public Saying sayHello(@QueryParam("name") Optional<String> name) {
        final String value = String.format(template, name.or(defaultName));
        return new Saying(counter.incrementAndGet(), value);
    }
	
}
