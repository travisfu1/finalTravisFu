package catgame;

//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import javax.swing.JFrame;
import java.awt.Component;

public class Field extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public Field()
	{
		super("Cat and Mouse Chase");
		setSize(WIDTH,HEIGHT);

		Grass theGame = new Grass();
		((Component)theGame).setFocusable(true);

		getContentPane().add(theGame);
		
		setVisible(true);
	} 

	public static void main( String args[] )
	{
		Field run = new Field();
	}
}