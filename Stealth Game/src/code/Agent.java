package code;
import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.input.Keyboard;

public class Agent 
{
	public double x, y, xspeed, yspeed, playerspotted;
	public int playerkilled;
	public Agent()
	{
		x = 550;
		y = 50;
		playerspotted = 0;
		playerkilled = 0;
	}
	
	public void chase(){
		double p2x = Game.getPlayerXPos();
	    if(p2x > x) xspeed+=0.2;
	    else if(p2x < x) xspeed-=0.2;
	    double p2y = Game.getPlayerYPos();
	    if(p2y > y) yspeed+=0.2;
	    else if(p2y < y) yspeed-=0.2;
	}
//	public void smellplayer(){
//		if(Game.player.x <= (x - 100) || Game.player.x >= (x + 100) || Game.player.y <= (x - 100) || Game.player.y >= (x + 100)){
//			chase();
//		}
//	}
	
	public void logic()
	{

	    
	    
	    //collision attempt
//	    if ((x > 100)&&(x < 200)&&
//	    (y > 160)&&(y < 200)){
//	    	xspeed = -9;
//	    	yspeed = -9;
//	    }
//	    
//	    if ((x > 100)&&(x < 200)&&
//	    (y > 160)&&(y < 200)){
//	    }
//	    
//	    if ((x > 180)&&(x < 260)&&
//	    (y > 100)&&(y < 132)){
//	    	xspeed = -9;
//	    	yspeed = -9;
//	    }
//		    	
//	    if(p2x > (x+3)){
//	    }
	    
	    
	    
	    if (x >= 600){
	    	x = 595;
	    }
	    
	    if (x < 0){
	    	x = 10;
	    }
	    if (y <  0){
	    	y = 10;
	    }
	    if (y > 400){
	    	y = 385;
	    }
	    
//	    if (x >= 180){
//	    	x;
//	    }

	    //player collision to be continued
//	    if(x >= Game.player2.x){
//	    	xspeed = 0;
//	    }
//	    
//	    if(y >= Game.player2.y){
//	    	yspeed = 0;
//	    }
	    
	    
		x+=xspeed;
		y+=yspeed;
		
		//yspeed -= 0.4;
		
		//if(y<=32);
		
		

		{
			//friction

			if(!Keyboard.isKeyDown(Keyboard.KEY_LEFT) && xspeed < 0) xspeed = xspeed*0.9;
			if(!Keyboard.isKeyDown(Keyboard.KEY_RIGHT) && xspeed > 0) xspeed = xspeed*0.9;
			if(!Keyboard.isKeyDown(Keyboard.KEY_UP) && yspeed > 0) yspeed = yspeed*0.9;
			if(!Keyboard.isKeyDown(Keyboard.KEY_DOWN) && yspeed < 0) yspeed = yspeed*0.9;
			
		}
		//controls
//		if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)) xspeed = Math.max(-5, xspeed-1);
//		if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) xspeed = Math.min(5, xspeed+1);
//		if(Keyboard.isKeyDown(Keyboard.KEY_UP)) yspeed = Math.min(5, yspeed+1);
//		if(Keyboard.isKeyDown(Keyboard.KEY_DOWN)) yspeed = Math.max(-5, yspeed-1);
//		if (xspeed > 0)xspeed = xspeed + Game.player.score;
//		if (xspeed < 0)xspeed = xspeed - Game.player.score;
		

	}
	
	
	public void draw()
	{
		logic();
		//smellplayer();
		//chase();
		
		glPushMatrix();
		
		glTranslated(x, y, 0);
		
		glBegin(GL_QUADS);
		
		glColor3d(1, 1, 1);
		glVertex2d(-8, 0);
		
		glColor3d(1, 1, 1);
		glVertex2d(8, 0);
		
		glColor3d(1, 1, 1);
		glVertex2d(8, 16);
		
		glColor3d(1, 1, 1);
		glVertex2d(-8, 16);
		
		glEnd();
		
		glPopMatrix();
	}

}
