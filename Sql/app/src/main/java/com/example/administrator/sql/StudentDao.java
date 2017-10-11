package com.example.administrator.sql;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;


public class StudentDao {
    public void addStu(Student stu, SQLiteDatabase database) {
        database.execSQL("insert into student(name,age,sex) values('"+stu.name+"',"+stu.age+",'"+stu.sex+"')");
    }

    public void delStu(Student stu,SQLiteDatabase database){
        database.execSQL("delete from student where name='"+stu.name+"'");
    }

    public void upDateStu(Student stu,SQLiteDatabase database){
        database.execSQL("update student set age= 50 where name='"+stu.name+"'");

    }

    public ArrayList<Student> queryStu(SQLiteDatabase database){
        ArrayList<Student> stus = new ArrayList<>();

        Cursor cursor = database.rawQuery("select name ,age ,sex from student", null);
        while(cursor.moveToNext()){
            Student stu = new Student();
            String name = cursor.getString(0);
            int age=cursor.getInt(1);
            String sex = cursor.getString(2);
            stu.name=name;
            stu.age=age;
            stu.sex=sex;
            stus.add(stu);

        }
        return stus;


    }
}
