
package com.syscow.jobseeker.model.adzuna;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "title",
    "created",
    "location",
    "company",
    "longitude",
    "salary_is_predicted",
    "__CLASS__",
    "salary_min",
    "latitude",
    "salary_max",
    "description",
    "category",
    "redirect_url",
    "adref",
    "contract_time",
    "contract_type"
})
@Generated("jsonschema2pojo")
public class Result {

    @JsonProperty("id")
    private String id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("created")
    private String created;
    @JsonProperty("location")
    private Location location;
    @JsonProperty("company")
    private Company company;
    @JsonProperty("longitude")
    private Double longitude;
    @JsonProperty("salary_is_predicted")
    private String salaryIsPredicted;
    @JsonProperty("__CLASS__")
    private String _class;
    @JsonProperty("salary_min")
    private Integer salaryMin;
    @JsonProperty("latitude")
    private Double latitude;
    @JsonProperty("salary_max")
    private Integer salaryMax;
    @JsonProperty("description")
    private String description;
    @JsonProperty("category")
    private Category category;
    @JsonProperty("redirect_url")
    private String redirectUrl;
    @JsonProperty("adref")
    private String adref;
    @JsonProperty("contract_time")
    private String contractTime;
    @JsonProperty("contract_type")
    private String contractType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("created")
    public String getCreated() {
        return created;
    }

    @JsonProperty("created")
    public void setCreated(String created) {
        this.created = created;
    }

    @JsonProperty("location")
    public Location getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(Location location) {
        this.location = location;
    }

    @JsonProperty("company")
    public Company getCompany() {
        return company;
    }

    @JsonProperty("company")
    public void setCompany(Company company) {
        this.company = company;
    }

    @JsonProperty("longitude")
    public Double getLongitude() {
        return longitude;
    }

    @JsonProperty("longitude")
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @JsonProperty("salary_is_predicted")
    public String getSalaryIsPredicted() {
        return salaryIsPredicted;
    }

    @JsonProperty("salary_is_predicted")
    public void setSalaryIsPredicted(String salaryIsPredicted) {
        this.salaryIsPredicted = salaryIsPredicted;
    }

    @JsonProperty("__CLASS__")
    public String getClass_() {
        return _class;
    }

    @JsonProperty("__CLASS__")
    public void setClass_(String _class) {
        this._class = _class;
    }

    @JsonProperty("salary_min")
    public Integer getSalaryMin() {
        return salaryMin;
    }

    @JsonProperty("salary_min")
    public void setSalaryMin(Integer salaryMin) {
        this.salaryMin = salaryMin;
    }

    @JsonProperty("latitude")
    public Double getLatitude() {
        return latitude;
    }

    @JsonProperty("latitude")
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @JsonProperty("salary_max")
    public Integer getSalaryMax() {
        return salaryMax;
    }

