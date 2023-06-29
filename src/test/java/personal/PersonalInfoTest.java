package personal;

import base.MITestBase;
import org.testng.annotations.Test;

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
}