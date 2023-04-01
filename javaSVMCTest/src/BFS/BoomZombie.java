package BFS;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Point {
	private int x;
	private int y;
	private int d;

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

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}

	public Point(int x, int y, int d) {
		super();
		this.x = x;
		this.y = y;
		this.d = d;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + ", d=" + d + "]";
	}

}

class customQueue {
	int size = 10000;
	int top = -1;
	int start = -1;
	Point[] arr = new Point[size];

	boolean isEmpty() {
		return top == start;
	}

	boolean isFull() {
		return top == size;
	}

	void add(Point p) {
		if (!isFull()) {
			arr[++top] = p;
		}
	}

	Point get() {
		if (!isEmpty()) {
			return arr[++start];
		}
		return new Point(0, 0, -1);
	}
}

public class BoomZombie {
	public static int timeDestroy(int arr[][], Point boom) {
		int max = 0;
		customQueue queue = new customQueue();
		queue.add(boom);
		boolean visited[][]=new boolean[arr.length][arr[0].length];
		visited[boom.getX()][boom.getY()]=true;
		arr[boom.getX()][boom.getY()]=-1;
		while (!queue.isEmpty()) {
			Point t = queue.get();
			if (t.getD() > max)
				max = t.getD();
			int[] dx = { -1, 0, 0, 1 };
			int[] dy = { 0, -1, 1, 0 };
			for (int i = 0; i < 4; i++) {
				int newX = t.getX() + dx[i];
				int newY = t.getY() + dy[i];
				if (newX >= 0 && newX < arr.length && newY >= 0 && newY < arr[0].length && arr[newX][newY] == 1&&!visited[newX][newY]) {
					Point newPoint = new Point(newX, newY, t.getD() + 1);
					visited[newX][newY]=true;
					arr[newX][newY]=t.getD()+1;
					queue.add(newPoint);
				}
			}
		}
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println(" ");
		}
		return max;
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("test.txt"));
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int arr[][] = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		Point boom = new Point(sc.nextInt(), sc.nextInt(), 0);
		System.out.println(timeDestroy(arr, boom));

	}

}
