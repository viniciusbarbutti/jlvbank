package DBO;

import java.util.Date;

public class DBORelease {
    private int id;
    private double value;
    private String type;
    private String description;
    private Date date;
    private int invoice;
    
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getInvoice() {
        return invoice;
    }

    public void setInvoice(int invoice) {
        this.invoice = invoice;
    }

    public String toString() {
        return "DBORelease{" +
                "id=" + id +
                ", value=" + value +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", invoice=" + invoice +
                '}';
    }
}
