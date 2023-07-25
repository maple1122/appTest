package media;

import base.MITestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static org.testng.Assert.*;

/**
 * @author wufeng
 * @date 2023/6/15 15:08
 */
public class MediaFollowTest extends MITestBase {

    @Test//关注
    public void testFollow() {
        MediaFollow.follow();
    }

    @Test//取消关注
    public void testCancellFollow() {
        MediaFollow.cancellFollow();
    }

    @Test//发送私信
    public void testCreateMessage() {
        MediaFollow.createMessage();
    }

    @Test//提问
    public void testCreateQuestion() {
        MediaFollow.createQuestion();
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