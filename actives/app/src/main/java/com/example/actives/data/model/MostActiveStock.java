package com.example.actives.data.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.actives.util.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Angelina Fedorova
 */

@Entity(tableName = Constants.TABLE_NAME)
public class MostActiveStock {

    @SerializedName("ticker")
    @Expose
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = Constants.TICKER)
    private String ticker;

    @SerializedName("changes")
    @Expose
    @ColumnInfo(name = Constants.CHANGES)
    private Double changes;

    @SerializedName("price")
    @Expose
    @ColumnInfo(name = Constants.PRICE)
    private Double price;

    @SerializedName("changesPercentage")
    @Expose
    @ColumnInfo(name = Constants.CHANGES_PERCENTAGE)
    private String changesPercentage;

    @SerializedName("companyName")
    @Expose
    @ColumnInfo(name = Constants.COMPANY_NAME)
    private String companyName;

    public MostActiveStock() {
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public Double getChanges() {
        return changes;
    }

    public void setChanges(Double changes) {
        this.changes = changes;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getChangesPercentage() {
        return changesPercentage;
    }

    public void setChangesPercentage(String changesPercentage) {
        this.changesPercentage = changesPercentage;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
