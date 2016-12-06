
package hemant3370.vicinito.com.vicinito.Models.Stream;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class DiscussionInfo {

    @SerializedName("discussion_id")
    @Expose
    private String discussionId;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("source_id")
    @Expose
    private Integer sourceId;
    @SerializedName("owner_id")
    @Expose
    private Integer ownerId;
    @SerializedName("message_count")
    @Expose
    private Integer messageCount;
    @SerializedName("timestamp")
    @Expose
    private String timestamp;

    /**
     * 
     * @return
     *     The discussionId
     */
    public String getDiscussionId() {
        return discussionId;
    }

    /**
     * 
     * @param discussionId
     *     The discussion_id
     */
    public void setDiscussionId(String discussionId) {
        this.discussionId = discussionId;
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
     *     The source
     */
    public String getSource() {
        return source;
    }

    /**
     * 
     * @param source
     *     The source
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * 
     * @return
     *     The sourceId
     */
    public Integer getSourceId() {
        return sourceId;
    }

    /**
     * 
     * @param sourceId
     *     The source_id
     */
    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    /**
     * 
     * @return
     *     The ownerId
     */
    public Integer getOwnerId() {
        return ownerId;
    }

    /**
     * 
     * @param ownerId
     *     The owner_id
     */
    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * 
     * @return
     *     The messageCount
     */
    public Integer getMessageCount() {
        return messageCount;
    }

    /**
     * 
     * @param messageCount
     *     The message_count
     */
    public void setMessageCount(Integer messageCount) {
        this.messageCount = messageCount;
    }

    /**
     * 
     * @return
     *     The timestamp
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * 
     * @param timestamp
     *     The timestamp
     */
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

}
