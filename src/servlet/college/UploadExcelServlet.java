package servlet.college;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import po.CodeName;
import po.StudentEntity;
import po.StudentloginEntity;
import servlet.Encrypt;
import util.CodeUtil;
import util.ExcelHelper;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**
 * Created by Minister on 2017/5/3.
 */
public class UploadExcelServlet extends HttpServlet {
    private static final int ADD = 0;
    private static final int UPDATA = 1;
    private static final int ADD_USER = 2;
    private static final int CLASSNAME = 0;
    private static final int FIELDSNUM = 1;
    private static final String PASSWORD = "123456" ;


    //指出是否是来自admin的操作
    boolean isAdmin = false;
    //如果重复是否替换
    boolean isupdate = false;
    //生成加密密码
    String encryptPwd = Encrypt.MD5(PASSWORD);

    Map<String,String> citycodeMap = null;
    Map<String,String> politicalMap = null;
    Map<String,String> majorMap = null;
    Map<String,String> trainModMap = null;
    Map<String,String> nationMap = null;
    Map<String,String> xingzhengMap = null;
    Map<String,String> educationMap = null;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        //储存处理哪一个表的参数的数组
        String[] para = null;
        isAdmin = false;
        isupdate = false;
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding(request.getCharacterEncoding());
        ExcelHelper helper = new ExcelHelper();
        try{
            List list = upload.parseRequest(request);
            for (int i = 0;i<list.size();i++){
                FileItem item = (FileItem) list.get(i);
                if (item.isFormField()) {
                    String fieldName = item.getFieldName();
                    if (fieldName.equals("type")) {
                        String type = item.getString();
                        System.out.println(type);
                        para = type.split("-");
                    }
                    if (fieldName.equals("isAdmin")){
                        if(item.getString().equals("true")){
                            isAdmin = true;
                        }
                    }
                    if (fieldName.equals("isUpdate")){
                        if (item.getString().equals("true")){
                            isupdate = true;
                        }
                    }
                }else if (item.getName().endsWith(".xls") || item.getName().endsWith(".xlsx")) {
                    List<List<String>> tableList = helper.importXlsx(item.getInputStream(), Integer.parseInt(para[FIELDSNUM]), 1);
                    System.out.println("行数："+tableList.size());
                    System.out.println("列数"+tableList.get(0).size());
                    int[] result;
                    switch (para[CLASSNAME]) {
                        case "StudentEntity":
                            result = addListToDatabase(tableList);
                            break;
                        case "CitycodeEntity":
                            result = addCodeListToDatabase(tableList, para[0]);
                            break;
                        case "XingzhengquhuaEntity":
                            result = addCodeListToDatabase(tableList, para[0]);
                            break;
                        case "SexEntity":
                            result = addCodeListToDatabase(tableList, para[0]);
                            break;
                        case "NationEntity":
                            result = addCodeListToDatabase(tableList, para[0]);
                            break;
                        case "BachelorEntity":
                            result = addCodeListToDatabase(tableList, para[0]);
                            break;
                        case "PoliticalEntity":
                            result = addCodeListToDatabase(tableList, para[0]);
                            break;
                        default:
                            throw new Exception();
                    }
                    System.out.println("添加：" + result[ADD]);
                    System.out.println("更新：" + result[UPDATA]);
                    System.out.println("新增登录用户：" + result[ADD_USER]);
                    out.print("<h1>文件导入成功！</h1>");
                    out.print("本次操作 添加新纪录记录：" + result[ADD] + "条，" +
                            "更新记录：" + result[UPDATA] + "条，" +
                            "新增登录用户："+result[ADD_USER]+"条");
                } else {
                    out.print("<h1>文件格式错误!</h1>");
                    out.print("请确认是.xlsx文件");
                }
            }
            out.flush();
            out.close();
        }catch(Exception e){
            e.printStackTrace();
            out.print("<h1>文件上传失败!</h1>");
            out.print("请仔细阅读注意事项");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    private void loadDataMap(){
        citycodeMap = CodeUtil.getCodeToNameMap("CitycodeEntity");
        politicalMap = CodeUtil.getCodeToNameMap("PoliticalEntity");
        majorMap = CodeUtil.getCodeToNameMap("BachelorEntity");
        trainModMap = CodeUtil.getCodeToNameMap("TrainingmodeEntity");
        nationMap = CodeUtil.getCodeToNameMap("NationEntity");
        xingzhengMap = CodeUtil.getCodeToNameMap("XingzhengquhuaEntity");
        educationMap = CodeUtil.getCodeToNameMap("DegreeEntity");
    }
    private int[] addListToDatabaseByMap(List<List<String>> list){
        loadDataMap();
        Object[] info = null;
        int[] result = {0,0,0};
        for (List<String> row:list) {
            info = row.toArray();
            //name转code
            info[3] = ((String)info[3]).equals("1")?"男":"女";//性别
            info[4] = codeToString(info[4],nationMap);//民族
            info[6] = codeToString(info[6],politicalMap);//政治面貌
            info[7] = codeToString(info[7],educationMap);//学历
            info[8] = codeToString(info[8],majorMap);//专业
            info[9] = codeToString(info[9],trainModMap);//培养方式
            info[10] = codeToString(info[10],xingzhengMap);//生源所在地
            info[12] = codeToString(info[12],trainModMap);//辅修专业
            info[24] = codeToString(info[24],xingzhengMap);//常住地址区县
            info[25] = codeToString(info[25],xingzhengMap);//现户籍所在地区县
            info[29] = codeToString(info[29],citycodeMap);//常住地址街道办
            info[31] = codeToString(info[31],citycodeMap);//现户籍街道办

            System.out.println(info[24]);

            StudentEntity stu = null;
            if ((stu = (StudentEntity) HibernateUtil.get(StudentEntity.class, Integer.parseInt(row.get(0))))!=null){
                stu.updata(info);
                HibernateUtil.update(stu);
                result[UPDATA]++;
            }else{
                stu = new StudentEntity(info);
                HibernateUtil.add(stu);
                result[ADD]++;
            }
        }
        cleanMap();
        return result;
    }
    private Object codeToString(Object code,Map dataMap){
        String name = (String) dataMap.get(code);
        return name;
    }
    private Object codeToString(Object code,String clazz){
        if(code!=null&&!code.equals("null")) {
            String[] fields = {"name"};
            List<Object[]> nameL = HibernateUtil.selectFields("po." + clazz, fields, "WHERE code='" + code + "'");
            String name = String.valueOf(nameL.get(0));
            return name;
        }
        return "";
    }
    private void cleanMap(){
        citycodeMap = null;
        politicalMap = null;
        majorMap = null;
        trainModMap = null;
        nationMap = null;
        xingzhengMap = null;
        educationMap = null;
    }
    private int[] addCodeListToDatabase(List<List<String>> list, String clazz) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Object[] info = null;
        int[] result = {0,0,0};
        for (List<String> row:list) {
            info = row.toArray();
            //name转code

            CodeName stu = null;
            if ((stu = (CodeName) HibernateUtil.get(Class.forName("po."+clazz), row.get(1)))!=null){
                stu.setName(info[1].toString());
                HibernateUtil.update(stu);
                result[UPDATA]++;
            }else if (!isupdate){
                stu = (CodeName) Class.forName("po."+clazz).newInstance();
                stu.setCode((String) info[1]);
                stu.setName((String) info[0]);
                HibernateUtil.add(stu);
                result[ADD]++;
            }
        }
        return result;
    }
    private int[] addListToDatabase(List<List<String>> list){
        Object[] info = null;
        int[] result = {0,0,0};
        for (List<String> row:list) {
            info = row.toArray();
            //name转code
            //info[3] = ((String)info[3]).equals("1")?"男":"女";//性别
            //info[4] = codeToString(info[4],"NationEntity");//民族
            //info[6] = codeToString(info[6],"PoliticalEntity");//政治面貌
            //info[7] = codeToString(info[7],"DegreeEntity");//学历
            //info[8] = codeToString(info[8],"BachelorEntity");//专业
            //info[9] = codeToString(info[9],"TrainingmodeEntity");//培养方式
            //info[10] = codeToString(info[10],"XingzhengquhuaEntity");//生源所在地
            //info[12] = codeToString(info[12],"BachelorEntity");//辅修专业
            //info[24] = codeToString(info[24],"XingzhengquhuaEntity");//常住地址区县
            //info[25] = codeToString(info[25],"XingzhengquhuaEntity");//现户籍所在地区县
            //info[29] = codeToString(info[29],"CitycodeEntity");//常住地址街道办
            //info[31] = codeToString(info[31],"CitycodeEntity");//现户籍街道办

            System.out.println(info[24]);

            StudentloginEntity login= null;
            StudentEntity stu = null;
            System.out.println("is update "+isupdate);
            System.out.println("is admin "+isAdmin);
            if ((stu = (StudentEntity) HibernateUtil.get(StudentEntity.class, Integer.parseInt(row.get(0))))!=null&&isupdate){
                stu.updata(info);
                HibernateUtil.update(stu);
                result[UPDATA]++;
            }else if (stu==null){
                stu = new StudentEntity(info);
                HibernateUtil.add(stu);
                result[ADD]++;
            }
            if (isAdmin&&(login = (StudentloginEntity) HibernateUtil.get(StudentloginEntity.class, Integer.parseInt(row.get(0))))==null){
                login = new StudentloginEntity();
                login.setStudentid(Integer.parseInt(row.get(0)));
                login.setStudentpassword(encryptPwd);
                HibernateUtil.add(login);
                result[ADD_USER]++;
            }
        }
        return result;
    }
}
