package com.backend.sellerEnd.service;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.backend.sellerEnd.dao.PictureDao;
import org.springframework.web.multipart.MultipartFile;

/**
 * Servlet implementation class UploadServlet
 */
public class PictureUploadService{
    private static final long serialVersionUID = 1L;

    // 上传文件存储目录
    private static final String UPLOAD_DIRECTORY = "resources/images";

    // 上传配置
    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

    private PictureDao pictureDao;
    public void setPictureDao(PictureDao pictureDao){
        this.pictureDao=pictureDao;
    }
    /**
     * 上传数据及保存文件
     */
    public void uploadPicture(String goodsID,MultipartFile file,HttpServletRequest request){
        System.out.println("开始");
        String path = request.getSession().getServletContext().getRealPath("resources/images");
        String fileName = file.getOriginalFilename();
        System.out.println(path);
        File targetFile = new File(path, fileName);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        //保存
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("图片：" + goodsID);
        pictureDao.savePic(goodsID,fileName);
    }
}
