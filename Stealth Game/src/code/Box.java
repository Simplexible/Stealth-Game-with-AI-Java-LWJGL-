package code;
import static org.lwjgl.opengl.GL11.*;

public class Box
{
	public double x, y, width, height;
	public Box()
	{
		x = 300;
		y = 200;
	}
	
	public double getXpos(){
		return x;
	}
	public double getYpos(){
		return y;
	}
	
	public double getwidth(){
		return width;
	}
	
	public double getheight(){
		return height;
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
		glVertex2d(-80, 0);
		glVertex2d(80, 0);
		glVertex2d(80, 160);
		glVertex2d(-80, 160);
		
		glEnd();
		
		glPopMatrix();
	}

}
