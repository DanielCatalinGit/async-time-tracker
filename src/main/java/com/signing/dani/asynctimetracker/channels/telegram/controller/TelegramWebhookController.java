package com.signing.dani.asynctimetracker.channels.telegram.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.signing.dani.asynctimetracker.channels.telegram.dto.TelegramUpdate;
import com.signing.dani.asynctimetracker.channels.telegram.service.TelegramTimeTrackingService;

@RestController
@RequestMapping("/api/webhook")
public class TelegramWebhookController {

    private final TelegramTimeTrackingService telegramTimeTrackingService;

    public TelegramWebhookController(TelegramTimeTrackingService telegramTimeTrackingService) {
        this.telegramTimeTrackingService = telegramTimeTrackingService;
    }

    @PostMapping("/telegram")
    public ResponseEntity<String> receiveTelegramUpdate(@RequestBody TelegramUpdate update) {
        telegramTimeTrackingService.processTelegramUpdate(update);
        return ResponseEntity.ok("OK");
    }
}