import java.awt.Color;

public abstract class WorldObject 
{
	protected int x;
	protected int y;
	protected WorldObject[][] grid;
	
	public enum eType
	{
		eEmpty,
		eCreature
	}
	
	Color color;
	eType type;
	
	public WorldObject(int _x, int _y, WorldObject[][] _grid)
	{
		color = new Color(0, 0, 0);
		x = _x;
		y = _y;
		grid = _grid;
	}
	
	public void DoTurn()
	{
		
	}
	
	public Color GetColor()
	{
		return color;
	}
	
	public eType GetType()
	{
		return type;
	}
	
	public int GetX()
	{
		return x;
	}
	
	public int GetY()
	{
		return y;
	}
}
