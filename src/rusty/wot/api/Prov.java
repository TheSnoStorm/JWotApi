package rusty.wot.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

@SuppressWarnings("unused")
public class Prov {

	public String					arena;
	public Integer						clan_id;
	public List<String>				neighbors	= new ArrayList<String>();
	public String					primary_region;
	public Integer						prime_time;
	public String					province_i18n;
	public String					province_id;
	public Integer						revenue;
	public String					status;
	public Long						updated_at;
	public Integer						vehicle_max_level;
	public Map<String, ProvRegion>	regions		= new HashMap<>();
//
//	@JsonAnyGetter
//	@SuppressWarnings("unused")
//	// called by Jackson
//	private Map<String, ProvRegion> getExtraProperty() {
//		return regions;
//	}
//
//	@JsonAnySetter
//	@SuppressWarnings("unused")
//	// called by jackson
//	private void setUnknownProperty(String key, ProvRegion value) {
//		regions.put(key, value);
//	}

	@Override
	public String toString() {
		return "ProvData [arena=" + arena + ", clan_id=" + clan_id + ", neighbors=" + neighbors + ", primary_region=" + primary_region + ", prime_time=" + prime_time + ", province_i18n=" + province_i18n + ", province_id=" + province_id + ", revenue=" + revenue + ", status=" + status + ", updated_at=" + updated_at + ", vehicle_max_level=" + vehicle_max_level + ", regions=" + regions + "]";
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
