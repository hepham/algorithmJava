import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Score {
	static int n=100;
	static int m=100;
	static int count=0;
	int[] result=new int[100];
	void sum(int target) {
		int sum=0;
		for(int i=0;i<m;i++) {
			sum=sum+result[i];
		}
		if(sum==target) {
			count=count+1;
		}
	}
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("testStar.txt"));
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		int score=sc.nextInt();
		int[][] arr=new int[3][4];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		count(arr,-1,-1,0,score);
		System.out.println(count);
	}

}
