package ics202;

public class Association extends AbstractObject
{
    protected MyComparable key;
    protected Object value;

    public Association(MyComparable comparable, Object obj)
    {
        key = comparable;
        value = obj;
    }

    public Association(MyComparable comparable)
    {
        this(comparable, null);
    }

    public MyComparable getKey()
    {
        return key;
    }

    public Object getValue()
    {
        return value;
    }
    
    public void setValue(Object value){
    	this.value = value;
    }

    protected int compareTo(MyComparable comparable)
    {
        Association association = (Association)comparable;
        return key.compare(association.getKey());
    }

    public String toString()
    {
        String s = "{ " + key;
        if(value != null)
            s = s + " ,   " + value;
        return s + " }";
    }
}
