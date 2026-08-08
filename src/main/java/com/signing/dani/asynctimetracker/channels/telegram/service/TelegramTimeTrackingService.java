package com.signing.dani.asynctimetracker.channels.telegram.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.signing.dani.asynctimetracker.channels.telegram.dto.TelegramUpdate;
import com.signing.dani.asynctimetracker.core.model.TimeRecord;
import com.signing.dani.asynctimetracker.core.repository.TimeRecordRepository;

@Service
public class TelegramTimeTrackingService {

    private final TimeRecordRepository timeRecordRepository;

    @Value("${telegram.bot.token}")
    private String botToken;

    public TelegramTimeTrackingService(TimeRecordRepository timeRecordRepository) {
        this.timeRecordRepository = timeRecordRepository;
    }

    public void processTelegramUpdate(TelegramUpdate update) {
        if (update.getMessage() == null || update.getMessage().getText() == null) {
            return;
        }

        String text = update.getMessage().getText().trim();
        String telegramUserId = String.valueOf(update.getMessage().getChat().getId());

        if (text.equals("/start") || text.equals("/fichar")) {
            enviarPanelDeFichaje(telegramUserId, "📅 Selecciona una opción en el menú inferior:");
            return;
        }

        String recordType;

        if (text.equals("🟢 Fichar Entrada") || text.toLowerCase().contains("entrada")) {
            recordType = "ENTRADA";
        } else if (text.equals("🔴 Fichar Salida") || text.toLowerCase().contains("salida")) {
            recordType = "SALIDA";
        } else {
            enviarPanelDeFichaje(telegramUserId, "⚠️ Usa los botones del teclado inferior para fichar.");
            return;
        }

        TimeRecord record = new TimeRecord(telegramUserId, LocalDateTime.now(), recordType);
        timeRecordRepository.save(record);

        System.out.println("Fichaje registrado: " + recordType + " para el usuario " + telegramUserId);
        enviarMensajeConfirmacion(telegramUserId, "Fichaje de " + recordType + " registrado con éxito \u2705");
    }

    private void enviarMensajeConfirmacion(String chatId, String textoMensaje) {
        String url = "https://api.telegram.org/bot" + botToken + "/sendMessage";
        RestTemplate restTemplate = new RestTemplate();
        
        Map<String, String> payload = new HashMap<>();
        payload.put("chat_id", chatId);
        payload.put("text", textoMensaje);

        try {
            restTemplate.postForObject(url, payload, String.class);
        } catch (Exception e) {
            System.err.println("Error al enviar el mensaje de confirmación a Telegram: " + e.getMessage());
        }
    }

    private void enviarPanelDeFichaje(String chatId, String textoMensaje) {
        String url = "https://api.telegram.org/bot" + botToken + "/sendMessage";
        RestTemplate restTemplate = new RestTemplate();

        Map<String, Object> payload = new HashMap<>();
        payload.put("chat_id", chatId);
        payload.put("text", textoMensaje);

        Map<String, Object> replyKeyboardMarkup = new HashMap<>();
        Map<String, Object> botonEntrada = new HashMap<>();
        botonEntrada.put("text", "🟢 Fichar Entrada");
        
        Map<String, Object> botonSalida = new HashMap<>();
        botonSalida.put("text", "🔴 Fichar Salida");

        replyKeyboardMarkup.put("keyboard", List.of(List.of(botonEntrada, botonSalida)));
        replyKeyboardMarkup.put("resize_keyboard", true);
        replyKeyboardMarkup.put("one_time_keyboard", false);

        payload.put("reply_markup", replyKeyboardMarkup);

        try {
            restTemplate.postForObject(url, payload, String.class);
        } catch (Exception e) {
            System.err.println("Error al enviar el panel de fichaje a Telegram: " + e.getMessage());
        }
    }
}