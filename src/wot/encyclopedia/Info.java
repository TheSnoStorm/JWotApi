package wot.encyclopedia;

import java.util.HashMap;

import org.joda.time.DateTime;

public class Info {

	@Override
	public String toString() {
		return "Info [clans_roles=" + clans_roles + ", tanks_updated_at=" + tanks_updated_at + ", game_version=" + game_version + ", languages=" + languages + ", vehicle_crew_roles=" + vehicle_crew_roles + ", vehicle_nations=" + vehicle_nations + ", vehicle_types=" + vehicle_types + "]";
	}

	public HashMap<String, String>	clans_roles;
	private DateTime					tanks_updated_at;
	public String					game_version;
	public HashMap<String, String>	languages;

	public HashMap<String, String>	vehicle_crew_roles;
	public HashMap<String, String>	vehicle_nations;
	public HashMap<String, String>	vehicle_types;

	public Info() {
		// TODO Auto-generated constructor stub
	}

	public DateTime getTanks_updated_at() {
		return tanks_updated_at;
	}

	public void setTanks_updated_at(Long tanks_updated_at) {
		this.tanks_updated_at = new DateTime(tanks_updated_at * 1000l);
	}

}
