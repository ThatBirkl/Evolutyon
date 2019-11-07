import java.awt.Color;

public class Empty extends WorldObject
{
	public Empty(int _x, int _y, WorldObject[][] _grid)
	{
		super(_x, _y, _grid);
		
		color = new Color(200, 200, 200);
		type = eType.eEmpty;
	}
}
