
package io;

/*
 * 
 * Created on 10 mars, 2017
 * version 1
 *
 */


import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;

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
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

import controller.ChangeChannelButtonListener;
//import controller.ChannelButtonListener;
import controller.ConnectionButtonListener;
import controller.DeconnexionButtonListener;
import controller.SendButtonListener;
import controller.ServerConnection;

/**
 * 
 * @author CNAM
 * 
 */
public class Window extends javax.swing.JFrame {
	
    // DÃ©claration des variables               
	public JTextPane chatTextArea;
	
    private JButton disconnectButton;
    private JTextPane inputTextArea;
    private JLabel usernameLabel;
    private JLabel onlineLabel;
    private JScrollPane inputMessage;
    private JScrollPane messageList;
    private JScrollPane usersListPanel;
    
    private JLabel channelLabel;
    private JLabel channelField;
    private JButton channelButton;

	private JButton sendButton;
    private JLabel usernameField;
    private JTextArea usersList;


    private static Window INSTANCE = new Window();
    public static final String[] EMOS = {"lol_icon_chat","hungry_icon_chat","loudly_icon_chat", "monkey_icon_chat","poop_icon_chat","angry_icon_chat","penguin_icon_chat","panda_icon_chat"};

    
    // Lancement de la fenêtre de chat et du choix pour le canal de discussion
    private Window() {
    	
        initComponents();
        
    }

    public static Window getInstance() {
		return INSTANCE;
	}

    
    public void addSpace() {
		final StyledDocument doc = inputTextArea.getStyledDocument();

    	try {
		    doc.insertString(doc.getLength(), " ", null );
		} catch (BadLocationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
    // CrÃ©ation de la fenÃªtre du chat
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
        chatTextArea = new JTextPane();
        usernameLabel = new JLabel();
        usernameField = new JLabel();
        channelLabel = new JLabel();
        channelField = new JLabel();
        channelButton = new JButton();
        disconnectButton = new JButton();
        sendButton = new JButton();
        usersListPanel = new JScrollPane();
        usersList = new JTextArea();
        onlineLabel = new JLabel();        
       
	    Toolkit kit = Toolkit.getDefaultToolkit();
	       
	    // Modifier l'icÃ´ne de JFrame
	    Image img = kit.getImage("images/hungry_icon.png");
	    setIconImage(img);
        
        emoList.setVisibleRowCount(1);
        emoList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        Window window = Window.getInstance();
//        window.addWindowListener(new WindowAdapter(){
//            public void windowClosing()
//           {
//              ServerConnection server = ServerConnection.getInstance();
//              server.closeConnection();
//           }
//        });
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat IRC CNAM");
        Font fontText = new Font("Arial", Font.PLAIN, 14);
        inputTextArea.setFont(fontText);
        inputMessage.setViewportView(inputTextArea);


        chatTextArea.setEditable(false);
        chatTextArea.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        messageList.setViewportView(chatTextArea);

        usernameLabel.setText("Username :");
        channelLabel.setText("Channel :");

        usersList.setEditable(false);
        usersList.setColumns(20);
        usersList.setRows(5);
        usersListPanel.setViewportView(usersList);
        
        sendButton.setText("Send");
        sendButton.addActionListener(new SendButtonListener());
        sendButton.addKeyListener(new SendButtonListener());
        inputTextArea.addKeyListener(new SendButtonListener());
        
        disconnectButton.addActionListener(new DeconnexionButtonListener());
        disconnectButton.setText("Deconnexion");
        
        channelButton.setText("Change channel");
        channelButton.addActionListener(new ChangeChannelButtonListener()); 

        onlineLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        onlineLabel.setText("Online Users");
        
        //Ajout des smileys quand l'icÃ´ne sÃ©lectionnÃ© pour le remettre aprÃ¨s
        emoList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
            	
            	StyledDocument doc = getInputTextArea().getStyledDocument();
            	
                JList list = (JList)evt.getSource();
                if (evt.getClickCount() == 2) {
					try {

	                	if(emoList.isSelectedIndex(0)){
							doc.insertString(doc.getLength(), "lol_icon_chat", null);		
	                    	addSpace();
	                	}else if(emoList.isSelectedIndex(1)){
							doc.insertString(doc.getLength(), "hungry_icon_chat", null);		
	                    	addSpace();
						} else if(emoList.isSelectedIndex(2)){
							doc.insertString(doc.getLength(), "loudly_icon_chat", null);		
	                    	addSpace();
						} else if(emoList.isSelectedIndex(3)){
							doc.insertString(doc.getLength(), "monkey_icon_chat", null);
	                    	addSpace();
						} else if(emoList.isSelectedIndex(4)){
							doc.insertString(doc.getLength(), "poop_icon_chat", null);
	                    	addSpace();
						} else if(emoList.isSelectedIndex(5)){
							doc.insertString(doc.getLength(), "angry_icon_chat", null);
	                    	addSpace();
						} else if(emoList.isSelectedIndex(6)){
							doc.insertString(doc.getLength(), "penguin_icon_chat", null);
	                    	addSpace();
						} else if(emoList.isSelectedIndex(7)){
							doc.insertString(doc.getLength(), "panda_icon_chat", null);
	                    	addSpace();
						}
					} catch (BadLocationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }
            }
        });
        
        
   