    @JsonProperty("salary_max")
    public void setSalaryMax(Integer salaryMax) {
        this.salaryMax = salaryMax;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("category")
    public Category getCategory() {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(Category category) {
        this.category = category;
    }

    @JsonProperty("redirect_url")
    public String getRedirectUrl() {
        return redirectUrl;
    }

    @JsonProperty("redirect_url")
    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    @JsonProperty("adref")
    public String getAdref() {
        return adref;
    }

    @JsonProperty("adref")
    public void setAdref(String adref) {
        this.adref = adref;
    }

    @JsonProperty("contract_time")
    public String getContractTime() {
        return contractTime;
    }

    @JsonProperty("contract_time")
    public void setContractTime(String contractTime) {
        this.contractTime = contractTime;
    }

    @JsonProperty("contract_type")
    public String getContractType() {
        return contractType;
    }

    @JsonProperty("contract_type")
    public void setContractType(String contractType) {
        this.contractType = contractType;
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
        StringBuilder sb = new StringBuilder();
        sb.append(Result.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("title");
        sb.append('=');
        sb.append(((this.title == null)?"<null>":this.title));
        sb.append(',');
        sb.append("created");
        sb.append('=');
        sb.append(((this.created == null)?"<null>":this.created));
        sb.append(',');
        sb.append("location");
        sb.append('=');
        sb.append(((this.location == null)?"<null>":this.location));
        sb.append(',');
        sb.append("company");
        sb.append('=');
        sb.append(((this.company == null)?"<null>":this.company));
        sb.append(',');
        sb.append("longitude");
        sb.append('=');
        sb.append(((this.longitude == null)?"<null>":this.longitude));
        sb.append(',');
        sb.append("salaryIsPredicted");
        sb.append('=');
        sb.append(((this.salaryIsPredicted == null)?"<null>":this.salaryIsPredicted));
        sb.append(',');
        sb.append("_class");
        sb.append('=');
        sb.append(((this._class == null)?"<null>":this._class));
        sb.append(',');
        sb.append("salaryMin");
        sb.append('=');
        sb.append(((this.salaryMin == null)?"<null>":this.salaryMin));
        sb.append(',');
        sb.append("latitude");
        sb.append('=');
        sb.append(((this.latitude == null)?"<null>":this.latitude));
        sb.append(',');
        sb.append("salaryMax");
        sb.append('=');
        sb.append(((this.salaryMax == null)?"<null>":this.salaryMax));
        sb.append(',');
        sb.append("description");
        sb.append('=');
        sb.append(((this.description == null)?"<null>":this.description));
        sb.append(',');
        sb.append("category");
        sb.append('=');
        sb.append(((this.category == null)?"<null>":this.category));
        sb.append(',');
        sb.append("redirectUrl");
        sb.append('=');
        sb.append(((this.redirectUrl == null)?"<null>":this.redirectUrl));
        sb.append(',');
        sb.append("adref");
        sb.append('=');
        sb.append(((this.adref == null)?"<null>":this.adref));
        sb.append(',');
        sb.append("contractTime");
        sb.append('=');
        sb.append(((this.contractTime == null)?"<null>":this.contractTime));
        sb.append(',');
        sb.append("contractType");
        sb.append('=');
        sb.append(((this.contractType == null)?"<null>":this.contractType));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.redirectUrl == null)? 0 :this.redirectUrl.hashCode()));
        result = ((result* 31)+((this.created == null)? 0 :this.created.hashCode()));
        result = ((result* 31)+((this.contractType == null)? 0 :this.contractType.hashCode()));
        result = ((result* 31)+((this.latitude == null)? 0 :this.latitude.hashCode()));
        result = ((result* 31)+((this.description == null)? 0 :this.description.hashCode()));
        result = ((result* 31)+((this.title == null)? 0 :this.title.hashCode()));
        result = ((result* 31)+((this.salaryIsPredicted == null)? 0 :this.salaryIsPredicted.hashCode()));
        result = ((result* 31)+((this.salaryMax == null)? 0 :this.salaryMax.hashCode()));
        result = ((result* 31)+((this.adref == null)? 0 :this.adref.hashCode()));
        result = ((result* 31)+((this.contractTime == null)? 0 :this.contractTime.hashCode()));
        result = ((result* 31)+((this.location == null)? 0 :this.location.hashCode()));
        result = ((result* 31)+((this.company == null)? 0 :this.company.hashCode()));
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        result = ((result* 31)+((this._class == null)? 0 :this._class.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.category == null)? 0 :this.category.hashCode()));
        result = ((result* 31)+((this.salaryMin == null)? 0 :this.salaryMin.hashCode()));
        result = ((result* 31)+((this.longitude == null)? 0 :this.longitude.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Result) == false) {
            return false;
        }
        Result rhs = ((Result) other);
        return (((((((((((((((((((this.redirectUrl == rhs.redirectUrl)||((this.redirectUrl!= null)&&this.redirectUrl.equals(rhs.redirectUrl)))&&((this.created == rhs.created)||((this.created!= null)&&this.created.equals(rhs.created))))&&((this.contractType == rhs.contractType)||((this.contractType!= null)&&this.contractType.equals(rhs.contractType))))&&((this.latitude == rhs.latitude)||((this.latitude!= null)&&this.latitude.equals(rhs.latitude))))&&((this.description == rhs.description)||((this.description!= null)&&this.description.equals(rhs.description))))&&((this.title == rhs.title)||((this.title!= null)&&this.title.equals(rhs.title))))&&((this.salaryIsPredicted == rhs.salaryIsPredicted)||((this.salaryIsPredicted!= null)&&this.salaryIsPredicted.equals(rhs.salaryIsPredicted))))&&((this.salaryMax == rhs.salaryMax)||((this.salaryMax!= null)&&this.salaryMax.equals(rhs.salaryMax))))&&((this.adref == rhs.adref)||((this.adref!= null)&&this.adref.equals(rhs.adref))))&&((this.contractTime == rhs.contractTime)||((this.contractTime!= null)&&this.contractTime.equals(rhs.contractTime))))&&((this.location == rhs.location)||((this.location!= null)&&this.location.equals(rhs.location))))&&((this.company == rhs.company)||((this.company!= null)&&this.company.equals(rhs.company))))&&((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id))))&&((this._class == rhs._class)||((this._class!= null)&&this._class.equals(rhs._class))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.category == rhs.category)||((this.category!= null)&&this.category.equals(rhs.category))))&&((this.salaryMin == rhs.salaryMin)||((this.salaryMin!= null)&&this.salaryMin.equals(rhs.salaryMin))))&&((this.longitude == rhs.longitude)||((this.longitude!= null)&&this.longitude.equals(rhs.longitude))));
    }

}
