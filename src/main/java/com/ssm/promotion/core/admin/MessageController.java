package com.ssm.promotion.core.admin;


import com.ssm.promotion.core.common.Result;
import com.ssm.promotion.core.common.ResultGenerator;
import com.ssm.promotion.core.entity.Message;
import com.ssm.promotion.core.entity.PageBean;
import com.ssm.promotion.core.service.MessageService;
import com.ssm.promotion.core.util.DateUtil;
import com.ssm.promotion.core.util.ResponseUtil;
import com.ssm.promotion.core.util.StringUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/messages")
public class MessageController {

    @Resource
    MessageService messageService;

    private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(MessageController.class);// 日志文件

    @RequestMapping(value = "/datagrid", method = RequestMethod.POST)
    public String list(
            @RequestParam(value = "page", required = false) String page,
            @RequestParam(value = "rows", required = false) String rows,
            Message message, HttpServletResponse response) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        if (page != null && rows != null) {
            PageBean pageBean = new PageBean(Integer.parseInt(page),
                    Integer.parseInt(rows));
            map.put("start", pageBean.getStart());
            map.put("size", pageBean.getPageSize());
        }
        if (message != null) {
            map.put("messageContent",
                    StringUtil.formatLike(message.getMessageContent()));
        }
        List<Message> messageList = messageService.findMessage(map);
        Long total = messageService.getTotalMessage(map);
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(messageList);
        result.put("rows", jsonArray);
        result.put("total", total);
        log.info("request: message/list , map: " + map.toString());
        ResponseUtil.write(response, result);
        return null;
    }

    /**
     * 查找相应的数据集合
     *
     * @param page
     * @param rows
     * @param message
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public Result list(
            @RequestParam(value = "page", required = false) String page,
            @RequestParam(value = "rows", required = false) String rows,
            Message message) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        if (page != null && rows != null) {
            PageBean pageBean = new PageBean(Integer.parseInt(page),
                    Integer.parseInt(rows));
            map.put("start", pageBean.getStart());
            map.put("size", pageBean.getPageSize());
        }
        if (message != null) {
            map.put("messageContent",
                    StringUtil.formatLike(message.getMessageContent()));
        }
        List<Message> messageList = messageService.findMessage(map);
        Long total = messageService.getTotalMessage(map);

        Result result = ResultGenerator.genSuccessResult();
        Map data = new HashMap();
        data.put("rows", messageList);
        data.put("total", total);
        result.setData(data);
        return result;
    }

    /**
     * 添加
     *
     * @param message
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public Result save(@RequestBody Message message)
            throws Exception {
        int resultTotal = 0;

        message.setMessageCreateDate(DateUtil.getCurrentDateStr());

        resultTotal = messageService.addMessage(message);

        log.info("request: message/save , " + message.toString());

        if (resultTotal > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("添加失败");
        }
    }

    /**
     * 修改
     *
     * @param message
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public Result update(@RequestBody Message message)
            throws Exception {
        int resultTotal = 0;

        resultTotal = messageService.updateMessage(message);

        log.info("request: message/update , " + message.toString());

        if (resultTotal > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("修改失败");
        }
    }

    /**
     * 警告
     *
     * @param message
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/isBad", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateType(@PathVariable("ids") String ids ,
                             @RequestBody Message message)
            throws Exception {

        if (ids.length() > 20) {
            return ResultGenerator.genFailResult("ERROR");
        }

        String[] idsStr = ids.split(",");
        for (int i = 0; i < idsStr.length; i++) {
            messageService.deleteMessage(idsStr[i]);
        }
        log.info("request: article/delete , ids: " + ids);
        return ResultGenerator.genSuccessResult();

//
//        int resultTotal = 0;
//
//
//        resultTotal = messageService.updateMessageType(message);
//
//        log.info("request: message/update , " + message.toString());
//
//        if (resultTotal > 0) {
//            return ResultGenerator.genSuccessResult();
//        } else {
//            return ResultGenerator.genFailResult("修改失败");
//        }
    }


    /**
     * 删除
     *
     * @param ids
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delete(@PathVariable("ids") String ids) throws Exception {
        if (ids.length() > 20) {
            return ResultGenerator.genFailResult("ERROR");
        }
        String[] idsStr = ids.split(",");
        for (int i = 0; i < idsStr.length; i++) {
            messageService.deleteMessage(idsStr[i]);
        }

        log.info("request: message/delete , ids: " + ids);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 根据id查找
     *
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result findById(@PathVariable("id") String id) throws Exception {
        Message message = messageService.findById(id);
        Result result = ResultGenerator.genSuccessResult();
        result.setData(message);
        log.info("request: message/findById");
        return result;
    }


}
