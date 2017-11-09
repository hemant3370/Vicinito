
package hemant3370.vicinito.com.vicinito.Models.Stream;

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
    @SerializedName("profile_pic")
    @Expose
    private String profilePic;
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
    @SerializedName("email_subscription")
    @Expose
    private String emailSubscription;

    /**
     * 
     * @return
     *     The itemType
     */
    public String getItemType() {
        return itemType;
    }

    /**
     * 
     * @param itemType
     *     The itemType
     */
    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The thumbnail
     */
    public String getThumbnail() {
        return thumbnail;
    }

    /**
     * 
     * @param thumbnail
     *     The thumbnail
     */
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    /**
     * 
     * @return
     *     The followerCount
     */
    public Integer getFollowerCount() {
        return followerCount;
    }

    /**
     * 
     * @param followerCount
     *     The follower_count
     */
    public void setFollowerCount(Integer followerCount) {
        this.followerCount = followerCount;
    }

    /**
     * 
     * @return
     *     The followingCount
     */
    public Integer getFollowingCount() {
        return followingCount;
    }

    /**
     * 
     * @param followingCount
     *     The following_count
     */
    public void setFollowingCount(Integer followingCount) {
        this.followingCount = followingCount;
    }

    /**
     * 
     * @return
     *     The userBio
     */
    public String getUserBio() {
        return userBio;
    }

    /**
     * 
     * @param userBio
     *     The user_bio
     */
    public void setUserBio(String userBio) {
        this.userBio = userBio;
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
     *     The gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * 
     * @param gender
     *     The gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 
     * @return
     *     The emailSubscription
     */
    public String getEmailSubscription() {
        return emailSubscription;
    }

    /**
     * 
     * @param emailSubscription
     *     The email_subscription
     */
    public void setEmailSubscription(String emailSubscription) {
        this.emailSubscription = emailSubscription;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
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
        dest.writeString(this.profilePic);
        dest.writeString(this.thumbnail);
        dest.writeValue(this.followerCount);
        dest.writeValue(this.followingCount);
        dest.writeString(this.userBio);
        dest.writeString(this.type);
        dest.writeString(this.gender);
        dest.writeString(this.emailSubscription);
    }

    public User() {
    }

    protected User(Parcel in) {
        this.itemType = in.readString();
        this.name = in.readString();
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.profilePic = in.readString();
        this.thumbnail = in.readString();
        this.followerCount = (Integer) in.readValue(Integer.class.getClassLoader());
        this.followingCount = (Integer) in.readValue(Integer.class.getClassLoader());
        this.userBio = in.readString();
        this.type = in.readString();
        this.gender = in.readString();
        this.emailSubscription = in.readString();
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
