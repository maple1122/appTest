package content;

import base.MITestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * @author wufeng
 * @date 2023/6/13 11:21
 */
public class CommentTest extends MITestBase {

    @Test
    public void testGetCommetList() {
        Comment.getCommentList();
    }

    @Test
    public void testPublishComment() {
        Comment.publishComment();
    }

//    @Test
//    public void testReplyComment() {
//        Comment.replyComment();
//    }

    @Test
    public void testGetMyCommentList() {
        Comment.getMyCommentList();
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