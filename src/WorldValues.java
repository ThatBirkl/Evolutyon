import java.util.ArrayList;

public class WorldValues 
{
	final public static int worldDimX = 200;
	final public static int worldDimY = 200;
	final public static int cellSize = 5; //height and width of a cell in pixels
	final public static long waitBetweenTurns = 1000;
	final public static long waitBetweenCreatures = 0;
	
	private static ArrayList<Creature> actedCreatures = new ArrayList<Creature>();
	
	public static void AddActedCreature(Creature _creature)
	{
		actedCreatures.add(_creature);
	}
	
	public static boolean CreatureActed(Creature _creature)
	{
		return actedCreatures.contains(_creature);
	}
	
	public static void ClearActedCreatures()
	{
		actedCreatures.clear();
	}
}
