
package mazegame;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JFrame;

public class AnaPencere extends JFrame //JFrame swing kütüphanesinden
{
    
    
    PencereBir pencerebir = new PencereBir();
    
    
    
    public AnaPencere()
    {
        
        this.add(pencerebir.panel);//PencereBirde ki JPaneli JFrame'in içine eklendi
    //***************************************************************
        //JFrame'in arkaplan rengini ayarlıyor
        Container content = this.getContentPane();
        content.setBackground(Color.BLACK);
        content.setLayout(new FlowLayout());
        
    //***************************************************************
    
        this.setTitle("MAZeGAMe");         //Pencere ismi
        this.setSize(1800,1000);           //Pencere boyutu
        this.setLocationRelativeTo(null);  //Pencereyi ortalıyor
        this.setResizable(false);          //Pencereyi tekrar boyutlandırma engelliyor
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Pencere kapanınca projeyi durduruyor
        this.setLayout(null);//JFrame'in içinde otomatik konumlandırmayı kapatıyor
    }
    //***************************************************************
    
    
    
}
