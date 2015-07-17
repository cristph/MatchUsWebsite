package us.match.website.service.serviceImpl;

import org.springframework.stereotype.Service;
import us.match.website.dao.ProjectDao;
import us.match.website.model.Project;
import us.match.website.service.FilterService;
import javax.annotation.Resource;
import java.util.*;

/**
 * Created by WH on 2015/7/10.
 */
@Service
public class FilterServiceImpl implements FilterService {

    @Resource
    ProjectDao projectDao;

    @Override
    public List<Project> filter(ArrayList<String> keyWords) {
        long up = System.currentTimeMillis();
        long current = up, before = up;

        String[] classNames =this.getClassNames(keyWords);
        String[] modeNames=this.getModeName(keyWords);
        String[] techNames=this.getTechName(keyWords);

        /*if select all ,return all*/
        if(classNames.length==ClassNames.size()
                && modeNames.length== Mode.size()
                && techNames.length==Technology.size()) {
            return projectDao.getallProject();
        }
        /*get project by class*/
        List<Project> arrList1=null;
        if(classNames.length>0)
            arrList1=projectDao.getbysubject(classNames);
        else
            arrList1=new ArrayList<Project>();
        /*get project by mode*/
        List<Project> arrList2=null;
        if(modeNames.length>0)
            arrList2=projectDao.getbymodule(modeNames);
        else
            arrList2=new ArrayList<Project>();
        /*get project by technology*/
        List<Project> arrList3=null;
        if(techNames.length>0)
            arrList3=projectDao.getbyskill(techNames);
        else
            arrList3=new ArrayList<Project>();

        current = System.currentTimeMillis();
        System.out.println(current-before+"----1");
        before = current;

        if(arrList1.size()>0) {
            if(arrList2.size()>0)
                arrList1.retainAll(arrList2);
            if(arrList3.size()>0)
                arrList1.retainAll(arrList3);
//            System.out.println(resultSet.size()+"ResultSetSize");
            return arrList1;
        }
        current = System.currentTimeMillis();
        System.out.println(current-before+"----2");
        before = current;
        if(arrList2.size()>0){
            if(arrList3.size()>0)
                arrList2.retainAll(arrList3);
//            System.out.println(resultSet.size() + "ResultSetSize");
            return arrList2;
        }
        else if(arrList3.size()>0){
            return arrList3;
        }
        current = System.currentTimeMillis();
        System.out.println(current-before+"---3");
        before = current;
        return new ArrayList<Project>();
    }


    public String[] getClassNames(ArrayList<String> keywords) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < keywords.size(); i++) {
            if(ClassNames.indexOf(keywords.get(i))!=-1)
                result.add(keywords.get(i));
        }
        String [] array=new String[result.size()];
        for(int i=0;i<result.size();i++)
            array[i]=result.get(i);
        return array;
    }

    public String[] getModeName(ArrayList<String> keywords) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < keywords.size(); i++) {
            if(Mode.indexOf(keywords.get(i))!=-1)
                result.add(keywords.get(i));
        }
        String [] array=new String[result.size()];
        for(int i=0;i<result.size();i++)
            array[i]=result.get(i);
        return array;
    }

    public String[] getTechName(ArrayList<String> keywords) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < keywords.size(); i++) {
            if(Technology.indexOf(keywords.get(i))!=-1)
                result.add(keywords.get(i));
        }
        String [] array=new String[result.size()];
        for(int i=0;i<result.size();i++)
            array[i]=result.get(i);
        return array;
    }


    static ArrayList<String> ClassNames = new ArrayList<String>();/*类目名称*/
    static ArrayList<String> Mode=new ArrayList<String>();/*模式*/
    static ArrayList<String> Technology=new ArrayList<String>();/*技术*/
    static {/*初始化*/
        ClassNames.add("移动应用");
        ClassNames.add("网站建设");
        ClassNames.add("企业软件");
        ClassNames.add("嵌入式开发");
        ClassNames.add("视觉设计");
        ClassNames.add("文案设计");
        ClassNames.add("其他类目");


        Mode.add("外包");
        Mode.add("比赛");
        Mode.add("其他模式");

        Technology.add("Java");
        Technology.add("C/C++");
        Technology.add("Html/Css/Js");
        Technology.add("python");
        Technology.add("PHP");
        Technology.add("Ruby");
        Technology.add("Linux");
        Technology.add("Mysql");
        Technology.add("C#");
        Technology.add("android");
        Technology.add("iOS");
        Technology.add("其他技术");
    }

}