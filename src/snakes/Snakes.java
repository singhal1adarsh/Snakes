package snakes;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Snakes extends JPanel implements ActionListener, KeyListener {
    
    Timer t = new Timer(50, this);
    int x = 0, velX = 10, X = 250, Y = 250, y = 0, velY = 10, food = 9;
    int[] a = new int[200];
    int[] b = new int[200];
    int[] d = new int[200];
    int[] c = new int[200];
    int ll = 1, rr = 1, uu =0, dd = 0;
    private static JFrame currObject;
    
    int i, j;
    public void set (){
        c[0] = 100;
        a[0] = 100;
        b[0] = 0;
        for(i = 0; i<food-1; i++)    {
            c[i+1] = c[i] - 10;
        }
        
        for(i = 0; i<food; i++)    {
            d[i] = 0;
        }
        for(i = 0; i<food; i++)    {
            a[i+1] = a[i] - 10;
            a[i] = 0;
            
        }
    }
    
    int  velx = 10, vely = 0;
    public Snakes()   {
        t.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }
    
    public void paintComponent(Graphics g)  {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillRect(X, Y, 10, 10);
        g.setColor(Color.BLACK);
        for(i = 0; i<food+1; i++)   {
        g.fillRect(a[i], b[i], 10, 10);   
        }
    }
    public void actionPerformed(ActionEvent e)  {
        if(x<0|| x>550)
            velX = -velX;
        if(y<0 || y>350)
            velY = -velY;
        x = x + velX;
        y = y + velY;
        a[0] = a[0] + velx;
        for(i=0; i<food+1; i++)  {
            a[i+1] = c[i];
            c[i] = a[i];
        }
        
        b[0] = b[0] + vely;
        for(i=0; i<food+1; i++)  {
            b[i+1] = d[i];
            d[i] = b[i];
        }
        if(a[0] == X && b[0] == Y)  {
            if(a[0] == a[i] && b[0] ==b[i]) {
                X = a[food+1];
                food++;
                Y = a[food+1];
            }
            else{
                X = x;
                food++;
                Y = y;
            }
        }
        
        
        if(a[0]==600){ 
            a[0]=0;
            c[0] = 0;
        }
        else if(a[0]==-10)    {
            a[0] = 590;
        }
        
        if(b[0]==390)  {
            b[0]=0;
            d[0]=0;
        }
        else if(b[0]==-10)    {
            b[0] = 390;
        }
        for(i = 1;i<food+1;i++)  {
            if(a[0] == a[i] && b[0] ==b[i]) {
                int Score = food - 9;
                System.out.println("YOUR SCORE WAS \"" + Score + "\"" );
                currObject.dispose();
                new overBro(currObject, false);
            }
        }
        repaint();
    }
    public void keyPressed(KeyEvent e)   {
        int c = e.getKeyCode();
        
        if (c == KeyEvent.VK_LEFT && rr==0)
        {
            velx = -10;
            vely = 0;
            rr = 1;
            dd = 0;
            uu = 0;
            ll = 1;
        }
        if(c == KeyEvent.VK_UP && dd==0 )
        {
            velx = 0;
            vely = -10;
            ll = 0;
            rr = 0;
            dd = 1;
            uu = 1;
        }
        if(c == KeyEvent.VK_RIGHT && ll==0) {
            velx = 10;
            vely = 0;
            rr = 1;
            ll = 1;
            uu = 0;
            dd = 0;
        } 
        if(c == KeyEvent.VK_DOWN && uu == 0)
        {
            velx = 0;
            vely = 10;
            uu = 1;
            rr = 0;
            dd = 1;
            ll = 0;
            //System.out.println("Down");
            
         }
    }
    
    public void keyTyped(KeyEvent e){}
    public void keyReleased(KeyEvent e) {    }
    public static void main(String[] args)  {
        Snakes s = new Snakes();
        s.set();
        JFrame jf = new JFrame();
        currObject=jf;
        jf.setTitle("Snakes");
        jf.setSize(610,430);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(s);

    }
}
    