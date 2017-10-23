package pojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"id", "order", "created", "totalMoney", "paidMoney", "manager"})
@XmlRootElement(name = "Invoice")
public class Invoice {
    private int id;
    private Order order;
    private String created;
    private double totalMoney;
    private double paidMoney;
    private String manager;

    public Invoice() {
    }

    public Invoice(Order order, String created, double totalMoney, double paidMoney, String manager) {
        this.order = order;
        this.created = created;
        this.totalMoney = totalMoney;
        this.paidMoney = paidMoney;
        this.manager = manager;
    }

    public int getId() {
        return id;
    }

    @XmlElement
    public void setId(int id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    @XmlElement
    public void setOrder(Order order) {
        this.order = order;
    }

    public String getCreated() {
        return created;
    }

    @XmlElement
    public void setCreated(String created) {
        this.created = created;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    @XmlElement
    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public double getPaidMoney() {
        return paidMoney;
    }

    @XmlElement
    public void setPaidMoney(double paidMoney) {
        this.paidMoney = paidMoney;
    }

    public String getManager() {
        return manager;
    }

    @XmlElement
    public void setManager(String manager) {
        this.manager = manager;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Invoice invoice = (Invoice) o;

        if (id != invoice.id) return false;
        if (Double.compare(invoice.totalMoney, totalMoney) != 0) return false;
        if (Double.compare(invoice.paidMoney, paidMoney) != 0) return false;
        if (!order.equals(invoice.order)) return false;
        if (!created.equals(invoice.created)) return false;
        return manager.equals(invoice.manager);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + order.hashCode();
        result = 31 * result + created.hashCode();
        temp = Double.doubleToLongBits(totalMoney);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(paidMoney);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + manager.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", order=" + order +
                ", created=" + created +
                ", totalMoney=" + totalMoney +
                ", paidMoney=" + paidMoney +
                ", manager='" + manager + '\'' +
                '}';
    }
}
