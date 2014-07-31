package rusty.wot.api;

public class LandingTournamentBattle {
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
