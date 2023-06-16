package content;

import base.MITestBase;
import org.testng.annotations.Test;


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
}