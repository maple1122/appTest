package content;

import base.MITestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;


/**
 * @author wufeng
 * @date 2023/6/13 9:33
 */
public class ContentDetailTest extends MITestBase {

    @Test//获取稿件详情
    public void testGetActicleDetail() {
        ContentDetail.getActicleDetail();
    }

    @Test//点赞
    public void testPraise(){
        ContentDetail.praise();
    }

    @Test//取消点赞
    public void testCancellPraise(){
        ContentDetail.canCellPraise();
    }

    @Test//收藏
    public void testCollect(){
        ContentDetail.collect();
    }

    @Test//取消收藏
    public void testCancellCollect(){
        ContentDetail.canCellCollect();
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