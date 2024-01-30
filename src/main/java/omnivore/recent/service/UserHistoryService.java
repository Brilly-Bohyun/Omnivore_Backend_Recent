package omnivore.recent.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import omnivore.recent.dto.RecentInfo;
import omnivore.recent.entity.Restaurant;
import omnivore.recent.entity.User;
import omnivore.recent.entity.UserHistory;
import omnivore.recent.repository.RestaurantRepository;
import omnivore.recent.repository.UserHistoryRepository;
import omnivore.recent.repository.UserRepository;
import org.bson.types.ObjectId;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Base64;
import java.util.List;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserHistoryService {
    private final UserRepository userRepository;
    private final UserHistoryRepository userHistoryRepository;
    private final RestaurantRepository restaurantRepository;

    public List<RecentInfo> show (String jwt) {
        String userEmail = getEmailFromPayload(parseJwtPayload(jwt));
        User user = getUserByEmail(userEmail);
        List<UserHistory> userHistories = getUserHistories(user.getId());
        return userHistories.stream().map(userHistory -> getRestaurant(userHistory.getRestaurant()).toDto()).toList();
    }

    private User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("해당 사용자를 찾을 수 없습니다."));
    }

    private List<UserHistory> getUserHistories(ObjectId userId) {
        return userHistoryRepository.findTop3ByUserIdOrderByTimestampDesc(userId);
    }

    private Restaurant getRestaurant(ObjectId restaurantId) {
        return restaurantRepository.findById(restaurantId).orElseThrow(() -> new IllegalArgumentException("해당 사용자를 찾을 수 없습니다."));
    }

    private String parseJwtPayload(String jwt) {
        String base64Payload = jwt.split("\\.")[1];
        byte[] decodedBytes = Base64.getDecoder().decode(base64Payload);
        return new String(decodedBytes);
    }

    private String getEmailFromPayload(String payloadString) {
        JSONObject payloadJson = new JSONObject(payloadString);
        return payloadJson.getString("email");
    }
}
