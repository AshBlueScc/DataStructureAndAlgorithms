package graph;

import java.nio.file.Path;
import java.util.Arrays;
import myQueue.MyQueue;
import myStack.Mystack;

public class Graph {
	private Vertex[] vertex;	//记录顶点的数组
	private int[][] adjMat;	//邻接矩阵
	private int currentSize;
	private Mystack mystack; //用于dfs
	private MyQueue myQueue;	//用于bfs
	private int currentIndex;
	
	
	public Graph(int size) {
		vertex = new Vertex[size];
		adjMat = new int[size][size];
		currentSize = 0;
		mystack = new Mystack();
		myQueue = new MyQueue();
		currentIndex = 0;
		
		for(int i = 0; i < adjMat.length; i++) {
			for(int j = 0; j < adjMat[i].length; j++) {
				if(i == j) {
					adjMat[i][j] = 0;
				}else {
					adjMat[i][j] = Integer.MAX_VALUE;
				}
				
			}
		}
	}
	
	public void addEdge(Vertex v1, Vertex v2, int value) {
		String name1 = v1.getName();
		String name2 = v2.getName();
		
		int index1 = 0;
		for(int i = 0; i < vertex.length; i ++) {
			if(name1 == vertex[i].getName()) {
				index1 = i;
				break;
			}
		}
		
		int index2 = 0;
		for(int i = 0; i < vertex.length; i ++) {
			if(name2 == vertex[i].getName()) {
				index2 = i;
				break;
			}
		}
		
		adjMat[index1][index2] = value;
		adjMat[index2][index1] = value;
	}
	
	public void addVertex(Vertex vt) {
		vertex[currentSize++] = vt;
	}

	public int[][] getAdjMat() {
		return adjMat;
	}
	
	/**
	 * 深度优先搜索算法（Depth-First Search）
	 * ->表示进栈或者入队
	 * <-表示出栈或者出队
	 * 
	 */
	public void dfs() {
		//首先把第0个元素推进去
		if(vertex.length != 0) {
			vertex[0].visited = true;
			mystack.push(0);
			
			
			System.out.print(vertex[0].getName() + "->");
			
			out:while(!mystack.isEmpty()) {
				
				for(int i = currentIndex + 1; i < vertex.length; i++) {
					if(adjMat[currentIndex][i] !=Integer.MAX_VALUE && adjMat[currentIndex][i] !=0 && vertex[i].visited == false) {
						vertex[i].visited = true;
						mystack.push(i);
						System.out.print(vertex[i].getName() + "->");
						currentIndex++;
						continue out;
					}
				}	
				int k = mystack.pop();
				System.out.print(vertex[k].getName() + "<-");
				
				if(!mystack.isEmpty()) {				
					currentIndex=mystack.peek();
				}
			}
			
		}
	}
	
	/**
	 * 广度优先搜索算法（Breadth-First Search）
	 * ->表示进栈或者入队
	 * <-表示出栈或者出队
	 */
	public void  bfs() {
		
		if(vertex.length != 0) {
			vertex[0].visited = true;
			myQueue.add(0);
			System.out.print(vertex[0].getName() + "->");
			
			while(!myQueue.isEmpty()) {
				for(int i = currentIndex + 1; i < vertex.length; i++) {
					if(adjMat[currentIndex][i] !=Integer.MAX_VALUE && adjMat[currentIndex][i] !=0 && vertex[i].visited == false) {
						vertex[i].visited = true;
						myQueue.add(i);
						System.out.print(vertex[i].getName() + "->");
					}
				}	
				int k = myQueue.poll();
				System.out.print(vertex[k].getName() + "<-");		
				if(!myQueue.isEmpty()) {				
					currentIndex = myQueue.peek();
				}
				
			}
			
		}
	}
	
	/*
	 * 弗洛伊德算法(Floyd)
	 * 输出最短路径长度以及路径
	 * 参考:https://www.cnblogs.com/twjcnblog/archive/2011/09/07/2170306.html
	 */
	public void floyd(Vertex a, Vertex b) { 
		Mystack ms = new Mystack();	//用来存储某个终点的所有前驱节点
		int[][] pre = new int[vertex.length][vertex.length];		//前驱节点初始化
		for(int i = 0; i < vertex.length; i++) {
			for(int j = 0; j < vertex.length; j++) {
				pre[i][j] = i;
			}
		}
		
		//遍历中转点数组
//		System.out.println("--------------------");
//		for(int[] d:pre) {
//			System.out.println(Arrays.toString(d));
//		}
		
		//遍历中转点
		for(int k = 0; k < vertex.length; k++) {
			//遍历起点
			for(int i = 0; i < vertex.length; i++) {
				//遍历终点	
				for(int j = 0; j < vertex.length; j++) {
					int update = adjMat[i][j];
					int transfer = adjMat[i][k] + adjMat[k][j];
					if( adjMat[i][k] != Integer.MAX_VALUE && adjMat[k][j] != Integer.MAX_VALUE && update > transfer) {
						adjMat[i][j] = transfer;
						pre[i][j] = pre[k][j];
					}
				}
			}
		}
		
		//经过floyd算法后的各点之间的最短距离
//		System.out.println("--------------------");
//		for(int[] c:adjMat) {
//			System.out.println(Arrays.toString(c));
//		}
		
		//遍历中转点数组
//		System.out.println("--------------------");
//		for(int[] d:pre) {
//			System.out.println(Arrays.toString(d));
//		}
	
		//遍历所有点之间最短路径以及最短距离
		//遍历起点
		System.out.println("Origin->Dest 	Distance		Path");
		for(int i = 0; i < vertex.length; i++) {
			//遍历终点
			for(int j = 0; j < vertex.length; j++) {				
				if( i != j){
					if(adjMat[i][j] != Integer.MAX_VALUE) {
						int k = j;
						while (pre[i][k] != i) {
							ms.push(pre[i][k]);
							k = pre[i][k];
						}
						ms.push(i);
						String path = "";
						while(!ms.isEmpty()) {
							int v = ms.pop();
							path +=vertex[v].getName() + "->";
							
						}
						path += vertex[j].getName();
						if(a.getName() == vertex[i].getName() && b.getName() == vertex[j].getName()) {
							System.out.println(vertex[i].getName()+ "->" +vertex[j].getName() + "		" + adjMat[i][j] + "		"+path);
						}
					}else {
						System.out.println("No path!");
					}
				}
			}
		}
		
	}	
	
