package ladder.domain;
import org.junit.*;
import static org.assertj.core.api.Assertions.assertThat;
import ladder.domain.Line;

import java.util.*;

public class LineTest {
	Line line;
	@Before
	public void setUp() throws Exception {
		List<Boolean> points = new ArrayList<>();
		points.add(false);
		points.add(true);
		points.add(false);
		points.add(true);
		line = new Line(3, points);
	}
	
	@After
	public void tearDown() throws Exception {

	}
	
	/* 1. bar or no_bar 입력되었는지 테스트 */
	@Test
	public void addPointTest() {
		line.addPoint(false);
		assertThat(line.getPointsSize()).isEqualTo(5);
	}
	
	/* 3. 연속성 테스트 */
	@Test
	public void isContinousTest() {
		assertThat(line.isContinous(2, false)).isEqualTo(true);
	}
	
	/* 4. 연속이면 다음에 false(noBar)인지 테스트 */
	@Test
	public void getBarTest() {
		assertThat(line.setBar(4, true)).isEqualTo(false);
	}

}
