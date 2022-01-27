package gov.mef.gfa.gestionale.model;

/**
 * The type Test.
 */
public class Test {

	private long ID;
	private String val_1;

	public long getID() {
		return ID;
	}

	public void setID(long ID) {
		this.ID = ID;
	}

	public String getVal_1() {
		return val_1;
	}

	public void setFirstName(String val_1) {
		this.val_1 = val_1;
	}

	@Override
	public String toString() {
		return "User [ID=" + ID + ", val_1=" + val_1 + "]";
	}
}
