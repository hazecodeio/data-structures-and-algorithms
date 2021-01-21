package ics202.lab01;

import ics202.*;

public class PrintingVisitor extends AbstractVisitor {
	public void visit(Object object) {
		System.out.println(object);
	}
}
				