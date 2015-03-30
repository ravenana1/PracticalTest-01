package ro.pub.cs.systems.pdsd.practicaltest01;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class PracticalTest01MainActivity extends Activity {
	
	private Button button1;
	private Button button2;
	private Button button3;
	private EditText text1;
	private EditText text2;
	
	
	private ButtonClickListener viewClickListener = new ButtonClickListener();
	
	private class ButtonClickListener implements View.OnClickListener  {
		
		@Override
		public void onClick(View v) {
			String val = "";
			int numar = 0;
			if(button1.equals((Button)v)){
				text1 = (EditText)findViewById(R.id.text1);
				val = text1.getText().toString();
				numar = Integer.parseInt(val);
				numar++;
				text1.setText(String.valueOf(numar));
			}
			else if(button2.equals((Button)v)){
				text2 = (EditText)findViewById(R.id.text2);
				val = text2.getText().toString();
				numar = Integer.parseInt(val);
				numar++;
				text2.setText(String.valueOf(numar));
			}
			else if(button3.equals((Button)v)){
				System.out.println("e butonul 3");
				text1 = (EditText)findViewById(R.id.text1);
				text2 = (EditText)findViewById(R.id.text2);
				
				Intent intent = new Intent("ro.pub.cs.systems.pdsd.intent.action.PracticalTest01SecondaryActivity");
		          intent.putExtra("numar_click",
		            String.valueOf(
		              Integer.parseInt(text1.getText().toString())
		              + Integer.parseInt(text2.getText().toString())
		            ));
		          startActivityForResult(intent, 10);
			}
			
		}
	}
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_main);
        
        button1 = (Button) findViewById(R.id.buton1);
        button2 = (Button) findViewById(R.id.buton2);
        button3 = (Button) findViewById(R.id.buton3);
       
        
        button1.setOnClickListener(viewClickListener);
        button2.setOnClickListener(viewClickListener);
        button3.setOnClickListener(viewClickListener);
    }
    
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
      Toast.makeText(this, "The activity returned with result "+resultCode, Toast.LENGTH_LONG).show();
    }
    
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
      super.onSaveInstanceState(savedInstanceState);
      Log.d("debug", "onSave() method was invoked");
      
      text1 = (EditText) findViewById(R.id.text1);
      text2 = (EditText) findViewById(R.id.text2);
      
      String primul = text1.getText().toString();
      String doi = text2.getText().toString();
      
      savedInstanceState.putString("textul1", text1.getText().toString());
      savedInstanceState.putString("textul2", text2.getText().toString());
      
    }
   
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
      super.onRestoreInstanceState(savedInstanceState);
      Log.d("debug", "onRestore() method was invoked");
      
      text1 = (EditText) findViewById(R.id.text1);
      text2 = (EditText) findViewById(R.id.text2);
      
      text1.setText(savedInstanceState.getString("textul1"));
      text2.setText(savedInstanceState.getString("textul2"));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.practical_test01_main, menu);
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
}
