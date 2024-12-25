package giybat.uz.profile.controller;


import giybat.uz.exceptionHandler.AppBadException;
import giybat.uz.usernameHistory.dto.SmsConfirmDTO;
import giybat.uz.profile.dto.AuthDTO;
import giybat.uz.profile.dto.ProfileDTO;
import giybat.uz.profile.dto.RegistrationDTO;
import giybat.uz.profile.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/auth")
public class AuthController {


    @Autowired
    private AuthService authService;

    @PostMapping("/registration")
    public ResponseEntity<String> registration(@Valid @RequestBody RegistrationDTO dto) {
        return ResponseEntity.ok(authService.registration(dto));
    }

    @GetMapping("/registration/confirm/{id}")
    public ResponseEntity<String> registration(@PathVariable Integer id) {
        return ResponseEntity.ok(authService.registrationConfirm(id));
    }

    @PostMapping("/registration/confirm/code")
    public ResponseEntity<?> registrationConfirmCode(@Valid @RequestBody SmsConfirmDTO dto) {
        String s = authService.smsConfirm(dto, LocalDateTime.now());
        return ResponseEntity.ok().body(s);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody AuthDTO dto) {
        ProfileDTO login = authService.login(dto);
        return ResponseEntity.ok(login);
    }

    @ExceptionHandler({AppBadException.class, IllegalArgumentException.class})
    public ResponseEntity<?> handle(AppBadException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
