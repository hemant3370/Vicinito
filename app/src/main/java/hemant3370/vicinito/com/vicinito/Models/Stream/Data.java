
package hemant3370.vicinito.com.vicinito.Models.Stream;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class Data {

    @SerializedName("tags")
    @Expose
    private List<Tag> tags = new ArrayList<Tag>();
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("resources")
    @Expose
    private List<Resource> resources = new ArrayList<Resource>();

    /**
     * 
     * @return
     *     The tags
     */
    public List<Tag> getTags() {
        return tags;
    }

    /**
     * 
     * @param tags
     *     The tags
     */
    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    /**
     * 
     * @return
     *     The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return
     *     The resources
     */
    public List<Resource> getResources() {
        return resources;
    }

    /**
     * 
     * @param resources
     *     The resources
     */
    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

}
