package com.usafarmermarkets.backend.entities;

import jakarta.persistence.*;

import java.util.Objects;


@Entity
@Table(name ="farmsmarketdemo")
public class Market {

    // columns elements
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FMID")
    private int FMID;

    @Column(name = "MarketName")
    private String MarketName;

    @Column(name = "Website")
    private String Website;

    @Column(name = "Facebook")
    private String Facebook;

    @Column(name = "Twitter")
    private String Twitter;

    @Column(name = "Youtube")
    private String Youtube;

    @Column(name = "OtherMedia")
    private String OtherMedia;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name = "County")
    private String County;

    @Column(name = "State")
    private String State;

    @Column(name = "zip")
    private String zip;

    @Column(name = "x")
    private float x;

    @Column(name = "y")
    private float y;

    //constructor
    public Market() {

    }

    //getters and setters
    public int getFMID() {
        return FMID;
    }

    public void setFMID(int FMID) {
        this.FMID = FMID;
    }

    public String getMarketName() {
        return MarketName;
    }

    public void setMarketName(String MarketName) {
        this.MarketName = MarketName;
    }

    public String getWebsite() {
        return Website;
    }

    public void setWebsite(String Website) {
        this.Website = Website;
    }

    public String getFacebook() {
        return Facebook;
    }

    public void setFacebook(String Facebook) {
        this.Facebook = Facebook;
    }

    public String getTwitter() {
        return Twitter;
    }

    public void setTwitter(String Twitter) {
        this.Twitter = Twitter;
    }

    public String getYoutube() {
        return Youtube;
    }

    public void setYoutube(String Youtube) {
        this.Youtube = Youtube;
    }

    public String getOtherMedia() {
        return OtherMedia;
    }

    public void setOtherMedia(String OtherMedia) {
        this.OtherMedia = OtherMedia;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return County;
    }

    public void setCounty(String County) {
        this.County = County;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    //toString
    @Override
    public String toString() {
        return "Market{" +
                "FMID=" + FMID +
                ", MarketName='" + MarketName + '\'' +
                ", Website='" + Website + '\'' +
                ", Facebook='" + Facebook + '\'' +
                ", Twitter='" + Twitter + '\'' +
                ", Youtube='" + Youtube + '\'' +
                ", OtherMedia='" + OtherMedia + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", County='" + County + '\'' +
                ", State='" + State + '\'' +
                ", zip='" + zip + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    //hash
    @Override
    public int hashCode() {
        return Objects.hash(FMID, MarketName, Website, Facebook, Twitter, Youtube, OtherMedia, street, city, County, State, zip, x, y);
    }

    //equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Market)) return false;
        Market market = (Market) o;
        return FMID == market.FMID && Float.compare(market.x, x) == 0 && Float.compare(market.y, y) == 0 &&
                MarketName.equals(market.MarketName) && Website.equals(market.Website) && Facebook.equals(market.Facebook) &&
                Twitter.equals(market.Twitter) && Youtube.equals(market.Youtube) && OtherMedia.equals(market.OtherMedia) &&
                street.equals(market.street) && city.equals(market.city) && County.equals(market.County) && State.equals(market.State) && zip.equals(market.zip);
    }

}
