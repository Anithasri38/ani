import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxTest{
     MinMax m=new MinMax();
     @Test
     void minmax()
     {
          int[] sample={66,9,1,4};
          assertEquals(1,m.min(sample));
     }
     @Test
     void minmax1()
     {
          int[] sample={66,9,1,4};
          assertEquals(66,m.max(sample));
     }
}