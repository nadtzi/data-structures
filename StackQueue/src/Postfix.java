
public class Postfix {
	public double postfix(String s) {
		ArrayStack<Double> p = new ArrayStack<Double>();
		char [] c = s.toCharArray();
		for(int i = 0;i<c.length;i++) {
			if(c[i]=='*') {
				double num1 = p.pop();
				double num2 = p.pop();
				//double res = num2*num1;
			p.push(num2*num1);
			continue;
			}
			else if(c[i]=='+') {
				double num1 = p.pop();
				double num2 = p.pop();
				//double res = num2+num1;
			p.push(num2+num1);
			continue;
			}
			else if(c[i]=='-') {
				double num1 = p.pop();
				double num2 = p.pop();
				//double res = num2-num1;
			p.push(num2-num1);
			continue;
			}
			else if(c[i]=='/') {
				double num1 = p.pop();
				double num2 = p.pop();
				//double res = num2/num1;
			p.push(num2/num1);
			continue;
			}
			
			else if(Character.isDigit(c[i]))
					p.push((double) c[i]);
		}
		return p.top();
	}
}
