package com.google.controller.ui;

import com.google.service.dto.DriveData;
import com.google.exception.DriveAccessDeniedException;
import com.google.service.enums.SessionKey;
import com.google.service.GoogleDriveService;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;

@Controller
public class DriveController {

    private final GoogleDriveService googleDriveService;

    public DriveController(GoogleDriveService googleDriveService, ClientRegistrationRepository clientRegistrationRepository, RestTemplate restTemplate) {
        this.googleDriveService = googleDriveService;
    }

    @RequestMapping("/agenda")
    public String getDriveData(HttpSession session, Model model) {
        String accessToken = session.getAttribute(SessionKey.GOOGLE_OAUTH_TOKEN.toString()) == null
                ? "" : session.getAttribute(SessionKey.GOOGLE_OAUTH_TOKEN.toString()).toString();

        if (accessToken == null || accessToken.isBlank()) {
            throw new DriveAccessDeniedException("Invalid token");
        }
        DriveData events = googleDriveService.getDriveData(accessToken);
        model.addAttribute("events", events);
        return "agenda";
    }
}
