package omnivore.recent.repository;

import omnivore.recent.entity.UserHistory;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserHistoryRepository extends MongoRepository<UserHistory, ObjectId> {
    List<UserHistory> findTop3ByUserIdOrderByTimestampDesc(ObjectId userId);
}
