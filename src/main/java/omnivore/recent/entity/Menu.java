package omnivore.recent.entity;

import org.springframework.data.annotation.Id;
import org.bson.types.ObjectId;

public class Menu {
    @Id
    private ObjectId Id;

    private String name;

    private Integer price;

    private String description;

    private String photo;
}
