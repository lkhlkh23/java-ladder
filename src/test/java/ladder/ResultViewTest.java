package ladder;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ResultViewTest {

    private Ladder ladder;
    private ResultView rv;
    private String[] names = {"LEE", "CHOI", "OH", "YOUNG", "Z"};
    @Before
    public void setUp() throws Exception {
        ladder = new Ladder(names.length, 1);
        rv = new ResultView();
    }

    @After
    public void tearDown() throws Exception {
        ladder = null;
        rv = null;
    }

    @Test
    public void printLineTest() {
        Line line = new Line(names.length);
        line.addPoint(false);
        line.addPoint(true);
        line.addPoint(false);
        assertEquals(rv.printLineTest(line), "     |-----|     |");
    }

    @Test
    public void drawBarTest() {
        assertEquals(rv.drawBarTest(false), "     ");
        assertEquals(rv.drawBarTest(true), "-----");
    }

    @Test
    public void nameFormatTest() {
        assertEquals(rv.nameFormatTest("a"), "     a");
    }

}