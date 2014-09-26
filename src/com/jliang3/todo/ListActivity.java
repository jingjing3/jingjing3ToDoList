package com.jliang3.todo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.io.File;
import java.io.IOException;

import com.jliang3.todo.data.TextDbAdapter;
import com.jliang3.todo.utils.ToastUtils;
import com.jliang3.todo.ListActivity;



import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;

import android.util.Log;
import android.view.ContextMenu;
import android.view.KeyEvent;

import android.view.SubMenu;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ListActivity extends Activity {
	private static String TAG = "NoteListActivity";
	public static final int REQUEST_CODE_ADD_NOTE = 10000;
	public static final int REQUEST_CODE_EDIT_NOTE = 20000;
	Button mbtnAdd;
	Button mbtnFind;
	ListView mlvTexts;
	TextDbAdapter mdbHelper;
	
	AlertDialog.Builder builder=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i(TAG, "onCreate");
		setContentView(R.layout.list_edit);
		

	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	

@Override
protected void onStart() {
	// TODO Auto-generated method stub
	super.onStart();
	Log.i(TAG, "onStart");
}

@Override
protected void onResume() {
	// TODO Auto-generated method stub
	super.onResume();
	Log.i(TAG, "onResume");
}

@Override
protected void onSaveInstanceState(Bundle outState) {
	// TODO Auto-generated method stub
	super.onSaveInstanceState(outState);
	Log.i(TAG, "onSaveInstanceState");
}

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
public void onCreateContextMenu(ContextMenu menu, View v,
		ContextMenuInfo menuInfo) {
	// TODO Auto-generated method stub
	// super.onCreateContextMenu(menu, v, menuInfo);
	menu.add(0, 1, 0, com.jliang3.todo.R.string.note_list_item_menu_edit);
}


private void setClickListener() {
	// TODO Auto-generated method stub
	mbtnAdd.setOnClickListener(new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent(ListActivity.this,
					ListEditsActivity.class);
			startActivityForResult(intent, REQUEST_CODE_ADD_NOTE);
		}
	});
}


@Override
protected void onNewIntent(Intent intent) {
	// TODO Auto-generated method stub
	super.onNewIntent(intent);
	Log.i(TAG, "onNewIntent");
}
}
