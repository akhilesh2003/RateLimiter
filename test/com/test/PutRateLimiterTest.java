package com.test;


import org.junit.Assert;
import org.junit.Test;

import com.sc.exception.LimitExceedException;
import com.sc.rate.limiter.impl.PutRateLimiter;

public class PutRateLimiterTest {
	
	@Test
	public void putRateLimiterWithinThresholdTest()  throws LimitExceedException {
		PutRateLimiter obj = new PutRateLimiter();
		for(int i=0; i<10; i++) {
			Assert.assertEquals(true, obj.putRateLimiter());
		}
	}
	
	@Test(expected = LimitExceedException.class)
	public void putRateLimiterThresholdExccessTest()  throws LimitExceedException {
		PutRateLimiter obj = new PutRateLimiter();
		for(int i=0; i<100; i++) {
			obj.putRateLimiter();
		}
	}

}
