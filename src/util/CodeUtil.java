package util;

import po.CodeName;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Minister on 2017/5/11.
 */
public class CodeUtil {

    public static String getNameByCode(String EntityClass,String code){
        Class clazz = null;
        try {
            clazz = Class.forName("po."+EntityClass);
            CodeName object = (CodeName) HibernateUtil.get(clazz,code);
            return object.getName();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String getCodeByName(String EntityClass,String name){
        List<CodeName> list = HibernateUtil.query(EntityClass,"where name = '"+name+"'");
        return list.get(0).getCode();
    }
    public static Map<String,String> getCodeToNameMap(String EntityClass){
        List<CodeName> list = HibernateUtil.query(EntityClass,"");
        Map<String,String> map = new HashMap<>();
        for (CodeName codeName:list){
            map.put(codeName.getCode(),codeName.getName());
        }
        return map;
    }
    public static Map<String,String> getNameToCodeMap(String EntityClass){
        List<CodeName> list = HibernateUtil.query(EntityClass,"");
        Map<String,String> map = new HashMap<>();
        for (CodeName codeName:list){
            map.put(codeName.getName(),codeName.getCode());
        }
        return map;
    }
    public static Map<String,String> getDataMapWithCondition(String EntityClass,String condition){
        List<CodeName> list = HibernateUtil.query(EntityClass,condition);
        Map<String,String> map = new HashMap<>();
        for (CodeName codeName:list){
            map.put(codeName.getCode(),codeName.getName());
        }
        return map;
    }
    public static void main(String[] args){
        System.out.println("start..");
        Map<String,String> a = getNameToCodeMap("CitycodeEntity");
        System.out.println(a.get("上海市"));
    }
}
