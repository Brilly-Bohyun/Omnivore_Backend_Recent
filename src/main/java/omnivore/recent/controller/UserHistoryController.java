package omnivore.recent.controller;

import lombok.RequiredArgsConstructor;
import omnivore.recent.dto.RecentInfo;
import omnivore.recent.service.UserHistoryService;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/recents")
public class UserHistoryController {
    private final UserHistoryService userHistoryService;

    @GetMapping
    public List<RecentInfo> showUserHistory (@RequestHeader(HttpHeaders.AUTHORIZATION) String jwt) {
        return userHistoryService.show(jwt);
    }
}
