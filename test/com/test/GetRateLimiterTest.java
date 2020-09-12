package com.test;

import org.junit.Assert;
import org.junit.Test;

import com.sc.exception.LimitExceedException;
import com.sc.rate.limiter.impl.GetRateLimiter;

public class GetRateLimiterTest {

	@Test
	public void getRateLimiterWithinThresholdTest() throws LimitExceedException {
		GetRateLimiter obj = new GetRateLimiter();
		for(int i=0; i<10; i++) {
			Assert.assertEquals(true, obj.getRateLimiter());
		}
	}
	
	@Test(expected = LimitExceedException.class)
	public void getRateLimiterThresholdExccessTest() throws LimitExceedException {
		GetRateLimiter obj = new GetRateLimiter();
		for(int i=0; i<100; i++) {
			obj.getRateLimiter();
		}
	}
	
}