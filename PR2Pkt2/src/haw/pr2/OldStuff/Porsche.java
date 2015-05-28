package haw.pr2.OldStuff;

public class Porsche
{

	public static void main(String[] args)
	{
		Porsche911GT2RS porsche = new Porsche911GT2RS(0.0,0.0,0.0,0.0);
		for (int i = 0; i < 1000; ++i)
		{
			porsche.step(0.1, 1.0);
			System.out.println("Speed: " + porsche.getSpeed() * 3.6
					+ "\tPosition: " + porsche.getPos() + "\tTime: "
					+ porsche.getTime());
		}
	}
}
