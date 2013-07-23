package com.leven.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	private static final String HOST = "192.168.0.101";
	private static final int PORT = 9999;
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		TextView textView = (TextView) findViewById(R.id.textView);
		TextView msgTxt = (EditText) findViewById(R.id.msgTxt);
		TextView sendBtn = (TextView) findViewById(R.id.sendBtn);
		
		try {
			socket = new Socket(HOST, PORT);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
