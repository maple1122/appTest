package politic;

import base.MITestBase;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author wufeng
 * @date 2023/6/20 11:17
 */
public class QAListTest extends MITestBase {

    @Test//获取问政列表
    public void testGetQAList() {
        QAList.getQAList(2);
        QAList.getQAList(5);
        QAList.getQAList(6);
    }
}