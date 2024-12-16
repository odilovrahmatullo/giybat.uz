package giybat.uz.UsernameHistory.repository;

import giybat.uz.UsernameHistory.entiy.SmsTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmsTokenRepository extends JpaRepository<SmsTokenEntity,Integer> {
}
