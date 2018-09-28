package ladder.domain;
import org.junit.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.*;

public class LineTest {
	LadderLine line;
	@Before
	public void setUp() throws Exception {
		List<Boolean> points = new ArrayList<>();
		points.add(false);
		points.add(true);
		points.add(false);
		points.add(true);
		line = new LadderLine(3, null, points);
	}
	
	@After
	public void tearDown() throws Exception {

	}
	
	/* 3. 연속성 테스트 */
	@Test
	public void isContinousTest() {
		assertThat(line.isContinous(2, false)).isTrue();
	}
	
	/* 4. 연속이면 다음에 false(noBar)인지 테스트 */
	@Test
	public void getBarTest() {
		assertThat(line.setBar(4, true)).isFalse();
	}

	/* 포인터가 좌측으로 이동했는지 확인 */
	@Test
	public void isMoveLeftTest() {
		/*
		 *       a    b    c	d
		 *       |----|    |----|
		 * */
		assertThat(line.isMoveLeft(0)).isFalse();
		assertThat(line.isMoveLeft(1)).isTrue();
		assertThat(line.isMoveLeft(2)).isFalse();
		assertThat(line.isMoveLeft(3)).isTrue();
	}

	/* 포인터가 우측으로 이동했는지 확인 */
	@Test
	public void isMoveRightTest() {
		/*
		 *       a    b    c	d
		 *       |----|    |----|
		 * */
		assertThat(line.isMoveRight(0)).isTrue();
		assertThat(line.isMoveRight(1)).isFalse();
		assertThat(line.isMoveRight(2)).isTrue();
		assertThat(line.isMoveRight(3)).isFalse();
	}

}
