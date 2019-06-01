
package com.jli.bestlife.api.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("effective_time")
    @Expose
    private String effectiveTime;
    @SerializedName("inactive_ingredient")
    @Expose
    private List<String> inactiveIngredient = null;
    @SerializedName("purpose")
    @Expose
    private List<String> purpose = null;
    @SerializedName("keep_out_of_reach_of_children")
    @Expose
    private List<String> keepOutOfReachOfChildren = null;
    @SerializedName("warnings")
    @Expose
    private List<String> warnings = null;
    @SerializedName("when_using")
    @Expose
    private List<String> whenUsing = null;
    @SerializedName("spl_product_data_elements")
    @Expose
    private List<String> splProductDataElements = null;
    @SerializedName("ask_doctor")
    @Expose
    private List<String> askDoctor = null;
    @SerializedName("other_safety_information")
    @Expose
    private List<String> otherSafetyInformation = null;
    @SerializedName("openfda")
    @Expose
    private Openfda openfda;
    @SerializedName("version")
    @Expose
    private String version;
    @SerializedName("dosage_and_administration")
    @Expose
    private List<String> dosageAndAdministration = null;
    @SerializedName("pregnancy_or_breast_feeding")
    @Expose
    private List<String> pregnancyOrBreastFeeding = null;
    @SerializedName("do_not_use")
    @Expose
    private List<String> doNotUse = null;
    @SerializedName("package_label_principal_display_panel")
    @Expose
    private List<String> packageLabelPrincipalDisplayPanel = null;
    @SerializedName("indications_and_usage")
    @Expose
    private List<String> indicationsAndUsage = null;
    @SerializedName("set_id")
    @Expose
    private String setId;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("ask_doctor_or_pharmacist")
    @Expose
    private List<String> askDoctorOrPharmacist = null;
    @SerializedName("active_ingredient")
    @Expose
    private List<String> activeIngredient = null;
    @SerializedName("dosage_and_administration_table")
    @Expose
    private List<String> dosageAndAdministrationTable = null;

    public String getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(String effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public List<String> getInactiveIngredient() {
        return inactiveIngredient;
    }

    public void setInactiveIngredient(List<String> inactiveIngredient) {
        this.inactiveIngredient = inactiveIngredient;
    }

    public List<String> getPurpose() {
        return purpose;
    }

    public void setPurpose(List<String> purpose) {
        this.purpose = purpose;
    }

    public List<String> getKeepOutOfReachOfChildren() {
        return keepOutOfReachOfChildren;
    }

    public void setKeepOutOfReachOfChildren(List<String> keepOutOfReachOfChildren) {
        this.keepOutOfReachOfChildren = keepOutOfReachOfChildren;
    }

    public List<String> getWarnings() {
        return warnings;
    }

    public void setWarnings(List<String> warnings) {
        this.warnings = warnings;
    }

    public List<String> getWhenUsing() {
        return whenUsing;
    }

    public void setWhenUsing(List<String> whenUsing) {
        this.whenUsing = whenUsing;
    }

    public List<String> getSplProductDataElements() {
        return splProductDataElements;
    }

    public void setSplProductDataElements(List<String> splProductDataElements) {
        this.splProductDataElements = splProductDataElements;
    }

    public List<String> getAskDoctor() {
        return askDoctor;
    }

    public void setAskDoctor(List<String> askDoctor) {
        this.askDoctor = askDoctor;
    }

    public List<String> getOtherSafetyInformation() {
        return otherSafetyInformation;
    }

    public void setOtherSafetyInformation(List<String> otherSafetyInformation) {
        this.otherSafetyInformation = otherSafetyInformation;
    }

    public Openfda getOpenfda() {
        return openfda;
    }

    public void setOpenfda(Openfda openfda) {
        this.openfda = openfda;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<String> getDosageAndAdministration() {
        return dosageAndAdministration;
    }

    public void setDosageAndAdministration(List<String> dosageAndAdministration) {
        this.dosageAndAdministration = dosageAndAdministration;
    }

    public List<String> getPregnancyOrBreastFeeding() {
        return pregnancyOrBreastFeeding;
    }

    public void setPregnancyOrBreastFeeding(List<String> pregnancyOrBreastFeeding) {
        this.pregnancyOrBreastFeeding = pregnancyOrBreastFeeding;
    }

    public List<String> getDoNotUse() {
        return doNotUse;
    }

    public void setDoNotUse(List<String> doNotUse) {
        this.doNotUse = doNotUse;
    }

    public List<String> getPackageLabelPrincipalDisplayPanel() {
        return packageLabelPrincipalDisplayPanel;
    }

    public void setPackageLabelPrincipalDisplayPanel(List<String> packageLabelPrincipalDisplayPanel) {
        this.packageLabelPrincipalDisplayPanel = packageLabelPrincipalDisplayPanel;
    }

    public List<String> getIndicationsAndUsage() {
        return indicationsAndUsage;
    }

    public void setIndicationsAndUsage(List<String> indicationsAndUsage) {
        this.indicationsAndUsage = indicationsAndUsage;
    }

    public String getSetId() {
        return setId;
    }

    public void setSetId(String setId) {
        this.setId = setId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getAskDoctorOrPharmacist() {
        return askDoctorOrPharmacist;
    }

    public void setAskDoctorOrPharmacist(List<String> askDoctorOrPharmacist) {
        this.askDoctorOrPharmacist = askDoctorOrPharmacist;
    }

    public List<String> getActiveIngredient() {
        return activeIngredient;
    }

    public void setActiveIngredient(List<String> activeIngredient) {
        this.activeIngredient = activeIngredient;
    }

    public List<String> getDosageAndAdministrationTable() {
        return dosageAndAdministrationTable;
    }

    public void setDosageAndAdministrationTable(List<String> dosageAndAdministrationTable) {
        this.dosageAndAdministrationTable = dosageAndAdministrationTable;
    }

}
