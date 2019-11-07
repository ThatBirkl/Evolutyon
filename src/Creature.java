import java.awt.Color;

public class Creature extends WorldObject
{
	private boolean displayGeneration;
	private Color generationColor;
	
	private int energy;
	
	
	public Creature(int _x, int _y, WorldObject[][] _grid)
	{
		super(_x, _y, _grid);
		color = new Color(255, 100, 100);
		generationColor = new Color(255, 0, 0);	
		displayGeneration = true;
		type = eType.eCreature;
	}
	
	public Creature(int _x, int _y, WorldObject[][] _grid, Color _generationColorParent)
	{
		super(_x, _y, _grid);
		color = new Color(255, 100, 100);
		generationColor = modifyGenerationColor(_generationColorParent);
		displayGeneration = true;
		type = eType.eCreature;
	}
	
	private Color modifyGenerationColor(Color _generationColor)
	{
		if(_generationColor.getRed() == 255 && _generationColor.getGreen() < 255)
		{
			_generationColor = new Color(_generationColor.getRed(), _generationColor.getGreen() + 1, _generationColor.getBlue());
		}
		else if(_generationColor.getRed() > 0 && _generationColor.getGreen() == 255)
		{
			_generationColor = new Color(_generationColor.getRed() - 1, _generationColor.getGreen(), _generationColor.getBlue());
		}
		else if(_generationColor.getGreen() == 255 && _generationColor.getBlue() < 255)
		{
			_generationColor = new Color(_generationColor.getRed(), _generationColor.getGreen(), _generationColor.getBlue() + 1);
		}
		else if(_generationColor.getGreen() > 0 && _generationColor.getBlue() == 255)
		{
			_generationColor = new Color(_generationColor.getRed(), _generationColor.getGreen() - 1, _generationColor.getBlue());
		}
		else if(_generationColor.getBlue() == 255 && _generationColor.getRed() < 255)
		{
			_generationColor = new Color(_generationColor.getRed() + 1, _generationColor.getGreen(), _generationColor.getBlue());
		}	
		else if(_generationColor.getBlue() == 255 && _generationColor.getRed() == 255 && _generationColor.getGreen() < 255)
		{
			_generationColor = new Color(_generationColor.getRed(), _generationColor.getGreen() + 1, _generationColor.getBlue());
		}
		
		return _generationColor;
	}
	
	@Override
	public Color GetColor()
	{
		if(displayGeneration)
		{
			return generationColor;
		}
		else
		{
			return color;
		}
	}
	
	private Creature createChild()
	{
		return new Creature(x + 1, y + 1, grid, generationColor);
	}

	@Override
	public void DoTurn()
	{
		if(WorldValues.CreatureActed(this))
			return;
		
		WorldValues.AddActedCreature(this);;
		
		//TODO Decision needs to return a value that can then itself be turned into a function call
		//MakeDecision();
		MoveFor(StaticMaths.RandomBetween(-5, 5), StaticMaths.RandomBetween(-5, 5));
	}
	

	
	private synchronized void MoveTo(int _x, int _y)
	{
		grid[x][y] = new Empty(x, y, grid);
		if(grid[_x][_y].GetType() == eType.eEmpty)
		{
			grid[_x][_y] = this;
			x = _x;
			y = _y;
		}
		else if(grid[_x][_y].GetType() == eType.eCreature)
		{
			if(Fight((Creature)grid[_x][_y]))
			{
				grid[_x][_y] = this;
				x = _x;
				y = _y;
			}
		}
	}
	
	private boolean Fight(Creature _opponent)
	{
		return true;
	}
	
	private void MakeDecision()
	{
		
	}
	
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	//+++++++++++++++++++++++++++++++++++++++++ FUNCTIONS THAT ARE DIRECTLY CALLED AS DECISION +++++++++++++++++++++++++++++++++++++++++++++
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	private void MoveFor(int _x, int _y)
	{
		int __x = x + _x;
		int __y = y + _x;
		if(__x < 0 || __x >= WorldValues.worldDimX|| __y < 0 || __y >= WorldValues.worldDimY)
		{
			do 
			{
				if(__x < x)
					_x ++;
				else if(__x > x)
					_x --;
				
				if(__y < y)
					_y ++;
				else if(__y > y)
					_y --;
				
				__x = x + _x;
				__y = y + _y;
			}
			while(__x < 0 || __x >= WorldValues.worldDimX|| __y < 0 || __y >= WorldValues.worldDimY);
		}
		MoveTo(__x, __y);
	}
}
