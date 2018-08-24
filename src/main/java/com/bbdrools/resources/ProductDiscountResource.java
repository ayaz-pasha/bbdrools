/**
 * 
 */
package com.bbdrools.resources;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.bbdrools.model.ProductDiscount;
import com.bbdrools.service.IProductDiscountService;
import com.bbdrools.service.impl.ProductDiscountServiceImpl;
import com.codahale.metrics.annotation.Timed;

/**
 * @author ayazpasha
 *
 */
@Path("/api/product-discount")
@Produces(MediaType.APPLICATION_JSON)
public class ProductDiscountResource {

	private final String template;

    public ProductDiscountResource(String template) {
        this.template = template;
    }
	
	@POST
    @Timed
    @Path("/check")
    public Response runRules(ProductDiscount productDiscount) {
    	IProductDiscountService service = 
				new ProductDiscountServiceImpl();
		
    	ProductDiscount response = 
    			service.runRules(productDiscount);
		
		return Response.status(200).entity(response).build();
    }
}
