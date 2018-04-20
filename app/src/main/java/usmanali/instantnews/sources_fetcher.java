package usmanali.instantnews;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by SAJIDCOMPUTERS on 10/19/2017.
 */

public class sources_fetcher {
    public void get_sources_icons(String url, final ImageView img, final Context context){

        News_Service service= Retrofit_Client.get_Icon_Retrofit_Client().create(News_Service.class);
        Call<Sources_Icons> call =service.getIcons("https://icons.better-idea.org/allicons.json",url);
        call.enqueue(new Callback<Sources_Icons>() {
            @Override
            public void onResponse(Call<Sources_Icons> call, Response<Sources_Icons> response) {
                Sources_Icons iconslist=response.body();
                if (iconslist!=null)
                    for (int i=0;i<iconslist.icons.size();i++)
                   Picasso.with(context).load(iconslist.icons.get(0).url).into(img);
            }

            @Override
            public void onFailure(Call<Sources_Icons> call, Throwable t) {
                Log.e("iconerror",t.toString());
            }
        });
    }
    public void get_sources_names(final RecyclerView sourceslist, final Context context){
        News_Service service = Retrofit_Client.getClient().create(News_Service.class);
        Call<News_Sources> call=service.get_sources();
        call.enqueue(new Callback<News_Sources>() {
            @Override
            public void onResponse(Call<News_Sources> call, Response<News_Sources> response) {
                News_Sources newsSources=response.body();
                sourceslist.setAdapter(new sources_list_adapter(newsSources,context));
                Log.e("sources_name",newsSources.sources.get(0).url);
            }

            @Override
            public void onFailure(Call<News_Sources> call, Throwable t) {

            }
        });
    }
}
