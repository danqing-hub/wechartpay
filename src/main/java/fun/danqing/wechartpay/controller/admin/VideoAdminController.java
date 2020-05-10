package fun.danqing.wechartpay.controller.admin;

import fun.danqing.wechartpay.domain.Video;
import fun.danqing.wechartpay.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**管理员对Video的操作
 * @author 丹青
 * @date 2020/5/4-21:20
 */
@RestController
@RequestMapping("/admin/api/v1/video")
public class VideoAdminController {

    @Autowired
    private VideoService videoService;

    /**
     *根据id更新视频
     * @param video
     * @return
     */
    @PutMapping("/update_by_id")
    public int update(@RequestBody Video video){
        return videoService.update(video);
    }

    /**
     * 根据id删除视频
     * @param videoId
     * @return
     */
    @DeleteMapping("/del_by_id")
    public int delete(@RequestParam(value = "video_id",required = true) Integer videoId){
        return videoService.delete(videoId);
    }

    /**
     * 保存视频对象
     * @param title
     * @return
     */
    public Object save(String title){
        Video video = new Video();
        video.setTitle(title);
        return videoService.save(video);
    }
}
