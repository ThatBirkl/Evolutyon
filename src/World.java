
public class World 
{
	private WorldObject[][] grid;
	
	public World(int _dimX, int _dimY)
	{
		grid = new WorldObject[_dimY][_dimX];
		CreateWorld();
	}
	
	public WorldObject[][] GetGrid()
	{
		return grid;
	}
	
	public synchronized void Turn(int _wait) throws InterruptedException
	{
		int creatureCount = 0;
		
		for(int y = 0; y < grid.length; y++)
		{
			for(int x = 0; x < grid[y].length; x++)
			{				
				if(grid[y][x].GetType() == WorldObject.eType.eCreature)
				{
					if(!WorldValues.CreatureActed((Creature)grid[y][x]))
						creatureCount++;
					
					grid[y][x].DoTurn();
					
					if(_wait != 0)
						Thread.sleep(_wait);
				}
			}
		}
		Logging.Log(creatureCount);
		if(creatureCount < WorldValues.minCreatureCount)
		{
			CreateRandomCreature();
		}
		
		WorldValues.ClearActedCreatures();
	}
	
	private void CreateWorld()
	{
		for(int y = 0; y < grid.length; y++)
		{
			for(int x = 0; x < grid[y].length; x++)
			{
				grid[y][x] = new Empty(x, y, grid);
			}
		}
	}
	
	private void CreateRandomCreature()
	{
		int x = StaticMaths.RandomBetween(0, grid.length - 1);
		int y = StaticMaths.RandomBetween(0, grid[0].length - 1);
		
		grid[x][y] = new Creature(x, y, grid);
	}
}
