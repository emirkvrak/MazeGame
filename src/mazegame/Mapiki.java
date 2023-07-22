
package mazegame;

import java.awt.Image;
import java.io.File;
import java.util.Scanner;
import javax.swing.ImageIcon;


public class Mapiki 
{
    private Scanner m;
    private String Map[] = new String[22];
    private Image grass,wall,finish,mayin;
    
    public Mapiki()
    {
        
        ImageIcon img = new ImageIcon("img/grass.png");
        grass = img.getImage();
        img = new ImageIcon("img/duvar.png");
        wall = img.getImage();
        img = new ImageIcon("img/finish.png");
        finish = img.getImage();
        img = new ImageIcon("img/mayin.png");
        mayin = img.getImage();
        
        
        openFile();
        readFile();
        closeFile();
        
    }
    
    public Image getGrass()
    {
        return grass;
    }
    
    public Image getWall()
    {
        return wall;
    }
    
    public Image getFinish()
    {
        return finish;
    }
    
    public Image getMayin()
    {
        return mayin;
    }
    
    public String getMap(int x, int y)
    {
        String index = Map[y].substring(x,x + 1);
        
        return index;
    }
    
    public void openFile()
    {
        try {
            m = new Scanner(new File("img/Mapiki.txt"));
        } catch (Exception e) {
            System.out.println("error loading map");
        }
        
    }
    
    public void readFile()
    {
        while (m.hasNext()) {
            for (int i = 0; i < 22; i++) {
                Map[i] = m.next();
            }
        }
        
    }
    
    public void closeFile()
    {
        m.close();
        
    }
}
