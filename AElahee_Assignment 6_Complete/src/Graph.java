import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Graph implements GraphInterface<Town, Road> 
{ 
	private Map<Town,List<Road>> adjancency;

	
	
	public Graph()
	{
		adjancency=new HashMap<>();
	}
	
	
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) 
	{
		
		List<Road> roads = adjancency.get(sourceVertex);
		if(roads!=null)
		{
			for(Road road: roads)
			{
				if((road.getDestinitaion().equals(destinationVertex)&& road.getSource().equals(sourceVertex))|| (road.getDestinitaion().equals(sourceVertex)&& road.getSource().equals(destinationVertex)))
				{
					return road;
				}
				
			}
			
			
		}
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int distance, String description) {
		// TODO Auto-generated method stub
		
		Road road = new Road(sourceVertex, destinationVertex, distance, description);
		
		adjancency.putIfAbsent(sourceVertex, new ArrayList<>());
		
		adjancency.putIfAbsent(destinationVertex, new ArrayList<>());
		
		adjancency.get(sourceVertex).add(road);
		
		
		adjancency.get(destinationVertex).add(road);
		
		return road;
	
	}

	@Override
	public boolean addVertex(Town v)
	{
		// TODO Auto-generated method stub
		
		if(adjancency.containsKey(v))
		{
			return false;
		}
				
		adjancency.put(v, new ArrayList<>());
		
		return true;
		
			
				
		
	}

	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		// TODO Auto-generated method stub
		return getEdge(sourceVertex,destinationVertex)!=null;
	}

	@Override
	public boolean containsVertex(Town v) 
	{
		// TODO Auto-generated method stub
	
		return adjancency.containsKey(v);
	}

	@Override
	public Set<Road> edgeSet() {
		// TODO Auto-generated method stub
		Set<Road> roads = new HashSet<>();
		
		for(List<Road> roadList : adjancency.values())
		{
			
			roads.addAll(roadList);
		}
		return roads;
	}

	
	
	
	
	@Override
	public Set<Road> edgesOf(Town vertex) {
		// TODO Auto-generated method stub

		
		return new HashSet<>(adjancency.getOrDefault(vertex, new ArrayList<>()));   //get(vertex, new ArrayList<>()));
	}

	
	
	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int distance, String description) {
		// TODO Auto-generated method stub

		
		Road road = getEdge(sourceVertex,destinationVertex);
		
		
		if(road!= null && road.getDistance()== distance && road.getName().equals(description))
		{
			adjancency.get(sourceVertex).remove(road);
			adjancency.get(destinationVertex).remove(road);
			return road;
		}
		
		return null;
	}

	
	// fix
	@Override
	public boolean removeVertex(Town v) {
		// TODO Auto-generated method stub
		if (!adjancency.containsKey(v)) return false;
		adjancency.values().forEach(e -> e.removeIf(r -> r.getSource().equals(v) || r.getDestinitaion().equals(v)));
		adjancency.remove(v);
        return true;
	}

	@Override
	public Set<Town> vertexSet() {
		// TODO Auto-generated method stub
		 
		 
		 return adjancency.keySet();
	}

	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
//		// TODO Auto-generated method stub

		
		
		dijkstraShortestPath(sourceVertex);
		List<Town> path= new ArrayList<>();
		
		Town step= destinationVertex;
		
		if (predecessors.get(step)==null)
		{
			return null;
		}
		
		path.add(step);
		while(predecessors.get(step) !=null)
		{
			step= predecessors.get(step);
			path.add(step);
			
			
		}
		
		Collections.reverse(path);
		
		ArrayList<String> result = new ArrayList<>();
		
		for(int i=0;i<path.size()-1; i++)
		{
			Town x=path.get(i);
			Town y=path.get(i+1);
			Road r=getEdge(x,y);
			
			result.add(x.getName()+" via "+ r.getName()+" to "+y.getName() +" "+ r.getDistance()+" mi");
		}
		
		return result;
		
	}

	
	private Map<Town, Integer> distances;
	private Map<Town, Town> predecessors;
	private PriorityQueue<Town> priorityQueue;
	

	@Override
	public void dijkstraShortestPath(Town sourceVertex)
	{
		// TODO Auto-generated method stub
		distances = new HashMap<>();
		predecessors = new HashMap<>();
		priorityQueue = new PriorityQueue<>(Comparator.comparing(distances::get));

		for (Town town : adjancency.keySet()) 
		{
			distances.put(town, Integer.MAX_VALUE);
		}
		
		
		distances.put(sourceVertex, 0);

		priorityQueue.add(sourceVertex);
		

		while (!priorityQueue.isEmpty()) 
		{
			Town current = priorityQueue.poll();
			
			List<Road> roads = adjancency.get(current);

			if (roads != null) 
			{
				for (Road road : roads) 
				{
					Town neighbor = road.getSource();
							
					if(road.getDestinitaion().equals(current))
					{
						neighbor=road.getSource();
					}
					else
					{
						neighbor=road.getDestinitaion();
					}
					
								
					
					
					
					int D2 = distances.get(current) + road.getDistance();

					if (D2 < distances.getOrDefault(neighbor, Integer.MAX_VALUE))
					{
						distances.put(neighbor, D2);
						
						predecessors.put(neighbor, current);
						
						priorityQueue.remove(neighbor);
						priorityQueue.add(neighbor);
					}
				}
			}
		}
	}
	
}


