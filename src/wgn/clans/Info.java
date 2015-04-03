package wgn.clans;

import java.util.List;
import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Info {

	@Override
	public String toString() {
		return "Info [accepts_join_requests=" + accepts_join_requests + ", clan_id=" + clan_id + ", color=" + color + ", created_at=" + created_at + ", creator_id=" + creator_id + ", description=" + description + ", description_html=" + description_html + ", is_clan_disbanded=" + is_clan_disbanded + ", leader_id=" + leader_id + ", members_count=" + members_count + ", motto=" + motto + ", name=" + name + ", old_name=" + old_name + ", old_tag=" + old_tag + ", renamed_at=" + renamed_at + ", updated_at=" + updated_at + ", emblems=" + emblems + ", members=" + members + ", private_info=" + private_info + "]";
	}

	public Boolean				accepts_join_requests;
	public Integer				clan_id;
	public String				color;
	private DateTime			created_at;
	public Integer				creator_id;
	public String				description;
	public String				description_html;
	public Boolean				is_clan_disbanded;
	public Integer				leader_id;
	public String				leader_name;
	public Integer				members_count;
	public String				motto;
	public String				name;
	public String				old_name;
	public String				old_tag;
	private DateTime			renamed_at;
	private DateTime			updated_at;
	public Emblems				emblems;
	public List<Members>	members;

	@JsonProperty("private")
	public Private				private_info;

	public DateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Long created_at) {
		this.created_at = new DateTime(created_at * 1000l);
	}

	public DateTime getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Long updated_at) {
		this.updated_at = new DateTime(updated_at * 1000l);
	}

	public DateTime getRenamed_at() {
		return renamed_at;
	}

	public void setRenamed_at(Long renamed_at) {
		this.renamed_at = new DateTime(renamed_at * 1000l);
	}

	

	public static class Members {

		@Override
		public String toString() {
			return "Members [account_id=" + account_id + ", joined_at=" + joined_at + ", role=" + role + ", role_i18n=" + role_i18n + ", account_name=" + account_name + "]";
		}

		public Integer		account_id;
		private DateTime	joined_at;
		public String		role;
		public String		role_i18n;
		public String		account_name;

		public DateTime getJoined_at() {
			return joined_at;
		}

		public void setJoined_at(Long joined_at) {
			this.joined_at = new DateTime(joined_at * 1000l);
		}
	}

	public static class Private {
		@Override
		public String toString() {
			return "Private [treasury=" + treasury + "]";
		}

		public Integer	treasury;
	}
}
