package zyr.learn.util;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;


/**
 * Created by zhouweitao on 16/9/10.
 */
public class CalcuateHamcrestTest {
    @Before
    public void begin() {
        System.out.println("@Before");
    }
    @Test
    public void testN1() {
        //第一个参数为待处理的值，第二个参数为Matchers表达式，所有满足才满足
        assertThat(12,greaterThan(11));
    }

    @Test
    public void testN2() {
        assertThat(21,allOf(greaterThan(12),lessThan(32)));
    }

    @Test
    public void testN3() {
        assertThat("abc.jpeg",endsWith(".jpeg"));
    }
}