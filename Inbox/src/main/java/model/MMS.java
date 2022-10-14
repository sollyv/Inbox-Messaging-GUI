/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 * This class is a sub class of Message
 * The MMS class will contain the extra information of the file path and message type
 * @author Solly Vinson
 */
public class MMS extends Message {
    private String filepath;
    private String msgtype;

    public MMS(String sender, String recipient, String message, String status, String msgtype,String filepath) {
        super(sender, recipient, message, status, msgtype);
        this.filepath=filepath;
        this.msgtype=msgtype;
    }
    
     public MMS(int id,String sender, String recipient, String message, String status, String msgtype,String filepath) {
        super(id,sender, recipient, message, status, msgtype);
        this.filepath=filepath;
        this.msgtype=msgtype;
    }

    @Override
    public String getMsgtype() {
        return msgtype;
    }

    @Override
    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }
    
    
    
}
