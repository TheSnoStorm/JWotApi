package rusty.wot.api;

import java.util.ArrayList;
import java.util.List;

public class LandingTournamentRound {
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
}