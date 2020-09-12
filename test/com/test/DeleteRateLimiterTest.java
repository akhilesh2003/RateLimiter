package com.test;

import org.junit.Assert;
import org.junit.Test;

import com.sc.exception.LimitExceedException;
import com.sc.rate.limiter.impl.DeleteRateLimiter;

public class DeleteRateLimiterTest {
	
	@Test
	public void deleteRateLimiterWithinThresholdTest() throws LimitExceedException {
		DeleteRateLimiter obj = new DeleteRateLimiter();
		for(int i=0; i<10; i++) {
			Assert.assertEquals(true, obj.deleteRateLimiter());
		}
	}
	
	@Test(expected = LimitExceedException.class)
	public void deleteRateLimiterThresholdExccessTest()  throws LimitExceedException {
		DeleteRateLimiter obj = new DeleteRateLimiter();
		for(int i=0; i<100; i++) {
			obj.deleteRateLimiter();
		}
	}
	
}
