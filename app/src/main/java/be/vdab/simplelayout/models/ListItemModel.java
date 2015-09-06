package be.vdab.simplelayout.models;

/**
 * Created by RWIL on 04/09/2015.
 */
public class ListItemModel {
    String mTitle;
    String mContent;
    String mUrl;

    public ListItemModel(String mTitle, String mContent, String mUrl) {
        this.mTitle = mTitle;
        this.mContent = mContent;
        this.mUrl = mUrl;
    }

    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmContent() {
        return mContent;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent;
    }

}
