package usmanali.instantnews;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.curioustechizen.ago.RelativeTimeTextView;
import com.squareup.picasso.Picasso;

import java.util.Date;

/**
 * Created by SAJIDCOMPUTERS on 10/20/2017.
 */

public class news_list_adapter extends RecyclerView.Adapter<news_by_source_viewholder> {

    public news_list_adapter(News newsfromsource, Context context) {
        this.newsfromsource = newsfromsource;
        this.context = context;
    }

    News newsfromsource;
    Context context;

    @Override
    public news_by_source_viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.news_layout,parent,false);
        return new news_by_source_viewholder(v) ;
    }

    @Override
    public void onBindViewHolder(news_by_source_viewholder holder, final int position) {
        if(newsfromsource.articles.get(position).title.length()>65) {
            holder.articcle_title.setText(newsfromsource.articles.get(position).title.substring(0,65));
        }else{
            holder.articcle_title.setText(newsfromsource.articles.get(position).title);
        }
        Picasso.with(context).load(newsfromsource.articles.get(position).urlToImage).into(holder.news_image);
        Date date=null;
        try{
          date=ISO8601DateParser.parse(newsfromsource.articles.get(position).publishedAt);
        }catch(Exception ex){}
        if(date!=null)
        holder.timeago.setReferenceTime(date.getTime());
        holder.newscard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(context,News_Detail_Activity.class);
                i.putExtra("url",newsfromsource.articles.get(position).url);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsfromsource.articles.size();
    }
}
class news_by_source_viewholder extends RecyclerView.ViewHolder{
  TextView articcle_title;
    RelativeTimeTextView timeago;
    ImageView news_image;
    CardView newscard;
    public news_by_source_viewholder(View itemView) {
        super(itemView);
        articcle_title=(TextView) itemView.findViewById(R.id.articcle_title);
        timeago=(RelativeTimeTextView) itemView.findViewById(R.id.timeago);
        news_image=(ImageView) itemView.findViewById(R.id.source_image);
        newscard=(CardView) itemView.findViewById(R.id.newscard);
    }
}