package jpabook.jpashop.domain;

import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class Adress {
    private String city;
    private String street;
    private String zipcode;


    public Adress(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

    public Adress() {
    }

    public String getCity() {
        return city;
    }


    public String getStreet() {
        return street;
    }


    public String getZipcode() {
        return zipcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Adress adress = (Adress) o;
        return Objects.equals(city, adress.city) && Objects.equals(street, adress.street) && Objects.equals(zipcode, adress.zipcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, zipcode);
    }
}
