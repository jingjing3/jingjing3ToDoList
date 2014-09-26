package com.jliang3.todo.data;


import java.text.SimpleDateFormat;
import java.util.Date;





import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
public class TextDbAdapter {

	private static String TAG = "TextDbAdapter";
	private static String DATABASE_NAME = "mytext.db";
	private static int DATABASE_VERSION = 1;
	private static String DATABASE_TABLE_NOTES_NAME = "notexts";
	public static String TABLE_NOTES_KEY_ID = "_id";
	public static String TABLE_NOTES_KEY_TITLE = "title";
	public static String TABLE_NOTES_KEY_NOTE = "text";
	public static String TABLE_NOTES_KEY_CREATE_TIME = "createTime";
	public static String TABLE_NOTES_KEY_MODIFY_TIME = "modifyTime";
	private static String DATABASE_CREATE = "create table "
			+ DATABASE_TABLE_NOTES_NAME + "(" + TABLE_NOTES_KEY_ID
			+ " integer primary key autoincrement," + TABLE_NOTES_KEY_TITLE
			+ " text not null," + TABLE_NOTES_KEY_NOTE + " text not null,"
			+ TABLE_NOTES_KEY_CREATE_TIME + " text not null,"
			+ TABLE_NOTES_KEY_MODIFY_TIME + " text not null)";
	private static String DATABASE_DROP_TABLE = "drop table if exists texts ";

	private TextDbHelper mdbHelper;;
	private SQLiteDatabase mdb;
	private Context mcontext;


	public TextDbAdapter(Context context) {
		mcontext = context;
		mdbHelper = new TextDbHelper(context, DATABASE_NAME, null,
				DATABASE_VERSION);

	}

	private class TextDbHelper extends SQLiteOpenHelper {

		public TextDbHelper(Context context, String name,
				CursorFactory factory, int version) {
			super(context, name, factory, version);
		}
		@Override
		public void onCreate(SQLiteDatabase db) {
			
			db.execSQL(DATABASE_CREATE);
		}
		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			
			db.execSQL(DATABASE_DROP_TABLE);
			onCreate(db);
		
	}
		public TextDbHelper open() {
			mdb = mdbHelper.getWritableDatabase();
			if (mdb == null) {
				mdb = mdbHelper.getReadableDatabase();
			}

			return this;
		}

		public boolean isOpen() {
			if (mdb != null)
				return true;
			else
				return false;
		}

		public void close() {
			mdb.close();

		}

		private String getCurrentTimeString() {
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
			return format.format(date);
		}

		public long insertText(String title, String note) {
			ContentValues values = new ContentValues();
			values.put(TABLE_NOTES_KEY_TITLE, title);
			values.put(TABLE_NOTES_KEY_NOTE, note);

			values.put(TABLE_NOTES_KEY_CREATE_TIME, getCurrentTimeString());
			values.put(TABLE_NOTES_KEY_MODIFY_TIME, getCurrentTimeString());
			return mdb.insert(DATABASE_TABLE_NOTES_NAME, null, values);
		}

		public int updateText(long id, String title, String note) {
			ContentValues values = new ContentValues();
			values.put(TABLE_NOTES_KEY_TITLE, title);
			values.put(TABLE_NOTES_KEY_NOTE, note);

			values.put(TABLE_NOTES_KEY_MODIFY_TIME, getCurrentTimeString());

			return mdb.update(DATABASE_TABLE_NOTES_NAME, values, TABLE_NOTES_KEY_ID
					+ "=?", new String[] { String.valueOf(id) });
		}

		public int deleteText(long id) {
			return mdb.delete(DATABASE_TABLE_NOTES_NAME, TABLE_NOTES_KEY_ID + "=?",
					new String[] { String.valueOf(id) });
		}

		public Cursor getText(long id) {
			Cursor cursor = mdb.query(DATABASE_TABLE_NOTES_NAME, new String[] {
					TABLE_NOTES_KEY_ID, TABLE_NOTES_KEY_TITLE,
					TABLE_NOTES_KEY_NOTE, TABLE_NOTES_KEY_CREATE_TIME,
					TABLE_NOTES_KEY_MODIFY_TIME }, TABLE_NOTES_KEY_ID + "=?",
					new String[] { String.valueOf(id) }, null, null,
					TABLE_NOTES_KEY_MODIFY_TIME + " desc");
			if (cursor != null) {
				cursor.moveToFirst();
			}
			return cursor;
		}

		public Cursor findAll() {
			return mdb.query(DATABASE_TABLE_NOTES_NAME, new String[] {
					TABLE_NOTES_KEY_ID, TABLE_NOTES_KEY_TITLE,
					TABLE_NOTES_KEY_NOTE, TABLE_NOTES_KEY_CREATE_TIME,
					TABLE_NOTES_KEY_MODIFY_TIME }, null, null, null, null,
					TABLE_NOTES_KEY_MODIFY_TIME + " desc");
		}

	}

	public boolean open() {
		// TODO Auto-generated method stub
		return false;
	}

	public Cursor getText(long mtextId) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isOpen() {
		// TODO Auto-generated method stub
		return false;
	}

	public int updateText(long mtextId, String string, String string2) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insertText(String string, String string2) {
		// TODO Auto-generated method stub
		return 0;
	}

}

