package usmanali.instantnews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class News_Detail_Activity extends AppCompatActivity {
WebView news_detail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news__detail);
        news_detail=(WebView) findViewById(R.id.news_detail);
        news_detail.getSettings().setJavaScriptEnabled(true);
        news_detail.getSettings().setBuiltInZoomControls(true);
        news_detail.setWebChromeClient(new WebChromeClient());
        news_detail.loadUrl(getIntent().getStringExtra("url"));
    }
}
