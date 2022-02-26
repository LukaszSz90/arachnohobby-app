package LukaszSz90.arachnohobbyapp.converter;

import LukaszSz90.arachnohobbyapp.data.user.UserSummary;
import LukaszSz90.arachnohobbyapp.domain.model.User;
import LukaszSz90.arachnohobbyapp.domain.model.UserDetails;
import LukaszSz90.arachnohobbyapp.web.command.EditUserCommand;
import LukaszSz90.arachnohobbyapp.web.command.RegisterUserCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserConverter {
    public User from(RegisterUserCommand registerUserCommand) {
        return User.builder()
                .username(registerUserCommand.getUsername())
                .password(registerUserCommand.getPassword())
                .build();
    }

    public UserDetails fromDetails(EditUserCommand editUserCommand, User userToEdit){
        log.debug("Data to edit: {}", editUserCommand);
        UserDetails userDetails = userToEdit.getUserDetails();
        userDetails.setNickName(editUserCommand.getNickName());
        userDetails.setLivingLocalisation(editUserCommand.getLivingLocalisation());
        userDetails.setBreedingPeriod(editUserCommand.getBreedingPeriod());
        userDetails.setPictureNameUrl(editUserCommand.getPictureNameUrl());

        return userDetails;

    }
}
