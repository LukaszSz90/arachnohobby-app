package LukaszSz90.arachnohobbyapp.converter;

import LukaszSz90.arachnohobbyapp.domain.model.User;
import LukaszSz90.arachnohobbyapp.web.command.RegisterUserCommand;
import LukaszSz90.arachnohobbyapp.web.converter.UserConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserConverterTest {

    UserConverter cut;

    @BeforeEach
    void setUp() {
        cut = new UserConverter();
    }

    @Test
    void should_convert_valid_registration_request_to_user() {
        RegisterUserCommand request = new RegisterUserCommand();

                request.setUsername("test@test.pl");
                request.setPassword("test");

        User expected = User.builder()
                .username("test@test.pl")
                .password("test")
                .build();

        User result = cut.from(request);

        assertEquals(expected,result);


    }

    @Test
    void should_raise_exception_when_converting_from_null() {
        RegisterUserCommand request = null;
        assertThrows(IllegalArgumentException.class, () -> cut.from(request));
    }

}