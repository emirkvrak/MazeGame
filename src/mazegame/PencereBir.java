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

public class PencereBir extends JPanel
{

    JPanel panel, panelFirst;
    JButton btn1, btn11, btn2, btn21;
    CardLayout cl = new CardLayout();
//*******************************************************
    
    //Diğer claslara erişim
    PencereIki PI = new PencereIki();
    PencereUc PU = new PencereUc();
    
//*******************************************************
    
    public PencereBir() 
    {
        this.setLayout(null);
        this.setBounds(500, 100, 600, 700);//JPanel boyutu
        
        panel = new JPanel();
        panel.setBounds(100, 30, 1600, 900);//panel boyutu
        
        //***********************************************
        panelFirst = new JPanel();
        panelFirst.setLayout(null);
        panelFirst.setBackground(Color.BLACK);
        panelFirst.add(this);//panelFirst'e JPaneli ekliyor
        
        //***********************************************
        //CardLayout'a panelleri ekledik
        panel.setLayout(cl);
        panel.add(panelFirst, "1");
        panel.add(PI.panelSecond, "2");
        panel.add(PU.panelThird, "3");
        cl.show(panel, "1");
        //***********************************************
        btn1 = new JButton("▶ START");//Başlatma butonu
        this.add(btn1);//Buton1'i JPanele ekliyor
        btn1.setBounds(225, 225, 150, 50);//Buton konumu ve boyutu
        btn1.setBackground(Color.LIGHT_GRAY);//Buton rengi

        btn1.addActionListener(new ActionListener() //Butona tıklayınca ne olacağı
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(panel, "2");//panelSecondu çağırıyor
            }
        });
        //***********************************************
        btn11 = new JButton("◀");
        PI.add(btn11);
        btn11.setBounds(25, 25, 50, 50);
        btn11.setBackground(Color.LIGHT_GRAY);
        btn11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(panel, "1");//panelFirst çağırıyor
            }
        });
        //***********************************************
        btn2 = new JButton("❄ OYNANIŞ");
        this.add(btn2);
        btn2.setBounds(225, 325, 150, 50);
        btn2.setBackground(Color.LIGHT_GRAY);

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(panel, "3");//panelThird çağırıyor
            }
        });
        
        btn21 = new JButton("◀");
        PU.panelThird.add(btn21);
        btn21.setBounds(525, 125, 50, 50);
        btn21.setBackground(Color.LIGHT_GRAY);
        btn21.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(panel, "1");//panelFirst çağırıyor
            }
        });
    }
    
    
    @Override
    protected void paintComponent(Graphics g)//JPanel'in arkaplanına resim ekliyor
    {
        super.paintComponent(g);
    
        int baslangicX = 0;
        int baslangicY = 0;
    
        int bitisX = getSize().width;
        int bitisY = getSize().height;
        
        Image image = new ImageIcon("img/panelFirst.jpg").getImage();
        
        g.drawImage(image, baslangicX, baslangicY, bitisX, bitisY, null);
    }
    
}
