package PM.thread;

import java.awt.Canvas;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ThreadEx4 extends Frame {
    Pan pan = new Pan();
    private int x = 200, y = 20;
    private Message[] messages = new Message[5];
    private String[] str = {"Java", "Oracle", "Jsp", "Spring", "Xml"};
    private MessageThread[] mthread = new MessageThread[messages.length];

    public Pan getPan() {
        return pan;
    }

    public void setPan(Pan pan) {
        this.pan = pan;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void initString() {
        for (int i = 0; i < messages.length; i++) {
            messages[i] = new Message(20 + ((i + 1) * 70), 20, str[i]);
        }
    }

    public ThreadEx4() {
        this.add(pan);
        initString();
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // TODO Auto-generated method stub
                System.exit(0);
            }

            @Override
            public void windowOpened(WindowEvent e) {
                // TODO Auto-generated method stub
				/*StringThread s=new StringThread(ThreadEx7.this);
				s.start();*/
                for (int i = 0; i < mthread.length; i++) {
                    mthread[i] = new MessageThread(ThreadEx4.this, messages[i]);
                    mthread[i].start();
                }

            }

        });
        this.setBounds(100, 100, 500, 500);
        this.setVisible(true);
    }

    public class Pan extends Canvas {// Member InnerClass

        public Pan() {
        }

        @Override
        public void paint(Graphics g) {
            // TODO Auto-generated method stub
            g.setFont(new Font("굴림", Font.BOLD, 20));

            for (int i = 0; i < messages.length; i++) {
                g.drawString(messages[i].getMsg(), messages[i].getX(), messages[i].getY());
            }


        }

    }

    public static void main(String[] args) {
        new ThreadEx4();
    }
}
