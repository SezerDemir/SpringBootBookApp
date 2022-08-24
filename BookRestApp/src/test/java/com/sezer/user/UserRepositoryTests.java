package com.sezer.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTests {

    @Autowired UserRepository repo;

    @Test
    public void testCreateUser() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = "sezerD2";
        String encodedPassword = encoder.encode(password);

        User user = User.builder().email("sezer_d2@outlook.com").password(encodedPassword).build();
        assertThat(repo.save(user)).isNotNull();
    }

    @Test
    public void testAssignRoleToUser() {
        Integer userId_1 = 5;
        Integer roleId_1 = 2;

        User user = repo.findById(userId_1).get();
        user.addRole(Role.builder().id(roleId_1).build());
        assertThat(repo.save(user)).isNotNull();


    }
}
