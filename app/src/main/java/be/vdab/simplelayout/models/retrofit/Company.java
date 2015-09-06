package be.vdab.simplelayout.models.retrofit;

import com.google.gson.annotations.Expose;

/**
 * Created by RWIL on 06/09/2015.
 */
public class Company {

    @Expose
    private String name;
    @Expose
    private String catchPhrase;
    @Expose
    private String bs;

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The catchPhrase
     */
    public String getCatchPhrase() {
        return catchPhrase;
    }

    /**
     *
     * @param catchPhrase
     * The catchPhrase
     */
    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    /**
     *
     * @return
     * The bs
     */
    public String getBs() {
        return bs;
    }

    /**
     *
     * @param bs
     * The bs
     */
    public void setBs(String bs) {
        this.bs = bs;
    }

}
