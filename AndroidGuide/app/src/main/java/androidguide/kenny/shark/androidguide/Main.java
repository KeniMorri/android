package androidguide.kenny.shark.androidguide;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Main extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent bt = new Intent(this, term.class);
        onClickLis ocl1 = new onClickLis(bt);
        Button termB = (Button) findViewById(R.id.tbutton);
        termB.setOnClickListener(ocl1);


        final Intent bw = new Intent(this, web.class);
        onClickLis ocl2 = new onClickLis(bw);
        Button webB = (Button) findViewById(R.id.wbutton);
        webB.setOnClickListener(ocl2);
    }


    public class onClickLis implements View.OnClickListener {
        Intent sIntent;
        onClickLis() {

        }
        onClickLis(Intent sentIntent) {
            sIntent = sentIntent;
        }
        @Override
        public void onClick(View v) {
            startActivity(sIntent);
        }
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
        if (id == R.id.action_help) {
            final Intent myIntent = new Intent(this, help.class);
            startActivity(myIntent);
        }
        if (id == R.id.action_about) {
            final Intent myIntent = new Intent(this, About.class);
            startActivity(myIntent);
        }
        return super.onOptionsItemSelected(item);
    }
}
