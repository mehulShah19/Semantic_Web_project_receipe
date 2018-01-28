
package com.example.edplus.receipe_well_done.jsonCocktailIngrdient;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Binding {

    @SerializedName("isPreparedWith")
    @Expose
    private IsPreparedWith isPreparedWith;

    public IsPreparedWith getIsPreparedWith() {
        return isPreparedWith;
    }

    public void setIsPreparedWith(IsPreparedWith isPreparedWith) {
        this.isPreparedWith = isPreparedWith;
    }

}
