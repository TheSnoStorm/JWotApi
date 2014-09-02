package rusty.wot.api.clan;

import org.joda.time.DateTime;

public class Membersinfo {

	@Override
	public String toString() {
		return "Membersinfo [abbreviation=" + abbreviation + ", account_id=" + account_id + ", clan_id=" + clan_id + ", clan_name=" + clan_name + ", color=" + color + ", role=" + role + ", role_i18n=" + role_i18n + ", since=" + since + ", emblems=" + emblems + "]";
	}

	public String			abbreviation;
	public Integer				account_id;
	public Integer				clan_id;
	public String			clan_name;
	public String			color;
	public String			role;
	public String			role_i18n;
	private DateTime since;
	public ClanMemberEmblems			emblems;
	
	public DateTime getSince() {
		return since;
	}
	public void setSince(Long since) {
		this.since = new DateTime(since*1000);
	}

	public static class ClanMemberEmblems {
		@Override
		public String toString() {
			return "ClanMemberEmblems [large=" + large + ", small=" + small + ", bw_tank=" + bw_tank + ", medium=" + medium + "]";
		}
		public String			large;
		public String			small;
		public String			bw_tank;
		public String			medium;
		
	}
}
