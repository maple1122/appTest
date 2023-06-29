package politic;

import base.MITestBase;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author wufeng
 * @date 2023/6/20 14:33
 */
public class QADetailTest extends MITestBase {

    @Test
    public void testGetQADetail() {
        QADetail.getQADetail();
    }
}