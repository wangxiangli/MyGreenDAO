package com.bush;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class MyGreen {
    public static void main(String [] args){
        //包名是下方生成的
        Schema schema=new Schema(1,"com.bush.dao");
        Entity student= schema.addEntity("Student");
        student.addIdProperty();
        student.addStringProperty("name").notNull();
        student.addStringProperty("sexy").notNull();
        student.addIntProperty("age").notNull();
        try {
            //生成数据操作类的路径
            new DaoGenerator().generateAll(schema,"D:\\StdioWorkSpace\\MyRetrofit\\mygreendao\\src\\main\\java-gen");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("运行完成");
    }
}
