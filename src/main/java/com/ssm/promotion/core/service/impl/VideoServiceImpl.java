package com.ssm.promotion.core.service.impl;

import com.ssm.promotion.core.dao.VideoDao;
import com.ssm.promotion.core.entity.Video;
import com.ssm.promotion.core.service.VideoService;
import org.springframework.stereotype.Service;
import com.ssm.promotion.core.util.AntiXssUtil;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("videoService")
public class VideoServiceImpl implements VideoService {

    @Resource
    private VideoDao vd;

    @Override
    public List<Video> findVideo(Map<String, Object> map) {
        return vd.findVideos(map);
    }

    @Override
    public Long getTotalVideo(Map<String, Object> map) {
        return vd.getTotalVideos(map);
    }

    @Override
    public int addVideo(Video video) {
        if (video.getPath() == null || getTotalVideo(null) > 90 || video.getPath().length() > 100 || video.getUrl().length() > 100) {
            return 0;
        }
        video.setUrl(AntiXssUtil.replaceHtmlCode(video.getUrl()));
        return vd.insertVideo(video);
    }

    @Override
    public int updateVideo(Video video) {
        if (video.getPath() == null || getTotalVideo(null) > 90 || video.getPath().length() > 100 || video.getUrl().length() > 100) {
            return 0;
        }
        video.setUrl(AntiXssUtil.replaceHtmlCode(video.getUrl()));
        return vd.updVideo(video);
    }

    @Override
    public int deleteVideo(String id) {
        return vd.delVideo(id);
    }

    @Override
    public Video findById(String id) {
        return vd.findVideoById(id);
    }
}
