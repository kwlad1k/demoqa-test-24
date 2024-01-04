package guru.qa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SimpleJUnitTest {

    @BeforeEach
    void beforeEach() {
        System.out.println("### @BeforeEach");
    }

    @Test
    void firstTest() {
        Assertions.assertTrue(3>2);

    }

}
