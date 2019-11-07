import java.util.Random;

public class StaticMaths 
{
	public static int RandomBetween(int _min, int _max)
	{
		if (_min >= _max)
		{
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((_max - _min) + 1) + _min;
	}
}
