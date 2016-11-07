
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
    "sunriseTime",
    "sunsetTime",
    "moonPhase",
    "precipIntensity",
    "precipIntensityMax",
    "precipProbability",
    "temperatureMin",
    "temperatureMinTime",
    "temperatureMax",
    "temperatureMaxTime",
    "apparentTemperatureMin",
    "apparentTemperatureMinTime",
    "apparentTemperatureMax",
    "apparentTemperatureMaxTime",
    "dewPoint",
    "humidity",
    "windSpeed",
    "windBearing",
    "visibility",
    "cloudCover",
    "pressure",
    "ozone",
    "precipIntensityMaxTime",
    "precipType"
})
public class Datum__ implements Serializable {

    @JsonProperty("time")
    private Integer time;
    @JsonProperty("summary")
    private String summary;
    @JsonProperty("icon")
    private String icon;
    @JsonProperty("sunriseTime")
    private Integer sunriseTime;
    @JsonProperty("sunsetTime")
    private Integer sunsetTime;
    @JsonProperty("moonPhase")
    private Double moonPhase;
    @JsonProperty("precipIntensity")
    private Double precipIntensity;
    @JsonProperty("precipIntensityMax")
    private Double precipIntensityMax;
    @JsonProperty("precipProbability")
    private Double precipProbability;
    @JsonProperty("temperatureMin")
    private Double temperatureMin;
    @JsonProperty("temperatureMinTime")
    private Integer temperatureMinTime;
    @JsonProperty("temperatureMax")
    private Double temperatureMax;
    @JsonProperty("temperatureMaxTime")
    private Integer temperatureMaxTime;
    @JsonProperty("apparentTemperatureMin")
    private Double apparentTemperatureMin;
    @JsonProperty("apparentTemperatureMinTime")
    private Integer apparentTemperatureMinTime;
    @JsonProperty("apparentTemperatureMax")
    private Double apparentTemperatureMax;
    @JsonProperty("apparentTemperatureMaxTime")
    private Integer apparentTemperatureMaxTime;
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
    @JsonProperty("precipIntensityMaxTime")
    private Integer precipIntensityMaxTime;
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
     *     The sunriseTime
     */
    @JsonProperty("sunriseTime")
    public Integer getSunriseTime() {
        return sunriseTime;
    }

    /**
     * 
     * @param sunriseTime
     *     The sunriseTime
     */
    @JsonProperty("sunriseTime")
    public void setSunriseTime(Integer sunriseTime) {
        this.sunriseTime = sunriseTime;
    }

    /**
     * 
     * @return
     *     The sunsetTime
     */
    @JsonProperty("sunsetTime")
    public Integer getSunsetTime() {
        return sunsetTime;
    }

    /**
     * 
     * @param sunsetTime
     *     The sunsetTime
     */
    @JsonProperty("sunsetTime")
    public void setSunsetTime(Integer sunsetTime) {
        this.sunsetTime = sunsetTime;
    }

    /**
     * 
     * @return
     *     The moonPhase
     */
    @JsonProperty("moonPhase")
    public Double getMoonPhase() {
        return moonPhase;
    }

    /**
     * 
     * @param moonPhase
     *     The moonPhase
     */
    @JsonProperty("moonPhase")
    public void setMoonPhase(Double moonPhase) {
        this.moonPhase = moonPhase;
    }

    /**
     * 
     * @return
     *     The precipIntensity
     */
    @JsonProperty("precipIntensity")
    public Double getPrecipIntensity() {
        return precipIntensity;
    }

    /**
     * 
     * @param precipIntensity
     *     The precipIntensity
     */
    @JsonProperty("precipIntensity")
    public void setPrecipIntensity(Double precipIntensity) {
        this.precipIntensity = precipIntensity;
    }

    /**
     * 
     * @return
     *     The precipIntensityMax
     */
    @JsonProperty("precipIntensityMax")
    public Double getPrecipIntensityMax() {
        return precipIntensityMax;
    }

    /**
     * 
     * @param precipIntensityMax
     *     The precipIntensityMax
     */
    @JsonProperty("precipIntensityMax")
    public void setPrecipIntensityMax(Double precipIntensityMax) {
        this.precipIntensityMax = precipIntensityMax;
    }

    /**
     * 
     * @return
     *     The precipProbability
     */
    @JsonProperty("precipProbability")
    public Double getPrecipProbability() {
        return precipProbability;
    }

    /**
     * 
     * @param precipProbability
     *     The precipProbability
     */
    @JsonProperty("precipProbability")
    public void setPrecipProbability(Double precipProbability) {
        this.precipProbability = precipProbability;
    }

    /**
     * 
     * @return
     *     The temperatureMin
     */
    @JsonProperty("temperatureMin")
    public Double getTemperatureMin() {
        return temperatureMin;
    }

    /**
     * 
     * @param temperatureMin
     *     The temperatureMin
     */
    @JsonProperty("temperatureMin")
    public void setTemperatureMin(Double temperatureMin) {
        this.temperatureMin = temperatureMin;
    }

    /**
     * 
     * @return
     *     The temperatureMinTime
     */
    @JsonProperty("temperatureMinTime")
    public Integer getTemperatureMinTime() {
        return temperatureMinTime;
    }

