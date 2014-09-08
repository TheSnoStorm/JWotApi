package rusty.wot.api.encyclopedia;

import java.util.HashMap;

import org.joda.time.DateTime;

public class Info {
	@Override
	public String toString() {
		return "Info [clans_roles=" + clans_roles + ", game_updated_at=" + game_updated_at + ", game_version=" + game_version + ", vehicle_crew_roles=" + vehicle_crew_roles + ", vehicle_nations=" + vehicle_nations + ", vehicle_types=" + vehicle_types + "]";
	}
	public HashMap<String,String> clans_roles;
	public DateTime game_updated_at;
	public String game_version;

	public HashMap<String,String> vehicle_crew_roles;
	public HashMap<String,String> vehicle_nations;
	public HashMap<String,String> vehicle_types;
	public Info() {
		// TODO Auto-generated constructor stub
	}

}
