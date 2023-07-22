
package mazegame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


public class BolumIki extends JLabel implements ActionListener
{
    
    JPanel panelEkran = new JPanel();
    
    private Timer timer;
    public Timer timert = null;
    
    private Mapiki mi;
    
    
    private boolean win = false;
    private String Message = "";
    private Font font = new Font("Serif", Font.BOLD, 48);
    
    private int tileXb, tileYb ,tileXi ,tileYi;
    private int tesX1,tesY1,tesX2,tesY2;
    private int tesX12,tesY12,tesX22,tesY22;
    private int anX1,anY1,anX2,anY2;
    private int ziX1,ziY1,ziX2,ziY2;
    private Image krktrb ,krktri;
    private Image testere,anahtar,zindan;
    
    
    public BolumIki()
    {
        
        this.setBounds(20, 30, 1600, 800);
        
        mi = new Mapiki();
        
        
        ImageIcon img = new ImageIcon("img/karakterbir.png");
        krktrb= img.getImage();
        tileXb = 20;//20
        tileYb = 3;//3
        
        img = new ImageIcon("img/karakteriki.png");
        krktri = img.getImage();
        tileXi = 26;
        tileYi = 3;
        
        img = new ImageIcon("img/testere.png");
        testere = img.getImage();
        tesX1 = 8;
        tesY1 = 20;
        
        tesX12 = 1;
        tesY12 = 20;
        
        tesX2 = 38;
        tesY2 = 20;
        
        tesX22 = 45;
        tesY22 = 20;
        
        img = new ImageIcon("img/anahtar.png");
        anahtar = img.getImage();
        anX1 = 1;
        anY1 = 2;
        
        anX2 = 45;
        anY2 = 2;
        
        img = new ImageIcon("img/zindan.png");
        zindan = img.getImage();
        ziX1 = 19;
        ziY1 = 5;
        
        ziX2 = 27;
        ziY2 = 5;
        
       
        
        timer = new Timer(25 , this);
        timer.start();
        
        timert = new Timer(175, new TimerKontrol());
        
                
        
        
        panelEkran.setBounds(0, 100, 1600, 800);
        panelEkran.setBackground(Color.BLACK);
        panelEkran.setLayout(null);
        panelEkran.add(this);
        
        
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
    public void movetes1(int tesx1,int tesy1)
    {
        tesX1 += tesx1;
        tesY1 += tesy1;
    }
    public void movetes2(int tesx2,int tesy2)
    {
        tesX2 += tesx2;
        tesY2 += tesy2;
    }
    public void movetes12(int tesx12,int tesy12)
    {
        tesX12 += tesx12;
        tesY12 += tesy12;
    }
    public void movetes22(int tesx22,int tesy22)
    {
        tesX22 += tesx22;
        tesY22 += tesy22;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (mi.getMap(tileXb, tileYb).equals("f")) {
            Message = "Kırmızı Mantar Kazandı";
            win = true;
            
        }
        if (mi.getMap(tileXb, tileYb).equals("m")) {
            Message = "Kırmızı Mantar Mayına Bastı !!! Mavi Mantar Kazandı";
            win = true;
        }
        if (mi.getMap(tileXi, tileYi).equals("f")) {
            Message = "Mavi Mantar Kazandı";
            win = true;
        }
        if (mi.getMap(tileXi, tileYi).equals("m")) {
            Message = "Mavi Mantar Mayına Bastı !!! Kırmızı Mantar Kazandı";
            win = true;
        }
        
        if (tileXb==tesX1 && tileYb == tesY1) {
            Message = "Mavi Mantar testereye Bastı !!! Kırmızı Mantar Kazandı";
            win = true;
        }
        if (tileXi==tesX2 && tileYi == tesY2) {
            Message = "Kırmızı Mantar testereye degdi !!! Mavi Mantar Kazandı";
            win = true;
        }
        if (tileXb==tesX12 && tileYb == tesY12) {
            Message = "Mavi Mantar testereye Bastı !!! Kırmızı Mantar Kazandı";
            win = true;
        }
        if (tileXi==tesX22 && tileYi == tesY22) {
            Message = "Kırmızı Mantar testereye degdi !!! Mavi Mantar Kazandı";
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
                    if (mi.getMap(x, y).equals("f")) {
                        g.drawImage(mi.getFinish(), x * 33, y * 33, null);
                    }
                    if (mi.getMap(x, y).equals("g")) {
                        g.drawImage(mi.getGrass(), x * 33, y * 33, null);
                    }
                    if (mi.getMap(x, y).equals("w")) {
                        g.drawImage(mi.getWall(), x * 33, y * 33, null);
                    }
                    if (mi.getMap(x, y).equals("m")) {
                        g.drawImage(mi.getMayin(), x * 33, y * 33, null);
                    }
                }
                g.drawImage(krktrb, tileXb * 33, tileYb * 33, null);
                g.drawImage(krktri, tileXi * 33, tileYi * 33, null);
                g.drawImage(testere, tesX1 * 33, tesY1 * 33, null);
                g.drawImage(testere, tesX2 * 33, tesY2 * 33, null);
                g.drawImage(testere, tesX12 * 33, tesY12 * 33, null);
                g.drawImage(testere, tesX22 * 33, tesY22 * 33, null);
                g.drawImage(anahtar, anX1 * 33, anY1 * 33, null);
                g.drawImage(anahtar, anX2 * 33, anY2 * 33, null);
                g.drawImage(zindan, ziX1 * 33, ziY1 * 33, null);
                g.drawImage(zindan, ziX2 * 33, ziY2 * 33, null);
            }  
        }
        
