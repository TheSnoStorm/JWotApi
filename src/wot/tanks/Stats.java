package wot.tanks;

public class Stats {
		@Override
	public String toString() {
		return "Stats [account_id=" + account_id + ", mark_of_mastery=" + mark_of_mastery + ", max_frags=" + max_frags + ", max_xp=" + max_xp + ", tank_id=" + tank_id + ", in_garage=" + in_garage + ", all=" + all + ", clan=" + clan + ", company=" + company + "]";
	}
		public Integer account_id;
		public Integer mark_of_mastery;
		public Integer max_frags;
		public Integer max_xp;
		public Integer tank_id;
		public Boolean in_garage;
		public StatSet all;
		public StatSet clan;
		public StatSet company;
	public Stats() {
		super();
	}
	public static class StatSet {
		@Override
		public String toString() {
			return "StatSet [battle_avg_xp=" + battle_avg_xp + ", battles=" + battles + ", capture_points=" + capture_points + ", damage_dealt=" + damage_dealt + ", damage_received=" + damage_received + ", draws=" + draws + ", dropped_capture_points=" + dropped_capture_points + ", frags=" + frags + ", hits=" + hits + ", hits_percents=" + hits_percents + ", losses=" + losses + ", shots=" + shots + ", spotted=" + spotted + ", survived_battles=" + survived_battles + ", wins=" + wins + ", xp=" + xp + "]";
		}
		public Integer battle_avg_xp;
		public Integer battles;
		public Integer capture_points;
		public Integer damage_dealt;
		public Integer damage_received;
		public Integer draws;
		public Integer dropped_capture_points;
		public Integer frags;
		public Integer hits;
		public Integer hits_percents;
		public Integer losses;
		public Integer shots;
		public Integer spotted;
		public Integer survived_battles;
		public Integer wins;
		public Integer xp;
	}
}