	//floyd算法遍历出所有点之间的最短路径和记录路径
	public void floydALL() { 
		Mystack ms = new Mystack();	//用来存储某个终点的所有前驱节点
		int[][] pre = new int[vertex.length][vertex.length];		//前驱节点初始化
		for(int i = 0; i < vertex.length; i++) {
			for(int j = 0; j < vertex.length; j++) {
				pre[i][j] = i;
			}
		}
		
		//遍历中转点数组
//		System.out.println("--------------------");
//		for(int[] d:pre) {
//			System.out.println(Arrays.toString(d));
//		}
		
		//遍历中转点
		for(int k = 0; k < vertex.length; k++) {
			//遍历起点
			for(int i = 0; i < vertex.length; i++) {
				//遍历终点	
				for(int j = 0; j < vertex.length; j++) {
					int update = adjMat[i][j];
					int transfer = adjMat[i][k] + adjMat[k][j];
					if( adjMat[i][k] != Integer.MAX_VALUE && adjMat[k][j] != Integer.MAX_VALUE && update > transfer) {
						adjMat[i][j] = transfer;
						pre[i][j] = pre[k][j];
					}
				}
			}
		}
		
		//经过floyd算法后的各点之间的最短距离
//		System.out.println("--------------------");
//		for(int[] c:adjMat) {
//			System.out.println(Arrays.toString(c));
//		}
		
		//遍历中转点数组
//		System.out.println("--------------------");
//		for(int[] d:pre) {
//			System.out.println(Arrays.toString(d));
//		}
	
		//遍历所有点之间最短路径以及最短距离
		//遍历起点
		System.out.println("Origin	->Dest Distance		->Path");
		for(int i = 0; i < vertex.length; i++) {
			//遍历终点
			for(int j = 0; j < vertex.length; j++) {				
				if( i != j){
					if(adjMat[i][j] != Integer.MAX_VALUE) {
						int k = j;
						while (pre[i][k] != i) {
							ms.push(pre[i][k]);
							k = pre[i][k];
						}
						ms.push(i);
						String path = "";
						while(!ms.isEmpty()) {
							int v = ms.pop();
							path +=vertex[v].getName() + "->";
							
						}
						path += vertex[j].getName();
						System.out.println(vertex[i].getName()+ "->" +vertex[j].getName() + "		" + adjMat[i][j] + "		"+path);
					}else {
						System.out.println("No path!");
					}
				}
			}
		}
		
	}	
	
	/**
	 * 狄杰特拉斯算法(Diskstra)
	 * 输出最短路径长度以及路径
	 * 参考:https://www.cnblogs.com/skywang12345/p/3711516.html
	 */
	public void dijkstra(Vertex v) {	
		//存储哪些点到点v的最短距离已经求出来了
		boolean[] flag = new boolean[vertex.length];
		//求v的下标
		int index1 = 0;
		int[] dis = new int[vertex.length];
		int[] prev= new int[vertex.length];	//前驱数组
		for(int i = 0; i < vertex.length; i++) {
			if(v.getName() == vertex[i].getName()) {
				index1 = i;		//该点在点的数组中的下标
				break;
			}
		}
		//初始化前驱节点数组
		for(int i = 0; i<vertex.length; i++) {
			flag[i] = false;		//该点到v的最短距离还没求出来
			prev[i] = i;		//该点的前驱节点为自己
			dis[i] = adjMat[index1][i];	//该点的最短路径为该点到v的权
		}
		
		//顶点自身初始化
		flag[index1] = true;
		dis[index1] = 0;
		
		int k = 0;
		for(int i = 0; i<vertex.length;i++) {
			int min = Integer.MAX_VALUE;
			for(int j = 0;j<vertex.length;j++) {
				if(flag[j] == false && dis[j] < min) {
					min = dis[j];
					k = j;
				}
			}
			
			flag[k] = true;
			
			for(int j = 0; j<vertex.length;j++){
				if(min!=Integer.MAX_VALUE) {
					int tmp = (adjMat[k][j] == Integer.MAX_VALUE ? Integer.MAX_VALUE:(min + adjMat[k][j]));				
					if(flag[j] == false && (tmp<dis[j])) {
						dis[j] = tmp;
						prev[j] = k;
					}
				}
			}
		}
		//prev实际上得到的是各点到v的前驱节点，故因倒过来输出
//		System.out.println(Arrays.toString(prev));
		System.out.println("Origin->Des    "+"Distance    " + "paths");
		for(int i = 0; i<vertex.length; i++) {
			Mystack mys = new Mystack();
			int k1 = prev[i];
			mys.push(i);
			while(prev[k1] != k1) {
				mys.push(k1);
				k1 = prev[k1];
			}
			if(k1 != i) {
				mys.push(k1);
			}
			String path = "";
			path += vertex[index1].getName() + "->";
			while(!mys.isEmpty()) {
				path+=vertex[mys.pop()].getName() + "->";
			}	
			path+="end!";
			System.out.println(v.getName()+"->"+vertex[i].getName()+"    		"+dis[i]+"    	    " + path);
		}
		
	}
}
