package androidguide.kenny.shark.androidguide;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;


public class website extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_website);
        TextView tv = (TextView) findViewById(R.id.textView);
        Bundle extras = getIntent().getExtras();
        tv.setText(( (String) extras.getCharSequence("url","defaultValue")));
        setTitle( (String) extras.getCharSequence("name","defaultValue"));
        WebView webview = (WebView) findViewById(R.id.webView);
        webview.setWebViewClient(new WebViewClient());
        webview.getSettings().setJavaScriptEnabled(true);
        webview.loadUrl(( (String) extras.getCharSequence("url","defaultValue") ));
    }

}
