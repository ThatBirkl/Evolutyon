import javax.swing.JFrame;

public class Window extends JFrame
{
	private static final long serialVersionUID = 2L;
	
	private World world;
	private Display worldContainer;
	
	public Window(int _dimX, int _dimY, World _world)
	{
		world = _world;
		InitUI(_dimX, _dimY);
	}
	
	private void InitUI(int _dimX, int _dimY)
	{
		worldContainer = new Display(world);
		add(worldContainer);
		setTitle("Evolutyon");
		setSize(_dimX, _dimY);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void Update()
	{
		worldContainer.repaint();
	}
}
