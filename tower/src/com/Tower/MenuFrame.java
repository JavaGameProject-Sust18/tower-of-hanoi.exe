package com.Tower;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class MenuFrame extends JFrame {
	ImagePanel panel = new ImagePanel();
	JButton loadGame = new JButton(panel.imageLoadGame);

	public MenuFrame() {
		init();
		addMenuFrameActionListener();
	}
	
	public void init(){
         loadGame.setBounds( 520, 300, 200, 45);
         loadGame.setBorder(null);

         this.add(loadGame);
         this.add(panel);
	}
	
	public void addMenuFrameActionListener(){
        loadGame.addActionListener(new newGameAction1());
        loadGame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GameMain.clip.close();
				GameMain.buttonmusic();
				setVisible(false);
				
			}
		});

        

	}
	
	public class ImagePanel extends JPanel {
		private ImageIcon imageIcon = new ImageIcon("images/Towers-of-Hanoi.png");
		private ImageIcon imageLoadGame = new ImageIcon("images/loadgame.jpg");
		private Image image = imageIcon.getImage();
			
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
		    g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		        
		    }
		 }
	}


class newGameAction1 implements ActionListener {
    public void actionPerformed(ActionEvent e){
        try{
            DataInputStream input =new DataInputStream(new FileInputStream("images/input.txt"));
            int x=input.readInt();
            input.close();
            System.out.println("here is XX: " + x);
            GameHold hold =new GameHold("Tower Of Hanoi",x);
        }
        catch(IOException ex){
            System.out.println("Problem with Input Output FIle");
        }
    }
}

   