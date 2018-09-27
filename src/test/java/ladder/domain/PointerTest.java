package ladder.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PointerTest {
    Pointer pointer1;
    Pointer pointer2;
    Pointer pointer3;

    @Before
    public void setUp() throws Exception {
        pointer1 = new Pointer(0);
        pointer2 = new Pointer(1);
        pointer3 = new Pointer(2);
    }

    @After
    public void tearDown() throws Exception {

    }
    /* 포인터가 좌측으로 이동했는지 확인 */
    @Test
    public void isMoveLeftTest() {
        /*
        *       a    b   c
        *       |----|   |
        * */
        List<Boolean> ladderLine = new ArrayList<>();
        ladderLine.add(false);
        ladderLine.add(true);
        ladderLine.add(false);
        assertThat(pointer1.isMoveLeft(ladderLine)).isEqualTo(false);
        assertThat(pointer2.isMoveLeft(ladderLine)).isEqualTo(true);
        assertThat(pointer3.isMoveLeft(ladderLine)).isEqualTo(false);
    }

    /* 포인터가 우측으로 이동했는지 확인 */
    @Test
    public void isMoveRightTest() {
        /*
         *       a    b   c
         *       |----|   |
         * */
        List<Boolean> ladderLine = new ArrayList<>();
        ladderLine.add(false);
        ladderLine.add(true);
        ladderLine.add(false);
        assertThat(pointer1.isMoveRight(ladderLine)).isEqualTo(true);
        assertThat(pointer2.isMoveRight(ladderLine)).isEqualTo(false);
        assertThat(pointer3.isMoveRight(ladderLine)).isEqualTo(false);
    }
}
