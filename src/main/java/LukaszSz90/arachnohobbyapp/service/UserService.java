package LukaszSz90.arachnohobbyapp.service;

import LukaszSz90.arachnohobbyapp.converter.UserConverter;
import LukaszSz90.arachnohobbyapp.domain.model.User;
import LukaszSz90.arachnohobbyapp.domain.model.UserProfile;
import LukaszSz90.arachnohobbyapp.domain.repository.UserRepository;
import LukaszSz90.arachnohobbyapp.exception.UserAlreadyExistException;
import LukaszSz90.arachnohobbyapp.web.command.EditUserProfileCommand;
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
        userToCreate.setUserProfile(UserProfile.builder()
                .user(userToCreate)
                .build());
        userRepository.save(userToCreate);
        log.debug("User is save: {}", userToCreate);
        return userToCreate.getId();
    }

    public UserProfile getCurrentUserProfile() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.getUserByUsername(username);
        return user.getUserProfile();
    }

    @Transactional
    public boolean editUserProfile(EditUserProfileCommand editUserProfileCommand) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User userToEdit = userRepository.getUserByUsername(username);

        log.debug("Download user to edit: {}", userToEdit);

        userConverter.from(editUserProfileCommand, userToEdit);
        log.debug("User profile has been changed: {}", userToEdit.getUserProfile());
        return true;
    }
}
