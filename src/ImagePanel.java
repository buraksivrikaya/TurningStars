import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


class ImagePanel extends JPanel {

  private Image img;

  public ImagePanel() {
    this(new ImageIcon("srcimages//galaxy.jpg").getImage());
  }

  public ImagePanel(Image img) {
    this.img = img;
    Dimension size = new Dimension(1000, 1000);
    setPreferredSize(size);
    setMinimumSize(size);
    setMaximumSize(size);
    setSize(size);
    setLayout(null);
  }

  public void paintComponent(Graphics g) {
    g.drawImage(img, 0, 0, null);
  }

}