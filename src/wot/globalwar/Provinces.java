package wot.globalwar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Provinces {

	public String					arena_id;
	public String					arena_i18n;
	public Integer						clan_id;
	public List<String>				neighbors	= new ArrayList<String>();
	public String					primary_region;
	public Integer						prime_time;
	public String					province_i18n;
	public String					province_id;
	public Integer						revenue;
	public String					status;
	public DateTime						updated_at;
	public Integer						vehicle_max_level;
	public Map<String, ProvRegion>	regions		= new HashMap<>();
	

@JsonProperty("updated_at")
	public DateTime getUpdatedAt() {
		return updated_at;
	}

@JsonProperty("updated_at")
	public void setUpdatedAt(Long updated_at) {
		this.updated_at = new DateTime(updated_at * 1000);
	}
	@Override
	public String toString() {
		return "Provinces [arena_id=" + arena_id + ", arena_i18n=" + arena_i18n + ", clan_id=" + clan_id + ", neighbors=" + neighbors + ", primary_region=" + primary_region + ", prime_time=" + prime_time + ", province_i18n=" + province_i18n + ", province_id=" + province_id + ", revenue=" + revenue + ", status=" + status + ", updated_at=" + updated_at + ", vehicle_max_level=" + vehicle_max_level + ", regions=" + regions + "]";
	}

	public static class ProvRegion {
		public String	region_i18n;
		public String	region_id;

		@Override
		public String toString() {
			return "ProvRegion [region_i18n=" + region_i18n + ", region_id=" + region_id + "]";
		}

	}
}
