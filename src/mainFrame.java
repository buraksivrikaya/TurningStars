import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class mainFrame extends JFrame{

	ImagePanel p=new ImagePanel();
	Star s1=new Star(0,0,true);
	Star s2=new Star(0,0,false);
	
	
	//coordinates and r
	int xp=400;
	int yp=400;
	int xc=400;
	int yc=300;
	int r1=300;
	int r2=100;

	
	mainFrame(){
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1000,1000);
		
		
		
		
		p.setLayout(null);
		p.add(s1);
		p.add(s2);
		this.add(p);
		
		
		
		
		
		p.addMouseListener(new MouseListener(){

			
			public void mouseClicked(MouseEvent e) {
			    switch(e.getModifiers()) {
			      case 16: {
				        s1.moveto(e.getX(),e.getY());
				        
				        xp=e.getX()-50;
				        yp=e.getY()-50;
			        break;
			        }
			      case 8: {
			        System.out.println("That's the MIDDLE button");
			        break;
			        }
			      case 4: {
			        s2.moveto(e.getX(),e.getY());
			       
			        xc=e.getX()-50;
			        yc=e.getY()-50;
			        
			        break;
			        }
			      }
				
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}});
	
	}
	

	
	boolean right1=true;
	boolean right2=true;
	
	void run(int speed){
		s1.moveto(xp, yp);
		s2.moveto(xc,yc);
		
		while(true){
			if(xp<=700 && right1){
				xp++;
				yp= (int) (Math.sqrt((r1-xp+400)*(r1+xp-400))+400);}
			
			
			else if(xp>=100 && !right1 ){
				xp--;
				yp= (int) (-Math.sqrt((-xp+700)*(xp-100))+400);}
			
			if(xp>700){right1=false;xp=xp-2;yp= (int) (-Math.sqrt((r1-xp+400)*(r1+xp-400))+400);}	
			if(xp<100){right1=true;xp=xp+2;yp= (int) (Math.sqrt((r1-xp+400)*(r1+xp-400))+400);}
		
			
			//--------------------------------
			
			if(xc<=xp+r2 && right2){
				xc=xc+2;
				yc= (int) (Math.sqrt((r2-xc+xp)*(r2+xc-xp))+yp);}
			
			
			else if(xc>=xp-r2 && !right2 ){
				xc=xc-2;
				yc= (int) (-Math.sqrt((r2-xc+xp)*(r2+xc-xp))+yp);}
			
			
			if(xc>r2+xp){right2=false;xc=xc-1;yc=(int) (-Math.sqrt((r2-xc+xp)*(r2+xc-xp))+yp);}	
			if(xc<xp-r2){right2=true;xc=xc+2;yc=(int) (Math.sqrt((r2-xc+xp)*(r2+xc-xp))+yp);}
			
			
			
			
			try{
				s2.moveto((int)xc, (int)yc);
				s1.moveto((int)xp,(int)yp);
				Thread.sleep(speed);				
			}
			catch(Exception e){
				System.out.println("ERROR : "+ e);
				break;
			}
		}
	}
	
	
	public static void main(String args []){
		mainFrame a=new mainFrame();a.run(2);
	}
}
