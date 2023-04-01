import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Point{
	int x;
	int y;
	public Point() {
		
	}
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
}
class CustomStack{
	int size=100;
	int top=-1;
	Point[] arr=new Point[size];
	boolean isEmpty() {
		return top==-1;
	}
	boolean isFull() {
		return top==size-1;
	}
	void add(Point x) {
		if(!isFull()) {
			top=top+1;
			arr[top]=x;
		}
	}
	Point get() {
		if(!isEmpty()) {
			top=top-1;
			return arr[top+1];
		}
		return new Point(0,0);
	}
	
}
public class Star {
	static boolean[][] map=new boolean[10][10];
	public static int[] findDirection(int[][]arr,Point point) {
		int[] direction=new int[4];
		for(int i=0;i<4;i++)direction[i]=0;
//		go left
		if(point.getX()-1>=0&&arr[point.getY()][point.getX()-1]==1&&map[point.getY()][point.getX()-1]==true) {
			direction[0]=1;
//			System.out.println("left");
		}
		if(point.getX()+1<arr[0].length&&arr[point.getY()][point.getX()+1]==1&&map[point.getY()][point.getX()+1]==true) {
			direction[1]=2;
//			System.out.println("right");
		}
		if(point.getY()+1<arr.length&& arr[point.getY()+1][point.getX()]==1&& map[point.getY()+1][point.getX()]==true) {
			direction[2]=3;
//			System.out.println("down");
		}
		if(point.getY()-1>=0&& arr[point.getY()-1][point.getX()]==1&& map[point.getY()-1][point.getX()]==true) {
			direction[3]=4;
//			System.out.println("up");
		}
		return direction;
	}
	public static boolean starCluster(int[][] arr,Point point) {
		int i=0;
		int j=0;
		CustomStack customStack=new CustomStack();
		customStack.add(point);
		Point x=new Point(point.getX(),point.getY());
		boolean check=false;
		while(!customStack.isEmpty()&&map[x.getY()][x.getX()]==true) {
//			System.out.println("Point get from stack:"+x.toString());
//			customStack.get();
			check=true;
			map[x.getY()][x.getX()]=false;
			int[] direction=findDirection(arr, x);
			for(i=0;i<direction.length;i++) {
				if(direction[i]==1) {
					Point t=new Point(x.getX()-1,x.getY());
//					map[x.getY()][x.getX()-1]=false;
					customStack.add(t);
//					System.out.println("Stack add Element:"+t.toString());
				}
				if(direction[i]==2) {
					Point t=new Point(x.getX()+1,x.getY());
//					map[x.getY()][x.getX()]=false;
					customStack.add(t);
//					System.out.println("Stack add Element:"+t.toString());

				}
				if(direction[i]==3) {
					Point t=new Point(x.getX(),x.getY()+1);
					customStack.add(t);
//					System.out.println("Stack add Element:"+t.toString());
				}
				if(direction[i]==4) {
					Point t=new Point(x.getX(),x.getY()-1);
					customStack.add(t);
//					System.out.println("Stack add Element:"+t.toString());
				}
			}
			x=customStack.get();
			while(map[x.getY()][x.getX()]==false&&!customStack.isEmpty()) {
//				System.out.println("Point break:"+x.toString());
				x=customStack.get();
			}
		}
		return check;
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("testStar.txt"));
		Scanner sc=new Scanner(System.in);
		int [][] arr=new int[10][10];
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				arr[i][j]=sc.nextInt();
				map[i][j]=true;
			}
		}

		int count=0;
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				if(arr[i][j]==1&&map[i][j]==true) {
					Point t=new Point(j,i);
	
					if(starCluster(arr, t))count=count+1;
//					System.out.println("_________________________");
					
				}
			}
		}
		System.out.println("Result:"+count);

	}

}
