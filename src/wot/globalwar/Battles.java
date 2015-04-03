package wot.globalwar;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Battles {

// @Override
// public String toString() {
// return "Battles [battles=" + battles + "]";
// }
// public Battles(){
// super();
// }
// public ClanBattle[] battles;;
//
// @JsonAnyGetter
// public ClanBattle[] getBattles() {
// return battles;
// }
// @JsonAnySetter
// public void setBattles(ClanBattle[] battles) {
// this.battles = battles;
// }
//
// public static class ClanBattle{

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arenas == null) ? 0 : arenas.hashCode());
		result = prime * result + ((provinces_i18n == null) ? 0 : provinces_i18n.hashCode());
		result = prime * result + ((started == null) ? 0 : started.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Battles other = (Battles) obj;
		if (arenas == null) {
			if (other.arenas != null) return false;
		} else if (!arenas.equals(other.arenas)) return false;
		if (provinces_i18n == null) {
			if (other.provinces_i18n != null) return false;
		} else if (!provinces_i18n.equals(other.provinces_i18n)) return false;
		if (started == null) {
			if (other.started != null) return false;
		} else if (!started.equals(other.started)) return false;
		if (time == null) {
			if (other.time != null) return false;
		} else if (!time.equals(other.time)) return false;
		if (type == null) {
			if (other.type != null) return false;
		} else if (!type.equals(other.type)) return false;
		return true;
	}

	@Override
	public String toString() {
		return "ClanBattle [provinces=" + provinces_i18n + ", started=" + started + ", time=" + time + ", type=" + type + ", arenas=" + arenas + "]";
	}

	public List<ClanBattleProvinces>	provinces_i18n	= new ArrayList<ClanBattleProvinces>();
	public Boolean						started;
	private DateTime					time;

	public String					type;
	public List<ClanBattleArenas>	arenas	= new ArrayList<ClanBattleArenas>();

	public DateTime getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = new DateTime(time * 1000);
	}

	public static class ClanBattleArenas {
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((arena_id == null) ? 0 : arena_id.hashCode());
			result = prime * result + ((name_i18n == null) ? 0 : name_i18n.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj) return true;
			if (obj == null) return false;
			if (getClass() != obj.getClass()) return false;
			ClanBattleArenas other = (ClanBattleArenas) obj;
			if (arena_id == null) {
				if (other.arena_id != null) return false;
			} else if (!arena_id.equals(other.arena_id)) return false;
			if (name_i18n == null) {
				if (other.name_i18n != null) return false;
			} else if (!name_i18n.equals(other.name_i18n)) return false;
			return true;
		}
		@Override
		public String toString() {
			return "ClansBattleArenas [name=" + arena_id + ", name_i18n=" + name_i18n + "]";
		}

		public String	arena_id;
		public String	name_i18n;

	}

	public static class ClanBattleProvinces {
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((name_i18n == null) ? 0 : name_i18n.hashCode());
			result = prime * result + ((province_id == null) ? 0 : province_id.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj) return true;
			if (obj == null) return false;
			if (getClass() != obj.getClass()) return false;
			ClanBattleProvinces other = (ClanBattleProvinces) obj;
			if (name_i18n == null) {
				if (other.name_i18n != null) return false;
			} else if (!name_i18n.equals(other.name_i18n)) return false;
			if (province_id == null) {
				if (other.province_id != null) return false;
			} else if (!province_id.equals(other.province_id)) return false;
			return true;
		}
		@Override
		public String toString() {
			return "ClanBattleProvinces [province_id=" + province_id + ", name_i18n=" + name_i18n + "]";
		}

		public String	province_id;
		public String	name_i18n;

	}
}

// }
