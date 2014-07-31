package rusty.wot;

public class Cluster {
	private final String	name;
	private final String	appId;
	private final String	domain;
	private final String	noobMeterAbrev;
	private final int clusterId;


	public Cluster(int clusterId, String name, String appId, String domain, String noobMeterAbrev) {
		super();
		this.noobMeterAbrev = noobMeterAbrev;
		this.name = name;
		this.appId = appId;
		this.domain = domain;
		this.clusterId = clusterId;
	}

	@Override
	public String toString() {
		return "Cluster [name=" + name + ", appId=" + appId + ", domain=" + domain + ", clusterId=" + clusterId + "]";
	}

	public String getName() {
		return name;
	}
	public int getClusterId() {
		return clusterId;
	}

	public String getAppId() {
		return appId;
	}

	public String getDomain() {
		return domain;
	}

	public String getApiAddress() {
		return "api.worldoftanks."+domain;
	}

	public String getNoobMeterAbrev() {
		return noobMeterAbrev;
	}
}
