package rusty.wot.api.globalwar;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Battles{

//@Override
//	public String toString() {
//		return "Battles [battles=" + battles + "]";
//	}
//public Battles(){
//	super();
//}
//	public ClanBattle[] battles;;
//	
//@JsonAnyGetter
//	public ClanBattle[] getBattles() {
//	return battles;
//}
// @JsonAnySetter
//public void setBattles(ClanBattle[] battles) {
//	this.battles = battles;
//}
//
//	public static class ClanBattle{
		
	@Override
		public String toString() {
			return "ClanBattle [provinces=" + provinces + ", started=" + started + ", time=" + time + ", type=" + type + ", arenas=" + arenas + "]";
		}

	public List<String> provinces = new ArrayList<String>();
	public Boolean started;
	private DateTime time;
	public DateTime getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = new DateTime(time*1000);
	}

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

//}
