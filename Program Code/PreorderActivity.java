package com.my.newproject2;

import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.graphics.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.text.*;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import java.util.ArrayList;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Button;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

public class PreorderActivity extends AppCompatActivity {
	
	
	private Toolbar _toolbar;
	
	private ArrayList<String> medicine = new ArrayList<>();
	private ArrayList<String> medi = new ArrayList<>();
	
	private TextView preorder;
	private TextView types;
	private Spinner type;
	private TextView name;
	private EditText entername;
	private TextView date;
	private EditText dates;
	private Button order;
	
	private Intent i = new Intent();
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.preorder);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		_toolbar = (Toolbar) findViewById(R.id._toolbar);
		setSupportActionBar(_toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) {
				onBackPressed();
			}
		});
		preorder = (TextView) findViewById(R.id.preorder);
		types = (TextView) findViewById(R.id.types);
		type = (Spinner) findViewById(R.id.type);
		name = (TextView) findViewById(R.id.name);
		entername = (EditText) findViewById(R.id.entername);
		date = (TextView) findViewById(R.id.date);
		dates = (EditText) findViewById(R.id.dates);
		order = (Button) findViewById(R.id.order);
		
		order.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if ((0 < dates.getText().toString().length()) && (0 < entername.getText().toString().length())) {
					i.setClass(getApplicationContext(), PaymentActivity.class);
					startActivity(i);
					SketchwareUtil.showMessage(getApplicationContext(), "Success");
					finish();
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "Fill all fields");
				}
			}
		});
	}
	private void initializeLogic() {
		medicine.add("Liquid");
		medicine.add("Capsule ");
		medicine.add("Tablets ");
		medicine.add("Drops");
		medicine.add("Injection ");
		medicine.add("Others");
		type.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, medicine));
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	@Override
	public void onBackPressed() {
		i.setClass(getApplicationContext(), DataActivity.class);
		startActivity(i);
		finish();
	}
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input){
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels(){
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels(){
		return getResources().getDisplayMetrics().heightPixels;
	}
	
}
