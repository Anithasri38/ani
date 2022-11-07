import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayExampleTest{
        ArrayExample a=new ArrayExample();
        @Test
        void arrA()
        {
                int[] expected={1,66};
                int[] sample={66,1,9,4};
                int[] actual=a.arrA(sample);
                assertArrayEquals(expected,actual);
        }
}