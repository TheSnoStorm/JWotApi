package rusty.wot.api.clanwars;

public class GlobalMap{
	@Override
	public String toString() {
		return "GlobalMap [map_id=" + map_id + ", state=" + state + ", type=" + type + ", map_url=" + map_url + "]";
	}
	public GlobalMap() {
		super();
	}
	public String map_id;
	public String state,type,map_url;
	
}