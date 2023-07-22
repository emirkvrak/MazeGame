
package mazegame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


public class PencereUc extends JPanel
{
    JPanel panelThird,panelAyar;
    JLabel lb1,lb2,lb3,lb4;
    JPanel pn1;
    JTabbedPane tpane = new JTabbedPane();
    
    public PencereUc()
    {   
        
        this.setBounds(0, 0, 600, 700);
        this.setLayout(null);
        
        panelAyar = new JPanel();
        panelAyar.setBounds(500, 200, 600, 600); 
        panelAyar.setLayout(null);
        panelAyar.add(this);
        
        panelThird = new JPanel();
        panelThird.setBackground(Color.BLACK); 
        panelThird.setLayout(null);
        panelThird.add(panelAyar);
        
        
            
            lb1 = new JLabel();
            lb1.setText("Mavi Mantar =");
            lb1.setBounds(20, 60, 400, 15);
            
            lb2 = new JLabel();
            lb2.setText("Sol = ◀ | Sağ = ▶ | Yukarı = ▲ | Aşağı = ▼");
            lb2.setBounds(20, 90, 400, 15);
            
            lb3 = new JLabel();
            lb3.setText("Kırmızı Mantar =");
            lb3.setBounds(20, 150, 400, 15);
            
            lb4 = new JLabel();
            lb4.setText("Sol = A | Sağ = D | Yukarı = W | Aşağı = S");
            lb4.setBounds(20, 180, 400, 15);
            
            pn1 = new JPanel();
            pn1.setLayout(null);
            pn1.add(lb1);
            pn1.add(lb2);
            pn1.add(lb3);
            pn1.add(lb4);
            
            tpane.setBounds(100, 100, 400, 400);
            tpane.add("KLAVYE", pn1);
            
        
            this.add(tpane);
    }
    
    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g); 
    
        int baslangicX = 0;
        int baslangicY = 0;
    
        int bitisX = getSize().width;
        int bitisY = getSize().height;
        
        Image image = new ImageIcon("img/panelThird.jpg").getImage();
        g.drawImage(image, baslangicX, baslangicY, bitisX, bitisY, null);
    }
}
