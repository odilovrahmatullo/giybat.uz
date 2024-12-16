package giybat.uz.UsernameHistory.controller;


import giybat.uz.ExceptionHandler.AppBadException;
import giybat.uz.UsernameHistory.entiy.EmailHistoryEntity;
import giybat.uz.UsernameHistory.service.EmailHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/email-history")
public class EmailHistoryController {
    @Autowired
    EmailHistoryService emailHistoryService;

    @GetMapping("/email/{email}")
    public ResponseEntity<?> getEmailHistoryService(@RequestParam String email) {
        List<EmailHistoryEntity> entity =  emailHistoryService.getByEmail(email);
        return ResponseEntity.ok(entity);
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<?> getEmailHistoryService(@RequestParam LocalDate date) {
        return ResponseEntity.ok(emailHistoryService.getAllGiven(date));
    }

    @ExceptionHandler(AppBadException.class)
    public ResponseEntity<?> handle(AppBadException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
