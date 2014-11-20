package don.com.pojo;

/**
 * Created by new on 11/17/14.
 */
public class SPData {

    private String login;
    private String contributions;
    private String avatar_url;

    public String getImage() {
        return this.avatar_url;
    }

    public void setImage_url(String image_url) {
        this.avatar_url = image_url;
    }

    public String getName() {
        return this.login;
    }

    public void setName(String name) {
        this.login = name;
    }

    public String getContributions() {
        return this.contributions;
    }

    public void setContributions(String contributions) {
        this.contributions = contributions;
    }
}
