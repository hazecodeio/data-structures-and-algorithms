package ics202;

public class PreOrder extends AbstractPrePostVisitor
{
	protected Visitor visitor;

    public PreOrder(Visitor visitor)
    {
        this.visitor = visitor;
    }

    public void preVisit(Object obj)
    {
        visitor.visit(obj);
    }

    public boolean isDone()
    {
        return visitor.isDone();
    }   
}