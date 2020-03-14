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

	  
	public static void createAndShowUI() throws FileNotFoundException, BadLocationException {
		JFrame Dictionary = new JFrame("Dictionary");
		Dictionary.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dictionary.setBounds(100, 100, 800, 600);
		Dictionary.pack();
		Dictionary.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBounds(207, 11, 556, 549);
		Dictionary.getContentPane().add(panel);
		
		JScrollPane scrollPane3 = new JScrollPane();
		panel.add(scrollPane3, "addWord");
		
		JPanel panel1 = new JPanel();
		panel1.setToolTipText("");
		panel1.setBackground(Color.WHITE);
		scrollPane3.setViewportView(panel1);
		panel1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Word*");
	    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
	    lblNewLabel.setBounds(10, 11, 117, 54);
	    panel1.add(lblNewLabel);
	    
	    JTextField textField = new JTextField();
	    textField.setToolTipText("word");
	    textField.setBounds(20, 76, 286, 20);
	    panel1.add(textField);
	    textField.setColumns(10);
	    
	    JLabel lblDefinitions = new JLabel("Definitions*");
	    lblDefinitions.setFont(new Font("Tahoma", Font.BOLD, 32));
	    lblDefinitions.setBounds(10, 107, 199, 54);
	    panel1.add(lblDefinitions);
	    
	    JTextField txtDefinitions = new JTextField();
	    txtDefinitions.setToolTipText("Definitions");
	    txtDefinitions.setColumns(10);
	    txtDefinitions.setBounds(20, 182, 286, 20);
	    panel1.add(txtDefinitions);
	    
	    JTextField textField_2 = new JTextField();
	    textField_2.setToolTipText("Part of Speech");
	    textField_2.setColumns(10);
	    textField_2.setBounds(346, 182, 147, 20);
	    panel1.add(textField_2);
	    
	    JLabel lblPartOfSpech = new JLabel("Parts of Speech*");
	    lblPartOfSpech.setFont(new Font("Tahoma", Font.BOLD, 18));
	    lblPartOfSpech.setBounds(336, 130, 157, 20);
	    panel1.add(lblPartOfSpech);
		
	    JTextField textField_1 = new JTextField();
	    textField_1.setToolTipText("synonym");
	    textField_1.setColumns(10);
	    textField_1.setBounds(20, 287, 286, 20);
	    panel1.add(textField_1);
	    
	    JLabel lblSeperateByComma = new JLabel("Seperate by comma");
	    lblSeperateByComma.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    lblSeperateByComma.setBounds(20, 264, 137, 20);
	    panel1.add(lblSeperateByComma);
	    
	    JLabel label = new JLabel("Seperate by comma");
	    label.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    label.setBounds(20, 157, 137, 20);
	    panel1.add(label);
	    
	    JLabel label_1 = new JLabel("Seperate by comma");
	    label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    label_1.setBounds(346, 161, 137, 20);
	    panel1.add(label_1);
	    
	    JLabel lblAntonyms = new JLabel("Antonyms");
	    lblAntonyms.setFont(new Font("Tahoma", Font.BOLD, 32));
	    lblAntonyms.setBounds(10, 318, 184, 54);
	    panel1.add(lblAntonyms);
	    
	    JLabel label_2 = new JLabel("Seperate by comma");
	    label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    label_2.setBounds(20, 369, 137, 20);
	    panel1.add(label_2);
	    
	    JTextField textField_3 = new JTextField();
	    textField_3.setToolTipText("antonyms");
	    textField_3.setColumns(10);
	    textField_3.setBounds(20, 400, 286, 20);
	    panel1.add(textField_3);
	    
	    JLabel lblRequred = new JLabel("* = required");
	    lblRequred.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    lblRequred.setBounds(20, 513, 137, 20);
	    panel1.add(lblRequred);
	    
	    JScrollPane scrollPane_2 = new JScrollPane();
	    panel1.add(scrollPane_2, "defintions");
	    
	    CardLayout cardLayout = (CardLayout) panel1.getLayout();
	    cardLayout.show(panel1, "defintions");
	    
	    JTextPane textPane = new JTextPane();
	    textPane.setEditable(false);
	    scrollPane_2.setViewportView(textPane);

	    StyledDocument doc = textPane.getStyledDocument();
	    DefaultCaret caret = (DefaultCaret) textPane.getCaret();
	    caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
	    textPane.setBorder(BorderFactory.createCompoundBorder(
	        textPane.getBorder(),
	            BorderFactory.createEmptyBorder(10, 10 ,10 , 10)));
	    
	    Style bigWord = textPane.addStyle("Style", null);
	    Style header = textPane.addStyle("Style", null);
	    StyleConstants.setFontSize(header, 20);
	    StyleConstants.setFontSize(bigWord, 36);
	    StyleConstants.setBold(bigWord, true);

	    doc.remove(0, doc.getLength());
	    doc.insertString(doc.getLength(),"Example Word\n" ,bigWord );
	    doc.insertString(doc.getLength(),"\n" , null );
	    doc.insertString(doc.getLength(),"Definitions\n" ,header );
	    doc.insertString(doc.getLength(),"\n" ,null );
	    doc.insertString(doc.getLength(),"1. Example Word (pos) \n\n    Definition of example word\n\n" ,null );
	    doc.insertString(doc.getLength(),"\n" ,null );
	    doc.insertString(doc.getLength(),"Synonyms\n" ,header );
	    doc.insertString(doc.getLength(),"\n1.Synonym " ,null );
	    doc.insertString(doc.getLength(),"\n\n" ,null );
	    doc.insertString(doc.getLength(),"Antonyms\n" ,header );
	    doc.insertString(doc.getLength(),"\n1.Antonym " ,null );
	    
	    JScrollPane scrollPane_1 = new JScrollPane();
	    scrollPane_1.setBounds(12, 114, 179, 446);
	    Dictionary.getContentPane().add(scrollPane_1);
	    
	}
}
		


		          
		       
		          
