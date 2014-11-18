import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Star extends JLabel {

	  ImageIcon red=new ImageIcon("srcimages//starr.png");
	  ImageIcon blue=new ImageIcon("srcimages//starb.png");
	  
	  
	  
	  
	  
	  public Star(int x, int y, boolean z) {
		setLocation(x,y);
	    if(z){setIcon(red);}else{setIcon(blue);}
	    // setMargin(new Insets(0,0,0,0));
	    setIconTextGap(0);
	    // setBorderPainted(false);
	    setBorder(null);
	    setText(null);
	    setSize(100,100);
	    //setSize(icon.getImage().getWidth(null), icon.getImage().getHeight(null));
	  }
	  
	 
	  
	  public void moveto(int  x1, int y1){setLocation(x1-50,y1-50);System.out.println(x1+","+y1);}
	
}
