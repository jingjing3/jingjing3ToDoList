package com.jliang3.todo;

import com.jliang3.todo.data.TextDbAdapter;
import com.jliang3.todo.utils.*;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.format.DateFormat;

public class ListEditsActivity extends Activity {
	Button mbtnSave;
	EditText mtxtTitle;
	EditText mtxtText;
	long mtextId;
	private static String TAG = "NoteEditActivity";
	TextDbAdapter mdbHelper;
	
	/**modified the following code based on 
	 * http://www.2cto.com/kf/201307/227935.html   
	 * @author liubin8095                       */
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.i(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(com.jliang3.todo.R.layout.blackboard);
		mdbHelper = new TextDbAdapter(this);
		if (mdbHelper.open() == false) {
			mdbHelper.open();
		}

		findViews();
		setClickListener();

		Intent beforeIntent = getIntent();
		mtextId = beforeIntent
				.getLongExtra(TextDbAdapter.TABLE_NOTES_KEY_ID, 0);
		if (mtextId != 0) {
			Cursor cursor = mdbHelper.getText(mtextId);
			if (cursor != null) {
				mtxtTitle
						.setText(cursor.getString(cursor
								.getColumnIndexOrThrow(TextDbAdapter.TABLE_NOTES_KEY_TITLE)));
				mtxtText.setText(cursor.getString(cursor
						.getColumnIndexOrThrow(TextDbAdapter.TABLE_NOTES_KEY_NOTE)));
			}

		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list_edits, menu);
		return true;
	}
	private void setClickListener() {
		// TODO Auto-generated method stub
		mbtnSave.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				if (mtxtTitle.length() > 0 && mtxtText.length() > 0) {

					saveText();
				}
			}
		});
	}
	private void findViews() {
		// TODO Auto-generated method stub
		mbtnSave = (Button) findViewById(com.jliang3.todo.R.id.Savebutton);
		mtxtTitle = (EditText) findViewById(com.jliang3.todo.R.id.TitleText);
		mtxtText = (EditText) findViewById(com.jliang3.todo.R.id.blackboardText);
	}

	

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.i(TAG, "onStart");
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Log.i(TAG, "onRestart");
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.i(TAG, "onResume");
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

@Override
protected void onSaveInstanceState(Bundle outState) {
	// TODO Auto-generated method stub
	super.onSaveInstanceState(outState);
	Log.i(TAG, "onSaveInstanceState");
	if (mtxtTitle.length() > 0) {
		saveText();
	}
}

private void saveText() {
	if (mtextId == 0) {
		insertNote();
	} else {
		updateNote();
	}
}

private void insertNote() {
	if (mdbHelper.isOpen() == false) {
		mdbHelper.open();
	}

	if (mdbHelper.insertText(mtxtTitle.getText().toString(), mtxtText
			.getText().toString()) > 0) {

		setResult(Activity.RESULT_OK);
		ListEditsActivity.this.finish();
	}
}

private void updateNote() {
	if (mdbHelper.isOpen() == false) {
		mdbHelper.open();
	}

	if (mdbHelper.updateText(mtextId, mtxtTitle.getText().toString(),
			mtxtText.getText().toString()) > 0) {

		setResult(Activity.RESULT_OK);
		ListEditsActivity.this.finish();
	}
}


/**modified the following code based on 
 * http://hankyang.logdown.com/posts/220707-androidandroid-fragament-life-cycle-life-cycle  
 * @author HANKYANG'S BLOG            */

@Override
protected void onPause() {
	// TODO Auto-generated method stub
	super.onPause();
	Log.i(TAG, "onPause");
}

@Override
protected void onStop() {
	// TODO Auto-generated method stub
	super.onStop();
	Log.i(TAG, "onStop");
}

@Override
protected void onDestroy() {
	// TODO Auto-generated method stub
	super.onDestroy();
	Log.i(TAG, "onDestroy");
}

@Override
protected void onNewIntent(Intent intent) {
	// TODO Auto-generated method stub
	super.onNewIntent(intent);
	Log.i(TAG, "onNewIntent");
}
}

