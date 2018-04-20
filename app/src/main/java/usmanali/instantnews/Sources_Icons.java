package usmanali.instantnews;

import java.util.List;

/**
 * Created by SAJIDCOMPUTERS on 10/19/2017.
 */

public class Sources_Icons {
    public String url;
    public List<Icon> icons;
}
class Icon
{
    public String url;
    public int width;
    public int height;
    public String format;
    public int bytes;
    public Object error;
    public String sha1sum;
}
