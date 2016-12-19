package com.example.andrew.testsystem.Repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.andrew.testsystem.Models.Test;
import com.example.andrew.testsystem.Models.TestItem;

import java.util.ArrayList;


public class TestsRepository {

    private final static String TESTS_TABLE = "tests";
    private final static String TEST_ITEMS_TABLE = "testItems";

    private DbHelper _helper;

    public TestsRepository(Context context) {
        _helper = new DbHelper(context);
    }

    public void addTest(Test test, TestItem[] items){

        ContentValues values = new ContentValues();

        values.put(Test.NAME_FIELD, test.getName());
        values.put(Test.IMAGE_FIELD, test.getImage());

        SQLiteDatabase db = _helper.getWritableDatabase();

        long testId = db.insert(TESTS_TABLE, null, values);
        test.setId(testId);

        for (TestItem item: items){
            values = new ContentValues();

            values.put(TestItem.TEST_ID, testId);
            values.put(TestItem.IMAGE, item.getImage());
            values.put(TestItem.QUESTION, item.getQuestion());
            values.put(TestItem.CORRECT_ANSWER, item.getCorrectAnswer());
            values.put(TestItem.WRONG_ANSWER_1, item.getWrongAnswer1());
            values.put(TestItem.WRONG_ANSWER_2, item.getWrongAnswer2());
            values.put(TestItem.WRONG_ANSWER_3, item.getWrongAnswer3());

            long testItemId = db.insert(TEST_ITEMS_TABLE, null, values);
        }

        db.close();
    }

    public Test[] getAllTests(){
        SQLiteDatabase db = _helper.getReadableDatabase();
        Cursor cursor = db.query(TESTS_TABLE, null, null, null, null, null, null);

        ArrayList<Test> tests = new ArrayList<>();

        if (cursor.moveToFirst()){

            int idIndex = cursor.getColumnIndex(Test.ID_FIELD);
            int nameIndex = cursor.getColumnIndex(Test.NAME_FIELD);
            int imageIndex = cursor.getColumnIndex(Test.IMAGE_FIELD);

            do {
                tests.add(new Test(
                        cursor.getInt(idIndex),
                        cursor.getString(nameIndex),
                        cursor.getString(imageIndex)
                ));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        Test[] results = new Test[tests.size()];
        return tests.toArray(results);
    }

    public TestItem[] getTestItems(long id){
        SQLiteDatabase db = _helper.getReadableDatabase();
        Cursor cursor = db.query(TEST_ITEMS_TABLE, null, null, null, null, null, null);

        ArrayList<TestItem> tests = new ArrayList<>();

        if (cursor.moveToFirst()){

            int idTestIndex = cursor.getColumnIndex(TestItem.TEST_ID);
            int imageIndex = cursor.getColumnIndex(TestItem.IMAGE);
            int questionIndex = cursor.getColumnIndex(TestItem.QUESTION);
            int correctAnswerIndex = cursor.getColumnIndex(TestItem.CORRECT_ANSWER);
            int wrongAnswer1Index = cursor.getColumnIndex(TestItem.WRONG_ANSWER_1);
            int wrongAnswer2Index = cursor.getColumnIndex(TestItem.WRONG_ANSWER_2);
            int wrongAnswer3Index = cursor.getColumnIndex(TestItem.WRONG_ANSWER_3);

            do {

                long remoteId  = cursor.getLong(idTestIndex);
                if (remoteId == id){
                    tests.add(new TestItem(
                            remoteId,
                            cursor.getString(imageIndex),
                            cursor.getString(questionIndex),
                            cursor.getString(correctAnswerIndex),
                            cursor.getString(wrongAnswer1Index),
                            cursor.getString(wrongAnswer2Index),
                            cursor.getString(wrongAnswer3Index)
                    ));
                }
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        TestItem[] results = new TestItem[tests.size()];
        return tests.toArray(results);
    }

    private class DbHelper extends SQLiteOpenHelper{

        private static final String DB_NAME = "testsDb";

        public DbHelper(Context context) {
            super(context, DB_NAME, null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String createTestsSql =
                    "create table tests (id integer primary key autoincrement, name text, image text);";
            String createTestItemsSql =
                    "create table testItems (id integer primary key autoincrement, " +
                            "testId integer, image text, question text, correctAnswer text, wrongAnswer1 text," +
                            "wrongAnswer2 text, wrongAnswer3 text);";

            db.execSQL(createTestsSql);
            db.execSQL(createTestItemsSql);

            db.execSQL("insert into tests (id, name, image) values (1, 'Radio station test', 'http://ukraine-fm.com/wp-content/uploads/2011/06/RadioRoks.png')");
            db.execSQL("insert into testItems (id, testId, image, question, correctAnswer, wrongAnswer1, wrongAnswer2, wrongAnswer3) values (1, 1, 'http://ukraine-fm.com/wp-content/uploads/2011/06/RadioRoks.png', 'What radio station is it?', 'Radio ROKS', 'Kiss FM', 'Hit FM', 'Radio RELAX');");
            db.execSQL("insert into testItems (id, testId, image, question, correctAnswer, wrongAnswer1, wrongAnswer2, wrongAnswer3) values (2, 1, 'http://www.kissfm.ua/static/img/brandbook/kiss_logo_black.png', 'What radio station is it?', 'Kiss FM', 'Radio ROKS', 'Hit FM', 'Radio RELAX');");
            db.execSQL("insert into testItems (id, testId, image, question, correctAnswer, wrongAnswer1, wrongAnswer2, wrongAnswer3) values (3, 1, 'https://upload.wikimedia.org/wikipedia/uk/5/52/Hit_fm_logo.png', 'What radio station is it?', 'Hit FM', 'Radio ROKS', 'Kiss FM', 'Radio RELAX');");
            db.execSQL("insert into testItems (id, testId, image, question, correctAnswer, wrongAnswer1, wrongAnswer2, wrongAnswer3) values (4, 1, 'http://radiovolna.net/uploads/posts/2015-02/thumbs/1423673603_728x300.jpg-728300.png', 'What radio station is it?', 'Radio RELAX', 'Radio ROKS', 'Kiss FM', 'Hit FM');");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
