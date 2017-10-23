package pojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.time.LocalDate;

@XmlRootElement(name = "Customer")
@XmlType(propOrder = {"id", "firstName", "secondName", "phone", "address", "nick"})
public class Customer {
    private int id;
    private String firstName;
    private String secondName;
    private String phone;
    private String address;
    private String nick;

    public Customer() {
    }

    public Customer(int id, String firstName, String secondName, String phone, String address, String nick) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.phone = phone;
        this.address = address;
        this.nick = nick;
    }

    public int getId() {
        return id;
    }

    @XmlElement
    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    @XmlElement
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    @XmlElement
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPhone() {
        return phone;
    }

    @XmlElement
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    @XmlElement
    public void setAddress(String address) {
        this.address = address;
    }

    public String getNick() {
        return nick;
    }

    @XmlElement
    public void setNick(String nick) {
        this.nick = nick;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (!firstName.equals(customer.firstName)) return false;
        if (!secondName.equals(customer.secondName)) return false;
        if (!phone.equals(customer.phone)) return false;
        if (!address.equals(customer.address)) return false;
        return nick.equals(customer.nick);
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + secondName.hashCode();
        result = 31 * result + phone.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + nick.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", nick='" + nick + '\'' +
                '}';
    }
}

