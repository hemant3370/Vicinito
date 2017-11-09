
package hemant3370.vicinito.com.vicinito.Models.Stream.ItemDetail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Thumb {

    @SerializedName("optimised")
    @Expose
    private Optimised optimised;
    @SerializedName("media")
    @Expose
    private Media_ media;
    @SerializedName("icon")
    @Expose
    private Icon_ icon;

    public Optimised getOptimised() {
        return optimised;
    }

    public void setOptimised(Optimised optimised) {
        this.optimised = optimised;
    }

    public Media_ getMedia() {
        return media;
    }

    public void setMedia(Media_ media) {
        this.media = media;
    }

    public Icon_ getIcon() {
        return icon;
    }

    public void setIcon(Icon_ icon) {
        this.icon = icon;
    }

}
