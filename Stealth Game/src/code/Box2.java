package code;
import static org.lwjgl.opengl.GL11.*;

public class Box2
{
	public double x, y;
	public Box2()
	{
	//	x = 200;
	//	y = 350;
	}
	
	public double getXpos(){
		return x;
	}
	public double getYpos(){
		return y;
	}
	
	public void logic()
	{
			
		}
		
	
	public void draw()
	{
		logic();
		
		glPushMatrix();
		
		glTranslated(x, y, 0);
		
		glBegin(GL_QUADS);
		
		glColor3d(0.5, 0.5, 0.5);
		glVertex2d(100, 160);
		glVertex2d(100, 200);
		glVertex2d(200, 200);
		glVertex2d(200, 160);
		
		glEnd();
		
		glPopMatrix();
	}

}
