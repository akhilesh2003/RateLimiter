package com.sc.rate.limiter.impl;

import java.util.HashMap;
import java.util.Map;

import com.sc.dto.RateLimitterDTO;
import com.sc.exception.LimitExceedException;
import com.sc.rate.limiter.RateLimiter;

/*
 * PutRateLimiter for delete API test, implements RateLimiter interface
 */
public class PutRateLimiter implements RateLimiter{
	
	static final private Map<String,int[]> map = new HashMap<String, int[]>();
	static final private int window = 1;
	private int threshold = 10;

	public boolean putRateLimiter() throws LimitExceedException {
		
		RateLimiter.super.validate(new RateLimitterDTO(map, window, threshold, "putRateLimiter"));
		
		return true;
	
	}

}