    /**
     * 
     * @param temperatureMinTime
     *     The temperatureMinTime
     */
    @JsonProperty("temperatureMinTime")
    public void setTemperatureMinTime(Integer temperatureMinTime) {
        this.temperatureMinTime = temperatureMinTime;
    }

    /**
     * 
     * @return
     *     The temperatureMax
     */
    @JsonProperty("temperatureMax")
    public Double getTemperatureMax() {
        return temperatureMax;
    }

    /**
     * 
     * @param temperatureMax
     *     The temperatureMax
     */
    @JsonProperty("temperatureMax")
    public void setTemperatureMax(Double temperatureMax) {
        this.temperatureMax = temperatureMax;
    }

    /**
     * 
     * @return
     *     The temperatureMaxTime
     */
    @JsonProperty("temperatureMaxTime")
    public Integer getTemperatureMaxTime() {
        return temperatureMaxTime;
    }

    /**
     * 
     * @param temperatureMaxTime
     *     The temperatureMaxTime
     */
    @JsonProperty("temperatureMaxTime")
    public void setTemperatureMaxTime(Integer temperatureMaxTime) {
        this.temperatureMaxTime = temperatureMaxTime;
    }

    /**
     * 
     * @return
     *     The apparentTemperatureMin
     */
    @JsonProperty("apparentTemperatureMin")
    public Double getApparentTemperatureMin() {
        return apparentTemperatureMin;
    }

    /**
     * 
     * @param apparentTemperatureMin
     *     The apparentTemperatureMin
     */
    @JsonProperty("apparentTemperatureMin")
    public void setApparentTemperatureMin(Double apparentTemperatureMin) {
        this.apparentTemperatureMin = apparentTemperatureMin;
    }

    /**
     * 
     * @return
     *     The apparentTemperatureMinTime
     */
    @JsonProperty("apparentTemperatureMinTime")
    public Integer getApparentTemperatureMinTime() {
        return apparentTemperatureMinTime;
    }

    /**
     * 
     * @param apparentTemperatureMinTime
     *     The apparentTemperatureMinTime
     */
    @JsonProperty("apparentTemperatureMinTime")
    public void setApparentTemperatureMinTime(Integer apparentTemperatureMinTime) {
        this.apparentTemperatureMinTime = apparentTemperatureMinTime;
    }

    /**
     * 
     * @return
     *     The apparentTemperatureMax
     */
    @JsonProperty("apparentTemperatureMax")
    public Double getApparentTemperatureMax() {
        return apparentTemperatureMax;
    }

    /**
     * 
     * @param apparentTemperatureMax
     *     The apparentTemperatureMax
     */
    @JsonProperty("apparentTemperatureMax")
    public void setApparentTemperatureMax(Double apparentTemperatureMax) {
        this.apparentTemperatureMax = apparentTemperatureMax;
    }

    /**
     * 
     * @return
     *     The apparentTemperatureMaxTime
     */
    @JsonProperty("apparentTemperatureMaxTime")
    public Integer getApparentTemperatureMaxTime() {
        return apparentTemperatureMaxTime;
    }

    /**
     * 
     * @param apparentTemperatureMaxTime
     *     The apparentTemperatureMaxTime
     */
    @JsonProperty("apparentTemperatureMaxTime")
    public void setApparentTemperatureMaxTime(Integer apparentTemperatureMaxTime) {
        this.apparentTemperatureMaxTime = apparentTemperatureMaxTime;
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
     *     The precipIntensityMaxTime
     */
    @JsonProperty("precipIntensityMaxTime")
    public Integer getPrecipIntensityMaxTime() {
        return precipIntensityMaxTime;
    }

    /**
     * 
     * @param precipIntensityMaxTime
     *     The precipIntensityMaxTime
     */
    @JsonProperty("precipIntensityMaxTime")
    public void setPrecipIntensityMaxTime(Integer precipIntensityMaxTime) {
        this.precipIntensityMaxTime = precipIntensityMaxTime;
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
        return "Datum__{" +
                "time=" + time +
                ", summary='" + summary + '\'' +
                ", icon='" + icon + '\'' +
                ", sunriseTime=" + sunriseTime +
                ", sunsetTime=" + sunsetTime +
                ", moonPhase=" + moonPhase +
                ", precipIntensity=" + precipIntensity +
                ", precipIntensityMax=" + precipIntensityMax +
                ", precipProbability=" + precipProbability +
                ", temperatureMin=" + temperatureMin +
                ", temperatureMinTime=" + temperatureMinTime +
                ", temperatureMax=" + temperatureMax +
                ", temperatureMaxTime=" + temperatureMaxTime +
                ", apparentTemperatureMin=" + apparentTemperatureMin +
                ", apparentTemperatureMinTime=" + apparentTemperatureMinTime +
                ", apparentTemperatureMax=" + apparentTemperatureMax +
                ", apparentTemperatureMaxTime=" + apparentTemperatureMaxTime +
                ", dewPoint=" + dewPoint +
                ", humidity=" + humidity +
                ", windSpeed=" + windSpeed +
                ", windBearing=" + windBearing +
                ", visibility=" + visibility +
                ", cloudCover=" + cloudCover +
                ", pressure=" + pressure +
                ", ozone=" + ozone +
                ", precipIntensityMaxTime=" + precipIntensityMaxTime +
                ", precipType='" + precipType + '\'' +
                '}';
    }
}
