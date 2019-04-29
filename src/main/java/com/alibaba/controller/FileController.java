package com.alibaba.controller;

import com.alibaba.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;


@RestController
@RequestMapping("/admin/activity")
public class FileController {
    /**
     * 第一种上传方式：在yml文件中定义上传路径
     */
    @Autowired
    @Value("${uploadPath}")
    private String uploadPath;
    @Autowired
    private FileService fileService;
    @RequestMapping("/add")
    //  inputFile为前端传过来的文件数组
    public void add(MultipartFile[] inputFile, HttpServletRequest request){
        //  获取请求路径
        StringBuffer url = request.getRequestURL();
        //  截取字符串http://localhost:8080/
        String imagePath = url.substring(0,url.lastIndexOf("admin"));
        //  第二种方式，获取当前项目的磁盘根目录
        String uploadPath  =  System.getProperty("user.dir");
        //  创建一个文件对象，参数是磁盘路径
        File newUploadPath = new File(uploadPath);
        //  判断项目根目录/data目录是否存在，不存在就创建
        if(!newUploadPath.exists()){
            newUploadPath.mkdir();
        }
        File lastUploadPath = new File(newUploadPath+"/activity");
        //  判断项目根目录/data/activity目录是否存在，不存在就创建
        if(!lastUploadPath.exists()){
                lastUploadPath.mkdir();
        }
        for (int i = 0;i<inputFile.length;i++) {
            //  获取上传文件名称
            String originaFilename = inputFile[i].getOriginalFilename();
            //  获取后缀名
            String fileExtention = originaFilename.substring(originaFilename.lastIndexOf("."));
            //  新文件名
            String fileName = UUID.randomUUID()+fileExtention;
            //  创建文件对象
            File destFile = new File(lastUploadPath +"/"+ fileName);
            //  上传文件
            try {
                inputFile[i].transferTo(destFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //  先将资源信息存入数据库中，代码省略
        //  创建文件表映射对象
        com.alibaba.entity.File file = new com.alibaba.entity.File();
        //  将图片路径和资源ID存入文件表中
        //file.setImage(images);
        int a =  fileService.insertFile(file);
    }
}
