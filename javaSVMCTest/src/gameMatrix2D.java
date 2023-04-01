import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class gameMatrix2D {
	static int x = 0;
	static int y = 0;
	static int lastArrow=-1;
	public static int[] findDirection(int[][] arr) {
		int[] direct = new int[3];
		for (int i = 0; i < 3; i++) {
			direct[i] = 0;
		}
//	 go left
		if (x - 1 >= 0 && arr[y][x - 1] == 1) {
			System.out.println("go left");
			direct[0] = 1;
		}
//	 go right
		if (x + 1 < arr.length && arr[y][x+1] == 1) {
			System.out.println("go right");
			direct[1] = 2;
		}
//		go up
		if (y - 1 >= 0 && arr[y-1][x] == 1) {
			System.out.println("go up");
			direct[2] = 3;
		}

		return direct;
	}

	public static void changeCordinate(int[][] arr, int direct) {
		switch (direct) {
		case 1: {
			arr[y][x] = 0;
			x = x - 1;
			break;
		}
		case 2: {
			arr[y][x] = 0;
			x = x + 1;
			break;
		}
		case 3: {
			arr[y][x] = 0;
			y = y - 1;
			break;
		}
		}
	}
	public static void move(int[][] arr) {
		int[] currentArrow=findDirection(arr);
		int check=0;
//		System.out.println(lastArrow);
		for(int i=0;i<3;i++) {
//			System.out.println(currentArrow[i]);
			if(currentArrow[i]!=lastArrow&&currentArrow[i]!=0) {
//				System.out.println(currentArrow[i]);
				lastArrow=currentArrow[i];
				changeCordinate(arr, lastArrow);
				check=1;
				break;
			}
		}
		if(check==0) {
//			System.out.println("here");
			changeCordinate(arr, lastArrow);
		}
	}
	public static void main(String[] agrs) throws FileNotFoundException {
		System.setIn(new FileInputStream("test.txt"));
		Scanner sc=new Scanner(System.in);
		int[][] arr=new int[10][10];
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				arr[i][j]=sc.nextInt();
				if(arr[i][j]==2) {
					x=j;
					y=i;
				}
			}
		}
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println(" ");
		}
		System.out.println("toa do diem den:"+x+" "+y);
		while(y>0) {
			move(arr);
			System.out.println(x+" "+y);
//			System.out.println(arr[y][x]);
		}
		System.out.println(x);
	}
}
