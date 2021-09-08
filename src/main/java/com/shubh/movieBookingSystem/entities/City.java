package com.shubh.movieBookingSystem.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;


@Entity
public class City {
    @Id
    @GeneratedValue
    private int cityId;

    @Column(length = 20, nullable = false)
    private String cityName;

    /**
     * Default fetch strategy will be lazy
     */
    @OneToMany(mappedBy = "city", fetch = FetchType.EAGER)
    @JsonBackReference
    private Set<Theatre> theatres;

    public City() {}


    public City(int cityId, String cityName) {
        this.cityId = cityId;
        this.cityName = cityName;
    }

    public City(String cityName) {
        this.cityName = cityName;
    }

    public Set<Theatre> getTheatres() {
        return theatres;
    }

    public void setTheatres(Set<Theatre> theatres) {
        this.theatres = theatres;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "City{" + "cityId=" + cityId + ", cityName='" + cityName + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return cityName.equals(city.cityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityName);
    }
}
