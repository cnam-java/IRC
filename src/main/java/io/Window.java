
package io;

/*
 * 
 * Created on 10 mars, 2017
 * version 1
 *
 */


import java.awt.Font;
import java.awt.event.KeyEvent;

import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.ConnectionButtonListener;
import controller.DeconnexionButtonListener;
import controller.SendButtonListener;

/**
 * 
 * @author Cnam
 * 
 */
public class Window extends javax.swing.JFrame {
	
    // Déclaration des variables               
    private JTextArea chatTextArea;
    private JButton disconnectButton;
    private JTextPane inputTextArea;
    private JLabel usernameLabel;
    private JLabel onlineLabel;
    private JScrollPane inputMessage;
    private JScrollPane messageList;
    private JScrollPane usersListPanel;
    


	private JButton sendButton;
    private JLabel usernameField;
    private JTextArea usersList;


    private static Window INSTANCE = new Window();
    
    // Lancement de la fenêtre de chat et du choix pour le canal de discussion
    private Window() {
        initComponents();
        chanelChat();
        
    }
    
    public static Window getInstance() {
		return INSTANCE;
	}

    // Message de choix du canal de discussion
    private void chanelChat() {  	
    	  String[] options = {"OK"};
		  JPanel panel = new JPanel();
		  JLabel lbl = new JLabel("Entrez un cannal à rejoindre ou à créer");
		  JTextField txt = new JTextField(10);
		  panel.add(lbl);
		  panel.add(txt);
		  int selectedOption = JOptionPane.showOptionDialog(null, panel, "Cannel de discussion", JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options , options[0]);
			
		  if(txt.getText().isEmpty() && selectedOption == 0){
				chanelChat();
			} else if (selectedOption != 0){
				System.exit(0);
			}
	}

	// Récupération du nom d'utilisateur à partir de la fenêtre de connexion
	public void getConnexion(String txtconnexion){
	 	usernameField.setText(txtconnexion);    
	}

	
    public void setUsernameField(String username) {
		this.usernameField.setText(username);
	}

