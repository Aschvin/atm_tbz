package ch.nyp.noa;

import ch.nyp.noa.webContext.domain.user.User;
import ch.nyp.noa.webContext.domain.user.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class NoaApplicationTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findUserByUsername() {
        User given = new User();
        given.setUsername("john.doe");
        given.setPassword("12345");

        testEntityManager.persist(given);
        testEntityManager.flush();

        User found = userRepository.findByUsername("john.doe").get();

        assertThat(found.getUsername()).isEqualTo(given.getUsername());
    }

}
