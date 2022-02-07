package LukaszSz90.arachnohobbyapp.web.controller.user;

import LukaszSz90.arachnohobbyapp.domain.model.UserProfile;
import LukaszSz90.arachnohobbyapp.service.UserService;
import LukaszSz90.arachnohobbyapp.web.command.EditUserProfileCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/profile")
@Slf4j @RequiredArgsConstructor
public class EditUserProfileController {

    private final UserService userService;

    @GetMapping
    public String getProfilePage(Model model) {
        EditUserProfileCommand editUserCommand = displayCurrentUserProfile();
        model.addAttribute("userProfileCommand", editUserCommand);
        return "profile/edit";
    }

    private EditUserProfileCommand displayCurrentUserProfile() {
        UserProfile userProfile = userService.getCurrentUserProfile();
        return EditUserProfileCommand.builder()
                .nickName(userProfile.getNickName())
                .breedingPeriod(userProfile.getBreedingPeriod())
                .livingLocalisation(userProfile.getLivingLocalisation())
                .build();
    }

    @PostMapping
    public String editUserProfileProcess(@Valid EditUserProfileCommand editUserProfileCommand, BindingResult bindingResult) {
        log.debug("Download user data for editing: {}",editUserProfileCommand);

        if(bindingResult.hasErrors()) {
            log.debug("Incorrect user data to edit: {}", editUserProfileCommand);
            return "profile/edit";
        }

        try {
            boolean isEditSuccess = userService.editUserProfile(editUserProfileCommand);
            log.debug("User profile has been changed");

            return "redirect:/profile";
        }
        catch (RuntimeException re) {
            log.debug("Error while changing data");
            bindingResult.rejectValue(null,null, "Error occured!");
        }

        return "redirect:/profile";
    }
}
