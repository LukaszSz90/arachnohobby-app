package LukaszSz90.arachnohobbyapp.converter;

import LukaszSz90.arachnohobbyapp.domain.model.User;
import LukaszSz90.arachnohobbyapp.domain.model.UserDetails;
import LukaszSz90.arachnohobbyapp.web.command.RegisterUserCommand;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public User from(RegisterUserCommand registerUserCommand) {
        return User.builder()
                .username(registerUserCommand.getUsername())
                .password(registerUserCommand.getPassword())
                .build();
    }
}