        if (tileXb==anX1 && tileYb == anY1) {
           anX1 =0;
           anY1 =0;
           ziX1 =18;
           ziY1 =5;
        }
        if (tileXi==anX2 && tileYi == anY2) {
           anX2 =46;
           anY2 =0;
           ziX2 =28;
           ziY2 =5;
        }
        
        
        if (win) 
        {
            g.setColor(Color.ORANGE);
            g.setFont(font);
            g.drawString(Message, 150, 300);
        }
        
    }
    
    
    public class KlavyeKontrol extends KeyAdapter//implements KeyListener
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
            if (keycode == KeyEvent.VK_W) {
                if ((!mi.getMap(tileXb,tileYb-1).equals("w"))&&(!(tileXb == ziX1 && tileYb-1 == ziY1)))
                {
                   moveb(0, -1);
                }
            }
            
            if (keycode == KeyEvent.VK_S) {
                if (!mi.getMap(tileXb,tileYb+1).equals("w"))
                {
                    moveb(0, 1);
                    
                }
                    
            }
            if (keycode == KeyEvent.VK_A) {
                if (!mi.getMap(tileXb-1,tileYb).equals("w"))
                {
                    moveb(-1, 0);
                    
                } 
                    
            }
            if (keycode == KeyEvent.VK_D) {
                if (!mi.getMap(tileXb+1,tileYb).equals("w"))
                {   
                    moveb(1, 0);
                    
                }
            }
            //karakteriki
            if (keycode == KeyEvent.VK_UP) {
                if ((!mi.getMap(tileXi,tileYi-1).equals("w"))&&(!(tileXi == ziX2 && tileYi-1 == ziY2)))
                {
                    movei(0, -1);
                }
            }
            
            if (keycode == KeyEvent.VK_DOWN) {
                if (!mi.getMap(tileXi,tileYi+1).equals("w"))
                {
                    movei(0, 1);
                }
                    
            }
            if (keycode == KeyEvent.VK_LEFT) {
                if (!mi.getMap(tileXi-1,tileYi).equals("w"))
                {
                    movei(-1, 0);
                } 
                    
            }
            if (keycode == KeyEvent.VK_RIGHT) {
                if (!mi.getMap(tileXi+1,tileYi).equals("w"))
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
    
    
    class TimerKontrol implements ActionListener
    {
        
        @Override
        public void actionPerformed(ActionEvent e) 
        {   
                //1. BÖlüm
               if (!mi.getMap(tesX1+1,tesY1).equals("w"))
                {  
                    movetes1(1, 0);
                   
                }
               else 
                {
                    for (int i = 0; i < 14; i++) {
                        movetes1(-1, 0);
                    }
                }
               
               if (!mi.getMap(tesX12,tesY12-1).equals("w"))
                {  
                    movetes12(0, -1);
                   
                }
               else  
                {
                    for (int i = 0; i < 16; i++) {
                        movetes12(0, 1);
                    }
                }
               //2.bölüm
               if (!mi.getMap(tesX2-1,tesY2).equals("w"))
                {   
                    movetes2(-1, 0);
                    
                    
                }
               else  
                {
                    for (int i = 0; i < 14; i++) {
                        movetes2(1, 0);
                    }
                }
               
               if (!mi.getMap(tesX22,tesY22-1).equals("w"))
                {  
                    movetes22(0, -1);
                   
                }
               else 
                {
                    for (int i = 0; i < 16; i++) {
                        movetes22(0, 1);
                    }
                }
                
        }
        
    }
        
    
    
    
}
