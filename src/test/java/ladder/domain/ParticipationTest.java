package ladder.domain;

import org.junit.*;
import static org.assertj.core.api.Assertions.assertThat;


public class ParticipationTest {
	Participation participation1;
	Participation participation2;
	
	@Before
	public void setUp() throws Exception {
		participation1 = new Participation("LEE KI");
		participation2 = new Participation("LEE");
	}
	
	@After
	public void tearDown() throws Exception {

	}
	
	/* 1. 이름이 몇 글자 출력되는지 테스트 */
	@Test
	public void getNameSizeTest() {
		Assert.assertEquals(participation1.getNameSize(), 6);
		Assert.assertEquals(participation2.getNameSize(), 3);
		assertThat(participation1.getNameSize()).isEqualTo(6);
		assertThat(participation2.getNameSize()).isEqualTo(3);
	}
	
	/* 2. 이름이 5글자를 넘겼는지 테스트 */
	@Test
	public void isOverSizeTest() {
		assertThat(participation1.isOverSize()).isEqualTo(true);
		assertThat(participation2.isOverSize()).isEqualTo(false);
	}
	
	/* 3. 이름 5글자 넘기면 5글자로 잘라지는지 테스트 */
	@Test
	public void splitNameTest() {
		//Assert.assertEquals(participation1.subStringName(), "LEE K");
	}
	
	/* 이름이 5글자 형식에 맞춰지는지 테스트 */
	@Test
	public void stringFormatTest() {
		assertThat(participation2.stringFormat()).isEqualTo("   LEE");
	}
}
