package com.lodoss.newtestproject.app;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Boris on 18/05/16.
 */
public class ListObject {
    @SerializedName("results")
    @Expose
    private List<Item> results = new ArrayList<Item>();

    /**
     *
     * @return
     * The results
     */
    public List<Item> getResults() {
        return results;
    }

    /**
     *
     * @param results
     * The results
     */
    public void setResults(List<Item> results) {
        this.results = results;
    }
}
