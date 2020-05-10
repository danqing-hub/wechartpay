package fun.danqing.wechartpay.service.impl;

import fun.danqing.wechartpay.domain.Video;
import fun.danqing.wechartpay.mapper.VideoMapper;
import fun.danqing.wechartpay.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 丹青
 * @date 2020/5/3-22:11
 */
@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;

    @Override
    public List<Video> findAll() {
        return videoMapper.findAll();
    }

    @Override
    public Video findById(int id) {
        return videoMapper.findById(id);
    }

    @Override
    public int update(Video video) {
        return videoMapper.update(video);
    }

    @Override
    public int delete(int id) {
        return videoMapper.delete(id);
    }

    @Override
    public int save(Video video) {
        return videoMapper.save(video);
    }
}
