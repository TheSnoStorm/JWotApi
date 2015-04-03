package wgn.clans;

import org.joda.time.DateTime;

public class Membersinfo {

	@Override
	public String toString() {
		return "Membersinfo [account_id=" + account_id + ", joined_at=" + joined_at + ", role=" + role + ", role_i18n=" + role_i18n + ", clan=" + clan + "]";
	}

	public Integer		account_id;
	public String		account_name;
	private DateTime	joined_at;
	public String		role;
	public String		role_i18n;
	public Clan			clan;
	public Emblems		emblems;

	public DateTime getJoined_at() {
		return joined_at;
	}

	public void setJoined_at(Long joined_at) {
		this.joined_at = new DateTime(joined_at * 1000);
	}

	public static class Clan {
		@Override
		public String toString() {
			return "Clan [clan_id=" + clan_id + ", color=" + color + ", created_at=" + created_at + ", members_count=" + members_count + ", name=" + name + ", tag=" + tag + "]";
		}

		public Integer		clan_id;
		public String		color;
		private DateTime	created_at;
		public Integer		members_count;
		public String		name;
		public String		tag;

		public DateTime getCreated_at() {
			return created_at;
		}

		public void setCreated_at(Long created_at) {
			this.created_at = new DateTime(created_at * 1000);
		}

	}

}
