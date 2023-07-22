
package mazegame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


public class BolumBir extends JLabel implements ActionListener
{
    
    JPanel panelEkran = new JPanel();
   
    
    private Timer timer;
    private Mapbir mb;
    
    
    private boolean win = false;
    
    private String Message = "";
    private Font font = new Font("Serif", Font.BOLD, 48);
    
    
    private int tileXb, tileYb ,tileXi ,tileYi;
    private Image krktrb ,krktri;
    
    public BolumBir()
    {
        
        this.setBounds(20, 30, 1600, 800);
        
        mb = new Mapbir();
        
        
        ImageIcon img = new ImageIcon("img/karakterbir.png");
        krktrb= img.getImage();
        tileXb = 25;
        tileYb = 1;
        
        img = new ImageIcon("img/karakteriki.png");
        krktri = img.getImage();
        tileXi = 21;
        tileYi = 1;
        
        
        timer = new Timer(25 , this);
        timer.start();
        
        
        
        panelEkran.setBounds(0, 100, 1600, 800);
        panelEkran.setBackground(Color.BLACK);
        panelEkran.setLayout(null);
        panelEkran.add(this);
        
        
        
        
    }
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (mb.getMap(tileXb, tileYb).equals("f")) {
            Message = "Kırmızı Mantar Kazandı";
            win = true;
        }
        if (mb.getMap(tileXb, tileYb).equals("m")) {
            Message = "Kırmızı Mantar Mayına Bastı !!! Mavi Mantar Kazandı";
            win = true;
        }
        if (mb.getMap(tileXi, tileYi).equals("f")) {
            Message = "Mavi Mantar Kazandı";
            win = true;
        }
        if (mb.getMap(tileXi, tileYi).equals("m")) {
            Message = "Mavi Mantar Mayına Bastı !!! Kırmızı Mantar Kazandı";
            win = true;
        }
        repaint();
    }
    
    
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        
        if (!win) 
        {
            for (int y = 0; y < 22; y++) {
                for (int x = 0; x < 47; x++) {
                    
                    if (mb.getMap(x, y).equals("f")) {
                        g.drawImage(mb.getFinish(), x * 33, y * 33, null);
                    }
                    if (mb.getMap(x, y).equals("g")) {
                        g.drawImage(mb.getGrass(), x * 33, y * 33, null);
                    }
                    if (mb.getMap(x, y).equals("w")) {
                        g.drawImage(mb.getWall(), x * 33, y * 33, null);
                    }
                    if (mb.getMap(x, y).equals("m")) {
                        g.drawImage(mb.getMayin(), x * 33, y * 33, null);
                        
                    }
                    
                }
                g.drawImage(krktrb, tileXb * 33, tileYb * 33, null);
                g.drawImage(krktri, tileXi * 33, tileYi * 33, null);
                
            }  
        }
        
        
        if (win) 
        {
            g.setColor(Color.ORANGE);
            g.setFont(font);
            g.drawString(Message, 150, 300);
            
            
        }
        
    }

    
    public void moveb( int txb , int tyb)
    {
    
        tileXb += txb;
        tileYb += tyb;
    }
    public void movei( int txi , int tyi)
    {
        
        tileXi += txi;
        tileYi += tyi;
    }
    
    public class KlavyeKontrol implements KeyListener//extends KeyAdapter
    {
        @Override
        public void keyTyped(KeyEvent e)
        {
        
        }
        
        @Override
        public void keyPressed(KeyEvent e)
        {
            int keycode = e.getKeyCode();
            //karakterbir
            if (keycode == KeyEvent.VK_UP) {
                if (!mb.getMap(tileXb,tileYb-1).equals("w"))
                {
                   moveb(0, -1);
                }
            }
            
            if (keycode == KeyEvent.VK_DOWN) {
                if (!mb.getMap(tileXb,tileYb+1).equals("w"))
                {
                    moveb(0, 1);
                    
                }
                    
            }
            if (keycode == KeyEvent.VK_LEFT) {
                if (!mb.getMap(tileXb-1,tileYb).equals("w"))
                {
                    moveb(-1, 0);
                    
                } 
                    
            }
            if (keycode == KeyEvent.VK_RIGHT) {
                if (!mb.getMap(tileXb+1,tileYb).equals("w"))
                {   
                    moveb(1, 0);
                    
                }
            }
            //karakteriki
            if (keycode == KeyEvent.VK_W) {
                if (!mb.getMap(tileXi,tileYi-1).equals("w"))
                {
                    movei(0, -1);
                }
            }
            
            if (keycode == KeyEvent.VK_S) {
                if (!mb.getMap(tileXi,tileYi+1).equals("w"))
                {
                    movei(0, 1);
                }
                    
            }
            if (keycode == KeyEvent.VK_A) {
                if (!mb.getMap(tileXi-1,tileYi).equals("w"))
                {
                    movei(-1, 0);
                } 
                    
            }
            if (keycode == KeyEvent.VK_D) {
                if (!mb.getMap(tileXi+1,tileYi).equals("w"))
                {   
                    movei(1, 0);
                }
            }
            
        }
        
        @Override
        public void keyReleased(KeyEvent e)
        {
        
        }
        
    }
    
   
    
}
