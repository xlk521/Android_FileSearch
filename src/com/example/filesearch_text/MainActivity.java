package com.example.filesearch_text;

import java.io.File;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{

	private Button search = null;
	private TextView textView = null;
	private EditText editText = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		search = (Button)findViewById(R.id.button1);
		textView = (TextView)findViewById(R.id.textView1);
		editText = (EditText)findViewById(R.id.editText1);
		
		search.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String text = editText.getText().toString();
		if (text.equals("")) {
			textView.setText("null");
		}else{
			textView.setText(searchFile(text));
		}
	}

	private String searchFile(String text) {
		String result = "";
		File[] files = new File("/").listFiles();
		for (File f : files) {
			if(f.getName().indexOf(text)>=0){
				result += f.getPath() + "\n";
			}
		}
		if (result.equals("")) {
			result = "null";
		}
		return result;
	}

}
