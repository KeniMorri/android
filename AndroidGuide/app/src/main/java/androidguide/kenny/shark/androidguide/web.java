package androidguide.kenny.shark.androidguide;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class web extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        Resources res = getResources();
        String[] values = res.getStringArray(R.array.url_titles);
        String[] urls = res.getStringArray(R.array.urls);


        ListView lv = (ListView) findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new itemListener(urls, new Intent(this,website.class)));


    }

    public class itemListener implements AdapterView.OnItemClickListener {
        String[] internalList;
        Intent websiteview;
        itemListener(String[] urllist, Intent pintent) {
            internalList = urllist;
            websiteview = pintent;
        }
        @Override
        public void onItemClick(AdapterView<?> parent, View view,
        int position, long id) {

            // ListView Clicked item index
            int itemPosition     = position;
            websiteview.putExtra("url", internalList[itemPosition]);
            websiteview.putExtra("name", ((String) parent.getItemAtPosition(position)));
            startActivity(websiteview);
        }

    }
}
