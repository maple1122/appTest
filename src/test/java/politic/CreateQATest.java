package politic;

import base.MITestBase;
import org.testng.annotations.Test;
import politic.CreateQA;


/**
 * @author wufeng
 * @date 2023/6/20 15:15
 */
public class CreateQATest extends MITestBase {

    @Test(priority = 1)
    public void testCreateQA() {
        CreateQA.createQA();
    }
}