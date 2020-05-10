package fun.danqing.wechartpay.service;

import fun.danqing.wechartpay.domain.Video;

import java.util.List;

/**视频业务类接口
 * @author 丹青
 * @date 2020/5/3-22:11
 */
public interface VideoService {

    List<Video> findAll();

    Video findById(int id);

    int update(Video Video);

    int delete(int id);

    int save(Video video);
}
