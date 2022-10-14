/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 * This class is the parent class for all Messages and it contains member 
 * variables common to all child classes, such as id, sender name, recipient name,
 * message and message status
 * @author Solly Vinson
 */
public class Message {
    private int id;
    private String sender;
    private String recipient;
    private String message;
    private String status;
    private String msgtype;
   
    
     public Message(String sender, String recipient, String message,String status,String msgtype) {
        this.sender = sender;
        this.recipient = recipient;
        this.message = message;
        this.status=status;
        this.msgtype=msgtype;
        
    }
     public Message(int id,String sender, String recipient, String message,String status,String msgtype) {
        this.id=id;
        this.sender = sender;
        this.recipient = recipient;
        this.message = message;
        this.status=status;
        this.msgtype=msgtype;
        
    }
   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    @Override
    public String toString() {
        return "Message{" + "id=" + id + ", sender=" + sender + ", recipient=" + recipient + ", message=" + message + ", status=" + status + ", msgtype=" + msgtype + '}';
    }
    
    
    
}
