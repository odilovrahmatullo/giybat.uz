package giybat.uz.UsernameHistory.service;


import giybat.uz.UsernameHistory.entiy.SmsHistoryEntity;
import giybat.uz.UsernameHistory.repository.SmsHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SmsHistoryService {
    @Autowired
    private SmsHistoryRepository smsHistoryRepository;

    public void smsHistory(String phone, Integer message, LocalDateTime createdDate){
        SmsHistoryEntity smsHistory = new SmsHistoryEntity();
        smsHistory.setPhone(phone);
        smsHistory.setCode(message);
        smsHistory.setCreatedData(createdDate);
        smsHistoryRepository.save(smsHistory);
    }


}
