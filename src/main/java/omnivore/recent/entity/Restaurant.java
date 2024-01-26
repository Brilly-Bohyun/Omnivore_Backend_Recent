package omnivore.recent.entity;

import org.springframework.data.annotation.Id;
import omnivore.recent.dto.RecentInfo;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "restaurant")
public class Restaurant {
    @Id
    private ObjectId id;

    private String photo;

    private String name;

    private String category;

    private String operation;

    @Field(name = "user_id")
    private Long userId;

    private List<Menu> menus;

    public RecentInfo toDto() {
        return RecentInfo.builder()
                .name(name)
                .photo(photo)
                .category(category)
                .operation(operation)
                .build();
    }
}
