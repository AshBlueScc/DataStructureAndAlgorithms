package graph;

import javax.xml.soap.Node;

public class Vertex {
	private String name;
	public boolean visited;
	
	public Vertex(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
}
