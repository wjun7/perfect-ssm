package com.ssm.promotion.core.dao;

import com.ssm.promotion.core.entity.Video;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface VideoDao {
    /**
     * 返回相应的数据集合
     *
     * @param map
     * @return
     */
    public List<Video> findVideos(Map<String, Object> map);

    /**
     * 数据数目
     *
     * @param map
     * @return
     */
    public Long getTotalVideos(Map<String, Object> map);

    /**
     * 添加图片
     *
     * @param video
     * @return
     */
    public int insertVideo(Video video);

    /**
     * 修改图片
     *
     * @param video
     * @return
     */
    public int updVideo(Video video);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    public int delVideo(String id);

    /**
     * 根据id查找
     *
     * @param id
     * @return
     */
    public Video findVideoById(String id);
}
