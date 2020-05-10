package fun.danqing.wechartpay.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import fun.danqing.wechartpay.domain.Video;
import fun.danqing.wechartpay.mapper.VideoMapper;
import fun.danqing.wechartpay.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 丹青
 * @date 2020/5/3-22:10
 */

/**
 * video接口
 */
@RestController
@RequestMapping("/api/v1/video")
public class VideoController {
    @Autowired
    private VideoService videoService;

    /**
     * 分页接口
     * @param page 当前第几页，默认是第一页
     * @param size 每页显示几条数据，默认是10条
     * @return
     */
    @GetMapping("/page")
    public Object pageVideo(@RequestParam(value = "page",defaultValue = "1") int page,
                            @RequestParam(value = "size",defaultValue = "10") int size){
        PageHelper.startPage(page, size);
        List<Video> list = videoService.findAll();
        PageInfo<Video> pageInfo = new PageInfo<>(list);
        /**
         * 把需要的数据封装一下，发送给前端
         */
        Map map = new HashMap();
        map.put("total",pageInfo.getTotal());//总条数
        map.put("total_page",pageInfo.getPages());//总页数
        map.put("current_page",page);//当前页
        map.put("data",pageInfo.getList());//数据
        return map;
    }

    /**
     * 根据id找视频
     * @param videoId
     * @return
     */
    @GetMapping("/find_by_id")
    public Object findById(@RequestParam(value = "video_id",required = true) Integer videoId){
        return videoService.findById(videoId);
    }

}
