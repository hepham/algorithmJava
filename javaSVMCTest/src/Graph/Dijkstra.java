package Graph;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
class Leaf{
	int x;
	int y;
	int r;
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
	public int getR() {
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}
	public Leaf(int x, int y, int r) {
		super();
		this.x = x;
		this.y = y;
		this.r = r;
	}
	
}
public class Dijkstra {

    private static int n; 
    private static int[][] graph; 
    private static int[] dist; 
    private static boolean[] visited;
    public static int sqr(int x) {
    	return x*x;
    }
    public static int distance(Leaf start,Leaf end) {
 
    	int d=sqr(start.getX()-end.getX())+sqr(start.getY()-end.getY());
    	int radius=start.getR()+end.getR();
    	
    	if(d<sqr(radius+40))return 1;
    	if(d<=sqr(radius+90))return 200;
    	return -1;
    }
    public static void dijkstra(int start) {
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        dist[start] = 0;

       
        for (int i = 0; i < n - 1; i++) {
            int u = minDistance(dist, visited);
            visited[u] = true;

            for (int v = 0; v < n; v++) {
                if (!visited[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE
                        && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }
    }
    private static int minDistance(int[] dist, boolean[] visited) {
        int minDist = Integer.MAX_VALUE, minIndex = -1;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && dist[i] <= minDist) {
                minDist = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void main(String[] args) throws FileNotFoundException {
    	System.setIn(new FileInputStream("test.txt"));
    	Scanner sc=new Scanner(System.in);
    	int T=sc.nextInt();
        for(int testcase=1;testcase<=T;testcase++) {
        	n=sc.nextInt();
        	Leaf[] pointArray=new Leaf[n];
        	for(int i=0;i<n;i++) {
        		pointArray[i]=new Leaf(sc.nextInt(),sc.nextInt(),sc.nextInt());
        	}
        	graph=new int[n][n];
        	for(int i=0;i<n;i++) {
        		for(int j=0;j<n;j++) {
        			graph[i][j]=distance(pointArray[i], pointArray[j]);
        		}
        	}

        	  dist = new int[n];
    	      visited = new boolean[n];
    	
    	      dijkstra(0);
    	      int longStep=dist[n-1]/200;
    	      int shortStep=dist[n-1]%200;
    	      System.out.println("Case #"+testcase+" "+longStep+" "+shortStep);
    	      
    	      
        }
	    
    }
}
