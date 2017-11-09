
package hemant3370.vicinito.com.vicinito.Models.Stream.ItemDetail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Resource {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("caption")
    @Expose
    private String caption;
    @SerializedName("properties")
    @Expose
    private Properties_____ properties;
    @SerializedName("variants")
    @Expose
    private Variants variants;
    @SerializedName("is_thumb")
    @Expose
    private Boolean isThumb;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("html_text")
    @Expose
    private String htmlText;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public Properties_____ getProperties() {
        return properties;
    }

    public void setProperties(Properties_____ properties) {
        this.properties = properties;
    }

    public Variants getVariants() {
        return variants;
    }

    public void setVariants(Variants variants) {
        this.variants = variants;
    }

    public Boolean getIsThumb() {
        return isThumb;
    }

    public void setIsThumb(Boolean isThumb) {
        this.isThumb = isThumb;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHtmlText() {
        return htmlText;
    }

    public void setHtmlText(String htmlText) {
        this.htmlText = htmlText;
    }

}
