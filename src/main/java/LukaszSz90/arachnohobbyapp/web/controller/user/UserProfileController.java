package LukaszSz90.arachnohobbyapp.web.controller.user;

import LukaszSz90.arachnohobbyapp.domain.model.UserDetails;
import LukaszSz90.arachnohobbyapp.service.UserService;
import LukaszSz90.arachnohobbyapp.web.command.EditUserCommand;
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
@RequestMapping("/profile/edit")
@Slf4j @RequiredArgsConstructor
public class UserProfileController {

    private final UserService userService;

    @GetMapping
    public String geEditProfilePage(Model model) {
        EditUserCommand editUserCommand = showCurrentDetails();

        model.addAttribute("editUserCommand", editUserCommand);
        return "profile/edit";
    }

    private EditUserCommand showCurrentDetails() {
        UserDetails userDetails = userService.getCurrentUserDetails();

        return EditUserCommand.builder()
                .nickName(userDetails.getNickName())
                .breedingPeriod(userDetails.getBreedingPeriod())
                .livingLocalization(userDetails.getLivingLocalization())
                .pictureNameUrl(userDetails.getPictureNameUrl())
                .build();
    }

    @PostMapping
    public String editUserProfile(@Valid EditUserCommand editUserCommand, BindingResult bindingResult) {
        log.debug("Download user data to edit: {}", editUserCommand);

        if(bindingResult.hasErrors()) {
            log.debug("Incorrect data to edit: {}", editUserCommand);
            return "profile/edit";
        }
        try {
            boolean isEditSuccess = userService.editUserDetails(editUserCommand);
            log.debug("User data has been changed: {}", isEditSuccess);
            return "redirect:/profile/view";
        }
        catch (RuntimeException re) {
            log.debug("Error while changing data");
            bindingResult.rejectValue(null, null, "Error occured");
        }

        return "redirect:/profile/vew";
    }
}
