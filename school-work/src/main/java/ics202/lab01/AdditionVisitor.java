package ics202.lab01;

import ics202.*;

public class AdditionVisitor extends AbstractVisitor {
	private int sum=0;
	
	public int getSum() {
		return sum;
	}
	
	public void visit(Object object) {
		int value = ((Int) object).intValue();
		sum+=value;
	}
}
				