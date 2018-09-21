package ladder.domain;
import org.junit.*;
import static org.assertj.core.api.Assertions.assertThat;
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

	}
	
	/* 1. bar or no_bar 입력되었는지 테스트 */
	@Test
	public void addPointTest() {
		assertThat(line.getPointsSize()).isEqualTo(2);
	}
	
	/* 3. 연속성 테스트 */
	@Test
	public void isContinousTest() {
		assertThat(line.isContinous(2, true)).isEqualTo(true);
	}
	
	/* 4. 연속이면 다음에 false(noBar)인지 테스트 */
	@Test
	public void getBarTest() {
		assertThat(line.setBar(2, true)).isEqualTo(false);
	}

}
