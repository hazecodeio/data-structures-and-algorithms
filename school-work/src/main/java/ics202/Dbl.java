package ics202;

public class Dbl extends AbstractObject {
	protected double value;
   
	public Dbl (double value) {
		this.value = value;
	}

	public double doubleValue () {
		return value;
	}

	protected int compareTo (MyComparable object) {
		Dbl arg = (Dbl) object;
		if (value < arg.value)
			return -1;
		else if (value > arg.value)
			return +1;
		else
			return 0;
	}
	
    public String toString() {
        return Double.toString(value);
    }
}