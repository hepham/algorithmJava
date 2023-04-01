package javaSVMCTest;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Point{
	int x;
	int y;
	int arrow;
	public Point() {
		
	}
	public Point(int x, int y, int arrow) {
		super();
		this.x = x;
		this.y = y;
		this.arrow = arrow;
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
	public int getArrow() {
		return arrow;
	}
	public void setArrow(int arrow) {
		this.arrow = arrow;
	}
	public boolean checkOutMap() {
		return y>10||y<0;
	}
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + ", arrow=" + arrow + "]";
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
			top=top++;
			arr[top]=x;
		}
	}
	Point get() {
		if(!isEmpty()) {
			top=top--;
			return arr[top+1];
		}
		return new Point(-1,-1,0);
	}
	
}
public class Magnet {
	static int[][] map=new int[10][10];
	public static int checkColide(Point point) {
		if(point.getArrow()==1 && map[point.getY()+1][point.getX()]==1) {
			map[point.getY()][point.getX()]=1;
			 map[point.getY()+1][point.getX()]=0;
			point.setY(point.getY()+1);
			return 1;
		}
		if(point.getArrow()==2 && map[point.getY()-1][point.getX()]==1) {
			map[point.getY()][point.getX()]=1;
			point.setY(point.getY()-1);
			map[point.getY()-1][point.getX()]=0;
			return 1;
		}
		return 0;
	}
	public static void main(String[] agrs) throws FileNotFoundException {
		System.setIn(new FileInputStream("test.txt"));
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		Point[] pointArray=new Point[10000];
		int pointCount=0;
		int[][] arr=new int[10][10];
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				map[i][j]=1;
			}
		}
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		for(int i=0;i<10;i++) {
			CustomStack customStack=new CustomStack();
			for(int j=0;j<10;j++) {
				if(arr[j][i]==1) {
					Point point=new Point(j,i,1);
					pointArray[pointCount+1]=point;
					
					
				}
				if(arr[i][j]==2) {
					Point point=new Point(j,i,2);
					pointArray[pointCount+1]=point;
				}
				
				map[i][j]=0;
				
			}
		}
	}

}
