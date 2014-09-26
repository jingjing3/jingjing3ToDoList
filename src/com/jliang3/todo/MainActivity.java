package com.jliang3.todo;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
	public void editTextEditor(MenuItem menu){
		Toast.makeText(this, "Edit Text", Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(MainActivity.this,ListEditsActivity.class);
		startActivity(intent);
	}
	public void List(MenuItem menu){
		Toast.makeText(this, "List", Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(MainActivity.this,ListEditsActivity.class);
		startActivity(intent);
	}
	public void E_mail(MenuItem menu){
		Toast.makeText(this, "E_mail", Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(MainActivity.this,E_mailActivity.class);
		startActivity(intent);
	}
	
	public void Archiving(MenuItem menu){
		Toast.makeText(this, "Archiving", Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(MainActivity.this,ArchivingActivity.class);
		startActivity(intent);
	}
	
	}


