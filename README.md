# JUnitLearningNotes
`单元测试，stub&mock，在容器中测试（jetty，catcus），隔离数据库测试dbutil`
###JUnit4.x
* `@Before设置初始化方法，@After释放资源，@Test测试方法`
* 设置断言Assert,套件测试@RunWith、@Suite，忽略测试@Ignore，时间测试@Test(timeout=1000)，异常测试@Test(expected = ArithmeticException.class)
> 测试步骤：
  beforeClass() 方法首先执行，并且只执行一次。
  afterClass() 方法最后执行，并且只执行一次。
  before() 方法针对每一个测试用例执行，但是是在执行测试用例之前。
  after() 方法针对每一个测试用例执行，但是是在执行测试用例之后。
  在 before() 方法和 after() 方法之间，执行每一个测试用例。
  
###是