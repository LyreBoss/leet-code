package com.share.design;

/**
 * @author Lgq create on 2020-01-28
 */
public class ContextData {

    private Boolean isValid_;
    private Boolean isFirst_;
    private Boolean isBusinessLine_;
    private Boolean district_;

    public Boolean getValid_() {
        return isValid_;
    }

    public void setValid_(Boolean valid_) {
        isValid_ = valid_;
    }

    public Boolean getFirst_() {
        return isFirst_;
    }

    public void setFirst_(Boolean first_) {
        isFirst_ = first_;
    }

    public Boolean getBusinessLine_() {
        return isBusinessLine_;
    }

    public void setBusinessLine_(Boolean businessLine_) {
        isBusinessLine_ = businessLine_;
    }

    public Boolean getDistrict_() {
        return district_;
    }

    public void setDistrict_(Boolean district_) {
        this.district_ = district_;
    }
}
