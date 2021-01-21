package ics202;

public class Int extends AbstractObject {
	protected int value;
   
	public Int (int value) {
		this.value = value;
	}

	public int intValue () {
		return value;
	}

	protected int compareTo (MyComparable object) {
		Int arg = (Int) object;
		if (value < arg.value)
			return -1;
		else if (value > arg.value)
			return +1;
		else
			return 0;
	}
	
    public String toString() {
        return Integer.toString(value);
    }
}