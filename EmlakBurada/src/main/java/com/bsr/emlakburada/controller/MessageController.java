package com.bsr.emlakburada.controller;

import com.bsr.emlakburada.dto.MessageRequestDTO;
import com.bsr.emlakburada.dto.response.MessageResponseDTO;
import com.bsr.emlakburada.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping(value = "/messages")
    public ResponseEntity<List<MessageResponseDTO>> getAllMessages() {
        return new ResponseEntity<>(messageService.getAllMessages(), HttpStatus.OK);
    }

    @GetMapping(value = "message/{messageId}")
    public ResponseEntity<MessageResponseDTO> getMessageById(@PathVariable long messageId) {
        return new ResponseEntity<>(messageService.getMessageById(messageId), HttpStatus.OK);
    }

    @PostMapping(value = "/message")
    public ResponseEntity<?> saveMessage(@RequestBody MessageRequestDTO messageRequestDTO) {
        messageService.saveMessage(messageRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
