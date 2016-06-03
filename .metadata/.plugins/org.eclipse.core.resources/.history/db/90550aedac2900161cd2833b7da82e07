package CatnMouseGame;

//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class Grass extends Canvas implements KeyListener, Runnable, MouseListener
{
	private Cat cat;
	private Mouse mouseOne;
	private Dog dogOne;

	//uncomment once you are ready for this part
	private boolean title; 
	private boolean conclusion;
	private ArrayList<Mouse> mice;
	private ArrayList<Dog> dogs;

	private int score;
	private int lives;
	private int velocity;

	private boolean[] keys;
	private BufferedImage back;

	public Grass()
	{
		setBackground(Color.green);
		title = true;
		conclusion = true;
		lives = 9;
		score = 0;
		velocity = 3; 
		keys = new boolean[5];
		
		cat = new Cat(300,300,6);
		
		
		//instantiate other stuff
		mice = new ArrayList<Mouse>();
		mice.add(new Mouse (100, 0, velocity));
		
		dogs = new ArrayList<Dog>();
		dogs.add(new Dog(300,0,6));
		
		this.addKeyListener(this);
		this.addMouseListener(this);
		new Thread(this).start();

		setVisible(true);
	}

   public void update(Graphics window)
   {
	   paint(window);
   }

	public void paint( Graphics window )
	{
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;
	
		
		
		if(title){
			
			window.setColor(Color.BLUE);
			window.fillRect(0,0,800,600);
			
			window.setColor(Color.WHITE);
			Font welcome = new Font("Welcome", Font.BOLD, 96);
			window.setFont(welcome);
			String welcomeMessage = "Welcome!";
			window.drawString(welcomeMessage, 50, 100);
			
			Font instruction = new Font("Impact", Font.BOLD, 36);
			window.setFont(instruction);
			String instructions = "chase the mice and avoid the dogs!";
			window.drawString(instructions, 60,300);
			
			Font instruction2 = new Font("Impact", Font.BOLD, 36);
			window.setFont(instruction2);
			String instructions2 = "Click screen to play";
			window.drawString(instructions2, 60,500);
			
			
			
		}
		if(conclusion==false){
			window.setColor(Color.BLUE);
			window.fillRect(0,0,800,600);
			
			window.setColor(Color.WHITE);
			Font poop = new Font("Welcome" + score, Font.BOLD, 96);
			window.setFont(poop);
			String end = "Score: " + score;
			window.drawString(end, 50, 100);
			
			Font turd = new Font("Welcome", Font.BOLD, 20);
			window.setFont(turd);
			String instruction3 = "Click to play again";
			window.drawString(instruction3,50, 300);
			
		
			
		}
		
		else if(!title){
			
			
			if(back==null)
				   back = (BufferedImage)(createImage(getWidth(),getHeight()));

				//create a graphics reference to the back ground image
				//we will draw all changes on the background image
				Graphics graphToBack = back.createGraphics();


				graphToBack.setColor(Color.green);
				graphToBack.fillRect(0,0,800,600);
				graphToBack.setColor(Color.black);
				graphToBack.drawString("Cat and Mouse Chase", 25, 50 );
			
				String scoreText = "Score:: " +score + " | " +"Lives:: "+ lives;
				Font scoretxt = new Font("Impact",Font.BOLD, 46);
				graphToBack.setFont(scoretxt);
				graphToBack.drawString(scoreText, 200, 200);
				
				
				if(keys[0] == true)
				{
					if(cat.getX()>-20){
						cat.move("LEFT");
					}
				};
				if(keys[1] == true)
				{
					if(cat.getX()<this.getWidth()-60){
						cat.move("RIGHT");
					}
				}
				if(keys[2] == true)
				{
					if(cat.getY()>0){
						cat.move("UP");
					}
				}
				if(keys[3] == true)
				{
					if(cat.getY()<500){
						cat.move("DOWN");
					}
				}
		
				for(Mouse poop: mice){
					Random speed = new Random(); 
					poop.draw(graphToBack);
					if(poop.getX()<900);
					{
						if(poop.getX()>800){
							poop.setX(-20);
						}
					poop.move("DOWN");
					}
				for(int i = 0; i<mice.size(); i++){
						if(mice.get(i).getY() >600){
							mice.remove(poop);
							lives--;
							mice.add(new Mouse((int)(Math.random()*800),0,(int)speed.nextInt(5)+1));
							System.out.println(lives);
							System.out.println("Miss ---cat X " + cat.getX() + "mouse X " + mice.get(i).getX());
						}
					}
				
				 
				 
				for(int i = 0; i<mice.size(); i++){
					
					if(cat.getX() +100 >mice.get(i).getX() && cat.getX() < mice.get(i).getX()+100 && 
							mice.get(i).getY()+60>cat.getY()){
						mice.remove(poop);
						score++;
						
						mice.add(new Mouse((int)(Math.random()*800),0,velocity));
						System.out.println("lives: " + lives);
						System.out.println("speed: " + velocity);
						//System.out.println("cat X " + cat.getX() + "mouse X " + mice.get(i).getX());
						if(score%5 == 0){
							System.out.println("Speed Increased: " + velocity);
							velocity++;
						}
					}
				}
				
				for(Dog turd: dogs){
					Random speed1 = new Random(); 
					turd.draw(graphToBack);
					if(turd.getX()<900);
					{
						if(poop.getX()>800){
							poop.setX(-20);
						}
					turd.move("DOWN");
					}
				for(int i = 0; i<dogs.size(); i++){
						if(dogs.get(i).getY() >600){
							dogs.remove(turd);
							dogs.add(new Dog((int)(Math.random()*800),0,(int)speed.nextInt(5)+1));
							System.out.println(lives);
						}
					}
				for(int i = 0; i<dogs.size(); i++){
					if(cat.getX()+100 > dogs.get(i).getX() && cat.getX()<dogs.get(i).getX()+100
							&& dogs.get(i).getY()+60>cat.getY()){
						dogs.remove(turd);
						lives-=2;
						dogs.add(new Dog((int)(Math.random()*800),0,6));
						System.out.println(lives);
					}
					
				}
			}
				cat.draw(graphToBack);
				
				twoDGraph.drawImage(back, null, 0, 0);
			
				}
				
				
				//add code to move stuff

				if(lives<1){
					conclusion = false;
					lives = 9;
					
					
					
				}
				
		}
				//add in collision detection
				
			
		}

		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		
	//}


	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = true;
		}
	/*	if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = true;
		}*/
	
		repaint();
	}

	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = false;
		}
		/*if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = false;
		}*/
		repaint();
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		title = false;
		conclusion = true;
		score = 0;
		velocity = 3;
		
	}


	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}


	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	public void keyTyped(KeyEvent e)
	{

	}

   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(5);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}
   
   
}