        // Ajout des icÃ´nes dans la zone de saisie du texte dans un plus petit format
        emoList.addListSelectionListener(new ListSelectionListener() {	
			public void valueChanged(ListSelectionEvent e) {			
				
            	StyledDocument doc = getInputTextArea().getStyledDocument();

            	try {
                if(e.getValueIsAdjusting()) {
                	if(emoList.isSelectedIndex(0)){
						doc.insertString(doc.getLength(), "lol_icon_chat", null);		
                    	addSpace();
                	}else if(emoList.isSelectedIndex(1)){
						doc.insertString(doc.getLength(), "hungry_icon_chat", null);		
                    	addSpace();
					} else if(emoList.isSelectedIndex(2)){
						doc.insertString(doc.getLength(), "loudly_icon_chat", null);		
                    	addSpace();
					} else if(emoList.isSelectedIndex(3)){
						doc.insertString(doc.getLength(), "monkey_icon_chat", null);
                    	addSpace();
					} else if(emoList.isSelectedIndex(4)){
						doc.insertString(doc.getLength(), "poop_icon_chat", null);
                    	addSpace();
					} else if(emoList.isSelectedIndex(5)){
						doc.insertString(doc.getLength(), "angry_icon_chat", null);
                    	addSpace();
					} else if(emoList.isSelectedIndex(6)){
						doc.insertString(doc.getLength(), "penguin_icon_chat", null);
                    	addSpace();
					} else if(emoList.isSelectedIndex(7)){
						doc.insertString(doc.getLength(), "panda_icon_chat", null);
                    	addSpace();
					}}}
                 catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                }
            }
        );
        
        
        // CrÃ©ation de la fenÃªtre de chat et des composants
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
            				    .addComponent(channelLabel, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                				.addPreferredGap(ComponentPlacement.UNRELATED)
                			.addComponent(channelField, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
                			.addPreferredGap(ComponentPlacement.RELATED)
            				.addComponent(channelButton)
            				.addPreferredGap(ComponentPlacement.RELATED)
            				.addComponent(disconnectButton))
            				.addComponent(inputMessage, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE))
            			    .addPreferredGap(ComponentPlacement.UNRELATED)
            			.addGroup(layout.createParallelGroup(Alignment.LEADING)
            				.addComponent(onlineLabel, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
            				.addComponent(usersListPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            			.addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(channelButton)                		
                    .addComponent(disconnectButton)
                    .addComponent(usernameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameLabel, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(channelField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)                        
                    .addComponent(channelLabel	, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(onlineLabel))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(messageList, GroupLayout.DEFAULT_SIZE,261, Short.MAX_VALUE)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(inputMessage, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)                            
                    .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(Alignment.TRAILING)
        			.addComponent(emoList, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
        			.addComponent(sendButton, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
        			.addGap(10))
                    .addComponent(usersListPanel))
                    .addContainerGap())
        );

        pack();
         
    }
    
    public String getChannel(){
    	return this.channelField.getText();
    }
    
    public String getMessage(){
    	return this.inputTextArea.getText();
    }
    
    public void setUsernameField(String username) {
		this.usernameField.setText(username);
	}
    
    public void setChanelField(String chanel) {
		this.channelField.setText(chanel);
	}
    
    public JTextPane getChatTextArea() {
		return chatTextArea;
	}

	public void setChatTextArea(JTextPane chatTextArea) {
		this.chatTextArea = chatTextArea;
	}

	public JTextPane getInputTextArea() {
		return inputTextArea;
	}

	public String getUsernameField() {
		return this.usernameField.getText();
	}
	
}
