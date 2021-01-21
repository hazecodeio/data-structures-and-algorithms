package ics202;

public class Chr extends AbstractObject {
	protected char value;
 
	public Chr (char value)	{
		this.value = value;
	}

	public char charValue () {
		return value;
	}

	protected int compareTo (MyComparable object) {
		Chr arg = (Chr) object;
		return (int) value - (int) arg.value;
	}
	
    public String toString() {
        return String.valueOf(value);
    }
}
