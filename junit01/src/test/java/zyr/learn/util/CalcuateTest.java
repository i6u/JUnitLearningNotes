package zyr.learn.util;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by zhouweitao on 16/9/10.
 */
public class CalcuateTest {
    private static Calcuate calcuate;
    @BeforeClass
    public static void setUp(){
        calcuate = new Calcuate();
    }

    @Test
    public void AddTest(){
        int rel = calcuate.add(1, 12);
        assertEquals("加法 error！",rel,13);    //静态导入Assert中的所有静态方法，就不用再使用类名调用
    }

    @Test
    public void MinusTest(){
        int rel = calcuate.minus(12, 32);
        assertEquals("减法 error！",rel,-20);    //静态导入Assert中的所有静态方法，就不用再使用类名调用
    }

    @Test
    public void MulTest(){
        int rel = calcuate.mul(12, 32);
        assertEquals("乘法 error",rel,384);
    }

    @Test
    public void DivideTest(){
        int rel = calcuate.divide(12, 1);
        assertEquals("除法 error",rel,12);
    }

    @Test(expected = ArithmeticException.class)//如果不抛出ArithmeticException异常，方法就有错误
    public void DivideTest1(){
        int rel = calcuate.divide(12, 0);
    }

    @Test(timeout = 300)    //时间测试，300毫秒内正常
    public void timeTesi() throws InterruptedException {
        Thread.sleep(1213);
    }ArithmeticException

}
