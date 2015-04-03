package wot.globalwar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Tournaments {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((competitors == null) ? 0 : competitors.hashCode());
		result = prime * result + ((finish_time == null) ? 0 : finish_time.hashCode());
		result = prime * result + ((max_competitors == null) ? 0 : max_competitors.hashCode());
		result = prime * result + ((province_i18n == null) ? 0 : province_i18n.hashCode());
		result = prime * result + ((province_id == null) ? 0 : province_id.hashCode());
		result = prime * result + ((province_status == null) ? 0 : province_status.hashCode());
		result = prime * result + ((start_time == null) ? 0 : start_time.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((tournament_tree == null) ? 0 : tournament_tree.hashCode());
		result = prime * result + ((updated_at == null) ? 0 : updated_at.hashCode());
		result = prime * result + ((winner == null) ? 0 : winner.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Tournaments other = (Tournaments) obj;
		if (competitors == null) {
			if (other.competitors != null) return false;
		} else if (!competitors.equals(other.competitors)) return false;
		if (finish_time == null) {
			if (other.finish_time != null) return false;
		} else if (!finish_time.equals(other.finish_time)) return false;
		if (max_competitors == null) {
			if (other.max_competitors != null) return false;
		} else if (!max_competitors.equals(other.max_competitors)) return false;
		if (province_i18n == null) {
			if (other.province_i18n != null) return false;
		} else if (!province_i18n.equals(other.province_i18n)) return false;
		if (province_id == null) {
			if (other.province_id != null) return false;
		} else if (!province_id.equals(other.province_id)) return false;
		if (province_status == null) {
			if (other.province_status != null) return false;
		} else if (!province_status.equals(other.province_status)) return false;
		if (start_time == null) {
			if (other.start_time != null) return false;
		} else if (!start_time.equals(other.start_time)) return false;
		if (status == null) {
			if (other.status != null) return false;
		} else if (!status.equals(other.status)) return false;
		if (tournament_tree == null) {
			if (other.tournament_tree != null) return false;
		} else if (!tournament_tree.equals(other.tournament_tree)) return false;
		if (updated_at == null) {
			if (other.updated_at != null) return false;
		} else if (!updated_at.equals(other.updated_at)) return false;
		if (winner == null) {
			if (other.winner != null) return false;
		} else if (!winner.equals(other.winner)) return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tournaments [status=" + status + ", max_competitors=" + max_competitors + ", province_i18n=" + province_i18n + ", province_id=" + province_id + ", province_status=" + province_status + ", competitors=" + competitors + ", finish_time=" + finish_time + ", start_time=" + start_time + ", updated_at=" + updated_at + ", winner=" + winner + ", tournament_tree=" + tournament_tree + "]";
	}

	public String						status;
	public Integer						max_competitors;
	public String						province_i18n;
	public String						province_id;
	public String						province_status;
	public List<Integer>				competitors		= new ArrayList<Integer>();
	public Long							finish_time;
	public Long							start_time;
	public Long							updated_at;
	public Integer						winner;
	public Set<LandingTournamentRound>	tournament_tree	= new HashSet<LandingTournamentRound>();

	public static class LandingTournamentRound {
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((battles == null) ? 0 : battles.hashCode());
			result = prime * result + ((current == null) ? 0 : current.hashCode());
			result = prime * result + ((round_idx == null) ? 0 : round_idx.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) return true;
			if (obj == null) return false;
			if (getClass() != obj.getClass()) return false;
			LandingTournamentRound other = (LandingTournamentRound) obj;
			if (battles == null) {
				if (other.battles != null) return false;
			} else if (!battles.equals(other.battles)) return false;
			if (current == null) {
				if (other.current != null) return false;
			} else if (!current.equals(other.current)) return false;
			if (round_idx == null) {
				if (other.round_idx != null) return false;
			} else if (!round_idx.equals(other.round_idx)) return false;
			return true;
		}

		public Boolean							current;
		public Integer							round_idx;
		public List<LandingTournamentBattle>	battles	= new ArrayList<LandingTournamentBattle>();

		public LandingTournamentRound() {
			super();
		}

		@Override
		public String toString() {
			return "TournRound [current=" + current + ", round_idx=" + round_idx + ", battles=" + battles + "]";
		}

		public static class LandingTournamentBattle {
			public Boolean canceled;
			public Boolean draw;
			public Boolean technical;
			public Integer	clan1;
			public Integer	clan2;
			public Long		start_at;
			public Integer	winner;

			public LandingTournamentBattle() {
				super();
			}

			@Override
			public String toString() {
				return "LandingTournamentBattle [canceled=" + canceled + ", draw=" + draw + ", technical=" + technical + ", clan1=" + clan1 + ", clan2=" + clan2 + ", start_at=" + start_at + ", winner=" + winner + "]";
			}

			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + ((canceled == null) ? 0 : canceled.hashCode());
				result = prime * result + ((clan1 == null) ? 0 : clan1.hashCode());
				result = prime * result + ((clan2 == null) ? 0 : clan2.hashCode());
				result = prime * result + ((draw == null) ? 0 : draw.hashCode());
				result = prime * result + ((start_at == null) ? 0 : start_at.hashCode());
				result = prime * result + ((technical == null) ? 0 : technical.hashCode());
				result = prime * result + ((winner == null) ? 0 : winner.hashCode());
				return result;
			}

			@Override
			public boolean equals(Object obj) {
				if (this == obj) return true;
				if (obj == null) return false;
				if (getClass() != obj.getClass()) return false;
				LandingTournamentBattle other = (LandingTournamentBattle) obj;
				if (canceled == null) {
					if (other.canceled != null) return false;
				} else if (!canceled.equals(other.canceled)) return false;
				if (clan1 == null) {
					if (other.clan1 != null) return false;
				} else if (!clan1.equals(other.clan1)) return false;
				if (clan2 == null) {
					if (other.clan2 != null) return false;
				} else if (!clan2.equals(other.clan2)) return false;
				if (draw == null) {
					if (other.draw != null) return false;
				} else if (!draw.equals(other.draw)) return false;
				if (start_at == null) {
					if (other.start_at != null) return false;
				} else if (!start_at.equals(other.start_at)) return false;
				if (technical == null) {
					if (other.technical != null) return false;
				} else if (!technical.equals(other.technical)) return false;
				if (winner == null) {
					if (other.winner != null) return false;
				} else if (!winner.equals(other.winner)) return false;
				return true;
			}

		}
	}

}
