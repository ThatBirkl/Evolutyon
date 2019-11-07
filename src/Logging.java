
public class Logging 
{
	public static void Log(Object _input)
	{
		try
		{
			if(_input != null)
				System.out.println(_input.toString());
			else
				System.out.println("null");
		}
		catch(Exception e)
		{
			
		}
	}
}
