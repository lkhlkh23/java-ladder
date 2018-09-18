package pracitice;

import org.junit.*;

import java.util.*;
import static org.junit.Assert.*;

public class ListTest {
    List<String> genericList;
    List nonGeneliclist;
    @Before
    public void setUp() throws Exception {
        genericList = new ArrayList<>();
        nonGeneliclist = new ArrayList();
    }

    @After
    public void tearDown() throws Exception {
        nonGeneliclist = null;
        genericList = null;
    }

    @Test
    public void immutableTest() {
        genericList.add("LEE");
        genericList.add("CHOI");
        genericList.add("PARK");
        genericList = Collections.unmodifiableList(genericList);

        /* java.lang.UnsupportedOperationException 발생! */
        /* 추가, 삭제 불가 */
        genericList.remove("LEE");
        genericList.add("LEE");

        assertEquals(genericList.get(3), "PARK");
    }

    @Test
    public void genericTest() {
        nonGeneliclist.add("LEE");
        nonGeneliclist.add("CHOI");
        nonGeneliclist.add("PARK");

        /* Generic을 사용하지 않으면 다음과 같이 형변환이 필요! */
        String name = (String)nonGeneliclist.get(0);
    }

}
