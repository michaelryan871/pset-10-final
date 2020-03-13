import java.awt.*;
import javax.swing.*;
import javax.swing.BorderFactory; 

// import com.google.gson.Gson; 

import java.io.*; 
import java.util.*;


public class Frame {
	
	public static void createAndShowUI() {
		JFrame Dictionary = new JFrame("Dictionary");
		Dictionary.setPreferredSize(new Dimension(900, 750));
		Dictionary.setResizable(false);
		Dictionary.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dictionary.pack();
		Dictionary.setLocationRelativeTo(null);
		Dictionary.setVisible(true);
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		createAndShowUI();
	}
}