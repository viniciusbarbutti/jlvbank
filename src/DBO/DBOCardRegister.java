package DBO;

import java.util.Date;

public class DBOCardRegister {
    private int id;
    private String card;
    private boolean statusCard;
    private String event;
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public boolean isStatusCard() {
        return statusCard;
    }

    public void setStatusCard(boolean statusCard) {
        this.statusCard = statusCard;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String toString() {
        return "DBOCardRegister{" +
                "id=" + id +
                ", card='" + card + '\'' +
                ", statusCard=" + statusCard +
                ", event='" + event + '\'' +
                ", date=" + date +
                '}';
    }
}
