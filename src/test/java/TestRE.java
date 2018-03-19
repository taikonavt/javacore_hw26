import main.Main;
import org.junit.Test;

public class TestRE {

    @Test(expected = RuntimeException.class)
    public void test1(){
        Main.updateArray(new int[]{1,2,3});
    }
}
