package rusty.wot.api.clanwars;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClansBattles {
public ClansBattles(){
	super();
}
	
	public Map<String,ClanBattle> clans = new HashMap<String,ClanBattle>();
	
	public static class ClanBattle{
		
	public List<String> provinces = new ArrayList<String>();
	public Boolean started;
	public Long time;
	public String type;
	public List<ClanBattleArenas> arenas = new ArrayList<ClanBattleArenas>();
	
	public static class ClanBattleArenas{
		@Override
		public String toString() {
			return "ClansBattleArenas [name=" + name + ", name_i18n=" + name_i18n + "]";
		}
		public String name;
		public String name_i18n;
	}
	}
}
