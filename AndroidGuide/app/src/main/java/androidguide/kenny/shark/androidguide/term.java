package androidguide.kenny.shark.androidguide;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;


public class term extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term);

        Resources res = getResources();
        String[] auto_com = res.getStringArray(R.array.auto_complete);
        String[] auto_toast = res.getStringArray(R.array.toast_answers);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, auto_com);
        AutoCompleteTextView textView = (AutoCompleteTextView)
                findViewById(R.id.autoCompleteTextView);
        textView.setAdapter(adapter);

        onItemClickLis oicl = new onItemClickLis(auto_toast, auto_com);

        textView.setOnItemClickListener(oicl);
    }


    public class onItemClickLis implements AdapterView.OnItemClickListener
    {
        String[] toastText;
        String[] values;
        onItemClickLis(String[] tText, String[] vText){
            values = vText;
            toastText = tText;
        }
        public void onItemClick(AdapterView<?> parent, View view, int pos, long id){
            // ListView Clicked item index
            int itemPosition     = pos;
            // ListView Clicked item value
            String  itemValue    = (String) parent.getItemAtPosition(pos);

            int j;
            for(j = 0; j< 40; j++)
            {
                if(itemValue.equals(values[j]))
                {
                    itemPosition = j;
                    j = 41;
                }
            }
            InputMethodManager imm = (InputMethodManager)getSystemService(
                    Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

            Toast.makeText(getApplicationContext(),(String) toastText[itemPosition], Toast.LENGTH_LONG).show();

        }
    }
}
