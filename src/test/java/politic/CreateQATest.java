package politic;

import base.MITestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import politic.CreateQA;

import java.lang.reflect.Method;


/**
 * @author wufeng
 * @date 2023/6/20 15:15
 */
public class CreateQATest extends MITestBase {

    @Test(priority = 1)
    public void testCreateQA() {
        CreateQA.createQA();
    }

    @BeforeMethod
    public void testStart(Method method) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>> Test case: "
                + method.getName());
    }

    @AfterMethod
    public void testEnd(Method method) {
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<< Test End!\n");
    }
}