	// Création de la fenêtre du chat
    private void initComponents() {
    	
    	final Object[] items =
    	        {
    	            new ImageIcon("images/lol_icon.png"),
    	            new ImageIcon("images/hungry_icon.png"),
    	            new ImageIcon("images/loudly_icon.png"),
    	            new ImageIcon("images/monkey_icon.png"),
    	            new ImageIcon("images/poop_icon.png"),
    	            new ImageIcon("images/angry_icon.png"),
    	            new ImageIcon("images/penguin_icon.png"),
    	            new ImageIcon("images/panda_icon.png")
    	        };
    	 
        final JList emoList = new JList(items);
        inputMessage = new JScrollPane();
        inputTextArea = new JTextPane();
        messageList = new JScrollPane();
        chatTextArea = new JTextArea();
        usernameLabel = new JLabel();
        usernameField = new JLabel();
        disconnectButton = new JButton();
        sendButton = new JButton();
        usersListPanel = new JScrollPane();
        usersList = new JTextArea();
        onlineLabel = new JLabel();        
       
        emoList.setVisibleRowCount(1);
        emoList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat IRC Cnam");
        Font fontText = new Font("Arial", Font.PLAIN, 14);
        inputTextArea.setFont(fontText);
        inputMessage.setViewportView(inputTextArea);

        chatTextArea.setColumns(20);
        chatTextArea.setEditable(false);
        chatTextArea.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        chatTextArea.setLineWrap(true);
        chatTextArea.setRows(5);
        messageList.setViewportView(chatTextArea);

        usernameLabel.setText("Username:");

        usersList.setEditable(false);
        usersList.setColumns(20);
        usersList.setRows(5);
        usersListPanel.setViewportView(usersList);
        
        sendButton.setText("Envoyer");
        sendButton.addActionListener(new SendButtonListener());
        sendButton.addKeyListener(new SendButtonListener());
        inputTextArea.addKeyListener(new SendButtonListener());
        disconnectButton.addActionListener(new DeconnexionButtonListener());
        disconnectButton.setText("Déconnexion");

        onlineLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        onlineLabel.setText("Online Users");
   
        // Ajout des Icons dans la zone de saisie du texte au format plus petits
        emoList.addListSelectionListener(new ListSelectionListener() {	
			public void valueChanged(ListSelectionEvent e) {				
                if(e.getValueIsAdjusting()) {
                	if(emoList.isSelectedIndex(0)){
                    	inputTextArea.insertIcon((Icon) new ImageIcon("images/lol_icon_chat.png"));
                	}else if(emoList.isSelectedIndex(1)){
                    	inputTextArea.insertIcon((Icon) new ImageIcon("images/hungry_icon_chat.png"));	
					} else if(emoList.isSelectedIndex(2)){
                    	inputTextArea.insertIcon((Icon) new ImageIcon("images/loudly_icon_chat.png"));	
					} else if(emoList.isSelectedIndex(3)){
                    	inputTextArea.insertIcon((Icon) new ImageIcon("images/monkey_icon_chat.png"));	
					} else if(emoList.isSelectedIndex(4)){
                    	inputTextArea.insertIcon((Icon) new ImageIcon("images/poop_icon_chat.png"));	
					} else if(emoList.isSelectedIndex(5)){
                    	inputTextArea.insertIcon((Icon) new ImageIcon("images/angry_icon_chat.png"));	
					} else if(emoList.isSelectedIndex(6)){
                    	inputTextArea.insertIcon((Icon) new ImageIcon("images/penguin_icon_chat.png"));	
					} else if(emoList.isSelectedIndex(7)){
                    	inputTextArea.insertIcon((Icon) new ImageIcon("images/panda_icon_chat.png"));	
					}
                }
            }
        });
        
        
        // Création de la fenêtre de chat et des composants
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            	layout.createParallelGroup(Alignment.TRAILING)
            		.addGroup(layout.createSequentialGroup()
            			.addContainerGap()
            			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
            				.addComponent(messageList, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
            			.addGroup(layout.createSequentialGroup()
            				.addComponent(emoList, GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
            				.addPreferredGap(ComponentPlacement.RELATED)
            				.addComponent(sendButton, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
            			.addGroup(layout.createSequentialGroup()
            				.addComponent(usernameLabel, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
            				.addPreferredGap(ComponentPlacement.UNRELATED)
            				.addComponent(usernameField, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
            				.addPreferredGap(ComponentPlacement.RELATED)
            				.addComponent(disconnectButton))
            				.addComponent(inputMessage, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE))
            			    .addPreferredGap(ComponentPlacement.UNRELATED)
            			.addGroup(layout.createParallelGroup(Alignment.LEADING)
            				.addComponent(onlineLabel, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
            				.addComponent(usersListPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            			.addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(disconnectButton)
                    .addComponent(usernameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameLabel, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(onlineLabel))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(messageList, GroupLayout.DEFAULT_SIZE,261, Short.MAX_VALUE)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(inputMessage, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)                            
                    .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(Alignment.TRAILING)
        			.addComponent(emoList, GroupLayout.DEFAULT_SIZE, 10, Short.MAX_VALUE)
        			.addComponent(sendButton, GroupLayout.DEFAULT_SIZE, 10, Short.MAX_VALUE))
        			.addGap(10))
                    .addComponent(usersListPanel))
                    .addContainerGap())
        );

        pack();
         
    }
    
    public JTextArea getChatTextArea() {
		return chatTextArea;
	}

	public void setChatTextArea(JTextArea chatTextArea) {
		this.chatTextArea = chatTextArea;
	}

	public JTextPane getInputTextArea() {
		return inputTextArea;
	}

	public String getUsernameField() {
		return this.usernameField.getText();
	}
	
}
