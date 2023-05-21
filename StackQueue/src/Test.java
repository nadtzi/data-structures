import java.util.Scanner;

public class Test {
	
	public static double postfix(String s) {
		ArrayStack<Double> p = new ArrayStack<Double>();
		char [] c = s.toCharArray();
		for(int i = 0;i<c.length;i++) {
			if(c[i]=='*') {
				double num1 = p.pop();
				double num2 = p.pop();
			p.push(num2*num1);
			continue;
			}
			else if(c[i]=='+') {
				double num1 = p.pop();
				double num2 = p.pop();
			p.push(num1+num2);
			continue;
			}
			else if(c[i]=='-') {
				double num1 = p.pop();
				double num2 = p.pop();
			p.push(num2-num1);
			continue;
			}
			else if(c[i]=='/') {
				double num1 = p.pop();
				double num2 = p.pop();
			p.push(num2/num1);
			continue;
			}
			
			else if(Character.isDigit(c[i]))
					p.push((double) Character.getNumericValue(c[i]));
		}
		return p.top();
	}
	
	public static void main(String arg[])
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter the Postfix: ");
		String s = in.nextLine();
		while(!s.equalsIgnoreCase("stop")) {
	
	System.out.println("The Prefix result = " +Test.postfix(s));
	System.out.println("Please enter the Postfix or Stop to exit: ");
	s = in.nextLine();
		}
		System.out.println(" you have exited");
		
	}
}