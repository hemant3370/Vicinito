
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
    private Properties__ properties;
    @SerializedName("is_thumb")
    @Expose
    private Boolean isThumb;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("html_text")
    @Expose
    private String htmlText;

    /**
     * 
     * @return
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 
     * @return
     *     The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 
     * @param url
     *     The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 
     * @return
     *     The caption
     */
    public String getCaption() {
        return caption;
    }

    /**
     * 
     * @param caption
     *     The caption
     */
    public void setCaption(String caption) {
        this.caption = caption;
    }

    /**
     * 
     * @return
     *     The properties
     */
    public Properties__ getProperties() {
        return properties;
    }

    /**
     * 
     * @param properties
     *     The properties
     */
    public void setProperties(Properties__ properties) {
        this.properties = properties;
    }

    /**
     * 
     * @return
     *     The isThumb
     */
    public Boolean getIsThumb() {
        return isThumb;
    }

    /**
     * 
     * @param isThumb
     *     The is_thumb
     */
    public void setIsThumb(Boolean isThumb) {
        this.isThumb = isThumb;
    }

    /**
     * 
     * @return
     *     The text
     */
    public String getText() {
        return text;
    }

    /**
     * 
     * @param text
     *     The text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * 
     * @return
     *     The htmlText
     */
    public String getHtmlText() {
        return htmlText;
    }

    /**
     * 
     * @param htmlText
     *     The html_text
     */
    public void setHtmlText(String htmlText) {
        this.htmlText = htmlText;
    }

}
