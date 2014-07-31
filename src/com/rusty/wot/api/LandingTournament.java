package com.rusty.wot.api;

import java.util.ArrayList;
import java.util.List;

public class LandingTournament {
	
	@Override
	public String toString() {
		return "LandingTournament [status=" + status + ", max_competitors=" + max_competitors + ", province_i18n=" + province_i18n + ", province_id=" + province_id + ", province_status=" + province_status + ", competitors=" + competitors + ", finish_time=" + finish_time + ", start_time=" + start_time + ", updated_at=" + updated_at + ", winner=" + winner + ", tournament_tree=" + tournament_tree + "]";
	}

	public String			status;
	public int				max_competitors;
	public String			province_i18n;
	public String			province_id;
	public String			province_status;
	public List<Integer>	competitors	= new ArrayList<Integer>();
	public long				finish_time;
	public long				start_time;
	public long				updated_at;
	public int				winner;
	public List<TournRound> tournament_tree= new ArrayList<TournRound>();

}
	class TournRound {
		public boolean				current;
		public int					round_idx;
		public List<TournBattle>	battles = new ArrayList<TournBattle>();
		
		public TournRound(){
			super();
		}

		@Override
		public String toString() {
			return "TournRound [current=" + current + ", round_idx=" + round_idx + ", battles=" + battles + "]";
		}
	}
		class TournBattle {
			public int		clan1;
			public int		clan2;
			public long		start_at;
			public int		winner;
			public String	fail_status;

			public TournBattle(){
			super();	
			}
			
			@Override
			public String toString() {
				return "TournBattle [clan1=" + clan1 + ", clan2=" + clan2 + ", start_at=" + start_at + ", winner=" + winner + ", fail_status=" + fail_status + "]";
			}

		}
