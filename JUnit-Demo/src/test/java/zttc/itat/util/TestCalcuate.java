package zttc.itat.util;

//把Assert中的static方法全部导入到类中
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestCalcuate {
	Calcuate cal;
	
	//执行任意一个方法之前都会仔细setUp方法
	@Before
	public void setUp() {
		cal = new Calcuate();
	}
	
	//加了@Test表示该方法是一个单元测试方法
	@Test
	public void testAdd() {
		int rel = cal.add(12,22);
		/*
		 * 以下就是一个简单的断言的编写
		 * 第一个参数是如果出错给出的提示信息
		 * 第二个参数表示方法执行完成之后预期的一个值
		 * 第三个参数表示实际值
		 */
		//Assert.assertEquals("加法有问题", rel, 34);
		/**
		 * 当进行了静态导入之后，import static org.junit.Assert.*;
		 * Assert中的所有静态方法就不用在添加类名来调用
		 * 这样可以有效的兼容junit3
		 */
		assertEquals("加法有问题", rel, 34);
	}
	
	@Test
	public void testMinus() {
		int rel = cal.minus(20, 10);
		assertEquals("减法有问题",rel,10);
	}
	
	@Test
	public void testDivide() {
		int rel = cal.divide(20, 10);
		assertEquals(rel,2);
	}
	
	//表示这个测试类应该抛出ArithmeticException,如果不抛出就报错
	@Test(expected=ArithmeticException.class)
	public void testDivideException() {
		int rel = cal.divide(20,0);
	}
	
	//表示这个方法应该在300毫秒内执行结束才算是正确
	@Test(timeout=300)
	public void testTime() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("abc");
	}
	
	@Test
	public void testMul() {
		int rel = cal.mul(10, 5);
		assertEquals(rel, 50);
	}
	
	@Test
	public void testHamcrest() {
		//首先需要静态导入import static org.hamcrest.Matchers.*;
		//判断50是否大于20并且小于60，具体的hamcrest的比较参数可以在文档中查询
		//assertThat(50,allOf(greaterThan(20),lessThan(60)));
		//判断某个字符串是否以另一个字符串结尾
		assertThat("abc.txt",endsWith("txt"));
	}
}
