package christmas.model;

public class Day {

    private int date;
    private boolean weekend = false;
    private boolean starDay = false;

    public Day(int date) {
        this.date = date;
        if (date % 7 == 1 | date % 7 == 2) {
            weekend = true;
        }
        if (date % 7 == 3 | date == 25) {
            starDay = true;
        }
    }

    public int getDate() {
        return date;
    }

    public boolean isWeekend() {
        return weekend;
    }

    public boolean isStarDay() {
        return starDay;
    }
}
