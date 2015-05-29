package com.generic.apis.pojos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
"coord",
"sys",
"weather",
"base",
"main",
"wind",
"clouds",
"dt",
"id",
"name",
"cod"
})
public class WeatherMap {

	@JsonProperty("coord")
	private Coord coord;
	
	@JsonProperty("sys")
	private Sys sys;
	
	@JsonProperty("weather")
	private List<Weather> weather = new ArrayList<Weather>();
	
	@JsonProperty("base")
	private String base;
	
	@JsonProperty("main")
	private Main main;
	
	@JsonProperty("wind")
	private Wind wind;
	
	@JsonProperty("clouds")
	private Clouds clouds;
	
	@JsonProperty("dt")
	private Integer dt;
	
	@JsonProperty("id")
	private Integer id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("cod")
	private Integer cod;
	
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	

	@JsonProperty("coord")
	public Coord getCoord() {
		return coord;
	}
	
	@JsonProperty("coord")
	public void setCoord(Coord coord) {
		this.coord = coord;
	}
	
	@JsonProperty("sys")
	public Sys getSys() {
		return sys;
	}
	
	@JsonProperty("sys")
	public void setSys(Sys sys) {
		this.sys = sys;
	}

	@JsonProperty("weather")
	public List<Weather> getWeather() {
		return weather;
	}
	
	@JsonProperty("weather")
	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}
	
	@JsonProperty("base")
	public String getBase() {
		return base;
	}
	
	@JsonProperty("base")
	public void setBase(String base) {
		this.base = base;
	}
	
	@JsonProperty("main")
	public Main getMain() {
		return main;
	}
	
	@JsonProperty("main")
	public void setMain(Main main) {
		this.main = main;
	}
	
	@JsonProperty("wind")
	public Wind getWind() {
		return wind;
	}
	
	@JsonProperty("wind")
	public void setWind(Wind wind) {
		this.wind = wind;
	}
	
	@JsonProperty("clouds")
	public Clouds getClouds() {
		return clouds;
	}
	
	@JsonProperty("clouds")
	public void setClouds(Clouds clouds) {
		this.clouds = clouds;
	}
	
	@JsonProperty("dt")
	public Integer getDt() {
		return dt;
	}

	@JsonProperty("dt")
	public void setDt(Integer dt) {
		this.dt = dt;
	}
	
	@JsonProperty("id")
	public Integer getId() {
		return id;
	}
	
	@JsonProperty("id")
	public void setId(Integer id) {
		this.id = id;
	}
	
	@JsonProperty("name")
	public String getName() {
		return name;
	}
	
	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}
	
	@JsonProperty("cod")
	public Integer getCod() {
		return cod;
	}
	
	@JsonProperty("cod")
	public void setCod(Integer cod) {
		this.cod = cod;
	}
	
	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}
	
	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}
	
	@Override
	public String toString() {
		try {
			return new ObjectMapper().writeValueAsString(this);
		} catch (JsonProcessingException e) {
			System.out.println(e.getMessage());
		}
		return "Invalid Response from 'WeatherMap'";
	}

}