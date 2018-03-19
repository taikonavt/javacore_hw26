import main.Main;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestUpdateArray {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2, 3, 4, 5}, new int[] {5}},
                {new int[]{1, 4, 0, 4}, new int[]{}},
                {new int[] {1, 2, 4, 3, 4, 5, 6, 7}, new int[]{5, 6, 7}}
        });
    }

    private int[] arrayIn;
    private int[] arrayOut;

    public TestUpdateArray(int[] arrayIn, int[] arrayOut){
        this.arrayIn = arrayIn;
        this.arrayOut = arrayOut;
    }

    @Test
    public void test(){
        Assert.assertArrayEquals(arrayOut, Main.updateArray(arrayIn));
    }
}
