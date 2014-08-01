package rusty.wot.api.clanwars;

import java.util.ArrayList;
import java.util.List;

public class LandingTournament {
	
	@Override
	public String toString() {
		return "LandingTournament [status=" + status + ", max_competitors=" + max_competitors + ", province_i18n=" + province_i18n + ", province_id=" + province_id + ", province_status=" + province_status + ", competitors=" + competitors + ", finish_time=" + finish_time + ", start_time=" + start_time + ", updated_at=" + updated_at + ", winner=" + winner + ", tournament_tree=" + tournament_tree + "]";
	}

	public String			status;
	public Integer				max_competitors;
	public String			province_i18n;
	public String			province_id;
	public String			province_status;
	public List<Integer>	competitors	= new ArrayList<Integer>();
	public Long				finish_time;
	public Long				start_time;
	public Long				updated_at;
	public Integer				winner;
	public List<LandingTournamentRound> tournament_tree= new ArrayList<LandingTournamentRound>();
	public static class LandingTournamentRound {
		public Boolean				current;
		public Integer					round_idx;
		public List<LandingTournamentBattle>	battles = new ArrayList<LandingTournamentBattle>();
		
		public LandingTournamentRound(){
			super();
		}

		@Override
		public String toString() {
			return "TournRound [current=" + current + ", round_idx=" + round_idx + ", battles=" + battles + "]";
		}
		public static class LandingTournamentBattle {
			public Integer		clan1;
			public Integer		clan2;
			public Long		start_at;
			public Integer		winner;
			public String	fail_status;

			public LandingTournamentBattle(){
			super();	
			}
			
			@Override
			public String toString() {
				return "TournBattle [clan1=" + clan1 + ", clan2=" + clan2 + ", start_at=" + start_at + ", winner=" + winner + ", fail_status=" + fail_status + "]";
			}

		}
	}
	
}
	 

