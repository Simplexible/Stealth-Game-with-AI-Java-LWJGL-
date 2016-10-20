package code;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;

public class Game {

	
	//creating objects!
	public static Agent agent;
	public static Player player;
	public static Box box;
	public static Box2 box2;
	public static Point point;
	
	public static double getPlayerXPos() {
		double t = player.getXpos();
		return t;
	}
	
	public static double getPlayerYPos() {
		double c = player.getYpos();
		return c;
	}
	
	public static void main(String[] args) throws Exception
	{
		Display.setTitle("Game");
		Display.setDisplayMode(new DisplayMode(600, 400));
		Display.create();
		//adding objects to game
		agent = new Agent();
		player = new Player();
		box = new Box();
		box2 = new Box2();
		point = new Point();
	
		while(!Display.isCloseRequested())
		{
			//drawing objects
			setCamera();
			drawBackground();
			agent.draw();
			player.draw();
			box.draw();
			box2.draw();
			point.draw();
			Display.update();
			Display.sync(60);
		}
		Display.destroy();
	}

			public static void setCamera()
			{
				//clear the screen
				glClear(GL_COLOR_BUFFER_BIT);
				glMatrixMode(GL_PROJECTION);
				glLoadIdentity();
				glOrtho(0, 600, 0, 400, -1, 1);
				
				// Modify modelview matrix
				glMatrixMode(GL_MODELVIEW);
				glLoadIdentity();
				
			}
			
			private static void drawGrid() {
	
				
			}
			
			public static void drawBackground()
			{
				drawGrid();
				//drawing background
				glBegin(GL_QUADS);
				
				glColor3d(0.7, 0.8, 0.9);
				glVertex2d(0, 0);
				glVertex2d(640, 0);
				
				//glColor3d(0.5, 0.6, 0.8);
				glVertex2d(640, 480);
				glVertex2d(0, 480);
				
				glEnd();
				
				//box
				/*
				glBegin(GL_QUADS);
				
				
				glVertex2d(0, 480);
				
				glVertex2d(120, 40);
				glVertex2d(180, 40);
				
				glVertex2d(180, 80);
				glVertex2d(120, 80);
				glEnd();
				*/
				
				//box 1

				//box 2

				//drawing grass
				
				//glBegin(GL_QUADS);
				
				//glColor3d(0.2, 0.8, 0.2);
				//glVertex2d(0, 25);
				//glVertex2d(640, 25);
				
				//glVertex2d(640, 32);
				//glVertex2d(0, 32);
				
				//glEnd();
				
			}
		}