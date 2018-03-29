package com.ssm.promotion.core.admin;

import com.ssm.promotion.core.common.Result;
import com.ssm.promotion.core.common.ResultGenerator;
import com.ssm.promotion.core.entity.PageBean;
import com.ssm.promotion.core.entity.Video;
import com.ssm.promotion.core.service.VideoService;
import com.ssm.promotion.core.util.DateUtil;
import com.ssm.promotion.core.util.ResponseUtil;
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
@RequestMapping("/videos")
public class VideoController {
    @Resource
    private VideoService videoService;
    private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(VideoController.class);// 日志文件

    /**
     * 查找相应的数据集合
     *
     * @param page
     * @param rows
     * @param video
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/datagrid")
    public String list(
            @RequestParam(value = "page", required = false) String page,
            @RequestParam(value = "rows", required = false) String rows,
            Video video, HttpServletResponse response) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        if (page != null && rows != null) {
            PageBean pageBean = new PageBean(Integer.parseInt(page),
                    Integer.parseInt(rows));
            map.put("start", pageBean.getStart());
            map.put("size", pageBean.getPageSize());
        }
        if (video != null) {
            map.put("id", video.getId() + "");
            map.put("type", video.getType() + "");
            map.put("grade", video.getGrade() + "");
        }
        List<Video> videoList = videoService.findVideo(map);
        Long total = videoService.getTotalVideo(map);
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(videoList);
        result.put("rows", jsonArray);
        result.put("total", total);
        log.info("request: videos/datagrid , map: " + map.toString());
        ResponseUtil.write(response, result);
        return null;
    }

    /**
     * 查找相应的数据集合
     *
     * @param page
     * @param rows
     * @param video
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Result list(
            @RequestParam(value = "page", required = false) String page,
            @RequestParam(value = "rows", required = false) String rows,
            Video video) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        if (page != null && rows != null) {
            PageBean pageBean = new PageBean(Integer.parseInt(page),
                    Integer.parseInt(rows));
            map.put("start", pageBean.getStart());
            map.put("size", pageBean.getPageSize());
        }
        if (video != null) {
            map.put("id", video.getId() + "");
            map.put("type", video.getType() + "");
            map.put("grade", video.getGrade() + "");
        }
        List<Video> videoList = videoService.findVideo(map);
        Result result = ResultGenerator.genSuccessResult();
        Long total = videoService.getTotalVideo(map);
        Map data = new HashMap();
        data.put("rows", videoList);
        data.put("total", total);
        log.info("request: video/list , map: " + map.toString());
        result.setData(data);
        return result;
    }


    /**
     * 添加
     *
     * @param video
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public Result save(@RequestBody Video video)
            throws Exception {
        int resultTotal = 0;

        video.setTime(DateUtil.getCurrentDateStr());

        resultTotal = videoService.addVideo(video);

        log.info("request: video/save , " + video.toString());

        if (resultTotal > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("添加失败");
        }
    }

    /**
     * 修改
     *
     * @param video
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public Result update(@RequestBody Video video)
            throws Exception {
        int resultTotal = 0;

        video.setTime(DateUtil.getCurrentDateStr());

        resultTotal = videoService.updateVideo(video);

        log.info("request: video/update , " + video.toString());

        if (resultTotal > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("修改失败");
        }
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
    public Result delete(@PathVariable(value = "ids") String ids
    ) throws Exception {
        if (ids.length() > 20) {
            return ResultGenerator.genFailResult("ERROR");
        }
        String[] idsStr = ids.split(",");
        for (int i = 0; i < idsStr.length; i++) {
            videoService.deleteVideo(idsStr[i]);
        }
        log.info("request: video/delete , ids: " + ids);
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
        Video video = videoService.findById(id);
        log.info("request: video/findById");
        if (video != null) {
            Result result = ResultGenerator.genSuccessResult();
            result.setData(video);
            return result;
        } else {
            return ResultGenerator.genFailResult("无资源");
        }
    }
}
