
package com.miguelangeljulvez.forecast.model;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "sources",
    "darksky-stations",
    "lamp-stations",
    "isd-stations",
    "madis-stations",
    "units"
})
public class Flags implements Serializable {

    @JsonProperty("sources")
    private List<String> sources = new ArrayList<String>();
    @JsonProperty("darksky-stations")
    private List<String> darkskyStations = new ArrayList<String>();
    @JsonProperty("lamp-stations")
    private List<String> lampStations = new ArrayList<String>();
    @JsonProperty("isd-stations")
    private List<String> isdStations = new ArrayList<String>();
    @JsonProperty("madis-stations")
    private List<String> madisStations = new ArrayList<String>();
    @JsonProperty("units")
    private String units;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The sources
     */
    @JsonProperty("sources")
    public List<String> getSources() {
        return sources;
    }

    /**
     * 
     * @param sources
     *     The sources
     */
    @JsonProperty("sources")
    public void setSources(List<String> sources) {
        this.sources = sources;
    }

    /**
     * 
     * @return
     *     The darkskyStations
     */
    @JsonProperty("darksky-stations")
    public List<String> getDarkskyStations() {
        return darkskyStations;
    }

    /**
     * 
     * @param darkskyStations
     *     The darksky-stations
     */
    @JsonProperty("darksky-stations")
    public void setDarkskyStations(List<String> darkskyStations) {
        this.darkskyStations = darkskyStations;
    }

    /**
     * 
     * @return
     *     The lampStations
     */
    @JsonProperty("lamp-stations")
    public List<String> getLampStations() {
        return lampStations;
    }

    /**
     * 
     * @param lampStations
     *     The lamp-stations
     */
    @JsonProperty("lamp-stations")
    public void setLampStations(List<String> lampStations) {
        this.lampStations = lampStations;
    }

    /**
     * 
     * @return
     *     The isdStations
     */
    @JsonProperty("isd-stations")
    public List<String> getIsdStations() {
        return isdStations;
    }

    /**
     * 
     * @param isdStations
     *     The isd-stations
     */
    @JsonProperty("isd-stations")
    public void setIsdStations(List<String> isdStations) {
        this.isdStations = isdStations;
    }

    /**
     * 
     * @return
     *     The madisStations
     */
    @JsonProperty("madis-stations")
    public List<String> getMadisStations() {
        return madisStations;
    }

    /**
     * 
     * @param madisStations
     *     The madis-stations
     */
    @JsonProperty("madis-stations")
    public void setMadisStations(List<String> madisStations) {
        this.madisStations = madisStations;
    }

    /**
     * 
     * @return
     *     The units
     */
    @JsonProperty("units")
    public String getUnits() {
        return units;
    }

    /**
     * 
     * @param units
     *     The units
     */
    @JsonProperty("units")
    public void setUnits(String units) {
        this.units = units;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "Flags{" +
                "sources=" + sources +
                ", darkskyStations=" + darkskyStations +
                ", lampStations=" + lampStations +
                ", isdStations=" + isdStations +
                ", madisStations=" + madisStations +
                ", units='" + units + '\'' +
                '}';
    }
}
