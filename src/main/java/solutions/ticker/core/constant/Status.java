package solutions.ticker.core.constant;

public enum Status {
	ERROR {
	    public String toString() {
	        return "Error";
	    }
	},
	 
	APPROVED {
	    public String toString() {
	        return "Approved";
	    }
	}
}
