
package hemant3370.vicinito.com.vicinito.Models.Stream.ItemDetail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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
    @SerializedName("isLiked")
    @Expose
    private Boolean isLiked;

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getShares() {
        return shares;
    }

    public void setShares(Integer shares) {
        this.shares = shares;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Boolean getIsLiked() {
        return isLiked;
    }

    public void setIsLiked(Boolean isLiked) {
        this.isLiked = isLiked;
    }

}
