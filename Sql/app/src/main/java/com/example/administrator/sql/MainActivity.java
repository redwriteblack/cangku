package com.example.administrator.sql;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity implements View.OnClickListener {
    private EditText et_name;
    private EditText et_age;
    private RadioGroup pg_sex;
    private Button but_start;
    private Mysql mq;
    private Button btn_dele;
    private Button btn_update;
    private Button btn_query;
    private TextView tv_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_name = (EditText) findViewById(R.id.et_name);
        et_age = (EditText) findViewById(R.id.et_age);
        pg_sex = (RadioGroup) findViewById(R.id.gp_sex);
        but_start = (Button) findViewById(R.id.but_start);
        btn_dele = (Button) findViewById(R.id.btn_dele);
        btn_update = (Button) findViewById(R.id.btn_update);
        btn_query = (Button) findViewById(R.id.btn_query);
        tv_content = (TextView) findViewById(R.id.tv_content);


        btn_query.setOnClickListener(this);
        btn_update.setOnClickListener(this);

        btn_dele.setOnClickListener(this);
        but_start.setOnClickListener(this);
        mq = new Mysql(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.but_start:
                start();

                break;

            case R.id.btn_dele:
                delete();
                break;


            case R.id.btn_update:
                upDate();

                break;

            case R.id.btn_query:

                query();

                break;

        }
    }

    private void query() {

        StudentDao sd = new StudentDao();
        SQLiteDatabase database = mq.getReadableDatabase();

        ArrayList<Student> students = sd.queryStu(database);

        tv_content.setText(students.toString());

    }

    private void upDate() {

        String name = et_name.getText().toString().trim();
        Student student = new Student();
        student.name = name;
        StudentDao sd = new StudentDao();
        SQLiteDatabase database = mq.getWritableDatabase();
        sd.upDateStu(student, database);


    }

    private void delete() {

        String name = et_name.getText().toString().trim();
        Student stu = new Student();
        stu.name = name;
        StudentDao dao = new StudentDao();
        SQLiteDatabase dataBase = mq.getWritableDatabase();
        // mq.getReadableDatabase()

        dao.delStu(stu, dataBase);

    }

    private void start() {
        String name = et_name.getText().toString().trim();
        int id = pg_sex.getCheckedRadioButtonId();
        int age = Integer.parseInt(et_age.getText().toString().trim());
        String sex = "man";
        switch (id) {
            case R.id.rb_man:
                sex = "man";
                break;
            case R.id.rb_woman:
                sex = "woman";
                break;

        }

        Student stu = new Student();
        stu.name = name;
        stu.age = age;
        stu.sex = sex;
        StudentDao sd = new StudentDao();
        SQLiteDatabase database = mq.getReadableDatabase();
        sd.addStu(stu, database);
    }
}
