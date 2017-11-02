
package hemant3370.vicinito.com.vicinito.Models.Stream;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class StreamResponse {

    @SerializedName("next_stream_id")
    @Expose
    private Integer nextStreamId;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("stream")
    @Expose
    private List<Stream> stream = new ArrayList<Stream>();

    /**
     * 
     * @return
     *     The nextStreamId
     */
    public Integer getNextStreamId() {
        return nextStreamId;
    }

    /**
     * 
     * @param nextStreamId
     *     The next_stream_id
     */
    public void setNextStreamId(Integer nextStreamId) {
        this.nextStreamId = nextStreamId;
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
     *     The stream
     */
    public List<Stream> getStream() {
        return stream;
    }

    /**
     * 
     * @param stream
     *     The stream
     */
    public void setStream(List<Stream> stream) {
        this.stream = stream;
    }

}
