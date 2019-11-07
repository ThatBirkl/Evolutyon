import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JPanel;

public class Display extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	private World world;
	
	public Display(World _world)
	{
		world = _world;
	}
	
	private void doDrawing(Graphics g) 
	{
        Graphics2D g2d = (Graphics2D) g;
        WorldObject[][] grid = world.GetGrid();
        int size = WorldValues.cellSize;
    	for(int y = 0; y < grid.length; y++)
    	{
    		for(int x = 0; x < grid[y].length; x++)
    		{
    			g2d.setColor(grid[y][x].GetColor());
    			g2d.fillRect(x * size, y * size, size, size);
    		}
    	}
    }
	
    @Override
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        doDrawing(g);
    }
}
