public class Weather {
    private int date;
    private String rain;
    private String clouds;

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getRain() {
        return rain;
    }

    public void setRain(String rain) {
        this.rain = rain;
    }

    public String getClouds() {
        return clouds;
    }

    public void setClouds(String clouds) {
        this.clouds = clouds;
    }

    public Weather(int date, String rain, String clouds) {
        this.date = date;
        this.rain = rain;
        this.clouds = clouds;
    }

    @Override
    public String toString() {
        return "Date: " + this.date + ". Rain: " + this.rain + ". Sky: " + this.clouds + ".";
    }
}
