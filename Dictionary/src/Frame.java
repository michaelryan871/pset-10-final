import java.awt.*;
import javax.swing.*;
import javax.swing.BorderFactory; 
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
		
		JTextField searchBar = new JTextField("Search");
		searchBar.setBounds(5, 45, 207, 35);
		Dictionary.add(searchBar);
		
		JRadioButton ascend = new JRadioButton("Asc");
		ascend.setBounds(22, 80, 60, 30);
		Dictionary.add(ascend);
		
		JRadioButton descend = new JRadioButton("Desc");
		descend.setBounds(123, 80, 65, 30);
		Dictionary.add(descend);
		
		JTextArea definition = new JTextArea(); 
		definition.setBounds(218, 5, 675, 715);
		definition.setEditable(false);
		Dictionary.add(definition);
		
		JList<String> words = new JList<String>();
		words.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		words.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		words.setVisibleRowCount(-1);
		words.setBounds(6, 123, 207, 597);
		Dictionary.add(words);
		
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