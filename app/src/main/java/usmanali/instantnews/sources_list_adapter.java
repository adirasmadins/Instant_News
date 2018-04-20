package usmanali.instantnews;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by SAJIDCOMPUTERS on 10/19/2017.
 */

public class sources_list_adapter extends RecyclerView.Adapter<sources_viewholder> {
    News_Sources news_sources;
    Context context;

    public sources_list_adapter(News_Sources news_sources, Context context) {
        this.news_sources = news_sources;
        this.context = context;
    }

    @Override
    public sources_viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
      View v=  LayoutInflater.from(parent.getContext()).inflate(R.layout.sources_list_layout,parent,false);
        return new sources_viewholder(v);
    }

    @Override
    public void onBindViewHolder(sources_viewholder holder, final int position) {
           holder.source_name.setText(news_sources.sources.get(position).name);
           new sources_fetcher().get_sources_icons(news_sources.sources.get(position).url,holder.source_image,context);
           holder.sourcescard.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   Intent i=new Intent(context,news_Activity.class);
                   i.putExtra("source",news_sources.sources.get(position).id);
                   context.startActivity(i);
               }
           });
    }

    @Override
    public int getItemCount() {
        return news_sources.sources.size();
    }
}
class sources_viewholder extends RecyclerView.ViewHolder {
    TextView source_name;
    ImageView source_image;
    CardView sourcescard;
    public sources_viewholder(View itemView) {
        super(itemView);
        source_name=(TextView) itemView.findViewById(R.id.source_name);
        source_image=(ImageView) itemView.findViewById(R.id.source_image);
        sourcescard=(CardView)  itemView.findViewById(R.id.sourcecard);
    }
}