package DBO;

import java.util.Date;

public class DBOCard {
    private int id;
    private String number;
    private String securityNumber;
    private String password;
    private Date dueDate;
    private String brand;
    private String owner;
    private String classification;
    private boolean status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSecurityNumber() {
        return securityNumber;
    }

    public void setSecurityNumber(String securityNumber) {
        this.securityNumber = securityNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String toString() {
        return "DBOCard{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", securityNumber='" + securityNumber + '\'' +
                ", password='" + password + '\'' +
                ", dueDate=" + dueDate +
                ", brand='" + brand + '\'' +
                ", owner='" + owner + '\'' +
                ", classification='" + classification + '\'' +
                ", status=" + status +
                '}';
    }
}
