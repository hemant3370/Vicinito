
package hemant3370.vicinito.com.vicinito.Models.Stream.ItemDetail;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("tags")
    @Expose
    private List<Tag> tags = null;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("resources")
    @Expose
    private List<Resource> resources = null;
    @SerializedName("products")
    @Expose
    private List<Product> products = null;

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
