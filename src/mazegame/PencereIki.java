package mazegame;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PencereIki extends JPanel
{

    JPanel panelSecond, panelSFirst, panelSSecond, panelSThird;
    JButton btn1, btn11, btn2, btn21;
    CardLayout cl2 = new CardLayout();
//*******************************************************
    
    //Diğer claslara erişim
    BolumBir BB;
    BolumIki BI;
    
    
    
    
//*******************************************************
    public PencereIki() 
    {

        this.setBounds(500, 100, 600, 700);
        this.setLayout(null);
        
        panelSecond = new JPanel();
        panelSecond.setFocusable(true);
        
        //***********************************************

        panelSFirst = new JPanel();
        panelSFirst.setBackground(Color.BLACK);
        panelSFirst.setLayout(null);
        panelSFirst.add(this);
        
        panelSSecond = new JPanel();
        panelSSecond.setBackground(Color.BLACK); 
        panelSSecond.setLayout(null);
        
        
        panelSThird = new JPanel();
        panelSThird.setBackground(Color.BLACK); 
        panelSThird.setLayout(null);
        

        //***********************************************
        panelSecond.setLayout(cl2);
        panelSecond.add(panelSFirst, "1");
        panelSecond.add(panelSSecond, "2");
        panelSecond.add(panelSThird, "3");
        cl2.show(panelSecond, "1");
        //***********************************************

        btn1 = new JButton("1. Bölüm");
        this.add(btn1);
        btn1.setBounds(225, 225, 150, 50);
        btn1.setBackground(Color.LIGHT_GRAY);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                cl2.show(panelSecond, "2");
                BB = new BolumBir();
                BolumBir.KlavyeKontrol Klavyebir = BB.new KlavyeKontrol();
                panelSecond.addKeyListener(Klavyebir);
                panelSSecond.add(BB.panelEkran);
                
                
                btn11 = new JButton("◀ BÖLÜMLER");
                panelSSecond.add(btn11);
                btn11.setBounds(25, 25, 150, 50);
                btn11.setBackground(Color.LIGHT_GRAY);
                btn11.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cl2.show(panelSecond, "1");
                    panelSecond.removeKeyListener(Klavyebir);
                    panelSSecond.remove(BB.panelEkran);
                    panelSSecond.remove(btn11);
                }
            });
                
            }
        });
        //*********************************************** 
        btn2 = new JButton("2. Bölüm");
        this.add(btn2);
        btn2.setBounds(225, 325, 150, 50);
        btn2.setBackground(Color.LIGHT_GRAY);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl2.show(panelSecond, "3");
                BI = new BolumIki();
                BolumIki.KlavyeKontrol Klavyeiki = BI.new KlavyeKontrol();
                panelSecond.addKeyListener(Klavyeiki);
                panelSThird.add(BI.panelEkran);
                BI.timert.start();
                
                
                
                btn21 = new JButton("◀ BÖLÜMLER");
                panelSThird.add(btn21);
                btn21.setBounds(25, 25, 150, 50);
                btn21.setBackground(Color.LIGHT_GRAY);
                btn21.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cl2.show(panelSecond, "1");
                    panelSecond.removeKeyListener(Klavyeiki);
                    panelSThird.remove(BI.panelEkran);
                    panelSThird.remove(btn21);
                    
                    }
                });
                
               
                
            }
        });

        //*********************************************** 
        

        
        
        
    }
    
    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g); 
    
        int baslangicX = 0;
        int baslangicY = 0;
    
        int bitisX = getSize().width;
        int bitisY = getSize().height;
        
        Image image = new ImageIcon("img/panelSecond.jpg").getImage();
        g.drawImage(image, baslangicX, baslangicY, bitisX, bitisY, null);
    }
}
