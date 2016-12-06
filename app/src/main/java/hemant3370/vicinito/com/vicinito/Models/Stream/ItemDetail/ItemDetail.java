
package hemant3370.vicinito.com.vicinito.Models.Stream.ItemDetail;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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
    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("addedOn")
    @Expose
    private AddedOn addedOn;
    @SerializedName("credits")
    @Expose
    private List<Object> credits = null;
    @SerializedName("publish_date")
    @Expose
    private PublishDate publishDate;
    @SerializedName("discussion_info")
    @Expose
    private DiscussionInfo discussionInfo;
    @SerializedName("itemType")
    @Expose
    private String itemType;
    @SerializedName("social")
    @Expose
    private Social social;
    @SerializedName("user")
    @Expose
    private User user;

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The contentId
     */
    public String getContentId() {
        return contentId;
    }

    /**
     * 
     * @param contentId
     *     The content_id
     */
    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    /**
     * 
     * @return
     *     The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * @return
     *     The htmlDescription
     */
    public String getHtmlDescription() {
        return htmlDescription;
    }

    /**
     * 
     * @param htmlDescription
     *     The html_description
     */
    public void setHtmlDescription(String htmlDescription) {
        this.htmlDescription = htmlDescription;
    }

    /**
     * 
     * @return
     *     The topic
     */
    public List<Topic> getTopic() {
        return topic;
    }

    /**
     * 
     * @param topic
     *     The topic
     */
    public void setTopic(List<Topic> topic) {
        this.topic = topic;
    }

    /**
     * 
     * @return
     *     The media
     */
    public Media getMedia() {
        return media;
    }

    /**
     * 
     * @param media
     *     The media
     */
    public void setMedia(Media media) {
        this.media = media;
    }

    /**
     * 
     * @return
     *     The icon
     */
    public Icon getIcon() {
        return icon;
    }

    /**
     * 
     * @param icon
     *     The icon
     */
    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    /**
     * 
     * @return
     *     The data
     */
    public Data getData() {
        return data;
    }

    /**
     * 
     * @param data
     *     The data
     */
    public void setData(Data data) {
        this.data = data;
    }

    /**
     * 
     * @return
     *     The addedOn
     */
    public AddedOn getAddedOn() {
        return addedOn;
    }

    /**
     * 
     * @param addedOn
     *     The addedOn
     */
    public void setAddedOn(AddedOn addedOn) {
        this.addedOn = addedOn;
    }

    /**
     * 
     * @return
     *     The credits
     */
    public List<Object> getCredits() {
        return credits;
    }

    /**
     * 
     * @param credits
     *     The credits
     */
    public void setCredits(List<Object> credits) {
        this.credits = credits;
    }

    /**
     * 
     * @return
     *     The publishDate
     */
    public PublishDate getPublishDate() {
        return publishDate;
    }

    /**
     * 
     * @param publishDate
     *     The publish_date
     */
    public void setPublishDate(PublishDate publishDate) {
        this.publishDate = publishDate;
    }

    /**
     * 
     * @return
     *     The discussionInfo
     */
    public DiscussionInfo getDiscussionInfo() {
        return discussionInfo;
    }

    /**
     * 
     * @param discussionInfo
     *     The discussion_info
     */
    public void setDiscussionInfo(DiscussionInfo discussionInfo) {
        this.discussionInfo = discussionInfo;
    }

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
     *     The social
     */
    public Social getSocial() {
        return social;
    }

    /**
     * 
     * @param social
     *     The social
     */
    public void setSocial(Social social) {
        this.social = social;
    }

    /**
     * 
     * @return
     *     The user
     */
    public User getUser() {
        return user;
    }

    /**
     * 
     * @param user
     *     The user
     */
    public void setUser(User user) {
        this.user = user;
    }

}
