package ch01;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String name;    // 姓名
    private Vector rentals = new Vector<>(); // 租借紀錄

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vector getRentals() {
        return rentals;
    }

    public void setRentals(Vector rentals) {
        this.rentals = rentals;
    }

    public String statement() {
        int frequentRenterPoints = 0;   // 常客積點
        String result = "Rental Record for " + getName() + "\n";
        Enumeration rentals = this.rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();  // 取得一筆租借紀錄
            // show figures for this rental （顯示此筆租借資料）
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.movie.price.getCharge(each.getDaysRented())) + "\n";
        }

        // add footer lines （結尾列印）
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
        return result;
    }

    public String htmlStatement() {
        Enumeration rentals = this.rentals.elements();
        String result = "<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n";

        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            // show figures for each rental
            result += each.getMovie().getTitle() + ": " + String.valueOf(each.movie.price.getCharge(each.getDaysRented())) + "<BR>\n";
        }
        // add footer lines
        result += "<P>You owe <EM>" + String.valueOf(getTotalCharge()) + "</EM><P>\n";
        result += "On this rental you earned <EM>" + String.valueOf(getTotalFrequentRenterPoints()) + "</EM> frequent renter points<P>";
        return  result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration rentals = this.rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();  // 取得一筆租借紀錄
            result += each.movie.price.getFrequentRenterPoints(each.getDaysRented());
        }
        return result;
    }

    private double getTotalCharge() {
        double result = 0; // 總消費金額
        Enumeration rentals = this.rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();  // 取得一筆租借紀錄
            result += each.movie.price.getCharge(each.getDaysRented());
        }
        return result;
    }
}
