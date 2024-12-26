package giybat.uz.post.repository;

import giybat.uz.post.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<PostEntity,Integer> {

    Optional<PostEntity> findByIdAndVisibleTrue(Integer id);
}
