import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;



public class TownGraphManager implements TownGraphManagerInterface {

	
	private final Graph graph;
	
	public TownGraphManager()
	{
		
		this.graph=new Graph();
	}
	
	
	

	
	
	////
	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName)
	{
		// TODO Auto-generated method stub
		
		Town s= new Town(town1);
		
		Town d= new Town(town2);
		
		graph.addVertex(s);
		graph.addVertex(d);
		Road road=graph.addEdge(s, d, weight, roadName);
		return road!=null;
	}

	@Override
	public String getRoad(String town1, String town2) {
		// TODO Auto-generated method stub
		
		Town s= new Town(town1);
		
		Town d= new Town(town2);
		
		graph.addVertex(s);
		graph.addVertex(d);
		
		Road road=graph.getEdge(s, d);
		
		if(road!=null)
		{
			return road.getName();
		}
		
		return null;
	}

	@Override
	public boolean addTown(String v) {
		// TODO Auto-generated method stub
		
		Town town = new Town(v);
		return graph.addVertex(town);
	}
	
	
	
	@Override
	public Town getTown(String name) {
		// TODO Auto-generated method stub
		
		for(Town town: graph.vertexSet())
		{
			if(town.getName().equals(name))
			{
				return town;
			}
		}
		return null;
	}

	@Override
	public boolean containsTown(String v) {
		// TODO Auto-generated method stub
		return graph.containsVertex(new Town(v));
	}

	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		// TODO Auto-generated method stub
		return graph.containsEdge(new Town(town1),new Town(town2));
	}

	@Override
	public ArrayList<String> allRoads() {
		// TODO Auto-generated method stub
		
		Set<Road> roads=graph.edgeSet();
		TreeSet<String> sorted=new TreeSet<>();
		
		for(Road road : roads)
		{
			sorted.add(road.getName());
		}
		return new ArrayList<>(sorted);
	}

	

	
	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) 
	{
		// TODO Auto-generated method stub
		
		Town s=  getTown(town1);
		
		Town d= getTown(town2);
		
	
		if(s==null || d==null)
		{
			return false;
		}
		
		Road r=graph.getEdge(s, d);
		
		if(r!=null && r.getName().equals(road))
		{
			graph.removeEdge(s, d, r.getDistance(), r.getName());
		}
		
		return false;
		
		
	}

	@Override
	public boolean deleteTown(String v) {
		// TODO Auto-generated method stub
		return graph.removeVertex(new Town(v));
	}
	
	

	  

	   
	    
	  
	@Override
	public ArrayList<String> allTowns() {
		// TODO Auto-generated method stub
		
		Set<Town> towns =graph.vertexSet();
		TreeSet<String> sorted=new TreeSet<>();
	
		for(Town town: towns)
		{
			sorted.add(town.getName());
		}
		
		return new ArrayList<>(sorted);
	}

	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		// TODO Auto-generated method stub
		
		ArrayList<String> path=graph.shortestPath(new Town(town1), new Town(town2));
		
		if(path!=null)
		{
			return path;
		}
		
		return new ArrayList<>();
	}

	
}
