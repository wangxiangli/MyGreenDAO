package com.bush.mygreendao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.bush.dao.DaoMaster;
import com.bush.dao.DaoSession;
import com.bush.dao.Student;
import com.bush.dao.StudentDao;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG ="-----" ;
    private Button btnInsert,btnUpdate,btnQuery,btnDelete;
    private StudentDao studentDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaoMaster.DevOpenHelper helper=new DaoMaster.DevOpenHelper(this,"student.DB",null);
        DaoMaster master=new DaoMaster(helper.getWritableDatabase());
        DaoSession session=master.newSession();
        studentDao=session.getStudentDao();

        btnDelete= (Button) findViewById(R.id.btn_delete );
        btnInsert= (Button) findViewById(R.id.btn_insert );
        btnQuery= (Button) findViewById(R.id.btn_query );
        btnUpdate= (Button) findViewById(R.id.btn_update );
        btnQuery.setOnClickListener(this);
        btnInsert.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_insert:
               // Student student=new Student("zhangsan","man",23);
                Student student=new Student();
                student.setAge(34);
                student.setName("zhagnsan");
                student.setSexy("man");
                studentDao.insert(student);
                break;
            case R.id.btn_update:
                Student lisi=new Student();
                lisi.setName("lisi");
                lisi.setSexy("weo");
                lisi.setAge(34);
                lisi.setId(3L);
                studentDao.update(lisi);
                break;
            case R.id.btn_delete:
                Student stu=new Student();
                stu.setId(4L);
                 studentDao.delete(stu );
                break;
            case R.id.btn_query:
                List<Student> list=studentDao.loadAll();
                for (Student student1:list){
                    Log.d(TAG, "onClick: "+student1.getId()+","+student1.getName());
                }
                break;
        }
    }
}
