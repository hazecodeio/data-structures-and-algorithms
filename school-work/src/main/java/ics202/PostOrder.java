package ics202;

public class PostOrder extends AbstractPrePostVisitor
{
	protected Visitor visitor;

    public PostOrder(Visitor visitor)
    {
        this.visitor = visitor;
    }

    public void postVisit(Object obj)
    {
        visitor.visit(obj);
    }

    public boolean isDone()
    {
        return visitor.isDone();
    }
}