/**
 * 
 */
package com.bbdrools.resources;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import org.junit.Rule;
import org.junit.Test;

import com.bbdrools.api.Saying;
import com.bbdrools.model.CampaignDiscount;
import com.bbdrools.model.JavelinPrice;
import com.bbdrools.util.JavelinConstants;
import com.fasterxml.jackson.databind.ObjectReader;

import io.dropwizard.jersey.validation.ValidationErrorMessage;
import io.dropwizard.testing.junit.ResourceTestRule;

/**
 * @author ayazpasha
 *
 */
public class JavelinPricingEndpointTest {
	
	@Rule
    public final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new JavelinPricingResource("Hello, %s!"))
            .build();

	@Test
	public void computeDiscountForNull() {
	    
		// Tests what happens when null request is sent to the end-point.
		final Response resp = resources.client().target("/javelin/api/price")
        		.request().post(Entity.json(null));
		
		// Clients will receive a 422 on bad request entity
	    assertThat(resp.getStatus()).isEqualTo(422);

	    // Check to make sure that errors are correct and human readable
	    ValidationErrorMessage msg = resp.readEntity(ValidationErrorMessage.class);
	    assertThat(msg.getErrors())
	            .containsOnly("The request entity was empty");
	}
	
	@Test
    public void computeDiscountForAllTiers() throws IOException {
		
		List<CampaignDiscount> data = formRequestData();
		
		// Hit the endpoint and get the raw json string
        String resp = resources.client().target("/javelin/api/price")
        		.request().post(Entity.json(data), String.class);

        // The expected json that will be returned
        //String json = "{ \"sp\": 58.8, \"rsp\": 98, \"spCombo\": 38.8, \"rspCombo\": 78, \"narq\": 9, \"campaigns\": [ 3000, 1000 ], \"comboCampaigns\": [ 2000 ], \"redemptionLessCampaigns\": [ 1000 ], \"redemptionLessComboCampaigns\": [ 2000 ] }";

        String json = "{ \"sp\":35.0, \"rsp\":40.0, \"spCombo\":29.75, \"rspCombo\":0.0, \"narq\":2, \"campaigns\":[4, 6, 9], \"comboCampaigns\":[10], \"redemptionLessCampaigns\":[3, 5, 6], \"redemptionLessComboCampaigns\":[] }";
        
        // The object responsible for translating json to our class
        ObjectReader reader = resources.getObjectMapper().reader(JavelinPrice.class);

        // Deserialize our actual and expected responses
        JavelinPrice actual = reader.readValue(resp);
        JavelinPrice expected = reader.readValue(json);
        
        assertThat(actual.getSp())
		        .isEqualTo(expected.getSp())
		        .isEqualTo(35.0);

		assertThat(actual.getRsp())
		        .isEqualTo(expected.getRsp())
		        .isEqualTo(40.0);
		
    }
	
	private List<CampaignDiscount> formRequestData() {
		
		List<CampaignDiscount> data = new ArrayList<CampaignDiscount>();
		CampaignDiscount discount1 = new CampaignDiscount(1l, 100.0, 0.0, JavelinConstants.FLAT, 10, JavelinConstants.REGULAR, 5, 9999999, 10, 2, 990, 10);
		CampaignDiscount discount2 = new CampaignDiscount(2l, 100.0, 50.0, JavelinConstants.FIXED, 0, JavelinConstants.REGULAR, 2, 1000, 10, 2, 990, 10);//
		CampaignDiscount discount3 = new CampaignDiscount(3l, 100.0, 0.0, JavelinConstants.FLAT, 12, JavelinConstants.REGULAR, 3, 9999999, 10, 2, 1001, 10);
		CampaignDiscount discount4 = new CampaignDiscount(4l, 100.0, 0.0, JavelinConstants.PERCENT, 20, JavelinConstants.REGULAR, 4, 1000, 10, 2, 990, 5);
		
		CampaignDiscount discount5 = new CampaignDiscount(5l, 100.0, 50.0, JavelinConstants.FIXED, 0, JavelinConstants.DIFFERENTIAL, 1, 9999999, 10, 2, 990, 5);
		CampaignDiscount discount9 = new CampaignDiscount(9l, 100.0, 45.0, JavelinConstants.FIXED, 0, JavelinConstants.DIFFERENTIAL, 2, 1000, 10, 2, 990, 5);
		
		CampaignDiscount discount6 = new CampaignDiscount(6l, 100.0, 0.0, JavelinConstants.FLAT, 10, JavelinConstants.ADDON, 1, 9999999, 10, 2, 990, 9);
		CampaignDiscount discount7 = new CampaignDiscount(7l, 100.0, 0.0, JavelinConstants.PERCENT, 15, JavelinConstants.ADDON, 2, 1000, 10, 2, 990, 5);
		CampaignDiscount discount8 = new CampaignDiscount(8l, 100.0, 0.0, JavelinConstants.FLAT, 5, JavelinConstants.ADDON, 3, 1000, 10, 2, 990, 5);
		
		CampaignDiscount discount10 = new CampaignDiscount(10l, 100.0, 0.0, JavelinConstants.PERCENT, 15, JavelinConstants.COMBO, 1, 10000, 10, 2, 990, 5);
		CampaignDiscount discount11 = new CampaignDiscount(11l, 100.0, 0.0, JavelinConstants.FLAT, 5, JavelinConstants.COMBO, 2, 9999999, 10, 2, 990, 5);	    
    	
		data.add(discount1);
		data.add(discount2);
		data.add(discount3);
		data.add(discount4);
		data.add(discount5);
		data.add(discount6);
		data.add(discount7);
		data.add(discount8);
		data.add(discount9);
		data.add(discount10);
		data.add(discount11);
		
		return data;
	}

	@Test
    public void saying() throws IOException {
    	
		// Hit the endpoint and get the raw json string
        String resp = resources.client().target("/javelin/api/")
                .queryParam("name", "dropwizard")
                .request().get(String.class);

        // The expected json that will be returned
        String json = "{ \"id\": 1, \"content\": \"Hello, dropwizard!\" }";

        // The object responsible for translating json to our class
        ObjectReader reader = resources.getObjectMapper().reader(Saying.class);

        // Deserialize our actual and expected responses
        Saying actual = reader.readValue(resp);
        Saying expected = reader.readValue(json);
        
        assertThat(actual.getId())
		        .isEqualTo(expected.getId())
		        .isEqualTo(1);

		assertThat(actual.getContent())
		        .isEqualTo(expected.getContent())
		        .isEqualTo("Hello, dropwizard!");
		
    }

}
