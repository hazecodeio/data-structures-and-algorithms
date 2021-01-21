package ics202;

public abstract class AbstractVisitor implements Visitor {

	public abstract void visit (Object object);

	public boolean isDone () {
		return false;
	}
}