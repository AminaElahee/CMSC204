
public class Road implements Comparable<Road> 
{
	
	public Town source;
	public Town destination;
	public int distance;   // not sure 
	public String name;
	
	
	public Road(Town source,Town destination, int distance, String name)
	{
		this.source=source;
		this.destination= destination;
		this.name=name;
		this.distance=distance;
	}
	
	
	public Road(Town source,Town destination, String name)
	{
		this(source, destination, 1, name); 
	}
	
	public boolean contains(Town town)
	{
		if(town.equals(source)||town.equals(destination))
		{
			return true;
		}
		
		return false;
	}
	
	@Override
	public String toString()
	{
		return name+"," + distance+ "miles, " + source+","+ destination;
		
	}
	
	public String getName()
	{
		return name;
		
	}
	
	public Town getDestinitaion()
	{
		return destination;
		
		
	}
	
	public Town getSource()
	{
		
		return source;
	}
	
	
	
	
	@Override
	public int compareTo(Road o) {
		// TODO Auto-generated method stub
		return this.name.compareTo(o.name);
	}
	
	
	public int getDistance() 
	{
		return distance;
		
	}
	
	public boolean equals(Object r)
	{
		if (this == r)
		{
			return true;
		}
		if (r == null || getClass() != r.getClass())
		{
			return false;
		}
		Road other = (Road) r;
		return distance == other.distance && name.equals(other.name) && (source.equals(other.source) && destination.equals(other.destination)) || (source.equals(other.destination) && destination.equals(other.source));
	}
	
	
	
	
	
	
	
	
	
	

}
