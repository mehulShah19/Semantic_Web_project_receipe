
package com.example.edplus.receipe_well_done.jsonCocktailIngrdient;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Results {

    @SerializedName("bindings")
    @Expose
    private List<Binding> bindings = null;

    public List<Binding> getBindings() {
        return bindings;
    }

    public void setBindings(List<Binding> bindings) {
        this.bindings = bindings;
    }

}
