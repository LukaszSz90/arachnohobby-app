package LukaszSz90.arachnohobbyapp.web.controller;

import LukaszSz90.arachnohobbyapp.exception.UserAlreadyExistException;
import LukaszSz90.arachnohobbyapp.service.UserService;
import LukaszSz90.arachnohobbyapp.web.command.RegisterUserCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller @Slf4j @RequiredArgsConstructor
@RequestMapping("/register")
public class RegistrationController {

    private final UserService userService;

    @GetMapping
    public String getRegister(Model model) {
        model.addAttribute(new RegisterUserCommand());
        return "register/form";
    }

    @PostMapping
    public String processRegister(@Valid RegisterUserCommand registerUserCommand, BindingResult bindingResult) {

        log.debug("Data to create user: {}", registerUserCommand);

        if (bindingResult.hasErrors()) {
            log.debug("Incorrect data: {}", bindingResult.getAllErrors());
            return "register/form";
        }

        try {
            Long id = userService.create(registerUserCommand);
            log.debug("Created user with id = {}", id);
            return "redirect:/login";
        }
        catch (UserAlreadyExistException uaee) {
            bindingResult.rejectValue("username",
                    null, "User with entered 'username' already exists");
            return "register/form";
        }
        catch (RuntimeException re) {
            bindingResult.rejectValue(null, null, "Error occurred!");
            return "register/form";
        }
    }


}
