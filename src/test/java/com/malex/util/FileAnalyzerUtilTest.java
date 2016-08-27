package com.malex.util;

import org.junit.*;

/**
 * @author malex
 */
public class FileAnalyzerUtilTest {

    @BeforeClass
    public  static void initBeforeAllTestClass(){
        System.out.println("Before class");
    }

    @Before
    public void initBeforeEveryTestMethod(){
        System.out.println("  >>> before");
    }

    //сам тестовый метод
    @Test
    public void test_01(){
        System.out.println("test 1");
    }

    @Test
    public void test_02(){
        System.out.println("test 2");
    }

    @Test(expected = RuntimeException.class)
    public void test_03(){
        System.out.println("test 3");
        throw new RuntimeException();
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_04(){
        System.out.println("test 4");
        throw new IllegalArgumentException();
    }

    @After
    public void destroyAfterEveryTestMethod(){
        System.out.println("  >>> after");
    }

    @AfterClass
    public static void destroyAfterAllTestMethod(){
        System.out.println("After class");
    }

}
