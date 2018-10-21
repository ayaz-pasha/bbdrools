package com.bbdrools.resources;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.bbdrools.api.Saying;
import com.google.common.base.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class JavelinPricingResourceTest {
	
	private JavelinPricingResource resource;

    @Before
    public void setup() {
        // Before each test, we re-instantiate our resource so it will reset
        // the counter. It is good practice when dealing with a class that
        // contains mutable data to reset it so tests can be ran independently
        // of each other.
        resource = new JavelinPricingResource("Hello, %s");
    }

    @Test
    public void idStartsAtOne() {
        Saying result = resource.sayHello(Optional.of("dropwizard"));
        assertEquals(result.getId(), 1);
    }

    @Test
    public void idIncrementsByOne() {
        Saying result = resource.sayHello(Optional.of("dropwizard"));
        Saying result2 = resource.sayHello(Optional.of("dropwizard2"));

        assertEquals(result2.getId(), result.getId() + 1);
    }
    
    @Test
    public void absentNameReturnsDefaultName() {
        Saying result = resource.sayHello(Optional.<String>absent());
        assertThat(result.getContent()).contains("RULE ENGINE");
    }

    @Test
    public void nameReturnsName() {
        Saying result = resource.sayHello(Optional.of("dropwizard"));
        assertThat(result.getContent()).contains("dropwizard");
    }
    
}
