package com.ssm.promotion.core.service;
import com.ssm.promotion.core.entity.Video;
import java.util.List;
import java.util.Map;

public interface VideoService {

    /**
     * 返回相应的数据集合
     *
     * @param map
     * @return
     */
    public List<Video> findVideo(Map<String, Object> map);

    /**
     * 数据数目
     *
     * @param map
     * @return
     */
    public Long getTotalVideo(Map<String, Object> map);

    /**
     * 添加视频
     *
     * @param video
     * @return
     */
    public int addVideo(Video video);

    /**
     * 修改视频
     *
     * @param video
     * @return
     */
    public int updateVideo(Video video);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    public int deleteVideo(String id);

    /**
     * 根据id查找
     *
     * @param id
     * @return
     */
    public Video findById(String id);
}
