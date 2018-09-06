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



public class Test_1 extends JPanel implements ActionListener, KeyListener {
    
    Timer t = new Timer(50, this);
    int[] a = new int[10];
    int[] b = new int[10];
    int i, j;
    public void set (){
        a[0] = 100;
        b[0] = 0;
        a[1] = 90;
        b[1] = 0;
        a[2] = 80;
        b[2] = 0;
        a[3] = 70;
        b[3] = 0;
        a[4] = 60;
        b[4] = 0;
        a[5] = 50;
        b[5] = 0;
        a[6] = 40;
        b[6] = 0;
        a[7] = 30;
        b[7] = 0;
        a[8] = 20;
        b[8] = 0;
        a[9] = 10;
        b[9] = 0;
        
    }
    int velx = 0, vely = 0;
    public Test_1()   {
        t.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }
    
    public void paintComponent(Graphics g)  {
        super.paintComponent(g);
        g.setColor(Color.RED);
        for(i = 0; i<10; i++)   {
        g.fillRect(a[i], b[i], 10, 10);
        }
    }
    
    public void actionPerformed (ActionEvent e) {
        for(i = 0; i>9;i++)    {
            a[i] = a[i] + velx;
            b[i] = b[i] + vely;
            
        }
        
        repaint();
        
        
    }
    public void keyPressed(KeyEvent e)  {
        
        int c = e.getKeyCode();
        
        if(c == KeyEvent.VK_LEFT)   {
            velx = -10;
            vely = 0;
        }
        if(c == KeyEvent.VK_RIGHT)   {
            velx = 10;
            vely = 0;
        }
        if(c == KeyEvent.VK_UP)   {
            velx = 0;
            vely = 10;
        }
        if(c == KeyEvent.VK_DOWN)   {
            velx = 0;
            vely = -10;
        }
    }
    public void keyTyped(KeyEvent e)    {
        
    }
    public void keyReleased(KeyEvent e){}
    public static void main(String[] args)  {
        Test_1 s = new Test_1();
        JFrame jf = new JFrame();
        jf.setTitle("Snakes");
        jf.setSize(600,400);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(s);

    }

}
