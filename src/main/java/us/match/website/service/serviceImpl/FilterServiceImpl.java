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
        String[] classNames =(String [])this.getClassNames(keyWords).toArray();
        String[] modeNames=(String [])this.getModeName(keyWords).toArray();
        String[] techNames=(String []) this.getTechName(keyWords).toArray();

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
            arrList1.get(0).retainAll(arrList1.get(i));
        }
        for(int i=1;i<arrList2.size();i++){
            arrList2.get(0).retainAll(arrList2.get(i));
        }
        for(int i=1;i<arrList3.size();i++){
            arrList3.get(0).retainAll(arrList3.get(i));
        }
        arrList1.get(0).retainAll(arrList2.get(0));
        arrList1.get(0).retainAll(arrList3.get(0));

        ArrayList<Project> resultSet=new ArrayList<Project>();
        for(int i=0;i<arrList1.get(0).size();i++){
            int projectId=arrList1.get(0).get(i);
            Project p=projectDao.getbyid(projectId);
            resultSet.add(p);
        }
        return resultSet;
    }

    public ArrayList<String> getClassNames(ArrayList<String> keywords) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < keywords.size(); i++) {
            if(ClassNames.indexOf(keywords.get(i))!=-1)
                result.add(keywords.get(i));
        }
        return result;
    }

    public ArrayList<String> getModeName(ArrayList<String> keywords) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < keywords.size(); i++) {
            if(Mode.indexOf(keywords.get(i))!=-1)
                result.add(keywords.get(i));
        }
        return result;
    }

    public ArrayList<String> getTechName(ArrayList<String> keywords) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < keywords.size(); i++) {
            if(Technology.indexOf(keywords.get(i))!=-1)
                result.add(keywords.get(i));
        }
        return result;
    }


    static ArrayList<String> ClassNames = new ArrayList<String>();/*类目名称*/
    static ArrayList<String> Mode=new ArrayList<String>();/*模式*/
    static ArrayList<String> Technology=new ArrayList<String>();/*技术*/
    static {/*初始化*/
        ClassNames.add("移动开发");
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