package giybat.uz.UsernameHistory.controller;


import giybat.uz.ExceptionHandler.AppBadException;
import giybat.uz.UsernameHistory.service.SmsHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sms-history")
public class SmsHistoryController {
    @Autowired
    SmsHistoryService smsHistoryService;

//    @GetMapping("/phone/{number}")
//    public ResponseEntity<?> getEmailHistoryService(@RequestParam(value = "number") String phone) {
//        List<SmsHistoryEntity> entity =  smsHistoryService.;
//        return ResponseEntity.ok(entity);
//    }

//    @GetMapping("/date/{date}")
//    public ResponseEntity<?> getEmailHistoryService(@RequestParam LocalDate date) {
//        return ResponseEntity.ok(smsHistoryService.getAllGiven(date));
//    }

    @ExceptionHandler(AppBadException.class)
    public ResponseEntity<?> handle(AppBadException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
