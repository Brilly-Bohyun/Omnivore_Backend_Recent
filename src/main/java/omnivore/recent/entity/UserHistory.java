package omnivore.recent.entity;

import org.springframework.data.annotation.Id;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "user_history")
public class UserHistory {
    @Id
    private ObjectId id;

    private ObjectId userId;

    private ObjectId restaurant;

    private LocalDateTime history;

    public ObjectId getRestaurant() {
        return restaurant;
    }
}
