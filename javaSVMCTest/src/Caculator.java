import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Caculator {

	public static int calculate(String str) {
		CustomStack1 customStack = new CustomStack1();
		String s="";
		int check=0;
		for(int j=str.length()-1;j>=0;j--) {
			s+=str.charAt(j);

		}
		int result = 0;
		int i = 0;
		int val=0;
		char operator='+';
		while(i<s.length()) {
			char c=s.charAt(i);
			if(c>='0'&&c<='9') {
				val=val*10+c-'0';
				if(operator=='+') {
					customStack.add(val);
				}
				if(operator=='*') {
					customStack.add(customStack.get()*val);
				}
			}else {
				val=0;
				operator=c;
			}
			i++;
			
			
		}
		while(!customStack.isEmpty()) {
			result=result+customStack.get();
		}
//		System.out.println("result:"+result);
		return result;
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("test.txt"));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		String s = sc.nextLine();
		System.out.println(s);
		int i = 0;

		CustomStack2 operator = new CustomStack2();
		CustomStack1 number = new CustomStack1();
		char c = '0';
		while (i < s.length()) {
			c = s.charAt(i);
			if (c >= '0' && c <= '9') {

				number.add(c - '0');
			} else if(c=='('||c=='*'||c=='+'){
				operator.add(c);
			}

			if(c==')') {
				int sum=0;
				String result="";
				char op=operator.get();
//				System.out.println(c);
				while(op!='(') {
					result=result+number.get();
					result+=op;
					op=operator.get();
//					System.out.println(op);
					
				}
				result=result+number.get();

				System.out.println("result:"+result);
				sum=calculate(result);
				number.add(sum);
				System.out.println(sum);
			}	
			i++;
		}
//		int T=0;
//		String str="";
//		while(!number.isEmpty()) {
//			str=str+number.get();
//			str=str+operator.get();
//		}
//		System.out.println("str97:"+str);
//		T=calculate(str);
//		System.out.println(T);
	}

}

class CustomStack1 {
	static int size = 100;
	int pop = -1;
	int[] arr = new int[size];

	boolean isEmpty() {
		return pop == -1;
	}

	boolean isFull() {
		return pop == size - 1;
	}

	void add(int x) {
		if (!isFull()) {
			pop = pop + 1;
			arr[pop] = x;
		}
	}

	int get() {
		if (!isEmpty()) {
			pop = pop - 1;
			return arr[pop + 1];
		}
		return 0;
	}
}

class CustomStack2 {
	static int size = 100;
	int pop = -1;
	char[] arr = new char[size];

	boolean isEmpty() {
		return pop == -1;
	}

	boolean isFull() {
		return pop == size - 1;
	}

	void add(char x) {
		if (!isFull()) {
			pop = pop + 1;
			arr[pop] = x;
		}
	}

	char get() {
		if (!isEmpty()) {
			pop = pop - 1;
			return arr[pop + 1];
		}
		return 0;
	}
}
