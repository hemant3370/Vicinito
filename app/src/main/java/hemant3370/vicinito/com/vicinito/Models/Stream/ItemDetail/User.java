
package hemant3370.vicinito.com.vicinito.Models.Stream.ItemDetail;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User implements Parcelable {

    @SerializedName("itemType")
    @Expose
    private String itemType;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("follower_count")
    @Expose
    private Integer followerCount;
    @SerializedName("following_count")
    @Expose
    private Integer followingCount;
    @SerializedName("user_bio")
    @Expose
    private String userBio;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("follow_status")
    @Expose
    private Boolean followStatus;

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Integer getFollowerCount() {
        return followerCount;
    }

    public void setFollowerCount(Integer followerCount) {
        this.followerCount = followerCount;
    }

    public Integer getFollowingCount() {
        return followingCount;
    }

    public void setFollowingCount(Integer followingCount) {
        this.followingCount = followingCount;
    }

    public String getUserBio() {
        return userBio;
    }

    public void setUserBio(String userBio) {
        this.userBio = userBio;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Boolean getFollowStatus() {
        return followStatus;
    }

    public void setFollowStatus(Boolean followStatus) {
        this.followStatus = followStatus;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.itemType);
        dest.writeString(this.name);
        dest.writeValue(this.id);
        dest.writeString(this.thumbnail);
        dest.writeValue(this.followerCount);
        dest.writeValue(this.followingCount);
        dest.writeString(this.userBio);
        dest.writeString(this.type);
        dest.writeString(this.gender);
        dest.writeValue(this.followStatus);
    }

    public User() {
    }

    protected User(Parcel in) {
        this.itemType = in.readString();
        this.name = in.readString();
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.thumbnail = in.readString();
        this.followerCount = (Integer) in.readValue(Integer.class.getClassLoader());
        this.followingCount = (Integer) in.readValue(Integer.class.getClassLoader());
        this.userBio = in.readString();
        this.type = in.readString();
        this.gender = in.readString();
        this.followStatus = (Boolean) in.readValue(Boolean.class.getClassLoader());
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
