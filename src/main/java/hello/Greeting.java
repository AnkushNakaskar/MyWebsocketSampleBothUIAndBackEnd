package hello;

import java.io.Serializable;

public class Greeting implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String content;
    private String fleetId;
    private String driverId;

    public Greeting() {
    }

    public Greeting(String content) {
        this.content = content;
    }

    public Greeting(String fleetId, String driverId) {
    	this.fleetId =fleetId;
    	this.driverId =driverId;
	}

	public String getContent() {
        return content;
    }

	public String getFleetId() {
		return fleetId;
	}

	public void setFleetId(String fleetId) {
		this.fleetId = fleetId;
	}

	public String getDriverId() {
		return driverId;
	}

	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}

}
