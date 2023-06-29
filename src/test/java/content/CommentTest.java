package content;

import base.MITestBase;
import org.testng.annotations.Test;

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

    @Test
    public void testReplyComment() {
        Comment.replyComment();
    }

    @Test
    public void testGetReplyCommentList() {

    }

    @Test
    public void testGetMyCommentList() {
        Comment.getMyCommentList();
    }

}