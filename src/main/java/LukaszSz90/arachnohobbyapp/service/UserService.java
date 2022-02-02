package LukaszSz90.arachnohobbyapp.service;

import LukaszSz90.arachnohobbyapp.converter.UserConverter;
import LukaszSz90.arachnohobbyapp.domain.model.User;
import LukaszSz90.arachnohobbyapp.domain.repository.UserRepository;
import LukaszSz90.arachnohobbyapp.exception.UserAlreadyExistException;
import LukaszSz90.arachnohobbyapp.web.command.RegisterUserCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional @Slf4j @RequiredArgsConstructor
public class UserService {

    private final UserConverter userConverter;
    private final UserRepository userRepository;

    public Long create(RegisterUserCommand registerUserCommand) {
        log.debug("User data to save: {}",registerUserCommand);

        User userToCreate = userConverter.from(registerUserCommand);
        
        if (userRepository.existByUsername(userToCreate.getUsername())) {
            throw new UserAlreadyExistException(String.format("User '%s' already exist",userToCreate.getUsername());
        }

        
    }
}
