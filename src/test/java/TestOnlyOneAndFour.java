import main.Main;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestOnlyOneAndFour {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 1, 1, 4, 4}, true},
                {new int[]{1, 4, 0, 4}, false},
                {new int[] {}, false},
                {new int[]{1, 1, 1, 1}, true},
                {new int[]{4, 4, 4}, true}
        });
    }

    private int[] arrayIn;
    private boolean result;

    public TestOnlyOneAndFour(int[] arrayIn, boolean result){
        this.arrayIn = arrayIn;
        this.result = result;
    }

    @Test
    public void test(){
        Assert.assertEquals(result, Main.onlyOneAndFour(arrayIn));
    }
}
