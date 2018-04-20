package usmanali.instantnews;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by SAJIDCOMPUTERS on 10/20/2017.
 */

public class news_fetcher {
    public void fetch_news_by_source(String source, String apikey, final RecyclerView newslist, final Context context, final KenBurnsView kenBurnsView, final TextView head_line){
        News_Service service=Retrofit_Client.getClient().create(News_Service.class);
        Call<News> call =service.getnewsbysource(source,apikey,"top");
        call.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, final Response<News> response) {
                if (response.body() != null) {
                    newslist.setAdapter(new news_list_adapter(response.body(), context));
                    Picasso.with(context).load(response.body().articles.get(0).urlToImage).into(kenBurnsView);
                    head_line.setText(response.body().articles.get(0).title);
                    kenBurnsView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent i=new Intent(context,News_Detail_Activity.class);
                            i.putExtra("url",response.body().articles.get(0).url);
                            context.startActivity(i);
                        }
                    });
                } else {
                    Toast.makeText(context,"News not found",Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<News> call, Throwable t) {
                Log.e("newsbysourceerror",t.toString());
            }
        });
    }
}
