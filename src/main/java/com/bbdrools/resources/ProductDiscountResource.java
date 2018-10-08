/**
 * 
 */
package com.bbdrools.resources;

import java.util.List;

import javax.validation.Valid;
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
 * APIs for upload time validation
 * 
 * @author ayazpasha
 *
 */
@Path("/javelin/api/discount")
@Produces(MediaType.APPLICATION_JSON)
public class ProductDiscountResource {

	private final String template;

    public ProductDiscountResource(String template) {
        this.template = template;
    }
	
	@POST
    @Timed
    @Path("/validation")
    public Response discountValidation(@Valid List<ProductDiscount> productDiscounts) {
    	IProductDiscountService service = 
				new ProductDiscountServiceImpl();
		
    	List<ProductDiscount> response = 
    			service.validate(productDiscounts);
		
		return Response.status(200).entity(response).build();
    }
	
}
