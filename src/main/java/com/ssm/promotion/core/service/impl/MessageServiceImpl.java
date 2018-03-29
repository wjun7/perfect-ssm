package com.ssm.promotion.core.service.impl;


import com.ssm.promotion.core.common.Constants;
import com.ssm.promotion.core.dao.MessageDao;
import com.ssm.promotion.core.entity.Message;
import com.ssm.promotion.core.redis.RedisUtil;
import com.ssm.promotion.core.service.MessageService;
import com.ssm.promotion.core.util.AntiXssUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("messageService")
public class MessageServiceImpl implements MessageService {

    private static final Logger log = Logger.getLogger(MessageService.class);


    @Resource
    private MessageDao messageDao;
    @Resource
    private RedisUtil redisUtil;

    @Override
    public List<Message> findMessage(Map<String, Object> map) {
        return messageDao.findMessages(map);
    }

    @Override
    public Long getTotalMessage(Map<String, Object> map) {
        return messageDao.getTotalMessages(map);
    }

    @Override
    public int addMessage(Message message) {
        if(message.getMessageContent()== null||message.getMessageContent().length()>144){
            return 0;
        }
        message.setMessageContent(AntiXssUtil.replaceHtmlCode(message.getMessageContent()));
        if(messageDao.insertMessage(message)>0){
            log.info("insert message success,save message to redis");
            redisUtil.put(Constants.MESSAGE_CACHE_KEY + message.getId(), message);
            return 1;
        }
        return 0;
    }

    @Override
    public int updateMessage(Message message) {
        if(message.getMessageContent()== null||message.getMessageContent().length()>144){
            return 0;
        }
        message.setMessageContent(AntiXssUtil.replaceHtmlCode(message.getMessageContent()));
        if(messageDao.insertMessage(message)>0){
            log.info("update message success,delete message in redis and save again");
            redisUtil.del(Constants.MESSAGE_CACHE_KEY + message.getId());
            redisUtil.put(Constants.MESSAGE_CACHE_KEY + message.getId(), message);
            return 1;
        }
        return 0;
    }

    @Override
    public int updMessageType(Message message) {
        messageDao.updMessageType(message);
        log.info("update message type success");
        return 1;
    }

    @Override
    public int deleteMessage(String id) {
        redisUtil.del(Constants.MESSAGE_CACHE_KEY + id);
        return messageDao.delMessage(id);
    }

    @Override
    public Message findById(String id) {
        log.info("get message by id:" + id);
        Message message = (Message) redisUtil.get(Constants.MESSAGE_CACHE_KEY + id, Message.class);
        if (message != null) {
            log.info("message in redis");
            return message;
        }
        Message messageFromMysql = messageDao.getMessageById(id);
        if (messageFromMysql != null) {
            log.info("get message from mysql and save message to redis");
            redisUtil.put(Constants.MESSAGE_CACHE_KEY + messageFromMysql.getId(), messageFromMysql);
            return messageFromMysql;
        }
        return null;
    }

}
