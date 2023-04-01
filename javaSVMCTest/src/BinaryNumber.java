
public class BinaryNumber {
	static int n;
	static int[] X=new int[100];
	static void printResult() {
		for(int i=1;i<=n;i++) {
			System.out.print(X[i]+" ");
		}
		System.out.println("");
	}
	static void Try(int i) {
		for(int j=0;j<=1;j++) {
			X[i]=j;
			if(i==n) {
				printResult();
			}else {
				Try(i+1);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		n=10;
		Try(1);
	}

}
