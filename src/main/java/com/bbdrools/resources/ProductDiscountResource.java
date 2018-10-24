/**
 * 
 */
package com.bbdrools.resources;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.validation.Valid;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.bbdrools.dto.DiscountValidationResponseDTO;
import com.bbdrools.model.ProductDiscount;
import com.bbdrools.service.IProductDiscountService;
import com.bbdrools.service.impl.ProductDiscountServiceImpl;
import com.bbdrools.util.JavelinConstants;
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
    public Response discountValidation(@Valid Map<String, ProductDiscount> productDiscounts) {
    	IProductDiscountService service = 
				new ProductDiscountServiceImpl();
		
    	Map<String, ProductDiscount> response = 
				new HashMap<String, ProductDiscount>();
		
    	Iterator<String> it = 
    			productDiscounts.keySet().iterator();
		
		while(it.hasNext()) {
			
			String skuId = it.next();
			response.put(skuId, 
					service.validate(productDiscounts.get(skuId)));
		}
		
		DiscountValidationResponseDTO resp = new DiscountValidationResponseDTO();
    	resp.setStatus(JavelinConstants.SUCCESS);
    	resp.setStatusMsg(JavelinConstants.SUCCESS_MSG_VALIDATION);
    	resp.setData(response);
		
		return Response.status(200).entity(resp).build();
    }
	
}
