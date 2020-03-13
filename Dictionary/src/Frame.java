import java.awt.*;
import javax.swing.*;
import javax.swing.BorderFactory; 
import javax.swing.JTextField;
import javax.swing.text.*;
import javax.swing.event.*;

// import com.google.gson.Gson; 

import java.io.*; 
import java.util.*;


public class Frame {
	
	public static void createAndShowUI() throws BadLocationException {
		JFrame Dictionary = new JFrame("Dictionary");
		Dictionary.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dictionary.setPreferredSize(new Dimension(900, 750));
		Dictionary.pack();
		Dictionary.setLocationRelativeTo(null);
		
		JButton add = new JButton("Add");
		add.setBounds(5, 5, 100, 35);
		Dictionary.add(add);
		
		JButton remove = new JButton("Remove");
		remove.setBounds(110, 5, 100, 35);
		Dictionary.add(remove);
		
			
		//JFrame Option(s)
		Dictionary.setLayout(null);
		Dictionary.setVisible(true);
		Dictionary.setResizable(false);
		
	}
	
	  public static void main(String[] args){

	      javax.swing.SwingUtilities.invokeLater(new Runnable(){ // Schedule a job
	        // for the event-dispatching thread: <-- Received from Oracle's website.
	        public void run(){
	          try {
				createAndShowUI();
			} catch (BadLocationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        }
	      });
	  }
}