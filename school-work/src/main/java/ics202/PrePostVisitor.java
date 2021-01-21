package ics202;

public interface PrePostVisitor
{

    public abstract void preVisit(Object obj);

    public abstract void inVisit(Object obj);

    public abstract void postVisit(Object obj);

    public abstract boolean isDone();

}