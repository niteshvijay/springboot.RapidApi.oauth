package com.rapidapi.demo.model;

import java.util.ArrayList;

public class Result {
	 private float offset;
	 private float limit;
	 private float total;
	 ArrayList < Object > webcams = new ArrayList < Object > ();


	 // Getter Methods 
	 public ArrayList<Object> getWebcams() {
		return webcams;
	}

	public void setWebcams(ArrayList<Object> webcams) {
		this.webcams = webcams;
	}

	public float getOffset() {
	  return offset;
	 }

	 public float getLimit() {
	  return limit;
	 }

	 public float getTotal() {
	  return total;
	 }

	 // Setter Methods 

	 public void setOffset(float offset) {
	  this.offset = offset;
	 }

	 public void setLimit(float limit) {
	  this.limit = limit;
	 }

	 public void setTotal(float total) {
	  this.total = total;
	 }
	}