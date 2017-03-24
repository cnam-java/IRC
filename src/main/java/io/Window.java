
package io;

/*
 * 
 * Created on 10 mars, 2017
 * version 1
 *
 */


import java.net.*;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.io.*;
import java.util.*;

import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle;

/**
 * 
 * @author Cnam
 * 
 */
public class Window extends javax.swing.JFrame {
	
	
    // Variables declaration - do not modify                     
    private javax.swing.JTextArea chatTextArea;
    private javax.swing.JButton connectButton;
    private javax.swing.JButton disconnectButton;
    private javax.swing.JTextPane inputTextArea;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JLabel onlineLabel;
    private javax.swing.JScrollPane inputMessage;
    private javax.swing.JScrollPane messageList;
    private javax.swing.JScrollPane usersListPanel;
    private javax.swing.JButton sendButton;
    private javax.swing.JTextField usernameField;
    private javax.swing.JTextArea usersList;
    private javax.swing.JComboBox emo;
    // End of variables declaration              
	
	
//    String username, serverIP = "";
//    int Port = 0;
    Socket sock;
    BufferedReader reader;
    PrintWriter writer;
    ArrayList<String> userList = new ArrayList();
    Boolean isConnected = false;


    /** Creates new form Chat */
    public Window() {
        initComponents();
    }
    
    
    /*	Permet de gérer les différentes connexions	 */

    public class IncomingReader implements Runnable{

        public void run() {
            String[] data;
            String stream, done = "Terminer", connect = "Connecter", disconnect = "Deconnecter", chat = "Chat";

            try {
                while ((stream = reader.readLine()) != null) {

                    data = stream.split(":");

                     if (data[2].equals(chat)) {

                        chatTextArea.append(data[0] + ": " + data[1] + "\n");
                        chatTextArea.setCaretPosition(chatTextArea.getDocument().getLength());

                    } else if (data[2].equals(connect)){

                        chatTextArea.removeAll();
                        userAdd(data[0]);

                    } else if (data[2].equals(disconnect)) {


                        userRemove(data[0]);

                    } else if (data[2].equals(done)) {


                        usersList.setText("");
                        writeUsers();
                        userList.clear();

                    }
                 
                }
           }catch(Exception ex) {
           }
        }
    }
    

    /*	 Appel du Thread	*/
    public void ListenThread() {
         Thread IncomingReader = new Thread(new IncomingReader());
         IncomingReader.start();
    }

    
    
    
    /*	 Méthodes User	*/
    public void userAdd(String data) {
         userList.add(data);

     }

    public void userRemove(String data) {
         chatTextArea.append(data + " s'"
         		+ "est déconnecté.\n");

     }

    public void writeUsers() {
         String[] tempList = new String[(userList.size())];
         userList.toArray(tempList);
         for (String token:tempList) {

             usersList.append(token + "\n");

         }

     }

//    public void sendDisconnect() {
//
//       String bye = (username + ": :Déconnecté");
//        try{
//            writer.println(bye); // Sends server the disconnect signal.
//            writer.flush(); // flushes the buffer
//        } catch (Exception e) {
//            chatTextArea.append("Impossible d'envoyer le message déconnecté.\n");
//        }
//
//      }

    public void Disconnect() {

        try {
               chatTextArea.append("Déconnecté.\n");
               sock.close();
        } catch(Exception ex) {
               chatTextArea.append("Échec de la déconnexion. \n");
        }
        isConnected = false;
        usernameField.setEditable(true);
        usersList.setText("");

      }

    
    /*	 Initialisation du visuel  	*/
    
    private void initComponents() {

    	final Controller controller = new Controller();
    	final Object[] items =
    	        {
    			 	new ImageIcon("images/emo_icon.png"),
    	            new ImageIcon("images/lol_icon.png"),
    	            new ImageIcon("images/hungry_icon.png"),
    	            new ImageIcon("images/loudly_icon.png"),
    	            new ImageIcon("images/monkey_icon.png"),
    	            new ImageIcon("images/poop_icon.png")
    	        };
    	 


        inputMessage = new javax.swing.JScrollPane();
        inputTextArea = new javax.swing.JTextPane();
        messageList = new javax.swing.JScrollPane();
        chatTextArea = new javax.swing.JTextArea();
        usernameLabel = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        connectButton = new javax.swing.JButton();
        disconnectButton = new javax.swing.JButton();
        sendButton = new javax.swing.JButton();
        usersListPanel = new javax.swing.JScrollPane();
        usersList = new javax.swing.JTextArea();
        onlineLabel = new javax.swing.JLabel();
        
        String[] tab = {"", " :) ", " :( ", " :/ ", " :s "};
        emo = new JComboBox(items);
        emo.setPreferredSize(new Dimension(100, 20));
        
        Icon icon = new ImageIcon("images/lol_icon.png");
        
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

        connectButton.setText("Connexion");
        connectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                controller.connectButtonActionPerformed(evt);
            }
        });

        disconnectButton.setText("Déconnexion");
        disconnectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                controller.disconnectButtonActionPerformed(evt);
            }
        });

        sendButton.setText("Envoyer");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                controller.sendButtonActionPerformed(evt);
            }
        });

        usersList.setEditable(false);
        usersList.setColumns(20);
        usersList.setRows(5);
        usersListPanel.setViewportView(usersList);

        onlineLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        onlineLabel.setText("Online Users");

        
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                controller.sendButtonActionPerformed(evt);
            }
        });
        

        
        emo.addItemListener(new java.awt.event.ItemListener(){
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED) {
//                	inputTextArea.append((String)emo.getSelectedItem());
                	if (emo.getSelectedItem() == items[0]){
                		
                	}
                	else if (emo.getSelectedItem() == items[1]) {
                    	inputTextArea.insertIcon((Icon) new ImageIcon("images/lol_icon_chat.png"));
					} else if(emo.getSelectedItem() == items[2]){
                    	inputTextArea.insertIcon((Icon) new ImageIcon("images/hungry_icon_chat.png"));	
					} else if(emo.getSelectedItem() == items[3]){
                    	inputTextArea.insertIcon((Icon) new ImageIcon("images/loudly_icon_chat.png"));	
					} else if(emo.getSelectedItem() == items[4]){
                    	inputTextArea.insertIcon((Icon) new ImageIcon("images/monkey_icon_chat.png"));	
					} else if(emo.getSelectedItem() == items[5]){
                    	inputTextArea.insertIcon((Icon) new ImageIcon("images/poop_icon_chat.png"));	
					}
                	else{
	                	inputTextArea.insertIcon((Icon) emo.getSelectedItem());
					}
                }
            }
        });
        
        /*	 Instanciation de la fenetre et ajout des composants 	*/

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);       
        
        layout.setHorizontalGroup( 
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(inputMessage, GroupLayout.DEFAULT_SIZE,396, Short.MAX_VALUE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emo, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sendButton, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
                    .addComponent(messageList, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 500 ,Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(usernameLabel, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(usernameField, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(connectButton)
                        .addGap(18, 18, 18)
                        .addComponent(disconnectButton)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(onlineLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(usersListPanel))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(disconnectButton)
                    .addComponent(connectButton)
                    .addComponent(usernameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameLabel, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(onlineLabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(messageList, GroupLayout.DEFAULT_SIZE,261, Short.MAX_VALUE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(sendButton, GroupLayout.DEFAULT_SIZE,10, Short.MAX_VALUE)
                            .addComponent(inputMessage, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                            .addComponent(emo, GroupLayout.Alignment.CENTER, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
                    .addComponent(usersListPanel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                                                                              
}
