package com.hunzhizi.util;

import com.hunzhizi.domain.Activity;
import com.hunzhizi.domain.ActivityCommit;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 魂之子
 * @since 2022-10-02 10:27
 * program: yanchaospringboot
 * description: 该类用于进行处理mysql 转换成 excel 相关内容操作
 */
public class ExcelUtil {
    public static String osName = System.getProperty("os.name").toLowerCase();
    public static String PATHWIN = "D:\\";
    public static String PATHLINUX = "/tmp/";
    public static String PATH = null;

    static {
        PATH = osName.startsWith("win") ? PATHWIN : PATHLINUX;
    }

//    public static void main(String[] args) {
//        LinkedList<String> strings = new LinkedList<>();
//        strings.add("姓名");
//        strings.add("学号");
//        strings.add("班级");
//        strings.add("电话");
//        strings.add("qq");
//        strings.add("电子邮件");
//        ArrayList<ActivityCommit> activityCommits = new ArrayList<>();
//        ActivityCommit activityCommit = new ActivityCommit();
//        activityCommit.setStuId("201911040113");
//        activityCommit.setQq("290249675");
//        activityCommit.setPhoneNum("13179290325");
//        activityCommit.setClazz(4);
//        activityCommits.add(activityCommit);
//        Activity activity = new Activity();
//        activity.setTitle("蓝桥杯");
//        activity.setSubmitEmail("290249675@qq.com");
//        activity.setActivityDesc("desc on activity");
//        convert2Excel(activity,strings,activityCommits);
//    }
    public static String convert2Excel(Activity activity, List<ActivityCommit> list) {
        String fileName = PATH + activity.getTitle() + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + ".xlsx";
        List<String> rowHeadName = new ArrayList<>();
        if(activity.isStuName()){
            rowHeadName.add("姓名");
        }
        if(activity.isStuId()){
            rowHeadName.add("学号");
        }
        if(activity.isClazz()){
            rowHeadName.add("班级");
        }
        if(activity.isPhoneNum()){
            rowHeadName.add("电话号码");
        }
        if(activity.isQq()){
            rowHeadName.add("qq");
        }
        if(activity.isStuEmail()){
            rowHeadName.add("电子邮件");
        }
        // 1.创建工作簿
        Workbook workbook = new XSSFWorkbook();
        // 2.创建表名
        Sheet sheet = workbook.createSheet(activity.getTitle());
        //3.创建单元格并写入数据
        Row rowHead = sheet.createRow(0);
        for (int i = 0; i < rowHeadName.size(); i++) {
            rowHead.createCell(i).setCellValue(rowHeadName.get(i));
        }

//        List<Orders> list = this.list();
        for (int i = 0; i < list.size(); i++) {
            int j = 0;
            Row row = sheet.createRow(i + 1);

            if(activity.isStuName()) row.createCell(j++).setCellValue(list.get(i).getStuName());
            if(activity.isStuId()) row.createCell(j++).setCellValue(list.get(i).getStuId());
            if(activity.isClazz()) row.createCell(j++).setCellValue(list.get(i).getClazz());
            if(activity.isPhoneNum()) row.createCell(j++).setCellValue(list.get(i).getPhoneNum());
            if(activity.isQq()) row.createCell(j++).setCellValue(list.get(i).getQq());
            if(activity.isStuEmail()) row.createCell(j++).setCellValue(list.get(i).getStuEmail());
        }
        //4.创建流用于输出
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(fileName);
            //5.输出
            workbook.write(fileOutputStream);

            //6.关闭
            workbook.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return fileName;
    }


}
