package media;

import base.MITestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * @author wufeng
 * @date 2023/6/15 9:02
 */
public class MediaContentTest extends MITestBase {

    //获取媒体号下的图文、音视频、拍拍列表
    @Test
    public void testGetMediaContent() {
        MediaContent.getMediaContent(11);//图文
        MediaContent.getMediaContent(14,15);//音视频
        MediaContent.getMediaContent(13);//拍拍
        MediaContent.getMediaContent(2);
    }

    @Test
    public void testGetQuestions(){
        MediaContent.getQuestions();
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