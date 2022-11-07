import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class TestExamplesTest {
    TestExamples t;
    @BeforeAll
    static void beforeAllInIt()
    {
        System.out.println("Before Test should work");
    }
    @BeforeEach
    void intIt()
    {
        t=new TestExamples();
    }
    @AfterEach
     void clean()
    {
        System.out.println("Cleaning.........");
    }
    @AfterAll
    static void after()
    {
        System.out.println("After all it should work");
    }
    @Test
    void sum()
    {
        assertEquals(4,t.sum(2,2),"Should return sum");
    }
    @Test
    void conCat()
    {
        assertEquals(6,t.multiply(2,3),"Should return multiplication");
    }
}
