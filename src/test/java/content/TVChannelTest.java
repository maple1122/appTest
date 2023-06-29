package content;

import base.MITestBase;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author wufeng
 * @date 2023/6/28 16:20
 */
public class TVChannelTest extends MITestBase {

    @Test
    public void testGetCommentList() {
        TVChannel.getCommentList();
    }

    @Test
    public void testPushComment() {
        TVChannel.pushComment();
    }
}