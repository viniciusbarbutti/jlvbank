package DBO;

import java.util.Date;

public class DBOInvoice {
    private int id;
    private double value;
    private String barCode;
    private String card;
    private Date startDate;
    private Date endDate;
    private Date dueDate;
    private boolean paid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public String toString() {
        return "DBOInvoice{" +
                "id=" + id +
                ", value=" + value +
                ", barCode='" + barCode + '\'' +
                ", card='" + card + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", dueDate=" + dueDate +
                ", paid=" + paid +
                '}';
    }
}
