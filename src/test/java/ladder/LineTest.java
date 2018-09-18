package ladder;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LineTest {
    Line line;

    @Before
    public void setUp() throws Exception {
        line = new Line(3);
    }

    @After
    public void tearDown() throws Exception {
        line = null;
    }

    @Test
    public void isContinousTest() {
        line.addPoint(true);
        line.addPoint(true);
        line.addPoint(false);

        assertTrue(line.isContinousTest(1) == true);
        assertTrue(line.isContinousTest(2) == false);
    }
}