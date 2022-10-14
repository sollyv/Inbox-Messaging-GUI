/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.MMS;
import model.Message;

/**
 * This class contains two methods, one to insert a new Message into the 
 * database and one to select all Messages from the database.
 * @author Solly Vinson
 */
public class InboxDAO {
    
    /**
     * This method will insert a  new message into the database
     * @param message from the form fields
     * @return true if successful otherwise false
     */
    public boolean send(Message message){
         boolean sendStatus;
        try{
            //Connect to the database and insert the values obtained from the fields into the databse
            Connection con=InboxDB.getConnection();
            String sql="INSERT into dbo.message_details(sender,recipient,message,status,msgtype,filepath) VALUES(?,?,?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,message.getSender());
            ps.setString(2,message.getRecipient());
            ps.setString(3,message.getMessage());
            ps.setString(4,message.getStatus());
            ps.setString(5,message.getMsgtype());
            ps.setString(6,null);
            if(message instanceof MMS m ){
                ps.setString(5,m.getMsgtype());
                ps.setString(6,m.getFilepath());    
            }
            
            ps.executeUpdate();
            sendStatus=true;
        }catch(Exception e){
            e.printStackTrace();
            sendStatus=false;
        }
        return sendStatus;
    }
    
    /**
     * This method will query the Messages database and get all Messages
     * It will then convert each row from the table into
     * a Message object (or its subtype) and add each one to a list.
     * 
     * @return A List containing Message objects
     */
    public List<Message> list(){
         // Declare the list
        List<Message> list = new ArrayList<>();
        
        try { 
         // Create a preparedStatement object with the sql select statement
         Connection con=InboxDB.getConnection();
         String sql="SELECT * FROM message_details ORDER BY Id Desc";
         PreparedStatement selectStmt = con.prepareStatement(sql);

         // Execute that statement, which will return a ResultSet
         ResultSet rs = selectStmt.executeQuery();

         // Loop through the resultSet
         while (rs.next()) {
                
                // From each row, create a Message object
                // The following code retrieves the fields that all messages have
                // in common
                int id = rs.getInt("id");
                String senderName = rs.getString("sender");
                String recipientName = rs.getString("recipient");
                String message = rs.getString("message");
                String msgtype=rs.getString("msgtype");
                String status=rs.getString("status");
                
                //Checking if it is a text message or a MMS message
                //Depending on which the corresponding values are added
                switch (msgtype) {
                    case "Text":
                        Message tm = new Message(id,senderName,recipientName,message,status,msgtype);
                        // Add the Text message to the list
                        list.add(tm);                      
                        break;
                    case "MMS":
                        //Get the filepath for the audio/video/photo file
                        String filepath=rs.getString("filepath");
                        MMS mmsmsg=new MMS(id,senderName,recipientName,message,status,msgtype,filepath);
                        //Add the MMS message to the list
                        list.add(mmsmsg);
                        break;
                }
            } 
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"ERROR");
        }
      //Return the list        
      return list;
    }   
}
