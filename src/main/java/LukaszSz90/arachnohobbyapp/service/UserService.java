package LukaszSz90.arachnohobbyapp.service;

import LukaszSz90.arachnohobbyapp.web.command.RegisterUserCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional @Slf4j @RequiredArgsConstructor
public class UserService {

    public Long create(RegisterUserCommand registerUserCommand) {
        return null;
    }
}
