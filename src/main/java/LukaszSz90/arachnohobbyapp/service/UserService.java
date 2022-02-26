package LukaszSz90.arachnohobbyapp.service;

import LukaszSz90.arachnohobbyapp.converter.UserConverter;
import LukaszSz90.arachnohobbyapp.data.user.UserSummary;
import LukaszSz90.arachnohobbyapp.domain.model.User;
import LukaszSz90.arachnohobbyapp.domain.model.UserDetails;
import LukaszSz90.arachnohobbyapp.domain.repository.UserRepository;
import LukaszSz90.arachnohobbyapp.exception.UserAlreadyExistException;
import LukaszSz90.arachnohobbyapp.web.command.EditUserCommand;
import LukaszSz90.arachnohobbyapp.web.command.RegisterUserCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Set;

@Service
@Slf4j @RequiredArgsConstructor
public class UserService {

    private final UserConverter userConverter;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Long create(RegisterUserCommand registerUserCommand) {
        log.debug("User data to save: {}",registerUserCommand);

        User userToCreate = userConverter.from(registerUserCommand);
        log.debug("User object obtained to save: {}", userToCreate);

        if (userRepository.existsByUsername(userToCreate.getUsername())) {
            log.debug("Attempting to register on an existing user");
            throw new UserAlreadyExistException(String.format("User '%s' already exist",userToCreate.getUsername()));
        }

        userToCreate.setActive(Boolean.TRUE);
        userToCreate.setRoles(Set.of("ROLE_USER"));
        userToCreate.setPassword(passwordEncoder.encode(userToCreate.getPassword()));
        userToCreate.setUserDetails(UserDetails.builder()
                .user(userToCreate)
                .build());
        userRepository.save(userToCreate);
        log.debug("User is save: {}", userToCreate);
        return userToCreate.getId();
    }

    @Transactional
    public UserDetails getCurrentUserSummary() {
        log.debug("Downloading the data of the currently logged user");
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        User user = userRepository.getAuthenticatedUser(username);

        log.debug("Summary of user data: {}", user.getUserDetails());

        return user.getUserDetails();
    }

    @Transactional
    public boolean editUserDetails(EditUserCommand editUserCommand) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User userToEdit = userRepository.getAuthenticatedUser(username);

        log.debug("Download user to edit: {}", username);

        userConverter.fromDetails(editUserCommand, userToEdit);

        log.debug("User data has been changed: {}", userToEdit.getUserDetails());
        return true;
    }
}
