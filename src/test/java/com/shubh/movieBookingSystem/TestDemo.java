package com.shubh.movieBookingSystem;

import org.junit.jupiter.api.*;

/**
 * This class is used for the demo of Unit Testing
 * JUnit Framework functionality
 */
public class TestDemo {

    /**
     * Before running any test if we want certain setup to be executed
     */
    @BeforeEach
    public void beforeEachTestMethod(){
        System.out.println("Before each test");
    }

    /**
     * Whenever we use @Test with any method, it becomes executable and test method
     */
    @Test
    public void myFirstTest(){
        System.out.println("Inside first test");
    }

    @Test
    public void mySecondTest(){
        System.out.println("Inside second test");
    }

    /**
     * I want to execute something after every test is executed
     */
    @AfterEach
    public void afterEachTestMethod(){
        System.out.println("Before each test");
    }

    /**
     * I want to execute something only once, in the beginning
     */
    @BeforeAll
    public static void beforeBeginning(){
        System.out.println("In the very beginning");
    }

    /**
     * I want to execute something only once, in the beginning
     */
    @AfterAll
    public static void afterBeginning(){
        System.out.println("In the very end");
    }
}
