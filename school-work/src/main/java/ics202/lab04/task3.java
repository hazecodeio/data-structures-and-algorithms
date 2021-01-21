 import ics202.*;
 class task3
 {
    public static void main(String args[])
    {
       StackAsLinkedList stack = new StackAsLinkedList();
       String postFix = "5 9 + 2 * 6 5 * +";
       int i;
       double o1, o2;
       Double obj, op1, op2, result;
       char ch;
       for(i=0; i<postFix.length(); i++)
       {
          ch = postFix.charAt(i);
          if(isDigit(ch))
          {
             obj = new Double(ch-'0');
             stack.push(obj);
          }
          
          else if(isOperator(ch))
          {
             op2 = (Double)stack.pop();
             o2 = op2.doubleValue();
             op1 = (Double)stack.pop();
             o1 = op1.doubleValue();
             switch(ch)
             {
                case '+' :
                   result = new Double(o1+o2);
                   stack.push(result);
                   break;
                case '-' :
                   result = new Double(o1-o2);
                   stack.push(result);
                   break;
                case '*' :
                   result = new Double(o1*o2);
                   stack.push(result);
                   break;
                case '/' :
                   result = new Double(o1/o2);
                   stack.push(result);
             } // switch
          } //else if
       } // for
       
       result = (Double)stack.pop();
       System.out.println("Result = " + result.doubleValue());
    } // main
    
    public static boolean isOperator(char ch)
    {
       return ((ch == '+') || (ch == '-') ||
               (ch == '*') || (ch == '/'));
    }
    
    public static boolean isDigit(char ch)
    {
       int value = ch - '0';
       return (value < 10 && value > -1);
    }
 } // class
