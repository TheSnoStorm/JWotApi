package rusty.wot.api;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.google.common.base.Joiner;

import rusty.wot.Cluster;
import rusty.wot.api.clan.Membersinfo;
import rusty.wot.api.encyclopedia.Info;
import rusty.wot.api.globalwar.Battles;
import rusty.wot.api.globalwar.FamePoints;
import rusty.wot.api.globalwar.Maps;
import rusty.wot.api.globalwar.Tournaments;
import rusty.wot.api.globalwar.Provinces;
import rusty.wot.api.tanks.Stats;

public class WargamingApi {
	private static ObjectMapper	mapper	= new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).registerModule(new JodaModule());
	public static Joiner		joiner	= Joiner.on(",").skipNulls();

	public static ArrayList<Maps> getGlobalwarMaps(Cluster cluster, String fields, String language) throws ApiException {
		String fieldsParam = "";
		if (fields != null && fields.length() > 0) {
			fieldsParam = "&fields=" + fields;
		}
		if (language == null) language = "en";
		WgApiArray<Maps> result;
		try {
			result = mapper.readValue(new URL("http://" + cluster.getApiAddress() + "/wot/globalwar/maps/"
					+ "?application_id=" + cluster.getAppId() +
					fieldsParam +
					"&language=" + language),
					new TypeReference<WgApiArray<Maps>>() {});
		} catch (IOException e) {
			throw new ApiException(e);
		}
		if (!result.status.equalsIgnoreCase("ok")) {
			throw new ApiException(result.error.toString());
		}
		return result.data;

	}

	public static Map<String, ArrayList<Battles>> getGlobalwarBattles(Cluster cluster, Maps cwMap, int clanid, String language) throws ApiException {

		if (language == null) language = "en";
		WgApiObjMap<ArrayList<Battles>> result;
		try {
			result = mapper.readValue(new URL("http://" + cluster.getApiAddress() + "/wot/globalwar/battles/"
					+ "?application_id=" + cluster.getAppId() +
					"&map_id=" + cwMap.map_id +
					"&clan_id=" + clanid +
					"&language=" + language),
					new TypeReference<WgApiObjMap<ArrayList<Battles>>>() {});
		} catch (IOException e) {
			throw new ApiException(e);
		}
		//System.out.println(result);
		if (!result.status.equalsIgnoreCase("ok")) {
			throw new ApiException(result.error.toString());
		}
		return result.data;

	}
	public static Info getEncyclopediaInfo(Cluster cluster, String language) throws ApiException {
		
		if (language == null) language = "en";

		WgApiObj<Info> result;
		try {
			result = mapper.readValue(new URL("http://" + cluster.getApiAddress() + "/wot/encyclopedia/info/"
					+ "?application_id=" + cluster.getAppId() +
					"&language=" + language),
					new TypeReference<WgApiObj<Info>>() {});
		} catch (IOException e) {
			throw new ApiException(e);
		}

		if (!result.status.equalsIgnoreCase("ok")) {
			throw new ApiException(result.error.toString());
		}
		return result.data;

	}
	public static Map<String, Membersinfo> getClanMembersinfo(Cluster cluster, String memberId, String fields, String language) throws ApiException {
		String fieldsParam = "";
		if (fields != null && fields.length() > 0) {
			fieldsParam = "&fields=" + fields;
		}
		if (language == null) language = "en";

		WgApiObjMap<Membersinfo> result;
		try {
			result = mapper.readValue(new URL("http://" + cluster.getApiAddress() + "/wot/clan/membersinfo/"
					+ "?application_id=" + cluster.getAppId() +
					"&member_id=" + memberId +
					fieldsParam +
					"&language=" + language),
					new TypeReference<WgApiObjMap<Membersinfo>>() {});
		} catch (IOException e) {
			throw new ApiException(e);
		}

		if (!result.status.equalsIgnoreCase("ok")) {
			throw new ApiException(result.error.toString());
		}
		return result.data;

	}
	public static Map<String, FamePoints> getGlobalwarFamepoints(Cluster cluster, String globalmap, String memberId, String fields, String language) throws ApiException {
		String fieldsParam = "";
		if (fields != null && fields.length() > 0) {
			fieldsParam = "&fields=" + fields;
		}
		if (language == null) language = "en";

		WgApiObjMap<FamePoints> result;
		try {
			result = mapper.readValue(new URL("http://" + cluster.getApiAddress() + "/wot/globalwar/famepoints/"
					+ "?application_id=" + cluster.getAppId() +
					"&map_id=" + globalmap +
					"&account_id=" + memberId +
					fieldsParam +
					"&language=" + language),
					new TypeReference<WgApiObjMap<FamePoints>>() {});
		} catch (IOException e) {
			throw new ApiException(e);
		}

		if (!result.status.equalsIgnoreCase("ok")) {
			throw new ApiException(result.error.toString());
		}
		return result.data;

	}
	public static Map<String, Provinces> getGlobalwarProvinces(Cluster cluster, String globalmap, String provid, String fields, String language) throws ApiException {
		String provParam = "";
		if (provid != null && provid.length() > 0) {
			provParam = "&province_id=" + provid;
		}
		String fieldsParam = "";
		if (fields != null && fields.length() > 0) {
			fieldsParam = "&fields=" + fields;
		}
		if (language == null) language = "en";

		WgApiObjMap<Provinces> result;
		try {
			result = mapper.readValue(new URL("http://" + cluster.getApiAddress() + "/wot/globalwar/provinces/"
					+ "?application_id=" + cluster.getAppId() +
					"&map_id=" + globalmap +
					provParam + fieldsParam +
					// "&fields=clan_id,arena,neighbors,regions.region_i18n"+
					"&language=" + language),
					new TypeReference<WgApiObjMap<Provinces>>() {});
		} catch (IOException e) {
			throw new ApiException(e);
		}

		if (!result.status.equalsIgnoreCase("ok")) {
			throw new ApiException(result.error.toString());
		}
		return result.data;

	}

	public static Tournaments getGlobalwarTournaments(Cluster cluster, Maps cwMap, String prov, String fields, String language) throws ApiException {
		if (language == null) language = "en";
		String fieldsParam = "";
		if (fields != null && fields.length() > 0) {
			fieldsParam = "&fields=" + fields;
		}
		WgApiArray<Tournaments> result;
		try {
			result = mapper.readValue(new URL("http://" + cluster.getApiAddress() + "/wot/globalwar/tournaments/?application_id=" + cluster.getAppId() +
					"&map_id=" + cwMap.map_id +
					"&province_id=" + prov +
					fieldsParam +
					"&language=" + language),
					new TypeReference<WgApiArray<Tournaments>>() {});
		} catch (IOException e) {
			throw new ApiException(e);
		}

		if (!result.status.equalsIgnoreCase("ok")) {
			throw new ApiException(result.error.toString());
		}
		return result.data.get(0);

	}
	public static ArrayList<Stats> getTanksStats(Cluster cluster, Integer uid, String vehids, String fields, String language) throws ApiException {
		if (language == null) language = "en";
		String fieldsParam = "";
		if (fields != null && fields.length() > 0) {
			fieldsParam = "&fields=" + fields;
		}
		String vehidParam = "";
		if (vehids != null && vehids.length() > 0) {
			vehidParam = "&tank_id=" + vehids;
		}
		WgApiObjMap<ArrayList<Stats>> result;
		try {
			result = mapper.readValue(new URL("http://" + cluster.getApiAddress() + "/wot/tanks/stats/?application_id=" + cluster.getAppId() +
					"&account_id=" + uid +
					vehidParam +
					fieldsParam +
					"&language=" + language),
					new TypeReference<WgApiObjMap<ArrayList<Stats>>>() {});
		} catch (IOException e) {
			throw new ApiException(e);
		}

		if (!result.status.equalsIgnoreCase("ok")) {
			throw new ApiException(result.error.toString());
		}
		return result.data.get(uid.toString());

	}
	public static void main(String[] args) {
		try {
			ArrayList<Cluster> clusters = new ArrayList<Cluster>();
			ArrayList<Integer> clans = new ArrayList<Integer>();
			ArrayList<Integer> players = new ArrayList<Integer>();
			clusters.add(new Cluster(1, "ASIA", "8eb93baa03066dbc50649d2dcbd1299c", "asia", "sea"));
			clans.add(2000000189);
			players.add(2000185894);
			clusters.add(new Cluster(2, "EU", "73e03ec54ee6b2e50cc5bc93c1d3babd", "eu", "eu"));
			clans.add(500009698);
			players.add(500284121);
			clusters.add(new Cluster(4, "NA", "d2c4458d29e8c1d5c5792501e6101e17", "com", "na"));
			clans.add(1000001000);
			players.add(1000694512);
			//clusters.add( new Cluster(5, "RU", "eee4feae89800ee2306aa2fc3793afb0", "ru", "ru"));
			for(int i = 0; i<clusters.size();i++){
				System.out.println("************************************* "+clusters.get(i).getName()+" clusters.get(i) *************************************");
				
			System.out.println(getEncyclopediaInfo(clusters.get(i), null));
			System.out.println(getClanMembersinfo(clusters.get(i), players.get(i).toString(), null, null));
			//System.out.println(getTanksStats(clusters.get(i), players.get(i), null, "mark_of_mastery,tank_id,all.battles,all.damage_dealt,all.dropped_capture_points,all.frags,all.spotted,all.wins,clan.battles,clan.damage_dealt,clan.dropped_capture_points,clan.frags,clan.hits_percents,clan.spotted,clan.wins", null));
			for(Maps cwMap : getGlobalwarMaps(clusters.get(i), null, null)){
				System.out.println(cwMap);
				if(cwMap.state.equalsIgnoreCase("active")){
			//System.out.println(getGlobalwarBattles(clusters.get(i), cwMap, clans.get(i), null));
			System.out.println(getGlobalwarFamepoints(clusters.get(i), cwMap.map_id, players.get(i).toString(), null,null));
			//String[] provs = {"US_13"};
			//System.out.println(getGlobalwarProvinces(clusters.get(i), cwMap.map_id, null, null, null));
			//System.out.println(getGlobalwarTournaments(clusters.get(i), cwMap, "US_11", null, null));
				}
			}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static class WgApiArray<T> {

		public String	status;
		public Error	error;
		public Integer	count;
		public ArrayList<T>	data	= new ArrayList<T>();
		private T		t;

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
		private T		t;

		public WgApiObj() {
		}

		public void set(T t) {
			this.t = t;
		}

		public T get() {
			return t;
		}

		public T	data;

		@Override
		public String toString() {
			return "WargamingApi [error=" + error + ", status=" + status + ", count=" + count + ", data=" + data + "]";
		}
	}
	public static class WgApiObjMap<T> {

		public String	status;
		public Error	error;
		public Integer	count;
		private T		t;

		public WgApiObjMap() {
		}

		public void set(T t) {
			this.t = t;
		}

		public T get() {
			return t;
		}

		public Map<String, T>	data	= new HashMap<String, T>();

		@Override
		public String toString() {
			return "WargamingApi [error=" + error + ", status=" + status + ", count=" + count + ", data=" + data + "]";
		}
	}

	public static class WgApiObjList<T> {

		public String	status;
		public Error	error;
		public Integer	count;
		private T		t;

		public WgApiObjList() {
		}

		public void set(T t) {
			this.t = t;
		}

		public T get() {
			return t;
		}

		private Map<String, List<T>>	data	= new HashMap<String, List<T>>();

		public Map<String, List<T>> getData() {
			return data;
		}

		public void setData(Map<String, List<T>> data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return "WargamingApi [error=" + error + ", status=" + status + ", count=" + count + ", data=" + data + "]";
		}

	}
}
