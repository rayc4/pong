import javax.swing.*;
import java.awt.*;
import java.io.*;
import javax.imageio.*;
import java.util.Random;

public class PongPanel extends JPanel{
	
	int int1Y=360;
	int int2Y=360;
	boolean bln1D=false;
	boolean bln1U=false;
	boolean bln2D=false;
	boolean bln2U=false;
	
	int intBallX=600;
	int intBallY=10;
	boolean blnBallU=false;
	boolean blnBallD=true;
	boolean blnBallR=true;
	boolean blnBallL=false;
	boolean blnStart=true;
	
	int intScore1=0;
	int intScore2=0;
	Random rand = new Random();
	
	public void paintComponent(Graphics g){
		g.drawLine(200,0,200,720);
		g.drawLine(1000,0,1000,720);
		g.setColor(Color.blue);
		g.drawString(intScore1+"",100,50);
		g.drawString(intScore2+"",1100,50);
		// Paddle 1
		g.fillRect(200,int1Y,10,100);
		// Paddle 2
		g.fillRect(990,int2Y,10,100);
		// Ball
		g.fillOval(intBallX, intBallY, 20,20);
		
		// Deflection
		if(intBallY<=0 || intBallY>=700){
			blnBallU^=true;
			blnBallD^=true;
		}
		
		if(intBallX<=210){
			if(intBallY+20>int1Y && intBallY<int1Y+100){
				blnBallL=false;
				blnBallR=true;
			}
			else{
				intScore2++;
				intBallX=600;
				intBallY=10;
				if(rand.nextBoolean()==true){
					blnBallD=true;
					blnBallR=true;
					blnBallL=false;
					blnBallU=false;
				}else{
					blnBallD=false;
					blnBallR=false;
					blnBallL=true;
					blnBallU=true;
				}
				
			}
		}else if(intBallX>=980){
			if(intBallY+30>int2Y && intBallY<int2Y+100){
				blnBallR=false;
				blnBallL=true;
			}else{
				intScore1++;
				intBallX=600;
				intBallY=10;
				if(rand.nextBoolean()==true){
					blnBallD=true;
					blnBallR=true;
					blnBallL=false;
					blnBallU=false;
				}else{
					blnBallD=false;
					blnBallR=false;
					blnBallL=true;
					blnBallU=true;
				}
			}
		}
		
		// Move Ball
		if(blnBallU){
			intBallY-=10;
		}else if(blnBallD){
			intBallY+=10;
		}
		if(blnBallL){
			intBallX-=10;
		}else if(blnBallR){
			intBallX+=10;
		}

		//Move P2
		if(bln2U){
			int2Y-=12;
		}
		if(bln2D){
			int2Y+=12;
		}
		
	}

	public PongPanel(){
		super();
	}
	
}
