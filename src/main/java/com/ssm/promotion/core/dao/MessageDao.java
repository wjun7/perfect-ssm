package com.ssm.promotion.core.dao;


import com.ssm.promotion.core.entity.Message;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Repository
public interface MessageDao {
    /**
     * 返回相应的数据集合
     *
     * @param map
     * @return
     */
    public List<Message> findMessages(Map<String, Object> map);

    /**
     * 数据数目
     *
     * @param map
     * @return
     */
    public Long getTotalMessages(Map<String, Object> map);

    /**
     * 添加评论
     *
     * @return
     */
    public int insertMessage(Message message);

    /**
     * 修改评论
     *
     * @return
     */
    public int updMessage(Message message);

    /**
     * 设置警告
     *
     * @return
     */
    public int updMessageType(Message message);


    /**
     * 删除
     *
     * @param id
     * @return
     */
    public int delMessage(String id);

    /**
     * 根据id查找
     *
     * @param id
     * @return
     */
    public Message getMessageById(String id);

    public int addComment(@Param("content")String content,
                          @Param("date")Timestamp timestamp);

}
