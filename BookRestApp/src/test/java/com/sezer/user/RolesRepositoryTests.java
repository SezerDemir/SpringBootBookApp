package com.sezer.user;

import com.sezer.user.api.RoleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class RolesRepositoryTests {

    @Autowired
    private RoleRepository repo;


    @Test
    public void testCreateRoles() {
        Role admin = Role.builder().name("ROLE_ADMIN").build();
        Role client = Role.builder().name("ROLE_CLIENT").build();

        assertThat(repo.saveAll(List.of(admin, client))).isNotNull();
    }


}
