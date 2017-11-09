
package hemant3370.vicinito.com.vicinito.Models.Stream.ItemDetail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ItemDetail {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("content_id")
    @Expose
    private String contentId;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("html_description")
    @Expose
    private String htmlDescription;
    @SerializedName("topic")
    @Expose
    private List<Topic> topic = null;
    @SerializedName("media")
    @Expose
    private Media media;
    @SerializedName("icon")
    @Expose
    private Icon icon;
    @SerializedName("thumb")
    @Expose
    private Thumb thumb;
    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("addedOn")
    @Expose
    private AddedOn addedOn;
    @SerializedName("credits")
    @Expose
    private List<Credit> credits = null;
    @SerializedName("publish_date")
    @Expose
    private PublishDate publishDate;
    @SerializedName("itemType")
    @Expose
    private String itemType;
    @SerializedName("social")
    @Expose
    private Social social;
    @SerializedName("user")
    @Expose
    private User user;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHtmlDescription() {
        return htmlDescription;
    }

    public void setHtmlDescription(String htmlDescription) {
        this.htmlDescription = htmlDescription;
    }

    public List<Topic> getTopic() {
        return topic;
    }

    public void setTopic(List<Topic> topic) {
        this.topic = topic;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public Thumb getThumb() {
        return thumb;
    }

    public void setThumb(Thumb thumb) {
        this.thumb = thumb;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public AddedOn getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(AddedOn addedOn) {
        this.addedOn = addedOn;
    }

    public List<Credit> getCredits() {
        return credits;
    }

    public void setCredits(List<Credit> credits) {
        this.credits = credits;
    }

    public PublishDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(PublishDate publishDate) {
        this.publishDate = publishDate;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public Social getSocial() {
        return social;
    }

    public void setSocial(Social social) {
        this.social = social;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
