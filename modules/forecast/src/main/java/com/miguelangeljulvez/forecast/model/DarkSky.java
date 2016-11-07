
package com.miguelangeljulvez.forecast.model;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "latitude",
    "longitude",
    "timezone",
    "offset",
    "currently",
    "minutely",
    "hourly",
    "daily",
    "flags"
})
public class DarkSky implements Serializable {

    private Integer timestamp;
    @JsonProperty("latitude")
    private Double latitude;
    @JsonProperty("longitude")
    private Double longitude;
    @JsonProperty("timezone")
    private String timezone;
    @JsonProperty("offset")
    private Integer offset;
    @JsonProperty("currently")
    private Currently currently;
    @JsonProperty("minutely")
    private Minutely minutely;
    @JsonProperty("hourly")
    private Hourly hourly;
    @JsonProperty("daily")
    private Daily daily;
    @JsonProperty("flags")
    private Flags flags;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * 
     * @return
     *     The latitude
     */
    @JsonProperty("latitude")
    public Double getLatitude() {
        return latitude;
    }

    /**
     * 
     * @param latitude
     *     The latitude
     */
    @JsonProperty("latitude")
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    /**
     * 
     * @return
     *     The longitude
     */
    @JsonProperty("longitude")
    public Double getLongitude() {
        return longitude;
    }

    /**
     * 
     * @param longitude
     *     The longitude
     */
    @JsonProperty("longitude")
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    /**
     * 
     * @return
     *     The timezone
     */
    @JsonProperty("timezone")
    public String getTimezone() {
        return timezone;
    }

    /**
     * 
     * @param timezone
     *     The timezone
     */
    @JsonProperty("timezone")
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    /**
     * 
     * @return
     *     The offset
     */
    @JsonProperty("offset")
    public Integer getOffset() {
        return offset;
    }

    /**
     * 
     * @param offset
     *     The offset
     */
    @JsonProperty("offset")
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    /**
     * 
     * @return
     *     The currently
     */
    @JsonProperty("currently")
    public Currently getCurrently() {
        return currently;
    }

    /**
     * 
     * @param currently
     *     The currently
     */
    @JsonProperty("currently")
    public void setCurrently(Currently currently) {
        this.currently = currently;
    }

    /**
     * 
     * @return
     *     The minutely
     */
    @JsonProperty("minutely")
    public Minutely getMinutely() {
        return minutely;
    }

    /**
     * 
     * @param minutely
     *     The minutely
     */
    @JsonProperty("minutely")
    public void setMinutely(Minutely minutely) {
        this.minutely = minutely;
    }

    /**
     * 
     * @return
     *     The hourly
     */
    @JsonProperty("hourly")
    public Hourly getHourly() {
        return hourly;
    }

    /**
     * 
     * @param hourly
     *     The hourly
     */
    @JsonProperty("hourly")
    public void setHourly(Hourly hourly) {
        this.hourly = hourly;
    }

    /**
     * 
     * @return
     *     The daily
     */
    @JsonProperty("daily")
    public Daily getDaily() {
        return daily;
    }

    /**
     * 
     * @param daily
     *     The daily
     */
    @JsonProperty("daily")
    public void setDaily(Daily daily) {
        this.daily = daily;
    }

    /**
     * 
     * @return
     *     The flags
     */
    @JsonProperty("flags")
    public Flags getFlags() {
        return flags;
    }

    /**
     * 
     * @param flags
     *     The flags
     */
    @JsonProperty("flags")
    public void setFlags(Flags flags) {
        this.flags = flags;
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
        return "DataSky{" +
                "timestamp=" + timestamp +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", timezone='" + timezone + '\'' +
                ", offset=" + offset +
                ", currently=" + currently +
                ", minutely=" + minutely +
                ", hourly=" + hourly +
                ", daily=" + daily +
                ", flags=" + flags +
                '}';
    }

}
