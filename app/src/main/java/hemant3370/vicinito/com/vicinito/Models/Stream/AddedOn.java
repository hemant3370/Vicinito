
package hemant3370.vicinito.com.vicinito.Models.Stream;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class AddedOn {

    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("format")
    @Expose
    private String format;

    /**
     * 
     * @return
     *     The date
     */
    public String getDate() {
        return date;
    }

    /**
     * 
     * @param date
     *     The date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * 
     * @return
     *     The format
     */
    public String getFormat() {
        return format;
    }

    /**
     * 
     * @param format
     *     The format
     */
    public void setFormat(String format) {
        this.format = format;
    }

}
