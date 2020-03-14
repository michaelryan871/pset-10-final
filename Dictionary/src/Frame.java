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

		
		JScrollPane scrollPane = new JScrollPane();
		panel1.add(scrollPane, "addWord");
		
		JPanel panel1 = new JPanel();
		panel1.setToolTipText("");
		panel1.setBackground(Color.WHITE);
		scrollPane.setViewportView(panel1);
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
	    panel.add(scrollPane_2, "defintions");
	    
	    CardLayout cardLayout = (CardLayout) panel.getLayout();
	    cardLayout.show(panel, "defintions");
	    
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
	    
	    //
	    
	    
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
		 words.addListSelectionListener(new ListSelectionListener() {
		      boolean ranOnce = false;
		      public void valueChanged(ListSelectionEvent arg0) {
		        if(ranOnce) {
		          ranOnce = false;
		        }else {
		          ranOnce = true;

		          String selectedWord = words.getSelectedValue();
		          System.out.println(selectedWord);
		
		          try {
		              ArrayList<Words> Words = getWordClass();
		              for(Words word: Words) {
		                if(word.getWord().equals(selectedWord)) {
		                  doc.remove(0, doc.getLength());
		                  doc.insertString(doc.getLength(),selectedWord.substring(0, 1).toUpperCase() + selectedWord.substring(1) + "\n" ,bigWord );
		                  doc.insertString(doc.getLength(),"\n" ,null );
		                  doc.insertString(doc.getLength(),"Definitions\n" ,header );
		                  doc.insertString(doc.getLength(),"\n" ,null );
		                  Definitions[] definitions = word.getDefinitions();
		                  int definitionCounter = 1;
		                  for (Definitions definition : definitions) {
		                    doc.insertString(doc.getLength(), definitionCounter + "." + selectedWord +" (" + definition.getPartOfSpeech() +")\n\n    "  +  definition.getDefinition() + "\n\n", null);
		                    definitionCounter++;
		                  }
		          
		/*words.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		words.setLayoutOrientation(JList.HORIZONTAL_WRAP);
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
		          
		       
		          
