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
  
###扩展测试框架Hamcrest
[方法简述](http://topmanopensource.iteye.com/blog/1971242)
* 核心
    - anything - 总是匹配,如果你不关心测试下的对象是什么是有用的
    - describedAs - 添加一个定制的失败表述装饰器
    - is - 改进可读性装饰器 - 见下 “Sugar”
* 逻辑
    - allOf - 如果所有匹配器都匹配才匹配, short circuits (很难懂的一个词,意译是短路,感觉不对,就没有翻译)(像 Java &&)
    - anyOf - 如果任何匹配器匹配就匹配, short circuits (像 Java ||)
    - not - 如果包装的匹配器不匹配器时匹配,反之亦然
* 对象
    - equalTo - 测试对象相等使用Object.equals方法
    - hasToString - 测试Object.toString方法
    - instanceOf, isCompatibleType - 测试类型
    - notNullValue, nullValue - 测试null
    - sameInstance - 测试对象实例
* Beans
    - hasProperty - 测试JavaBeans属性
* 集合
    - array - 测试一个数组元素test an array’s elements against an array of matchers
    - hasEntry, hasKey, hasValue - 测试一个Map包含一个实体,键或者值
    - hasItem, hasItems - 测试一个集合包含一个元素
    - hasItemInArray - 测试一个数组包含一个元素
* 数字
    - closeTo - 测试浮点值接近给定的值
    - greaterThan, greaterThanOrEqualTo, lessThan, lessThanOrEqualTo - 测试次序
* 文本
    - equalToIgnoringCase - 测试字符串相等忽略大小写
    - equalToIgnoringWhiteSpace - 测试字符串忽略空白
    - containsString, endsWith, startsWith - 测试字符串匹配
 
