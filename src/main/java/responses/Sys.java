package responses;

public class Sys {
    private float type;
    private float id;
    private String country;
    private float sunrise;
    private float sunset;
    // Getter Methods
    public float getType() {
        return type;
    }

    public void setType(float type) {
        this.type = type;
    }

    public float getId() {
        return id;
    }

    public void setId(float id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    // Setter Methods

    public void setCountry(String country) {
        this.country = country;
    }

    public float getSunrise() {
        return sunrise;
    }

    public void setSunrise(float sunrise) {
        this.sunrise = sunrise;
    }

    public float getSunset() {
        return sunset;
    }

    public void setSunset(float sunset) {
        this.sunset = sunset;
    }
}
