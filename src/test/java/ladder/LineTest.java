package ladder;
import org.junit.*;

import ladder.domain.Line;

public class LineTest {
	Line line;
	@Before
	public void setUp() throws Exception {
		line = new Line(3);
		line.addPoint(false);
		line.addPoint(true);
	}
	
	@After
	public void tearDown() throws Exception {
		line = null;
	}
	
	/* 1. bar or no_bar 입력되었는지 테스트 */
	@Test
	public void addPointTest() {
		Assert.assertEquals(2, line.getPointsSize());
	}
	
	/* 3. 연속성 테스트 */
	@Test
	public void isContinousTest() {
		Assert.assertEquals(true, line.isContinous(2, true));
	}
	
	/* 4. 연속이면 다음에 false(noBar)인지 테스트 */
	@Test
	public void getBarTest() {
		Assert.assertEquals(false, line.setBar(2, true));
	}

}
