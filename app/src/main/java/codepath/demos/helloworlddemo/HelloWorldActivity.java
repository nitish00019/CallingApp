package codepath.demos.helloworlddemo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class HelloWorldActivity extends Activity {

	EditText userMailEditText;
	EditText userPhoneNumberEditText;
	Button submitButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hello_world);
		userMailEditText = (EditText)findViewById(R.id.mail_id_textview);
		userPhoneNumberEditText = (EditText)findViewById(R.id.phone_number);
		userMailEditText.setVisibility(View.GONE);
		userPhoneNumberEditText.setVisibility(View.GONE);

		submitButton = (Button)findViewById(R.id.submit_button);
		submitButton.setVisibility(View.GONE);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_hello_world, menu);
		return true;
	}





}
