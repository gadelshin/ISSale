package pojo;

import util.Status;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
//import java.time.LocalDate;
import java.util.Map;

@XmlType(propOrder = {"id", "customer", "status", "goods"})
@XmlRootElement(name = "Order")
public class Order {
    private  int id;
    private Customer customer;
//    private String created;
    private Status status;
    private Map<Goods,Integer> goods;

    public Order() {
    }

//    public Order(Customer customer, LocalDate created, Status status, Map<Goods, Integer> goods) {
//        this.customer = customer;
//        this.created = created;
//        this.status = status;
//        this.goods = goods;
//    }

    public Order(Customer customer, Status status, Map<Goods, Integer> goods) {
        this.customer = customer;
//        this.created = created;
        this.status = status;
        this.goods = goods;
    }

    public int getId() {
        return id;
    }

    @XmlElement
    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    @XmlElement
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

//    public String getCreated() {
//    return created;
//}
//
//    @XmlElement
//    public void setCreated(String created) {
//        this.created = created;
//    }

    public Status getStatus() {
        return status;
    }

    @XmlElement
    public void setStatus(Status status) {
        this.status = status;
    }

    public Map<Goods, Integer> getGoods() {
        return goods;
    }

    @XmlElement
    public void setGoods(Map<Goods, Integer> goods) {
        this.goods = goods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (!customer.equals(order.customer)) return false;
//        if (!created.equals(order.created)) return false;
        if (status != order.status) return false;
        return goods.equals(order.goods);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + customer.hashCode();
//        result = 31 * result + created.hashCode();
        result = 31 * result + status.hashCode();
        result = 31 * result + goods.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
//                ", created=" + created +
                ", status=" + status +
                ", goods=" + goods +
                '}';
    }
}
