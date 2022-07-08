package praktikum.model;

import praktikum.model.constants.Color;

public class AboutRentData {

    private final int date;
    private final String period;
    private final String colorName;
    private final String comment;

    public AboutRentData(int date, String period, String colorName, String comment) {
        this.date = date;
        this.period = period;
        this.colorName = colorName;
        this.comment = comment;
    }

    public int getDate() {
        return date;
    }

    public String getPeriod() {
        return period;
    }

    public String getColor() {
        return colorName;
    }

    public String getComment() {
        return comment;
    }

}
