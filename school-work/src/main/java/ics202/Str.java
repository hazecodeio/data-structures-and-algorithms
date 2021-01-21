package ics202;

public class Str extends AbstractObject {
	protected String value;
   
	public Str (String value) {
		this.value = value;
	}

	public String stringValue () { 
		return value;
	}

	protected int compareTo (MyComparable object) {
		Str arg = (Str) object;
		return value.compareTo (arg.value);
	}
	
    public String toString() {
        return value;
    }
}
