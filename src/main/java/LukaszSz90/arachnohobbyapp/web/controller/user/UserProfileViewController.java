package LukaszSz90.arachnohobbyapp.web.controller.user;

import LukaszSz90.arachnohobbyapp.domain.model.User;
import LukaszSz90.arachnohobbyapp.domain.model.UserDetails;
import LukaszSz90.arachnohobbyapp.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/profile/view")
public class UserProfileViewController {

    private final UserService userService;

    @GetMapping
    private String prepareUserProfileView(Model model) {
        User user = userService.getLoggedUser();
        UserDetails details = user.getUserDetails();

        model.addAttribute("username",user.getUsername());
        model.addAttribute("nickName", details.getNickName());
        model.addAttribute("pictureNameUrl", details.getPictureNameUrl());
        model.addAttribute("breedingPeriod",details.getBreedingPeriod());
        model.addAttribute("livingLocalization", details.getLivingLocalization());

        return "profile/view";
    }
}
