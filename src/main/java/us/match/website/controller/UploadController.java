package us.match.website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * Created by Master on 2015/7/14.
 */
@Controller
public class UploadController {
    @RequestMapping("/upload")
    public String upload(){return "/uploadTest";}

    @ResponseBody
    @RequestMapping(value="/upload",method = RequestMethod.POST, produces = "text/html; charset=utf-8")
    public String handleFileUpload(@RequestParam("file") MultipartFile file){
//        try {
//            File f = new File("C:\\Users\\Ezio\\Desktop\\"+file.getOriginalFilename());
//            file.transferTo(f);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return "filename: "+ file.getOriginalFilename()+"\n" +
                "size: "+file.getSize();
    }

    public String getFilePath(String fileName){
        File file=new File(System.getProperty("user.dir"));
        return file.getAbsolutePath()+
                "/target/MatchUsWebsite/image/projectImage/"+
                fileName;
    }
}
