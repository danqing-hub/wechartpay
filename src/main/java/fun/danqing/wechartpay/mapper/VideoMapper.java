package fun.danqing.wechartpay.mapper;

import fun.danqing.wechartpay.domain.Video;
import fun.danqing.wechartpay.provider.VideoProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 丹青
 * @date 2020/5/4-0:36
 */
public interface VideoMapper {

    @Select("select * from video")
    List<Video> findAll();

    @Select("SELECT * FROM video WHERE id = #{id}")
    Video findById(int id);
   // @Update("UPDATE video SET title=#{title} WHERE id =#{id}")
    @UpdateProvider(type = VideoProvider.class,method = "updateVideo")
    int update(Video Video);

    @Delete("DELETE FROM video WHERE id =#{id}")
    int delete(int id);

    @Insert("INSERT INTO `video` ( `title`, `summary`, " +
            "`cover_img`, `view_num`, `price`, `create_time`," +
            " `online`, `point`)" +
            "VALUES" +
            "(#{title}, #{summary}, #{coverImg}, #{viewNum}, #{price},#{createTime}" +
            ",#{online},#{point});")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    int save(Video video);
}
