package rusty.wot.api;

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

}
	 

