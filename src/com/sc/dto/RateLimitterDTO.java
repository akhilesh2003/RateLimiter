package com.sc.dto;

import java.util.Map;

/*
 * DTO (Data Transfer Object) for passing data easily to any method call
 */
public class RateLimitterDTO {

	private Map<String,int[]> map;
	private int window;
	private int threshold;
	private String apiName;
	
	/*
	 * Constructor to create initial state of object
	 * @param 
	 * @Map to store API name as key, and there access count per minute in a array as value
	 * @window to decide the window size (time frame) for API
	 * @threshold for maximum allowed request for 
	 * String apiName)
	 */
	public RateLimitterDTO(Map<String, int[]> map, int window, int threshold, String apiName){
		this.map = map;
		this.window = window;
		this.threshold = threshold;
		this.apiName = apiName;
	}

	public Map<String, int[]> getMap() {
		return map;
	}

	public void setMap(Map<String, int[]> map) {
		this.map = map;
	}

	public int getWindow() {
		return window;
	}

	public void setWindow(int window) {
		this.window = window;
	}

	public int getThresold() {
		return threshold;
	}

	public void setThresold(int threshold) {
		this.threshold = threshold;
	}

	public String getApiName() {
		return apiName;
	}

	public void setApiName(String apiName) {
		this.apiName = apiName;
	}

}
