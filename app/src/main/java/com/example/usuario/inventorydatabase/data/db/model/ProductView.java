package com.example.usuario.inventorydatabase.data.db.model;

/**
 * Created by usuario on 1/02/18.
 */

public class ProductView {

    private int id;
    private int dependencyId;
    private String serial;
    private String modelCode;
    private String shortname;
    private String description;
    private String categoryName;
    private String productClassDescription;
    private String sectorName;
    private int quantity;
    private float value;
    private String vendor;
    private int bitmap;
    private String imageName;
    private String url;
    private String datePurchase;
    private String notes;

    public ProductView(int id, int dependencyId, String serial, String modelCode, String shortname, String description, String categoryName, String productClassDescription, String sectorName, int quantity, float value, String vendor, int bitmap, String imageName, String url, String datePurchase, String notes) {
        this.id = id;
        this.dependencyId = dependencyId;
        this.serial = serial;
        this.modelCode = modelCode;
        this.shortname = shortname;
        this.description = description;
        this.categoryName = categoryName;
        this.productClassDescription = productClassDescription;
        this.sectorName = sectorName;
        this.quantity = quantity;
        this.value = value;
        this.vendor = vendor;
        this.bitmap = bitmap;
        this.imageName = imageName;
        this.url = url;
        this.datePurchase = datePurchase;
        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDependencyId() {
        return dependencyId;
    }

    public void setDependencyId(int dependencyId) {
        this.dependencyId = dependencyId;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getProductClassDescription() {
        return productClassDescription;
    }

    public void setProductClassDescription(String productClassDescription) {
        this.productClassDescription = productClassDescription;
    }

    public String getSectorName() {
        return sectorName;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public int getBitmap() {
        return bitmap;
    }

    public void setBitmap(int bitmap) {
        this.bitmap = bitmap;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDatePurchase() {
        return datePurchase;
    }

    public void setDatePurchase(String datePurchase) {
        this.datePurchase = datePurchase;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

}
