package personal;

import base.MITestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static org.testng.Assert.*;

/**
 * @author wufeng
 * @date 2023/6/29 14:45
 */
public class PersonalInfoTest extends MITestBase {

    @Test
    public void testUpdateInfo() {
        PersonalInfo.updateInfo();
    }

    @Test
    public void testUpdateHeadImg() {
        PersonalInfo.updateHeadImg();
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