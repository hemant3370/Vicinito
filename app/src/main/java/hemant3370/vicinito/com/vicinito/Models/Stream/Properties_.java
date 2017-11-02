
package hemant3370.vicinito.com.vicinito.Models.Stream;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Properties_ {

    @SerializedName("height")
    @Expose
    private Integer height;
    @SerializedName("width")
    @Expose
    private Integer width;
    @SerializedName("colour")
    @Expose
    private String colour;

    /**
     * 
     * @return
     *     The height
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * 
     * @param height
     *     The height
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     * 
     * @return
     *     The width
     */
    public Integer getWidth() {
        return width;
    }

    /**
     * 
     * @param width
     *     The width
     */
    public void setWidth(Integer width) {
        this.width = width;
    }

    /**
     * 
     * @return
     *     The colour
     */
    public String getColour() {
        return colour;
    }

    /**
     * 
     * @param colour
     *     The colour
     */
    public void setColour(String colour) {
        this.colour = colour;
    }

}
