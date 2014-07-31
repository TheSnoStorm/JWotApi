package com.rusty.wot.api;

public class GlobalMap{
	@Override
	public String toString() {
		return "GlobalMap [map_id=" + map_id + ", state=" + state + ", type=" + type + ", map_url=" + map_url + "]";
	}
	public GlobalMap() {
	}
	private String map_id;
	public String getMap_id() {
		return map_id;
	}
	public void setMap_id(String map_id) {
		this.map_id = map_id;
	}
	private String state,type,map_url;
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMap_url() {
		return map_url;
	}
	public void setMap_url(String map_url) {
		this.map_url = map_url;
	}
}