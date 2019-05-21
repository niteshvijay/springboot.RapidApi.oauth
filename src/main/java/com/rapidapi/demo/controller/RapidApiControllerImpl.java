package com.rapidapi.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rapidapi.demo.model.WebCamCategoryRes;


@RestController
@RequestMapping("/webcams/list/")
public class RapidApiControllerImpl implements RapidApiController {
	public final String BASE_URL = "https://webcamstravel.p.rapidapi.com/webcams/list";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	@RequestMapping("/category")
	public WebCamCategoryRes camCategoryRes(@RequestParam(value="values") List<String> category ,@RequestHeader(value="X-RapidAPI-Host") String host, @RequestHeader(value="X-RapidAPI-Key") String key) throws Exception
	{
		ResponseEntity<WebCamCategoryRes> responseEntity;
		try {
			System.out.println("Category "+String.join(",", category));
			HttpHeaders headers = createHttpHeaders(host,key);
			HttpEntity<String> request = new HttpEntity<String>(headers);
			responseEntity = restTemplate.exchange(BASE_URL+"/category="+String.join(",", category), HttpMethod.GET, request, WebCamCategoryRes.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		}
		return responseEntity.getBody();
	}
	
	@Override
	@RequestMapping("/nearby/latitude/{latitude}/longitude/{longitude}/radius/{radius}")
	public WebCamCategoryRes neadbyCams(
			@PathVariable("latitude") String latitude,
			@PathVariable("longitude") String longitude,
			@PathVariable("radius") String radius,
			@RequestHeader(value="X-RapidAPI-Host") String host, 
			@RequestHeader(value="X-RapidAPI-Key") String key
			) throws Exception {
		HttpHeaders headers = createHttpHeaders(host,key);
		HttpEntity<String> request = new HttpEntity<String>(headers);
	    ResponseEntity<WebCamCategoryRes> responseEntity =restTemplate.exchange(BASE_URL+"/nearby="+latitude+","+longitude+","+radius, HttpMethod.GET, request, WebCamCategoryRes.class);
	    
		return responseEntity.getBody();
	}
	
	@Override
	@RequestMapping("/continent")
	public WebCamCategoryRes camContinentRes(@RequestParam(value="values") List<String> continent,
			@RequestHeader(value="X-RapidAPI-Host") String host, 
			@RequestHeader(value="X-RapidAPI-Key") String key) throws Exception {

		HttpHeaders headers = createHttpHeaders(host,key);
		HttpEntity<String> request = new HttpEntity<String>(headers);
	    ResponseEntity<WebCamCategoryRes> responseEntity =restTemplate.exchange(BASE_URL+"/continent="+String.join(",", continent), HttpMethod.GET, request, WebCamCategoryRes.class);
		return responseEntity.getBody();
	}
	
	private HttpHeaders createHttpHeaders(String host, String key)
	{
	    HttpHeaders headers = new HttpHeaders();
	    headers.add("X-RapidAPI-Host", host);
	    headers.add("X-RapidAPI-Key", key);
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    return headers;
	}


}
