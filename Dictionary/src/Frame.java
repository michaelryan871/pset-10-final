import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.text.*;
import javax.swing.event.*;
import javax.swing.event.ListSelectionEvent;

import com.google.gson.Gson; 

import java.io.*; 
import java.util.*;


public class Frame {
	
	  protected Object Dictionary;

	public static void main(String[] args) throws FileNotFoundException{

	      getWords();
	      EventQueue.invokeLater(new Runnable() {
	    	  public void run() {
	    		  try {
	    			 Frame window = new Frame();
	    		  } catch (Exception e) {
	    			  e.printStackTrace();
	    		  }
	    	  }
	      });
	 }
	
	  private static DefaultListModel<String> getWords() throws FileNotFoundException{
		    Gson gson = new Gson();
		        // String classpathDirectory = Setup.getClasspathDir();
		        BufferedReader br = new BufferedReader(new FileReader("./words.json"));
		        Words[] words = gson.fromJson(br, Words[].class);
		        System.out.println(words.length + " words added");
		        DefaultListModel<String> listOfWords = new DefaultListModel<String>();
		        for (Words word : words) {
		          listOfWords.addElement(word.getWord().toLowerCase());
		        }
		       ;
		        return  Setup.sortWordsAsc(listOfWords);
		  }
	  
	  private static ArrayList<Words> getWordClass() throws FileNotFoundException{
		    Gson gson = new Gson();
		        //String classpathDirectory = Setup.getClasspathDir();
		        BufferedReader br = new BufferedReader(new FileReader("./words.json"));
		        Words[] words = gson.fromJson(br, Words[].class);
		        ArrayList<Words> listOfWords = new ArrayList<Words>();
		        for (Words word : words) {
		          listOfWords.add(word);
		        }
		       ;
		        return listOfWords;
		  }
	
	public Frame() throws FileNotFoundException, BadLocationException {
		createAndShowUI();
	}
	  
	public static void createAndShowUI() throws BadLocationException {
		JFrame Dictionary = new JFrame("Dictionary");
		Dictionary.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dictionary.setPreferredSize(new Dimension(900, 750));
		Dictionary.pack();
		Dictionary.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(218, 5, 675, 715);
		Dictionary.getContentPane().add(panel);
		panel.setLayout(new CardLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, "addWord");
		
		JPanel panel1 = new JPanel();
		panel1.setToolTipText("");
		panel1.setBackground(Color.WHITE);
		scrollPane.setViewportView(panel1);
		panel1.setLayout(null);
		
		JButton add = new JButton("Add");
		add.setBounds(5, 5, 100, 35);
		Dictionary.add(add);
		
		JButton remove = new JButton("Remove");
		remove.setBounds(110, 5, 100, 35);
		Dictionary.add(remove);
		
		JTextField searchBar = new JTextField("");
		searchBar.setBounds(5, 45, 207, 35);
		Dictionary.add(searchBar);
		
		JRadioButton ascend = new JRadioButton("Asc");
		ascend.setBounds(22, 85, 60, 30);
		Dictionary.add(ascend);
		
		JRadioButton descend = new JRadioButton("Desc");
		descend.setBounds(123, 85, 65, 30);
		Dictionary.add(descend);
		
		// RadioButtons --> Group
		ButtonGroup group = new ButtonGroup();
		group.add(ascend);
		group.add(descend);
		
		JTextArea definition = new JTextArea(); 
		definition.setBounds(218, 5, 675, 715);
		definition.setEditable(false);
		Dictionary.add(definition);
		
		JList<String> words = new JList<String>();

		
		/*words.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		words.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		words.setVisibleRowCount(-1);
		words.setBounds(6, 123, 207, 597);
		Dictionary.add(words);*/
		
		//Border(s)
		words.setBorder(new LineBorder(Color.BLACK, 1, true));
		definition.setBorder(new LineBorder(Color.BLACK, 1, true));
		searchBar.setBorder(new LineBorder(Color.BLACK, 1, true));
		
		//JFrame Option(s)
		Dictionary.setLayout(null);
		Dictionary.setVisible(true);
		Dictionary.setResizable(false);
		
	}
}
