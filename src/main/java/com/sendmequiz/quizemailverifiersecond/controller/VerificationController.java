package com.sendmequiz.quizemailverifiersecond.controller;

import com.sendmequiz.quizemailverifiersecond.dto.VerificationRequestDTO;
import com.sendmequiz.quizemailverifiersecond.service.VerificationMailSender;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/sendmail")
@AllArgsConstructor
@Slf4j
public class VerificationController {

    private final VerificationMailSender sender;

    @PostMapping
    public ResponseEntity<String> sendMail(@RequestBody VerificationRequestDTO requestDTO) {
        log.info("Received request {}", requestDTO);
        sender.send(
            requestDTO.getUsername(),
            requestDTO.getValidationLink(),
            requestDTO.getEmail()
        );
        return ResponseEntity.ok("Sent successfully");
    }
}
