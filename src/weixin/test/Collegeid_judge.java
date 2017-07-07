package weixin.test;

/**
 * Created by Administrator on 2017/5/19.
 */
public class Collegeid_judge {


 public static String getCollegeid(String i){
     System.out.println("发送的学院ID"+i);
     String collegeid="";
     if(i.equals("1")){  collegeid+=125; }          //体艺学院
     else if(i.equals("2"))  {  collegeid+= 126;}   //国交学院
     else if(i.equals("3"))  {  collegeid+= 127;}   //化学院
     else if(i.equals("4"))  {  collegeid+= 128;}   //信息学院
     else if(i.equals("5"))  {  collegeid+= 129;}   //水土学院
     else if(i.equals("6"))  {  collegeid+= 130;}   //文法学院
     else if(i.equals("7"))  {  collegeid+= 131;}   //外语学院
     else if(i.equals("8"))  {  collegeid+= 132;}   //生科学院
     else if(i.equals("9"))  {  collegeid+= 133;}   //食科学院
     else if(i.equals("10")) {  collegeid+= 134;}   //经管学院
     else if(i.equals("11")) {  collegeid+= 135;}   //机电学院
     else if(i.equals("12")) {  collegeid+= 136;}   //动科学院
     else if(i.equals("13")) {  collegeid+= 137;}   //园艺学院
     else if(i.equals("14")) {  collegeid+= 138;}   //林学院
     else if(i.equals("15")) {  collegeid+= 139;}   //资环学院
     else if(i.equals("16")) {  collegeid+= 140;}   //植保学院
     else if(i.equals("17")) {  collegeid+= 141;}   //农学院
     else   {  collegeid="collegeid not found";}   // 找不到学院
     return collegeid;
 }


}
