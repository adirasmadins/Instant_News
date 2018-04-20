package usmanali.instantnews;

import java.util.List;

/**
 * Created by SAJIDCOMPUTERS on 10/19/2017.
 */

public class News_Sources {
    public String status;
    public List<Source> sources;
}
 class Source
{
    public String id;
    public String name;
    public String description;
    public String url;
    public String category;
    public String language;
    public String country;
    public UrlsToLogos urlsToLogos;
    public List<String> sortBysAvailable;
}
 class UrlsToLogos
{
    public String small;
    public String medium;
    public String large;
}
