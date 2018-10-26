/**
 * 
 */
package com.bbdrools.resources;

import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author ayazpasha
 *
 */
@Path("")
@Produces(MediaType.APPLICATION_JSON)
public class JavelinHealthCheckResource {
	
	private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public JavelinHealthCheckResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

	@GET
	@Path("/health_")
	public Response healthCheck() throws Exception{
		return Response.status(200).entity("Healthy").build();	
	}
}