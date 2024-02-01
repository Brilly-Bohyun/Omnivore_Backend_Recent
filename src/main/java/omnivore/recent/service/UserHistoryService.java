package omnivore.recent.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import omnivore.recent.dto.RecentInfo;
import omnivore.recent.entity.Restaurant;
import omnivore.recent.entity.User;
import omnivore.recent.entity.RecentLog;
import omnivore.recent.repository.RestaurantRepository;
import omnivore.recent.repository.UserHistoryRepository;
import omnivore.recent.repository.UserRepository;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Base64;
import java.util.Comparator;
import java.util.List;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserHistoryService {
    private final UserHistoryRepository userHistoryRepository;
    private final RestaurantRepository restaurantRepository;
    private final TranslateService translateService;
    private static final String SOURCE_LANGUAGE = "ko";


    public List<RecentInfo> show (String jwt, String targetLang) {
        String userEmail = getEmailFromPayload(parseJwtPayload(jwt));
        List<RecentLog> userHistories = getUserHistories(userEmail);
        return userHistories.stream()
                .sorted(Comparator.comparing(RecentLog::getTimestamp).reversed())
                .limit(3)
                .map(recentLog -> getRestaurant(recentLog.getRestaurantId()))
                .map(restaurant -> RecentInfo.builder().id(restaurant.getId())
                        .category(getTranslation(restaurant.getCategory(), targetLang))
                        .name(getTranslation(restaurant.getName(), targetLang))
                        .photo(restaurant.getPhoto()).build())
                .toList();
    }

    private String getTranslation(String originText, String targetLang) {
        return translateService.translate(originText, SOURCE_LANGUAGE, targetLang);
    }

    private List<RecentLog> getUserHistories(String email) {
        return userHistoryRepository.findAllByEmail(email);
    }

    private Restaurant getRestaurant(String restaurantId) {
        return restaurantRepository.findById(restaurantId).orElseThrow(() -> new IllegalArgumentException("해당 레스토랑을 찾을 수 없습니다."));
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
