package ru.practicum.user;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;

import java.io.IOException;
import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UserDtoJsonIT {

    private final JacksonTester<UserDto> json;

    @Test
    void testUserDtoSerialization() throws IOException {
        final UserDto dto = new UserDto();
        dto.setId(1L);
        dto.setFirstName("John");
        dto.setLastName("Doe");
        dto.setEmail("jdoe@google.com");
        dto.setState(UserState.ACTIVE.name());
        dto.setRegistrationDate(Instant.ofEpochMilli(1596978600000L));

        JsonContent<UserDto> result = json.write(dto);

        assertThat(result).isEqualToJson("user_dto.json", JSONCompareMode.STRICT);
    }
}
