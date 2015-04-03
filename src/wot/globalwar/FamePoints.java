package wot.globalwar;

import org.joda.time.DateTime;



import com.fasterxml.jackson.annotation.JsonProperty;

public class FamePoints implements Comparable<FamePoints> {
private String bbOutput = null;
public String getBbOutput() {
	return bbOutput;
}
public void setBbOutput(String bbOutput) {
	this.bbOutput = bbOutput;
}
public Integer account_id;
public Integer fame_points;
public Integer position;
private DateTime updated_at;

@JsonProperty("updated_at")
	public DateTime getUpdatedAt() {
	return updated_at;
}
	@JsonProperty("updated_at")
public void setUpdatedAt(long timeStamp) {
	this.updated_at = new DateTime(timeStamp *1000l);
}
	public FamePoints() {
	}
@Override
	public String toString() {
	return bbOutput;
	}
@Override
public int compareTo(FamePoints that) {
	if(that == null) return 1;
	else{
		
		return this.position.compareTo(that.position);
	}
}

}
