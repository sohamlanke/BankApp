package com.example.sqliteapplication;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
 public class DatabaseHelper extends SQLiteOpenHelper {
            private String TABLE_NAME = "user_table";
            private String TABLE_NAME1 = "transfers_table";

            public DatabaseHelper(@Nullable Context context) {
                super(context, "User.db", null, 2);
            }

            @Override
            public void onCreate(SQLiteDatabase db) {
                db.execSQL("create table " + TABLE_NAME +" (PHONENUMBER INTEGER PRIMARY KEY ,NAME TEXT,BALANCE DECIMAL,EMAIL VARCHAR,ACCOUNT_NO VARCHAR,IFSC_CODE VARCHAR)");
                db.execSQL("create table " + TABLE_NAME1 +" (TRANSACTIONID INTEGER PRIMARY KEY AUTOINCREMENT,DATE TEXT,FROMNAME TEXT,TONAME TEXT,AMOUNT DECIMAL,STATUS TEXT)");
                db.execSQL("insert into user_table values(8674576874561,'James',105743.00,'james1@gmail.com','1234567890','A12345')");
                db.execSQL("insert into user_table values(8674576874562,'sachin',3245.56,'sachin2@gmail.com','1234567891','B12345')");
                db.execSQL("insert into user_table values(8674576874563,'ruthu',9846.45,'ruthu3@gmail.com','1234567892','C12345')");
                db.execSQL("insert into user_table values(8674576874564,'sowmya',1500.34,'sowmya4@gmail.com','1234567893','D12345')");
                db.execSQL("insert into user_table values(8674576874565,'jacob',260.74,'jacob5@gmail.com','1234567894','E12345')");
                db.execSQL("insert into user_table values(8674576874566,'tanay',945.86,'tanay6@gmail.com','1234567895','F12345')");
                db.execSQL("insert into user_table values(8674576874567,'peter',7566.97,'peter7@gmail.com','1234567896','G12345')");
                db.execSQL("insert into user_table values(8674576874568,'lucas',632,'lucas8@gmail.com','1234567897','H12345')");
                db.execSQL("insert into user_table values(8674576874569,'david',853.49,'david9@gmail.com','1234567898','I12345')");
                db.execSQL("insert into user_table values(8674576874570,'Athul',86666.80,'athul10@gmail.com','1234567899','J12345')");
            }

            @Override
            public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
                db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME1);
                onCreate(db);
            }

            public Cursor readalldata(){
                SQLiteDatabase db = this.getWritableDatabase();
                Cursor cursor = db.rawQuery("select * from user_table", null);
                return cursor;
            }

            public Cursor readparticulardata(String phonenumber){
                SQLiteDatabase db = this.getWritableDatabase();
                Cursor cursor = db.rawQuery("select * from user_table where phonenumber = " +phonenumber, null);
                return cursor;
            }

            public Cursor readselectuserdata(String phonenumber) {
                SQLiteDatabase db = this.getWritableDatabase();
                Cursor cursor = db.rawQuery("select * from user_table except select * from user_table where phonenumber = " +phonenumber, null);
                return cursor;
            }

            public void updateAmount(String phonenumber, String amount){
                SQLiteDatabase db = this.getWritableDatabase();
                db.execSQL("update user_table set balance = " + amount + " where phonenumber = " +phonenumber);
            }

            public Cursor readtransferdata(){
                SQLiteDatabase db = this.getWritableDatabase();
                Cursor cursor = db.rawQuery("select * from transfers_table", null);
                return cursor;
            }

            public boolean insertTransferData(String date,String from_name, String to_name, String amount, String status){
                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put("DATE", date);
                contentValues.put("FROMNAME", from_name);
                contentValues.put("TONAME", to_name);
                contentValues.put("AMOUNT", amount);
                contentValues.put("STATUS", status);
                Long result = db.insert(TABLE_NAME1, null, contentValues);
                if(result == -1){
                    return false;
                }else{
                    return true;
                }
            }
        }




