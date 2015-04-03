package wgn.clans;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class Glossary {
		@Override
	public String toString() {
		return "Glossary [clans_roles=" + clans_roles + "]";
	}

		private Map<String,String> clans_roles;
//		public BiMap<String, String> getClansRolesBiMap() {
//			BiMap<String, String> result = HashBiMap.create(clans_roles);
//			return result;
//		}
		@JsonProperty("clans_roles")
		public Map<String, String> getClansRoles() {
			BiMap<String, String> result = HashBiMap.create(clans_roles);
			return result;
		}
		@JsonProperty("clans_roles")
		public void setClansRoles(HashMap<String, String> clans_roles) {
			this.clans_roles = clans_roles;
		}


}
