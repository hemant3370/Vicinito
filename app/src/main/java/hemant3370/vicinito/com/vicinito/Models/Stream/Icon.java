
package hemant3370.vicinito.com.vicinito.Models.Stream;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Icon {

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("properties")
    @Expose
    private Properties_ properties;

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
     *     The properties
     */
    public Properties_ getProperties() {
        return properties;
    }

    /**
     * 
     * @param properties
     *     The properties
     */
    public void setProperties(Properties_ properties) {
        this.properties = properties;
    }

}
