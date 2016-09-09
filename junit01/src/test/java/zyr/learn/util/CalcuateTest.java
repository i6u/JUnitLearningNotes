package zyr.learn.util;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by zhouweitao on 16/9/10.
 */
public class CalcuateTest {
    private Calcuate calcuate;
    @Before
    public void setUp(){
        calcuate = new Calcuate();
    }

    @Test
    public void AddTest(){
        int rel = calcuate.add(1, 12);
        assertEquals("加法有问题！",rel,11);    //静态导入Assert中的所有静态方法，就不用再使用类名调用
    }

    @Test
    public void MinusTest(){
        int rel = calcuate.minus(12, 32);
        assertEquals("减法有问题！",rel,31);    //静态导入Assert中的所有静态方法，就不用再使用类名调用
    }

    @After
    public void teamDown(){

    }
}
