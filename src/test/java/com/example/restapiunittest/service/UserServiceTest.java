package com.example.restapiunittest.service;

import com.example.restapiunittest.entity.User;
import com.example.restapiunittest.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserServiceTest {
        @Autowired
        private UserRepository repo;

        @Test
        public void testAddSuccess() {
            User newUser = new User().email("test@gmail.com")
                    .firstName("John")
                    .lastName("Doe")
                    .password("doe123");

            User persistedUser = repo.save(newUser);

            assertThat(persistedUser).isNotNull();
            assertThat(persistedUser.getId()).isGreaterThan(0);
        }
}