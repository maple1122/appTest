package media;

import base.MITestBase;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author wufeng
 * @date 2023/6/14 11:39
 */
public class MediaInfoTest extends MITestBase {

    @Test
    public void testGetMediaInfo() {
        MediaInfo.getMediaInfo();
    }
}