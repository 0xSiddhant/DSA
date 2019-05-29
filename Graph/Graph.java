import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Graph {

	private class Vertex{
		HashMap<String, Integer> nbrs = new HashMap<>();
	}
	
	private HashMap<String, Vertex> vtcs;
	
	Graph(){
		vtcs = new HashMap<>();
	}
	
	public int numVertex() {
		return this.vtcs.size();
	}
	
	public boolean containsVertex(String vname) {
		return this.vtcs.containsKey(vname);
	}
	
	public void addVertex(String vname) {
		Vertex v = new Vertex();
		vtcs.put(vname, v);
	}
	
	public void removeVertex(String vname) {
		/*
		 * 1> Get vname
		 * 2> visit nbrs of vname and remove vname from them
		 * 3> remove vname from vtcs
		 */
		
		Vertex vtx = vtcs.get(vname);
		if(vtx == null)
			return;
		ArrayList<String> keys = new ArrayList<>(vtx.nbrs.keySet());
		
		for(String key : keys) {
			Vertex nbrVtx = vtcs.get(key);
			nbrVtx.nbrs.remove(vname);
		}
		
		vtcs.remove(vname);
	}
	
	
	public int numEdges() {
		ArrayList<String> keys = new ArrayList<>(vtcs.keySet());
		int  count = 0;
		
		for(String key: keys) {
			Vertex v = this.vtcs.get(key);
			count += v.nbrs.size();
		}
		return count/2;
	}
	
	public boolean containsEdge(String vname1, String vname2) {
		Vertex vtx1 = vtcs.get(vname1);
		Vertex vtx2 = vtcs.get(vname2);
		
		if(vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)  )
			return false;
		return true;
	}
	
	public void addEdge(String vname1, String vname2,int cost) {
		Vertex vtx1 = vtcs.get(vname1); //2k address
		Vertex vtx2 = vtcs.get(vname2); //4k address
		
		if(vtx1 == null || vtx2 == null || vtx1.nbrs.containsKey(vname2))
			return;
		
		vtx1.nbrs.put(vname2, cost);	// 2k nbrs put C with given cost
		vtx2.nbrs.put(vname1, cost);	// 4k nbrs put A with given cost
	}
	
	public void removeEdge(String vname1,String vname2) {
		Vertex vtx1 = vtcs.get(vname1); //2k address
		Vertex vtx2 = vtcs.get(vname2); //4k address
		
		if(vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2))
			return;
		
		vtx1.nbrs.remove(vname2);	// 2k nbrs remove C 
		vtx2.nbrs.remove(vname1);	// 4k nbrs remove A 

	}
	
	
	public void display() {
		ArrayList<String> keys = new ArrayList<>(vtcs.keySet());
		for(String key: keys) {
			Vertex vtx = vtcs.get(key);
			System.out.println(key+" : "+vtx.nbrs);
			
		}
		System.out.println("--------------------------");
	}

	public boolean hasPath(String vname1,String vname2) {
		return hasPath(vname1,vname2,new HashMap<>());
	}
	private boolean hasPath(String vname1,String vname2,HashMap<String,Boolean> processed) {
		
		processed.put(vname1, true);
		// direct edge
		if(containsEdge(vname1, vname2))
			return true;
		
		// devoke the work to nghbrs
		Vertex vtx = vtcs.get(vname1);
		ArrayList<String> nbrs = new ArrayList<>(vtx.nbrs.keySet());
		for(String nbr: nbrs) {
			if(!processed.containsKey(nbr) && hasPath(nbr, vname2,processed))
				return true;
		}
		return false;
	}

	private class Pair{
		String vname;	// Vertex name
		String psf;	// processed So Far
		
	}
	
	public boolean bfs(String src, String dst) {
		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		// create a new pair
		Pair sp = new Pair();
		sp.vname = src;
		sp.psf = src;

		// put the new pair in queue
		queue.addLast(sp);

		// while queue is not empty keep on doing the work
		while (!queue.isEmpty()) {

			// remove a pair from queue
			Pair rp = queue.removeFirst();

			if (processed.containsKey(rp.vname)) {
				continue;
			}

			// processed put
			processed.put(rp.vname, true);

			// direct edge
			if (containsEdge(rp.vname, dst)) {
				System.out.println(rp.psf + dst);
				return true;
			}

			// nbrs
			Vertex rpvtx = vtcs.get(rp.vname);
			ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());

			// loop on nbrs
			for (String nbr : nbrs) {

				// process only unprocessed nbrs
				if (!processed.containsKey(nbr)) {

					// make a new pair of nbr and put in queue
					Pair np = new Pair();
					np.vname = nbr;
					np.psf = rp.psf + nbr;

					queue.addLast(np);
				}
			}
		}
		return false;
	}
	
	public boolean dfs(String src, String dst) {
		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> stack = new LinkedList<>();

		// create a new pair
		Pair sp = new Pair();
		sp.vname = src;
		sp.psf = src;

		// put the new pair in queue
		stack.addFirst(sp);

		// while queue is not empty keep on doing the work
		while (!stack.isEmpty()) {

			// remove a pair from queue
			Pair rp = stack.removeFirst();

			if (processed.containsKey(rp.vname)) {
				continue;
			}

			// processed put
			processed.put(rp.vname, true);

			// direct edge
			if (containsEdge(rp.vname, dst)) {
				System.out.println(rp.psf + dst);
				return true;
			}

			// nbrs
			Vertex rpvtx = vtcs.get(rp.vname);
			ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());

			// loop on nbrs
			for (String nbr : nbrs) {

				// process only unprocessed nbrs
				if (!processed.containsKey(nbr)) {

					// make a new pair of nbr and put in queue
					Pair np = new Pair();
					np.vname = nbr;
					np.psf = rp.psf + nbr;

					stack.addFirst(np);
				}
			}
		}
		return false;
	}
	
	
	public void bft() {
		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		ArrayList<String> keys = new ArrayList<>(vtcs.keySet());
		
		// For every node repeat the process
		for(String key: keys) {
			
			if(processed.containsKey(key))
				continue;
			// create a new pair
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;
			
			// put the new pair in queue
			queue.addLast(sp);
			
			// while queue is not empty keep on doing the work
			while (!queue.isEmpty()) {
				
				// remove a pair from queue
				Pair rp = queue.removeFirst();
				
				if (processed.containsKey(rp.vname)) {
					continue;
				}
				
				// processed put
				processed.put(rp.vname, true);
				
				// direct edge
				System.out.println(rp.vname+" "+rp.psf);
				
				// nbrs
				Vertex rpvtx = vtcs.get(rp.vname);
				ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());
				
				// loop on nbrs
				for (String nbr : nbrs) {
					
					// process only unprocessed nbrs
					if (!processed.containsKey(nbr)) {
						
						// make a new pair of nbr and put in queue
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;
						
						queue.addLast(np);
					}
				}
			}
		}
	}
	
	public void dft() {
		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> stack = new LinkedList<>();

		ArrayList<String> keys = new ArrayList<>(vtcs.keySet());
		
		// For every node repeat the process
		for(String key: keys) {
			
			if(processed.containsKey(key))
				continue;
			// create a new pair
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;
			
			// put the new pair in queue
			stack.addFirst(sp);
			
			// while queue is not empty keep on doing the work
			while (!stack.isEmpty()) {
				
				// remove a pair from queue
				Pair rp = stack.removeFirst();
				
				if (processed.containsKey(rp.vname)) {
					continue;
				}
				
				// processed put
				processed.put(rp.vname, true);
				
				// direct edge
				System.out.println(rp.vname+" "+rp.psf);
				
				// nbrs
				Vertex rpvtx = vtcs.get(rp.vname);
				ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());
				
				// loop on nbrs
				for (String nbr : nbrs) {
					
					// process only unprocessed nbrs
					if (!processed.containsKey(nbr)) {
						
						// make a new pair of nbr and put in queue
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;
						
						stack.addFirst(np);
					}
				}
			}
		}
	}
	
	public boolean isCyclic() {
		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		ArrayList<String> keys = new ArrayList<>(vtcs.keySet());
		
		// For every node repeat the process
		for(String key: keys) {
			
			if(processed.containsKey(key))
				continue;
			// create a new pair
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;
			
			// put the new pair in queue
			queue.addLast(sp);
			
			// while queue is not empty keep on doing the work
			while (!queue.isEmpty()) {
				
				// remove a pair from queue
				Pair rp = queue.removeFirst();
				
				if (processed.containsKey(rp.vname)) {
					return true;
				}
				
				// processed put
				processed.put(rp.vname, true);
				
				// nbrs
				Vertex rpvtx = vtcs.get(rp.vname);
				ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());
				
				// loop on nbrs
				for (String nbr : nbrs) {
					
					// process only unprocessed nbrs
					if (!processed.containsKey(nbr)) {
						
						// make a new pair of nbr and put in queue
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;
						
						queue.addLast(np);
					}
				}
			}
		}
		return false;
	}
	
	public boolean isConnected() {
		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		ArrayList<String> keys = new ArrayList<>(vtcs.keySet());
		
		int flag = 0;	// for checking Connected component
		
		
		// For every node repeat the process
		for(String key: keys) {
			
			if(processed.containsKey(key))
				continue;
			flag++;
			
			// create a new pair
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;
			
			// put the new pair in queue
			queue.addLast(sp);
			
			// while queue is not empty keep on doing the work
			while (!queue.isEmpty()) {
				
				// remove a pair from queue
				Pair rp = queue.removeFirst();
				
				if (processed.containsKey(rp.vname)) {
					continue;
				}
				
				// processed put
				processed.put(rp.vname, true);
				
				// nbrs
				Vertex rpvtx = vtcs.get(rp.vname);
				ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());
				
				// loop on nbrs
				for (String nbr : nbrs) {
					
					// process only unprocessed nbrs
					if (!processed.containsKey(nbr)) {
						
						// make a new pair of nbr and put in queue
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;
						
						queue.addLast(np);
					}
				}
			}
		}
		
		if(flag == 1)
			return true;
		else
			return false;
	}
	
	public boolean isTree() {
		return !isCyclic() && isConnected();
	}
	
	public ArrayList<ArrayList<String>> getCC() {
		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		ArrayList<ArrayList<String>> ans = new ArrayList<>();
		ArrayList<String> keys = new ArrayList<>(vtcs.keySet());
		
		// For every node repeat the process
		for(String key: keys) {
			
			if(processed.containsKey(key))
				continue;
			// For new Component create a new arraylist
			ArrayList<String> subans = new ArrayList<>();
			
			// create a new pair
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;
			
			// put the new pair in queue
			queue.addLast(sp);
			
			// while queue is not empty keep on doing the work
			while (!queue.isEmpty()) {
				
				// remove a pair from queue
				Pair rp = queue.removeFirst();
				
				if (processed.containsKey(rp.vname)) {
					continue;
				}
				
				// processed put
				processed.put(rp.vname, true);
				
				// direct edge
				// put subans 
				subans.add(rp.vname);
				
				// nbrs
				Vertex rpvtx = vtcs.get(rp.vname);
				ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());
				
				// loop on nbrs
				for (String nbr : nbrs) {
					
					// process only unprocessed nbrs
					if (!processed.containsKey(nbr)) {
						
						// make a new pair of nbr and put in queue
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;
						
						queue.addLast(np);
					}
				}
			}
			ans.add(subans);
		}
		return ans;
	}
	
	
	private class PrismPair implements Comparable<PrismPair> {
		String vname;
		String acqname;
		int cost;
		
		@Override
		public int compareTo(PrismPair o) {
			return o.cost - this.cost;
		}
	}
	
	public Graph prims() {
		
		Graph mst = new Graph();
		HashMap<String, PrismPair> map = new HashMap<>();
		
		HeapGeneric<PrismPair> heap = new HeapGeneric<>();
		
		for(String key: vtcs.keySet()) {
			
			PrismPair pair = new PrismPair();
			pair.vname = key;
			pair.acqname = null;
			pair.cost = Integer.MAX_VALUE;
			
			heap.add(pair);
			map.put(key, pair);	
			
		}
		// till the heap is not empty keep on removing elements
		while(!heap.isEmpty()) {
			
			// remove a pair
			PrismPair rp = heap.remove();
			map.remove(rp.vname);
			
			// add to mst
			if(rp.acqname == null) {
				mst.addVertex(rp.vname);
			}else {
				mst.addVertex(rp.vname);
				mst.addEdge(rp.vname, rp.acqname, rp.cost);
			}
			
			//nbrs
			for(String nbr : vtcs.get(rp.vname).nbrs.keySet()) {
				
				// work for nbrs which are in heap
				if(map.containsKey(nbr)) {
					int oc = map.get(nbr).cost;
					int nc = vtcs.get(rp.vname).nbrs.get(nbr);
					
					// update the pair only when nc < oc
					if (nc < oc) {

						PrismPair gp = map.get(nbr);
						
						// gp =>  Get Pair
						
						gp.acqname = rp.vname;
						gp.cost = nc;

						heap.updatePriority(gp);
}
				}
			}
		}
		
		return mst;
	}
}
