
package com.example.edplus.receipe_well_done.jsonCocktailIngrdient;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Head {

    @SerializedName("vars")
    @Expose
    private List<String> vars = null;

    public List<String> getVars() {
        return vars;
    }

    public void setVars(List<String> vars) {
        this.vars = vars;
    }

}
