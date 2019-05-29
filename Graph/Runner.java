public class Runner {

	public static void main(String[] args) {

		Graph graph = new Graph();
		
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addVertex("G");
		///graph.addVertex("H");
		
		graph.addEdge("A", "B", 2);
		graph.addEdge("A", "D", 3);
		graph.addEdge("B", "C", 1);
		graph.addEdge("C", "D", 8);
		graph.addEdge("D", "E", 10);
		graph.addEdge("E", "F", 45);
		graph.addEdge("E", "G", 7);
		graph.addEdge("F", "G", 18);
		
		graph.display();
		System.out.println("Cycle in graph: "+graph.isCyclic());
		System.out.println("Graph is Connected "+graph.isConnected());
		
		System.out.println(graph.numVertex());
		System.out.println(graph.numEdges());
		
		System.out.println(graph.containsEdge("A", "C"));
		System.out.println(graph.containsEdge("E", "F"));
		
		graph.removeEdge("A", "B");
		graph.display();
		
		graph.removeVertex("F");
		graph.display();
		
		graph.addVertex("F");
		graph.display();
		
		graph.addEdge("F", "A", 10);
		graph.display();
		
		System.out.println(graph.hasPath("A", "F"));
		
		System.out.println(graph.bfs("A", "G"));
		System.out.println(graph.dfs("A", "G"));
		
		graph.bft();
		System.out.println();
		graph.dft();
		
		System.out.println("Graph is Tree or not : "+graph.isTree());
		
		System.out.println(graph.getCC());
		
		graph.prims().display();
		
	}
	

}
