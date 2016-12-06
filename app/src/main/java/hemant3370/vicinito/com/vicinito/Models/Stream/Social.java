
package hemant3370.vicinito.com.vicinito.Models.Stream;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Social {

    @SerializedName("likes")
    @Expose
    private Integer likes;
    @SerializedName("shares")
    @Expose
    private Integer shares;
    @SerializedName("view_count")
    @Expose
    private Integer viewCount;

    /**
     * 
     * @return
     *     The likes
     */
    public Integer getLikes() {
        return likes;
    }

    /**
     * 
     * @param likes
     *     The likes
     */
    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    /**
     * 
     * @return
     *     The shares
     */
    public Integer getShares() {
        return shares;
    }

    /**
     * 
     * @param shares
     *     The shares
     */
    public void setShares(Integer shares) {
        this.shares = shares;
    }

    /**
     * 
     * @return
     *     The viewCount
     */
    public Integer getViewCount() {
        return viewCount;
    }

    /**
     * 
     * @param viewCount
     *     The view_count
     */
    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

}
