import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class pong implements ActionListener, KeyListener, MouseMotionListener{
	JFrame f;
	PongPanel p;
	Timer t;
	
	public void actionPerformed(ActionEvent evt){
		if(evt.getSource() == t){
			p.repaint();
		}
	}
	
	public void mouseMoved(MouseEvent evt){
		p.int1Y=evt.getY();
	}
	
	public void mouseDragged(MouseEvent evt){}
	public void keyReleased(KeyEvent evt){
		switch(evt.getKeyCode()){
			case 38: p.bln2U=false;
				break;
			case 40: p.bln2D=false;
				break;
		}
	}
	
	public void keyPressed(KeyEvent evt){
		//System.out.println(evt.getKeyCode());
		switch(evt.getKeyCode()){
			case 38: p.bln2U=true;
				break;
			case 40: p.bln2D=true;
				break;
		}
	}
	
	public void keyTyped(KeyEvent evt){}
	
	public pong(){
		f = new JFrame("Pong");
		p = new PongPanel();
		p.setLayout(null);
		p.setPreferredSize(new Dimension(1280,720));
		f.addKeyListener(this);
		p.addMouseMotionListener(this);
		
		f.setContentPane(p);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.pack();
		f.setVisible(true);
		
		t = new Timer(1000/60, this);
		t.start();
		
		
	}
	
	public static void main(String[] args){
		new pong();
	}
}
