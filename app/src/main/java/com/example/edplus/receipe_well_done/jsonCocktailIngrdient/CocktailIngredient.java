
package com.example.edplus.receipe_well_done.jsonCocktailIngrdient;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CocktailIngredient {

    @SerializedName("head")
    @Expose
    private Head head;
    @SerializedName("results")
    @Expose
    private Results results;

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public Results getResults() {
        return results;
    }

    public void setResults(Results results) {
        this.results = results;
    }

}
