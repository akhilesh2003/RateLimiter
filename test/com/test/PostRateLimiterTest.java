package com.test;

import org.junit.Assert;
import org.junit.Test;

import com.sc.exception.LimitExceedException;
import com.sc.rate.limiter.impl.PostRateLimiter;

public class PostRateLimiterTest {

	@Test
	public void postRateLimiterWithinThresholdTest()  throws LimitExceedException {
		PostRateLimiter obj = new PostRateLimiter();
		for(int i=0; i<10; i++) {
			Assert.assertEquals(true, obj.postRateLimiter());
		}
	}
	
	@Test(expected = LimitExceedException.class)
	public void postRateLimiterThresholdExccessTest()  throws LimitExceedException {
		PostRateLimiter obj = new PostRateLimiter();
		for(int i=0; i<100; i++) {
			obj.postRateLimiter();
		}
	}
	
}
