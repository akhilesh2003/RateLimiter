package com.sc.rate.limiter;

import java.util.Calendar;

import com.sc.dto.RateLimitterDTO;
import com.sc.exception.LimitExceedException;

public interface RateLimiter {
	
	/*
	 * (hour * minute) to get the array size for sliding window approach/ algorithm
	 */
	int size = 24*60; 
	
	/*
	 * default implementation for threshold check for each API
	 * @param RateLimitterDTO object
	 */
	default boolean validate(RateLimitterDTO obj) throws LimitExceedException {
		
		int index = (Calendar.HOUR_OF_DAY * 60 ) + Calendar.MINUTE;
		int[] arr;
		if(obj.getMap() != null && obj.getMap().get(obj.getApiName()) != null) {
			arr = obj.getMap().get(obj.getApiName());
			int count = 0;
			int i = index - obj.getWindow();
			for(;i < index && count < obj.getThresold(); i++) {
				count += arr[i];
			}
			if(count > obj.getThresold()) {
				throw new LimitExceedException("Thresold for API name: " + obj.getApiName() + " exceeds");
			}
			arr[index-1] = arr[index-1] + 1;
		}else {
			arr = new int[size];
			arr[index-1] = 1;
		}
		obj.getMap().put(obj.getApiName(), arr);
		return true;
	}
}
