package omnivore.recent.repository;

import omnivore.recent.entity.RecentLog;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableScan
@Repository
public interface UserHistoryRepository extends CrudRepository<RecentLog, String> {
    List<RecentLog> findAllByUserId(String userId);
}
