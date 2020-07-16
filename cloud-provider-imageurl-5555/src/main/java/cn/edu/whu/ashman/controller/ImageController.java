package cn.edu.whu.ashman.controller;

import cn.edu.whu.ashman.config.COSClientConfig;
import cn.edu.whu.ashman.entities.CommonResult;
import cn.edu.whu.ashman.util.COSUtil;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.PrintWriter;
import java.util.UUID;

/**
 * @author Zhuyuhan
 * @date 2020-07-16 13:16
 */
@Controller
public class ImageController {

    @Autowired
    private COSUtil cosUtil;
    @Value("${file.uploadPath}")
    private String path;
    @RequestMapping(value = "/uploadImage", method = { RequestMethod.POST,RequestMethod.GET})
    public ModelAndView uploadImage(HttpServletRequest request, HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        String url = null;
        MultipartHttpServletRequest req =(MultipartHttpServletRequest)request;
        MultipartFile multipartFile =  req.getFile("file");
        //新建UUID
        String uuid = UUID.randomUUID().toString();
        //合并生成唯一文件名
        String filename = uuid + ".png";
        PrintWriter writer = null;
        try {
            File file  =  new File(path,filename);
            multipartFile.transferTo(file);
            cosUtil.save(path+filename,filename);
            //url = cosUtil.getURL(filename);
            url = COSClientConfig.PREFIX+filename;
            System.out.println(url);
            //String urlJson = "{\"url\":"+url+"}";
            //JSONObject jsonObject = new JSONObject(urlJson);
            writer = response.getWriter();
            //writer.append(jsonObject.toString());
            writer.append(url);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if(writer!=null){
                writer.close();
            }
        }
        return null;
    }
}
