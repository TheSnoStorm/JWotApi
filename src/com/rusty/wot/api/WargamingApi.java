package com.rusty.wot.api;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import rusty.wot.Cluster;

public class WargamingApi {
	private static ObjectMapper mapper = new ObjectMapper();
	public WargamingApi() {
	}

	public static List<GlobalMap> getCwMaps(Cluster cluster) throws JsonParseException, JsonMappingException, MalformedURLException, IOException {
		WgApiArray<GlobalMap> result = mapper.readValue(new URL("https://" + cluster.getApiAddress() + "/wot/globalwar/maps/"
				+ "?application_id=" + cluster.getAppId()+
				"&language=en"),
				new TypeReference<WgApiArray<GlobalMap>>() {});

		return result.data;

	}
	public static Map<String,Prov> getProv(Cluster cluster,GlobalMap cwMap) throws JsonParseException, JsonMappingException, MalformedURLException, IOException {
		WgApiObj<Prov> result = mapper.readValue(new URL("https://" + cluster.getApiAddress() + "/wot/globalwar/provinces/"
				+ "?application_id=" + cluster.getAppId()+
				"&map_id="+ cwMap.getMap_id()+
				//"&fields=clan_id,arena,neighbors,regions.region_i18n"+
				"&language=en"),
				new TypeReference<WgApiObj<Prov>>() {});

		return result.data;

	}
	public static List<LandingTournament> getLandTourn(Cluster cluster,GlobalMap cwMap,String prov) throws JsonParseException, JsonMappingException, MalformedURLException, IOException {
		
		WgApiArray<LandingTournament> result = mapper.readValue(new URL("https://" + cluster.getApiAddress() + "/wot/globalwar/tournaments/?application_id=" + cluster.getAppId() + 
				"&map_id="+ cwMap.getMap_id()+
				"&province_id="+ prov +
				"&language=en"), 
				new TypeReference<WgApiArray<LandingTournament>>() {});

		return result.data;

	}
	public static void main(String[] args){
			try {
		Map<String,Cluster> clusters = new HashMap<String, Cluster>();
		clusters.put("na",new Cluster(4, "NA", "d2c4458d29e8c1d5c5792501e6101e17", "com", "na"));
		clusters.put("asia",new Cluster(1, "ASIA", "8eb93baa03066dbc50649d2dcbd1299c", "asia", "sea"));
		clusters.put("eu",new Cluster(2, "EU", "73e03ec54ee6b2e50cc5bc93c1d3babd", "eu", "eu"));
		clusters.put("ru",new Cluster(3, "RU", "eee4feae89800ee2306aa2fc3793afb0", "ru", "ru"));
		GlobalMap cwMap = new GlobalMap();
		cwMap.setMap_id("globalmap");
		cwMap.setMap_url("http://worldoftanks.com/clanwars/maps/globalmap");

		System.out.println(getProv(clusters.get("na"), cwMap));
		System.out.println(getLandTourn(clusters.get("na"), cwMap, "US_11"));
		for (String clusterKey : clusters.keySet()) {
				System.out.println(clusters.get(clusterKey) + " >>> " + getCwMaps(clusters.get(clusterKey)));
		}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public static class WgApiArray<T> {

		public String	status;
		public Error	error;
		public Integer	count;
		public List<T>	data	= new ArrayList<T>();
		private T	t;

		public WgApiArray() {
		}


		public void set(T t) {
			this.t = t;
		}

		public T get() {
			return t;
		}

		@Override
		public String toString() {
			return "WargamingApi [error=" + error + ", status=" + status + ", count=" + count + ", data=" + data + "]";
		}


	}
	public static class WgApiObj<T> {

		public String	status;
		public Error	error;
		public Integer	count;
		private T	t;

		public WgApiObj() {
		}


		public void set(T t) {
			this.t = t;
		}

		public T get() {
			return t;
		}
		public Map<String,T> data = new HashMap<String, T>();
		
//		@JsonAnyGetter
//	    @SuppressWarnings("unused") //called by Jackson
//	    private Map<String, T> getExtraProperty() {
//	        return data;
//	    }
//
//
//	    @JsonAnySetter
//	    @SuppressWarnings("unused") //called by jackson
//	    private void setUnknownProperty(String key, T t) {
//	    	data.put(key, t);
//	    }
		@Override
		public String toString() {
			return "WargamingApi [error=" + error + ", status=" + status + ", count=" + count + ", data=" + data + "]";
		}


	}
}
