package com.ssm.promotion.core.service;



import com.ssm.promotion.core.entity.Message;

import java.util.List;
import java.util.Map;

public interface MessageService {
    /**
     * 返回相应的数据集合
     *
     * @param map
     * @return
     */
    public List<Message> findMessage(Map<String, Object> map);

    /**
     * 数据数目
     *
     * @param map
     * @return
     */
    public Long getTotalMessage(Map<String, Object> map);

    /**
     * 添加评论
     *
     * @param message
     * @return
     */
    public int addMessage(Message message);

    /**
     * 修改评论
     *
     * @param message
     * @return
     */
    public int updateMessage(Message message);

    /**
     * 设置警告
     *
     * @param message
     * @return
     */
    public int updMessageType(Message message);


    /**
     * 删除
     *
     * @param id
     * @return
     */
    public int deleteMessage(String id);

    /**
     * 根据id查找
     *
     * @param id
     * @return
     */
    public Message findById(String id);

    /**
     * 发表评论
     * @param
     * @param
     * @return
     */
    public int addComment(Message message);

}
