package base;

/**
 * @author wufeng
 * @date 2023/6/14 15:10
 */
public enum ContentType {

    WENGAO("文稿", 1),
    TUJI("图集",2),
    SHIPIN("视频",4),
    YINPIN("音频",5),
    ZHUANTI("专题",6),
    ZHIBO("直播",7),
    TOUPIAO("投票",8),
    BAOMING("报名",9),
    WENJUAN("问卷",10),
    MEITITUWEN("媒体号图文",11),
    MEITIPAIPAI("媒体号拍拍",13),
    MEITISHIPIN("媒体号视频",14),
    MEITIYINPIN("媒体号音频",15),
    PAIPAIHUODONG("拍拍活动",16),
    PINDAOYANGSHIKA("频道样式卡",20),
    FUWU("服务",21),
    DIANSHIPINDAO("电视频道",22),
    GUANGBOPINDAO("广播频道",23),
    MEITIWENDA("媒体号问答",42),
    PAIPAIZHUANTI("拍拍专题",60);

    public String name;
    public int index;

    // 构造方法
    ContentType(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public static void main(String[] args){
        System.out.println(ContentType.MEITISHIPIN.name+","+ContentType.MEITITUWEN.index);
    }
}
