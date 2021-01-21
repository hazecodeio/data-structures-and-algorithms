package ics202;

import java.util.NoSuchElementException;

public interface Enumeration {
	boolean hasMoreElements ();
	Object nextElement () throws NoSuchElementException;
}