package us.match.website.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;

/**
 * Created by Master on 2015/7/14.
 */
public class UploadController {

    @ResponseBody
    @RequestMapping(value="/upload",method = RequestMethod.POST)
    public String handleRequest(HttpServletRequest request)
            throws IllegalStateException, IOException {
        CommonsMultipartResolver multipartResolver = new
                CommonsMultipartResolver(request.getSession().getServletContext());
        if(multipartResolver.isMultipart(request)){
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
            Iterator<String> iter = multiRequest.getFileNames();
            while(iter.hasNext()){
                int pre = (int) System.currentTimeMillis();
                MultipartFile file = multiRequest.getFile(iter.next());
                if(file != null){
                    String myFileName = file.getOriginalFilename();
                    if(myFileName.trim() !=""){
                        System.out.println(myFileName);
                        String fileName = new Date().getTime() + file.getOriginalFilename();
                        String path =getFilePath(myFileName);
                        File localFile = new File(path);
                        file.transferTo(localFile);
                    }
                }
                //记录上传该文件后的时间
                int finaltime = (int) System.currentTimeMillis();
                System.out.println(finaltime - pre);
            }

        }
        return "/success";

    }

    public String getFilePath(String fileName){
        File file=new File(System.getProperty("user.dir"));
        return file.getAbsolutePath()+
                "/target/MatchUsWebsite/image/projectImage/"+
                fileName;
    }

    public static void main(String[] args) {
        UploadController u=new UploadController();
        System.out.println(u.getFilePath("test.file"));
    }

}
