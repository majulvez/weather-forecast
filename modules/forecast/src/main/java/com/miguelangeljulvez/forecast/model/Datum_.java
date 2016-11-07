
package com.miguelangeljulvez.forecast.model;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "time",
    "summary",
    "icon",
    "precipIntensity",
    "precipProbability",
    "temperature",
    "apparentTemperature",
    "dewPoint",
    "humidity",
    "windSpeed",
    "windBearing",
    "visibility",
    "cloudCover",
    "pressure",
    "ozone",
    "precipType"
})
public class Datum_ implements Serializable  {

    @JsonProperty("time")
    private Integer time;
    @JsonProperty("summary")
    private String summary;
    @JsonProperty("icon")
    private String icon;
    @JsonProperty("precipIntensity")
    private Integer precipIntensity;
    @JsonProperty("precipProbability")
    private Integer precipProbability;
    @JsonProperty("temperature")
    private Double temperature;
    @JsonProperty("apparentTemperature")
    private Double apparentTemperature;
    @JsonProperty("dewPoint")
    private Double dewPoint;
    @JsonProperty("humidity")
    private Double humidity;
    @JsonProperty("windSpeed")
    private Double windSpeed;
    @JsonProperty("windBearing")
    private Integer windBearing;
    @JsonProperty("visibility")
    private Integer visibility;
    @JsonProperty("cloudCover")
    private Double cloudCover;
    @JsonProperty("pressure")
    private Double pressure;
    @JsonProperty("ozone")
    private Double ozone;
    @JsonProperty("precipType")
    private String precipType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The time
     */
    @JsonProperty("time")
    public Integer getTime() {
        return time;
    }

    /**
     * 
     * @param time
     *     The time
     */
    @JsonProperty("time")
    public void setTime(Integer time) {
        this.time = time;
    }

    /**
     * 
     * @return
     *     The summary
     */
    @JsonProperty("summary")
    public String getSummary() {
        return summary;
    }

    /**
     * 
     * @param summary
     *     The summary
     */
    @JsonProperty("summary")
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * 
     * @return
     *     The icon
     */
    @JsonProperty("icon")
    public String getIcon() {
        return icon;
    }

    /**
     * 
     * @param icon
     *     The icon
     */
    @JsonProperty("icon")
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 
     * @return
     *     The precipIntensity
     */
    @JsonProperty("precipIntensity")
    public Integer getPrecipIntensity() {
        return precipIntensity;
    }

    /**
     * 
     * @param precipIntensity
     *     The precipIntensity
     */
    @JsonProperty("precipIntensity")
    public void setPrecipIntensity(Integer precipIntensity) {
        this.precipIntensity = precipIntensity;
    }

    /**
     * 
     * @return
     *     The precipProbability
     */
    @JsonProperty("precipProbability")
    public Integer getPrecipProbability() {
        return precipProbability;
    }

    /**
     * 
     * @param precipProbability
     *     The precipProbability
     */
    @JsonProperty("precipProbability")
    public void setPrecipProbability(Integer precipProbability) {
        this.precipProbability = precipProbability;
    }

    /**
     * 
     * @return
     *     The temperature
     */
    @JsonProperty("temperature")
    public Double getTemperature() {
        return temperature;
    }

    /**
     * 
     * @param temperature
     *     The temperature
     */
    @JsonProperty("temperature")
    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    /**
     * 
     * @return
     *     The apparentTemperature
     */
    @JsonProperty("apparentTemperature")
    public Double getApparentTemperature() {
        return apparentTemperature;
    }

    /**
     * 
     * @param apparentTemperature
     *     The apparentTemperature
     */
    @JsonProperty("apparentTemperature")
    public void setApparentTemperature(Double apparentTemperature) {
        this.apparentTemperature = apparentTemperature;
    }

    /**
     * 
     * @return
     *     The dewPoint
     */
    @JsonProperty("dewPoint")
    public Double getDewPoint() {
        return dewPoint;
    }

    /**
     * 
     * @param dewPoint
     *     The dewPoint
     */
    @JsonProperty("dewPoint")
    public void setDewPoint(Double dewPoint) {
        this.dewPoint = dewPoint;
    }

    /**
     * 
     * @return
     *     The humidity
     */
    @JsonProperty("humidity")
    public Double getHumidity() {
        return humidity;
    }

    /**
     * 
     * @param humidity
     *     The humidity
     */
    @JsonProperty("humidity")
    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    /**
     * 
     * @return
     *     The windSpeed
     */
    @JsonProperty("windSpeed")
    public Double getWindSpeed() {
        return windSpeed;
    }

    /**
     * 
     * @param windSpeed
     *     The windSpeed
     */
    @JsonProperty("windSpeed")
    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    /**
     * 
     * @return
     *     The windBearing
     */
    @JsonProperty("windBearing")
    public Integer getWindBearing() {
        return windBearing;
    }

    /**
     * 
     * @param windBearing
     *     The windBearing
     */
    @JsonProperty("windBearing")
    public void setWindBearing(Integer windBearing) {
        this.windBearing = windBearing;
    }

    /**
     * 
     * @return
     *     The visibility
     */
    @JsonProperty("visibility")
    public Integer getVisibility() {
        return visibility;
    }

    /**
     * 
     * @param visibility
     *     The visibility
     */
    @JsonProperty("visibility")
    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    /**
     * 
     * @return
     *     The cloudCover
     */
    @JsonProperty("cloudCover")
    public Double getCloudCover() {
        return cloudCover;
    }

    /**
     * 
     * @param cloudCover
     *     The cloudCover
     */
    @JsonProperty("cloudCover")
    public void setCloudCover(Double cloudCover) {
        this.cloudCover = cloudCover;
    }

    /**
     * 
     * @return
     *     The pressure
     */
    @JsonProperty("pressure")
    public Double getPressure() {
        return pressure;
    }

    /**
     * 
     * @param pressure
     *     The pressure
     */
    @JsonProperty("pressure")
    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    /**
     * 
     * @return
     *     The ozone
     */
    @JsonProperty("ozone")
    public Double getOzone() {
        return ozone;
    }

    /**
     * 
     * @param ozone
     *     The ozone
     */
    @JsonProperty("ozone")
    public void setOzone(Double ozone) {
        this.ozone = ozone;
    }

    /**
     * 
     * @return
     *     The precipType
     */
    @JsonProperty("precipType")
    public String getPrecipType() {
        return precipType;
    }

    /**
     * 
     * @param precipType
     *     The precipType
     */
    @JsonProperty("precipType")
    public void setPrecipType(String precipType) {
        this.precipType = precipType;
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
        return "Datum_{" +
                "time=" + time +
                ", summary='" + summary + '\'' +
                ", icon='" + icon + '\'' +
                ", precipIntensity=" + precipIntensity +
                ", precipProbability=" + precipProbability +
                ", temperature=" + temperature +
                ", apparentTemperature=" + apparentTemperature +
                ", dewPoint=" + dewPoint +
                ", humidity=" + humidity +
                ", windSpeed=" + windSpeed +
                ", windBearing=" + windBearing +
                ", visibility=" + visibility +
                ", cloudCover=" + cloudCover +
                ", pressure=" + pressure +
                ", ozone=" + ozone +
                ", precipType='" + precipType + '\'' +
                '}';
    }
}
