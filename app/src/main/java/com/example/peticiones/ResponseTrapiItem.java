package com.example.peticiones;

import com.google.gson.annotations.SerializedName;

public class ResponseTrapiItem{

	@SerializedName("name")
	public String name;

	@SerializedName("genre")
	public String genre;

	@SerializedName("pic")
	public String pic;
}
