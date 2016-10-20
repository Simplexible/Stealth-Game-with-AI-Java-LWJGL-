package code;
//The player, moves with WASD keys.
import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.input.Keyboard;

public class Player
{
	public double x, y, xspeed, yspeed;
	public int score;
	public Player()
	{
		x = 50;
		y = 350;
		score = 0;
		//xspeed =1;
	}
	
	public double getXpos(){
		return x;
	}
	public double getYpos(){
		return y;
	}
	

	
	public void logic()
	{
		x+=xspeed;
		y+=yspeed;
		
		
		double Boxx = Game.box.x;
		double Boxy = Game.box.y;
		
		if((x == Boxx)&&(xspeed > 0)){
			xspeed -=5;
		}
		if((y == Boxy)&&(xspeed < 0)){
			yspeed -=5;
		}
		
		if((x == Boxx)&&(xspeed < 0)){
			xspeed +=5;
		}
		if((y == Boxy)&&(xspeed < 0)){
			yspeed +=5;
		}
		
		
//		  {if ((x > 100)&&(x < 200)&&
//		  (y > 160)&&(y < 200)){
//			  xspeed =0;
//			  yspeed =0;
//		  }}
//		    	
//		  if ((x > 180)&&(x < 260)&&
//		  (y > 100)&&(y < 132)){
//			xspeed = xspeed - xspeed;
//			yspeed = yspeed - yspeed;
//		  }
		  
		
		if (x >= 600){
	    	x = x-5;
	    }
		if (x <= 0){
	    	x = x+5;
	    }
		if (y >= 400){
	    	y = y-5;
	    }
		if (y <= 0){
	    	y = y+5;
	    }

		{
			//friction
			if(!Keyboard.isKeyDown(Keyboard.KEY_A) && xspeed < 0) xspeed = xspeed*0.85;
			if(!Keyboard.isKeyDown(Keyboard.KEY_D) && xspeed > 0) xspeed = xspeed*0.85;
			if(!Keyboard.isKeyDown(Keyboard.KEY_W) && yspeed > 0) yspeed = yspeed*0.85;
			if(!Keyboard.isKeyDown(Keyboard.KEY_S) && yspeed < 0) yspeed = yspeed*0.85;
			
		}
		//controls
		if(Keyboard.isKeyDown(Keyboard.KEY_A)) xspeed = Math.max(-5, xspeed-1);
		if(Keyboard.isKeyDown(Keyboard.KEY_D)) xspeed = Math.min(5, xspeed+1);
		if(Keyboard.isKeyDown(Keyboard.KEY_W)) yspeed = Math.min(5, yspeed+1);
		if(Keyboard.isKeyDown(Keyboard.KEY_S)) yspeed = Math.max(-5, yspeed-1);
		
		
		//collision with agent
		if(Math.abs(x-Game.agent.x)>16 || Math.abs(y-Game.agent.y)>16) return;
		//If we're here, the player is colliding with the enemy
		if(yspeed<0) Game.player.die();
		if(xspeed == 0) Game.player.die();
	}
		
		
				
	
	public void draw()
	{
		logic();
		glPushMatrix();
		
		glTranslated(x, y, 0);
		
		glBegin(GL_QUADS);
		
		glColor3d(0, 0, 0.7);
		glVertex2d(-8, 0);
		glVertex2d(8, 0);
		glVertex2d(8, 16);
		glVertex2d(-8, 16);
		
		glEnd();
		
		glPopMatrix();
	}

	//if player touches agent, player dies
	public void die() {
		Game.agent.playerkilled ++;
		x = Math.random()*600;
		y = Math.random()*400;
		System.out.println("Agent score = " + Game.agent.playerkilled);
		
	}
}
