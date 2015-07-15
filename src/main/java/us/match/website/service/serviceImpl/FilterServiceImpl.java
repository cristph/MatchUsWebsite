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
    public ArrayList<Project> filter(ArrayList<String> keyWords) {
        String[] classNames =this.getClassNames(keyWords);
        String[] modeNames=this.getModeName(keyWords);
        String[] techNames=this.getTechName(keyWords);

        System.out.println("classNames"+classNames.length);
        System.out.println("modeNames"+modeNames.length);
        System.out.println("techNames"+techNames.length);

        ArrayList<List<Integer>> arrList1=new ArrayList<List<Integer>>();
        for(int i=0;i<classNames.length;i++){
            List<Integer> tempList=projectDao.getbysubject(classNames[i]);
            tempList.sort(Comparator.<Integer>naturalOrder());
            arrList1.add(tempList);
        }

        ArrayList<List<Integer>> arrList2=new ArrayList<List<Integer>>();
        for(int i=0;i<modeNames.length;i++){
            List<Integer> tempList=projectDao.getbymodule(modeNames[i]);
            tempList.sort(Comparator.<Integer>naturalOrder());
            arrList2.add(tempList);
        }

        ArrayList<List<Integer>> arrList3=new ArrayList<List<Integer>>();
        for(int i=0;i<techNames.length;i++){
            List<Integer> tempList=projectDao.getbyskill(techNames[i]);
            tempList.sort(Comparator.<Integer>naturalOrder());
            arrList3.add(tempList);
        }


        for(int i=1;i<arrList1.size();i++){
            arrList1.get(0).addAll(arrList1.get(i));
        }
        for(int i=1;i<arrList2.size();i++){
            arrList2.get(0).addAll(arrList2.get(i));
        }
        for(int i=1;i<arrList3.size();i++){
            arrList3.get(0).addAll(arrList3.get(i));
        }
        if(arrList1.size()>0) {
            if(arrList2.size()>0)
                arrList1.get(0).retainAll(arrList2.get(0));
            if(arrList3.size()>0)
                arrList1.get(0).retainAll(arrList3.get(0));
            ArrayList<Project> resultSet=new ArrayList<Project>();
            for(int i=0;i<arrList1.get(0).size();i++){
                int projectId=arrList1.get(0).get(i);
                Project p=projectDao.getbyid(projectId);
                resultSet.add(p);
            }
            System.out.println(resultSet.size()+"ResultSetSize");
            return resultSet;
        }
        if(arrList2.size()>0){
            if(arrList3.size()>0)
                arrList2.get(0).retainAll(arrList3.get(0));
            ArrayList<Project> resultSet=new ArrayList<Project>();
            for(int i=0;i<arrList2.get(0).size();i++){
                int projectId=arrList2.get(0).get(i);
                Project p=projectDao.getbyid(projectId);
                resultSet.add(p);
            }
            System.out.println(resultSet.size() + "ResultSetSize");
            return resultSet;
        }
        else if(arrList3.size()>0){
            ArrayList<Project> resultSet=new ArrayList<Project>();
            for(int i=0;i<arrList3.get(0).size();i++){
                int projectId=arrList3.get(0).get(i);
                Project p=projectDao.getbyid(projectId);
                resultSet.add(p);
            }
            System.out.println(resultSet.size() + "ResultSetSize");
            return resultSet;
        }
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
        ClassNames.add("视觉设计");
        ClassNames.add("文案设计");
        ClassNames.add("嵌入式开发");

        Mode.add("外包");
        Mode.add("比赛");
        Mode.add("其他");

        Technology.add("Java");
        Technology.add("C/C++");
        Technology.add("Html/Css/Js");
        Technology.add("python");
        Technology.add("PHP");
        Technology.add("Ruby");
        Technology.add("Linux");
        Technology.add("Mysql");
        Technology.add("C#");
        Technology.add("iOS");
        Technology.add("其他技术");
    }

}