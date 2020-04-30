package cn.edu.sdwu.android02.classroom.sn170507180210;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class Act14_1 extends AppCompatActivity {
    private MyOpenHelper myOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout14_1);

        myOpenHelper = new MyOpenHelper(this);


    }

    public void insert(View view) {
        //以可写方法打开数据库(如果数据库不存在，自动创建数据库)
        SQLiteDatabase sqliteDatabase = myOpenHelper.getWritableDatabase();
        try {
            //将插入的数据放置在contentValues中
            //开启事务
            sqliteDatabase.beginTransaction();
            ContentValues contentValues = new ContentValues();
            contentValues.put("stuname", "Tom");
            contentValues.put("stutel", "198819951999");
            sqliteDatabase.insert("student", null, contentValues);
            //所有操作结束后调用此方法，才会将数据提交
            sqliteDatabase.setTransactionSuccessful();

        } catch (Exception e) {
            Log.e(Act14_1.class.toString(), e.toString());
        } finally {
            //结束事务
            sqliteDatabase.endTransaction();
            //使用完毕，将数据库关闭
            sqliteDatabase.close();
        }
    }

    public void query(View view) {
        //以可写方法打开数据库(如果数据库不存在，自动创建数据库)
        SQLiteDatabase sqliteDatabase = myOpenHelper.getReadableDatabase();//只读
        try {

            Cursor cursor=sqliteDatabase.rawQuery("select * from student where stuname=?",new String[]{"Tom"});
            while(cursor.moveToNext()){
                int id=cursor.getInt(cursor.getColumnIndex("id"));
                String stuname=cursor.getString(cursor.getColumnIndex("stuname"));
                String stutel=cursor.getString(cursor.getColumnIndex("stutel"));
                Log.i(Act14_1.class.toString(),"id:"+id+",stuname:"+stuname+",stutel:"+stutel);
            }
            cursor.close();

        } catch (Exception e) {
            Log.e(Act14_1.class.toString(), e.toString());
        } finally {

            //使用完毕，将数据库关闭
            sqliteDatabase.close();
        }
    }

    public void delete(View view){
        //以可写方法打开数据库(如果数据库不存在，自动创建数据库)
        SQLiteDatabase sqliteDatabase = myOpenHelper.getWritableDatabase();
        try {

            sqliteDatabase.beginTransaction();//开启事务
            sqliteDatabase.delete("student","id=?",new String[]{"5"});
            sqliteDatabase.setTransactionSuccessful();

        } catch (Exception e) {
            Log.e(Act14_1.class.toString(), e.toString());
        } finally {
            //结束事务
            sqliteDatabase.endTransaction();
            //使用完毕，将数据库关闭
            sqliteDatabase.close();
        }
    }

    public void modify(View view) {
        //以可写方法打开数据库(如果数据库不存在，自动创建数据库)
        SQLiteDatabase sqliteDatabase = myOpenHelper.getWritableDatabase();
        try {
            //将插入的数据放置在contentValues中
            //开启事务
            sqliteDatabase.beginTransaction();
            ContentValues contentValues = new ContentValues();

            contentValues.put("stutel", "13467912345");

            sqliteDatabase.update("student",contentValues,"id=?",new String[]{"4"});
            //所有操作结束后调用此方法，才会将数据提交
            sqliteDatabase.setTransactionSuccessful();

        } catch (Exception e) {
            Log.e(Act14_1.class.toString(), e.toString());
        } finally {
            //结束事务
            sqliteDatabase.endTransaction();
            //使用完毕，将数据库关闭
            sqliteDatabase.close();
        }
    }
}
