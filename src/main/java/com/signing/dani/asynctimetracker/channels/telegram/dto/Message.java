package com.signing.dani.asynctimetracker.channels.telegram.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {
    
    @JsonProperty("message_id")
    private Long messageId;
    
    private Chat chat;
    private String text;

    public Long getMessageId() { return messageId; }
    public void setMessageId(Long messageId) { this.messageId = messageId; }
    
    public Chat getChat() { return chat; }
    public void setChat(Chat chat) { this.chat = chat; }
    
    public String getText() { return text; }
    public void setText(String text) { this.text = text; }
}