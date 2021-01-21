package ics202;

public class InOrder extends AbstractPrePostVisitor
{
	protected Visitor visitor;

    public InOrder(Visitor visitor)
    {
        this.visitor = visitor;
    }

    public void inVisit(Object obj)
    {
        visitor.visit(obj);
    }

    public boolean isDone()
    {
        return visitor.isDone();
    }  
}