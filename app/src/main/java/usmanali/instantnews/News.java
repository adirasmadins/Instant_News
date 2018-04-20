package usmanali.instantnews;

import java.util.Date;
import java.util.List;

/**
 * Created by SAJIDCOMPUTERS on 10/20/2017.
 */

public class News {
    public String status;
    public String source;
    public String sortBy;
    public List<Article> articles;
}
 class Article
{
    public String author;
    public String title;
    public String description;
    public String url;
    public String urlToImage;
    public String publishedAt;
}
