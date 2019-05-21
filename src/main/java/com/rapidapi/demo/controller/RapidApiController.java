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

//resource class 
// add response type and request type content type 
// throw specific type of exception
// Validation 

public interface RapidApiController {


	@RequestMapping("/category")
	WebCamCategoryRes camCategoryRes(@RequestParam(value="value") List<String> category,
			@RequestHeader(value="X-RapidAPI-Host") String host, 
			@RequestHeader(value="X-RapidAPI-Key") String key) throws Exception;
	

	@RequestMapping("/nearby/latitude/{latitude}/longitude/{longitude}/radius/{radius}")
	WebCamCategoryRes neadbyCams(@PathVariable("latitude") String latitude,
			@PathVariable("longitude") String longitude,
			@PathVariable("radius") String radius,
			@RequestHeader(value="X-RapidAPI-Host") String host, 
			@RequestHeader(value="X-RapidAPI-Key") String key) throws Exception;
	

	@RequestMapping("/continent")
	WebCamCategoryRes camContinentRes(@RequestParam List<String> continent,
			@RequestHeader(value="X-RapidAPI-Host") String host, 
			@RequestHeader(value="X-RapidAPI-Key") String key) throws Exception;


}
