package cn.edu.whu.ashman.controller;

import cn.edu.whu.ashman.entities.CommonResult;
import cn.edu.whu.ashman.util.COSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
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
    public CommonResult uploadImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //CommonResult commonResult = null;
        String url = null;
        MultipartHttpServletRequest req =(MultipartHttpServletRequest)request;
        MultipartFile multipartFile =  req.getFile("file");
        //新建UUID
        String uuid = UUID.randomUUID().toString();
        //合并生成唯一文件名
        String filename = uuid + ".png";
        try {
            File file  =  new File(path,filename);
            multipartFile.transferTo(file);
            cosUtil.save(path+filename,filename);
            url = cosUtil.getURL(filename);
        } catch (IOException e) {
            e.printStackTrace();
            return new CommonResult(404,"获取url失败",null);
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return new CommonResult(404,"获取url失败",null);
        }
        return new CommonResult(200,"成功获取url",url);
    }
    @PostMapping("/imageUpload")
    public CommonResult upload(@RequestParam("file") MultipartFile file, HttpSession httpSession) {
        String url = null;
        // 获取上传文件名
        String filename = file.getOriginalFilename();
        //获取图片后缀名
        String suffixName = filename.substring(filename.lastIndexOf("."));
        //新建UUID
        String uuid = UUID.randomUUID().toString();
        //合并生成唯一文件名
        filename = uuid + suffixName;
        // 新建文件,注意这里是绝对路径
        File filepath = new File(path, filename);
        // 判断路径是否存在，如果不存在就创建一个
        if (!filepath.getParentFile().exists()) {
            filepath.getParentFile().mkdirs();
        }
        try {
            // 写入文件到服务器备份
            file.transferTo(new File(path + filename));
            //读服务器文件存到存储桶中去
            cosUtil.save(path+filename,filename);
            url = cosUtil.getURL(filename);
        } catch (IOException e) {
            e.printStackTrace();
            return new CommonResult(404,"获取url失败",null);
        }
        return new CommonResult(200,"成功获取url",url);
    }
}
