package fun.danqing.wechartpay.provider;

import fun.danqing.wechartpay.domain.Video;
import org.apache.ibatis.jdbc.SQL;

/**video构建动态sql语句
 * @author 丹青
 * @date 2020/5/8-13:07
 */
public class VideoProvider {
    /**
     * 根据id更新Video动态语句
     * @param video
     * @return
     */
    public String updateVideo(final Video video){
        return new SQL(){{
            UPDATE("video");

            //条件写法.
            if(video.getTitle()!= null){
                SET("title=#{title}");
            }
            if(video.getSummary()!= null){
                SET("summary=#{summary}");
            }
            if(video.getCoverImg()!= null){
                SET("cover_img=#{coverImg}");
            }
            if(video.getCreateTime()!= null){
                SET("create_time=#{createTime}");
            }
            if(video.getId()!= null){
                SET("id=#{id}");
            }
            if(video.getOnline()!= null){
                SET("online=#{online}");
            }
            if(video.getPoint()!= null){
                SET("point=#{point}");
            }
            if(video.getPrice()!= null){
                SET("price=#{price}");
            }
            if(video.getViewNum()!= null){
                SET("view_num=#{viewNum}");
            }

            WHERE("id=#{id}");
        }}.toString();
    }
}
