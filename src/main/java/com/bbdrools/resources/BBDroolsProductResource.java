package com.bbdrools.resources;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.bbdrools.dto.DiscountRequestDTO;
import com.bbdrools.dto.DiscountResponseDTO;
import com.bbdrools.service.IBBDroolsProductService;
import com.bbdrools.service.impl.BBDroolsProductServiceImpl;
import com.codahale.metrics.annotation.Timed;

@Path("/api/product")
@Produces(MediaType.APPLICATION_JSON)
public class BBDroolsProductResource {

	private final String template;

    public BBDroolsProductResource(String template) {
        this.template = template;
    }

    @POST
    @Timed
    @Path("/run-rules")
    public Response runRules(DiscountRequestDTO request) {
    	IBBDroolsProductService service = 
				new BBDroolsProductServiceImpl();
		
    	DiscountResponseDTO response = 
    			service.runRules(request);
		
		return Response.status(200).entity(response).build();
    }	
}
