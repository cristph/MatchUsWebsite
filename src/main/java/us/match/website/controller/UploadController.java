package us.match.website.controller;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

/**
 * Created by Master on 2015/7/14.
 */
public class UploadController {
    public String handleRequest(HttpServletRequest request,
                                      HttpServletResponse response) throws Exception{

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        MultipartFile file = multipartRequest.getFile(" file ");
        InputStream input = file.getInputStream();


        return "Upload Success";
    }

}
