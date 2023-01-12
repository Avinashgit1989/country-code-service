package com.country.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryCode implements Serializable {
    @Id
    @JsonIgnore
    private int Id;
    private String countryName;
    @JsonIgnore
    private String alphaTwoCode;
    private String alphaThreeCode;
    @JsonIgnore
     private int numericval;

}
