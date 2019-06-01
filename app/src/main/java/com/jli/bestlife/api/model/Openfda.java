
package com.jli.bestlife.api.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Openfda {

    @SerializedName("product_ndc")
    @Expose
    private List<String> productNdc = null;
    @SerializedName("is_original_packager")
    @Expose
    private List<Boolean> isOriginalPackager = null;
    @SerializedName("package_ndc")
    @Expose
    private List<String> packageNdc = null;
    @SerializedName("generic_name")
    @Expose
    private List<String> genericName = null;
    @SerializedName("spl_set_id")
    @Expose
    private List<String> splSetId = null;
    @SerializedName("upc")
    @Expose
    private List<String> upc = null;
    @SerializedName("brand_name")
    @Expose
    private List<String> brandName = null;
    @SerializedName("manufacturer_name")
    @Expose
    private List<String> manufacturerName = null;
    @SerializedName("unii")
    @Expose
    private List<String> unii = null;
    @SerializedName("rxcui")
    @Expose
    private List<String> rxcui = null;
    @SerializedName("spl_id")
    @Expose
    private List<String> splId = null;
    @SerializedName("substance_name")
    @Expose
    private List<String> substanceName = null;
    @SerializedName("product_type")
    @Expose
    private List<String> productType = null;
    @SerializedName("route")
    @Expose
    private List<String> route = null;
    @SerializedName("application_number")
    @Expose
    private List<String> applicationNumber = null;

    public List<String> getProductNdc() {
        return productNdc;
    }

    public void setProductNdc(List<String> productNdc) {
        this.productNdc = productNdc;
    }

    public List<Boolean> getIsOriginalPackager() {
        return isOriginalPackager;
    }

    public void setIsOriginalPackager(List<Boolean> isOriginalPackager) {
        this.isOriginalPackager = isOriginalPackager;
    }

    public List<String> getPackageNdc() {
        return packageNdc;
    }

    public void setPackageNdc(List<String> packageNdc) {
        this.packageNdc = packageNdc;
    }

    public List<String> getGenericName() {
        return genericName;
    }

    public void setGenericName(List<String> genericName) {
        this.genericName = genericName;
    }

    public List<String> getSplSetId() {
        return splSetId;
    }

    public void setSplSetId(List<String> splSetId) {
        this.splSetId = splSetId;
    }

    public List<String> getUpc() {
        return upc;
    }

    public void setUpc(List<String> upc) {
        this.upc = upc;
    }

    public List<String> getBrandName() {
        return brandName;
    }

    public void setBrandName(List<String> brandName) {
        this.brandName = brandName;
    }

    public List<String> getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(List<String> manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public List<String> getUnii() {
        return unii;
    }

    public void setUnii(List<String> unii) {
        this.unii = unii;
    }

    public List<String> getRxcui() {
        return rxcui;
    }

    public void setRxcui(List<String> rxcui) {
        this.rxcui = rxcui;
    }

    public List<String> getSplId() {
        return splId;
    }

    public void setSplId(List<String> splId) {
        this.splId = splId;
    }

    public List<String> getSubstanceName() {
        return substanceName;
    }

    public void setSubstanceName(List<String> substanceName) {
        this.substanceName = substanceName;
    }

    public List<String> getProductType() {
        return productType;
    }

    public void setProductType(List<String> productType) {
        this.productType = productType;
    }

    public List<String> getRoute() {
        return route;
    }

    public void setRoute(List<String> route) {
        this.route = route;
    }

    public List<String> getApplicationNumber() {
        return applicationNumber;
    }

    public void setApplicationNumber(List<String> applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

}
