package com.signing.dani.asynctimetracker.channels.telegram.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TelegramUpdate {
    
    @JsonProperty("update_id")
    private Long updateId;
    
    private Message message;
    
    @JsonProperty("callback_query")
    private CallbackQuery callbackQuery;

    public Long getUpdateId() { return updateId; }
    public void setUpdateId(Long updateId) { this.updateId = updateId; }
    
    public Message getMessage() { return message; }
    public void setMessage(Message message) { this.message = message; }
    
    public CallbackQuery getCallbackQuery() { return callbackQuery; }
    public void setCallbackQuery(CallbackQuery callbackQuery) { this.callbackQuery = callbackQuery; }
}