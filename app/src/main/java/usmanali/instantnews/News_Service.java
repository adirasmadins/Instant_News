package usmanali.instantnews;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by SAJIDCOMPUTERS on 10/19/2017.
 */

public interface News_Service {
    @GET("sources?language=en")
    Call<News_Sources> get_sources();
    @GET
    Call<Sources_Icons> getIcons(@Url String address,@Query("url") String url);
    @GET("articles")
    Call<News> getnewsbysource(@Query("source")String source,@Query("apikey")String apikey,@Query("sortBy")String sortBy);
}
