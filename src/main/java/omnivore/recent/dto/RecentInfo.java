package omnivore.recent.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RecentInfo {
    private String name;
    private String category;
    private String operation;
    private String photo;
}
