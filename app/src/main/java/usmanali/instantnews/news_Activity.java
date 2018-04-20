package usmanali.instantnews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.flaviofaria.kenburnsview.KenBurnsView;

public class news_Activity extends AppCompatActivity {
RecyclerView newslist;
    KenBurnsView kenBurnsView;
    TextView headline;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        newslist=(RecyclerView) findViewById(R.id.news_list);
        String source=getIntent().getStringExtra("source");
        newslist.setLayoutManager(new LinearLayoutManager(news_Activity.this));
        kenBurnsView=(KenBurnsView) findViewById(R.id.top_image);
        headline=(TextView) findViewById(R.id.head_line);
        new news_fetcher().fetch_news_by_source(source,"ee1909c7d7f44ac7b8392517f8e5ac84",newslist,news_Activity.this,kenBurnsView,headline);
    }
}
