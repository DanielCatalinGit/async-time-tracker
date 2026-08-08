package com.signing.dani.asynctimetracker.channels.telegram.dto;

public class CallbackQuery {
    
    private String id;
    private Message message;
    private String data;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public Message getMessage() { return message; }
    public void setMessage(Message message) { this.message = message; }
    
    public String getData() { return data; }
    public void setData(String data) { this.data = data; }
}