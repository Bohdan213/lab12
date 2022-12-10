package task2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProccesTest {
    @Test
    public void testHandler() {
        assertTrue(Procces.getResult(130));
    }
}