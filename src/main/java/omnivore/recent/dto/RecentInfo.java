package omnivore.recent.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class RecentInfo {
    private String id;
    private String name;
    private String category;
    private String photo;
}
