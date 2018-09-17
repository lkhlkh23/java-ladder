package ladder;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LadderTest {
    Ladder ladder;

    @Before
    public void setUp() throws Exception {
        ladder = new Ladder(3, 4);
    }

    @After
    public void tearDown() throws Exception {
        ladder = null;
    }

    @Test
    public void getStepTest() {
        assertEquals(ladder.getStep(0, false), '|');
        assertEquals(ladder.getStep(1, true), '-');
        assertEquals(ladder.getStep(1, false), ' ');
    }
}