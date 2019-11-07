
public class Program 
{
	public static void main (String[] args) throws InterruptedException
	{
		World world = new World(WorldValues.worldDimX, WorldValues.worldDimY);
		
		Window window = new Window(WorldValues.worldDimX * WorldValues.cellSize, 
									WorldValues.worldDimY * WorldValues.cellSize,
									world);
		window.setVisible(true);
		
		while(true)
		{
			world.Turn(0);
			window.Update();
			Thread.sleep(WorldValues.waitBetweenTurns);
		}
	}
}