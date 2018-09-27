package ladder.domain;

import org.junit.After;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RewardTest {
    Reward reward;
    @Before
    public void setUp() throws Exception {
        /*
         *       a    b   c
         *       |----|   |
         * */
        List<Boolean> line = new ArrayList<>();
        ladderLine.add(false);
        ladderLine.add(true);
        ladderLine.add(false);
        reward = new Reward(ladderLine);
    }

    @After
    public void tearDown() throws Exception {

    }
}
