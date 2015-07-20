package us.match.website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;

/**
 * Created by Master on 2015/7/14.
 */
@Controller
public class UploadController {

    @RequestMapping(value="/upload",method = RequestMethod.POST)
    public @ResponseBody String handleFileUpload(@RequestParam("file") MultipartFile file){
        System.out.println("upload start");
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File("name" + "-uploaded")));
                stream.write(bytes);
                stream.close();
                return "You successfully uploaded " + "" + " into " + "" + "-uploaded !";
            } catch (Exception e) {
                return "You failed to upload " + "" + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + "" + " because the file was empty.";
        }
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
