package ics202;

public class Flt extends AbstractObject {
    protected float value;
   
    public Flt (float value) {
        this.value = value;
    }

    public float floatValue () {
        return value;
    }

    protected int compareTo (MyComparable object) {
        Flt arg = (Flt) object;
        if (value < arg.value)
            return -1;
        else if (value > arg.value)
            return +1;
        else
            return 0;
    }
    
    public String toString() {
        return Float.toString(value);
    }
}