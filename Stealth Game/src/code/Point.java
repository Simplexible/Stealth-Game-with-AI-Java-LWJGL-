package code;

import static org.lwjgl.opengl.GL11.*;

public class Point {
	
	public double x, y;
	public Point(){
		x = 70;
		y = 250;
	}
	
	public void logic(){
		if(Math.abs(x-Game.player.x)>16 || Math.abs(y-Game.player.y)>16) return;
		//At this point, the point and the player collide
		Game.point.respawn();
	}
	
	public void draw()
	{
		logic();
		
		glPushMatrix();
		
		glTranslated(x, y, 0);
		
		glBegin(GL_QUADS);
		
		glColor3d(1, 0, 0);
		glVertex2d(-16, 0);
		
		glVertex2d(16, 0);
		
		glVertex2d(16, 8);
		
		glVertex2d(-16, 8);
		
		glEnd();
		
		glPopMatrix();
	}
	
	public void respawn(){
		x = Math.random()*600;
		y = Math.random()*400;
		Game.player.score ++;
		System.out.println("Score = " + Game.player.score);
	}
}
