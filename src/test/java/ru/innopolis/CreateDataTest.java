package ru.innopolis;

import pojo.Customer;
import pojo.Goods;
import pojo.Invoice;
import pojo.Order;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.Util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static db.dao.CustomerDAO.InsertNewCustomer;
import static db.dao.GoodsDAO.InsertNewGoods;
import static util.Status.*;

public class CreateDataTest {
    static Customer customer01;
    static Goods goods02;
    static Order order03;
    static Invoice invoice01;

//    public static void main(String[] args) throws Exception {
//    public void xMain() throws Exception {
//        try {
//            CreateDataTest.setUp();
//            CreateDataTest.testMarshalling();
//            CreateDataTest.testUnMarshalling();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    @Before
    public void setUp() throws Exception {


//        Customer customer02 = new Customer("Сергей", "Попов"
//                , "89170064590", "г.Казань, ул.Минская, 13/133","sergen");
//        customer01.setId(2);
//
//        Customer customer03 = new Customer("Сергей", "Марков"
//                , "89170064590", "г.Казань, ул.Тульская, 14/144","sergen");
//        customer01.setId(3);

//        Customer customer04 = new Customer("Алекс", "Стеблов"
//                , "89170064590", "г.Казань, ул.Светлая, 15/155","alexsteb");
//        customer01.setId(4);

//        Customer customer05 = new Customer("Марк", "Кашин"
//                , "89170064590", "г.Казань, ул.Губкина, 16/166","markasha");
//        customer01.setId(5);

//        customer01 = new Customer(resultSet.getInt("id"), resultSet.getString("family"), resultSet.getString("name"), resultSet.getString("phone"), resultSet.getString("address"));
        customer01 = new Customer();
        customer01.setId(1);
        customer01.setFirstName("Павел");
        customer01.setSecondName("Смирнов");
        customer01.setPhone("89171234567");
        customer01.setAddress("г.Казань, ул.Строителей-1, 23/52");
        customer01.setNick("pasha");

//        Customer customer02 = new Customer(resultSet.getInt("id"), resultSet.getString("family"), resultSet.getString("name"), resultSet.getString("phone"), resultSet.getString("address"));
        Customer customer02 = new Customer();
        customer02.setId(2);
        customer02.setFirstName("Сергей");
        customer02.setSecondName("Попов");
        customer02.setPhone("89170064590");
        customer02.setAddress("г.Казань, ул.Минская, 13/133");
        customer02.setNick("sergen");

//        Customer customer03 = new Customer(resultSet.getInt("id"), resultSet.getString("family"), resultSet.getString("name"), resultSet.getString("phone"), resultSet.getString("address"));
        Customer customer03 = new Customer();
        customer03.setId(3);
        customer03.setFirstName("Владимир");
        customer03.setSecondName("Марков");
        customer03.setPhone("89170064590");
        customer03.setAddress("г.Казань, ул.Тульская, 14/144");
        customer03.setNick("vladgen");

//        Customer customer04 = new Customer(resultSet.getInt("id"), resultSet.getString("family"), resultSet.getString("name"), resultSet.getString("phone"), resultSet.getString("address"));
        Customer customer04 = new Customer();
        customer04.setId(4);
        customer04.setFirstName("Алекс");
        customer04.setSecondName("Стеблов");
        customer04.setPhone("89170064590");
        customer04.setAddress("г.Казань, ул.Светлая, 15/155");
        customer04.setNick("alexsteb");

//        Customer customer05 = new Customer(resultSet.getInt("id"), resultSet.getString("family"), resultSet.getString("name"), resultSet.getString("phone"), resultSet.getString("address"));
        Customer customer05 = new Customer();
        customer05.setId(5);
        customer05.setFirstName("Марк");
        customer05.setSecondName("Кашин");
        customer05.setPhone("89170064590");
        customer05.setAddress("г.Казань, ул.Губкина, 16/166");
        customer05.setNick("markasha");

//        InsertNewCustomer(customer01);
//        InsertNewCustomer(customer02);
//        InsertNewCustomer(customer03);
//        InsertNewCustomer(customer04);
//        InsertNewCustomer(customer05);

//        Goods good01 = new Goods("iPhone 7 32Gb Black", "APPLE"
//                , "Форм-фактор Моноблок, Материал корпуса Алюминий, ОС iOS, ПРОЦЕССОР A10 Fusion + сопроцессор движения M10 Количество ядер 4, Частота 2.37 ГГц"
//                , 43999.0);
//
//        Goods good02 = new Goods("iPhone 8 64Gb Gold", "APPLE"
//                , "Форм-фактор Моноблок, Материал корпуса Алюминий, ОС iOS, ПРОЦЕССОР A11 Bionic + сопроцессор движения M11 Количество ядер 6"
//                , 56980.0);
//
//        Goods good03 = new Goods("Galaxy A5 2017 Black", "SAMSUNG"
//                , "Форм-фактор Моноблок, Материал корпуса Металл, ОС Android 6.0.1, ПРОЦЕССОР Exynos 7880, Количество ядер 8, Частота 1.9 ГГц"
//                , 22990.0);
//
//        Goods good04 = new Goods("Galaxy S8 Black", "SAMSUNG"
//                , "Форм-фактор Моноблок, Материал корпуса Металл, ОС Android 7.0 (Nougat), ПРОЦЕССОР Exynos 8895, Количество ядер 8, Частота 2.3 ГГц"
//                , 49990.0);
//
//        Goods good05 = new Goods("Xperia XZ DS Mineral Black", "SONY"
//                , "Форм-фактор Моноблок, Материал корпуса Металл, ОС Android t6.0 Marshmallow, ПРОЦЕССОР Snapdragon 820, Количество ядер 4, Частота 1.6/2.2 ГГц"
//                , 39990.0);
//
//        Goods good06 = new Goods("Redmi Note 4 64Gb Silver", "XIAOMI"
//                , "Форм-фактор Моноблок, Материал корпуса Металл, ОС Android, ПРОЦЕССОР , Количество ядер 10, Частота 2.1 ГГц"
//                , 16990.0);

        Goods goods01 = new Goods();
        goods01.setId(1);
        goods01.setName("iPhone 7 32Gb Black");
        goods01.setModel("APPLE");
        goods01.setDescription("Форм-фактор Моноблок, Материал корпуса Алюминий, ОС iOS, ПРОЦЕССОР A10 Fusion + сопроцессор движения M10 Количество ядер 4, Частота 2.37 ГГц");
        goods01.setPrice(43999.0);

        goods02 = new Goods();
        goods02.setId(2);
        goods02.setName("iPhone 8 64Gb Gold");
        goods02.setModel("APPLE");
        goods02.setDescription("Форм-фактор Моноблок, Материал корпуса Алюминий, ОС iOS, ПРОЦЕССОР A11 Bionic + сопроцессор движения M11 Количество ядер 6");
        goods02.setPrice(56980.0);

        Goods goods03 = new Goods();
        goods03.setId(3);
        goods03.setName("Galaxy A5 2017 Black");
        goods03.setModel("SAMSUNG");
        goods03.setDescription("Форм-фактор Моноблок, Материал корпуса Металл, ОС Android 6.0.1, ПРОЦЕССОР Exynos 7880, Количество ядер 8, Частота 1.9 ГГц");
        goods03.setPrice(22990.0);

        Goods goods04 = new Goods();
        goods04.setId(4);
        goods04.setName("Galaxy S8 Black");
        goods04.setModel("SAMSUNG");
        goods04.setDescription("Форм-фактор Моноблок, Материал корпуса Металл, ОС Android 7.0 (Nougat), ПРОЦЕССОР Exynos 8895, Количество ядер 8, Частота 2.3 ГГц");
        goods04.setPrice(49990.0);

        Goods goods05 = new Goods();
        goods05.setId(5);
        goods05.setName("Xperia XZ DS Mineral Black");
        goods05.setModel("SONY");
        goods05.setDescription("Форм-фактор Моноблок, Материал корпуса Металл, ОС Android t6.0 Marshmallow, ПРОЦЕССОР Snapdragon 820, Количество ядер 4, Частота 1.6/2.2 ГГц");
        goods05.setPrice(39990.0);

        Goods goods06 = new Goods();
        goods06.setId(6);
        goods06.setName("Redmi Note 4 64Gb Silver");
        goods06.setModel("XIAOMI");
        goods06.setDescription("Форм-фактор Моноблок, Материал корпуса Металл, ОС Android, ПРОЦЕССОР , Количество ядер 10, Частота 2.1 ГГц");
        goods06.setPrice(16990.0);

//        InsertNewGoods(goods01);
//        InsertNewGoods(goods02);
//        InsertNewGoods(goods03);
//        InsertNewGoods(goods04);
//        InsertNewGoods(goods05);
//        InsertNewGoods(goods06);

        DateTimeFormatter gmd = Util.Formatter.yyyyDotMMdotDD;

        Map<Goods,Integer> goodsSet01 = new HashMap<>();
        goodsSet01.put(goods01,2);
        goodsSet01.put(goods02,1);

//        Order order01 = new Order(customer01, LocalDate.of(2017, Month.SEPTEMBER, 1), INTENT, goodsSet01);
        Order order01 = new Order();
        order01.setId(1);
        order01.setCustomer(customer01);
//        order01.setCreated(LocalDate.of(2017, Month.SEPTEMBER, 1));
//        order01.setCreated("2017-09-05");
        order01.setStatus(INTENT);
        order01.setGoods(goodsSet01);

        Map<Goods,Integer> goodsSet02 = new HashMap<>();
        goodsSet01.put(goods03,1);
        goodsSet01.put(goods04,3);
//        Order order02 = new Order(customer02, LocalDate.of(2017, Month.SEPTEMBER, 9), REQUEST, goodsSet02);
        Order order02 = new Order();
        order02.setId(2);
        order02.setCustomer(customer02);
//        order02.setCreated(LocalDate.of(2017, Month.SEPTEMBER, 9));
//        order02.setCreated("2017-09-09");
        order02.setStatus(REQUEST);
        order02.setGoods(goodsSet02);

        Map<Goods,Integer> goodsSet03 = new HashMap<>();
        goodsSet03.put(goods05,2);
        goodsSet03.put(goods06,4);
//        LocalDateTime.parse("2017.10.04 10:00", yyyyDotMMdotDD_hhColonMM)
        order03 = new Order();
        order03.setId(3);
        order03.setCustomer(customer03);
//        order03.setCreated(LocalDate.of(2017, Month.SEPTEMBER, 17));
//        order01.setCreated("2017-09-17");
        order03.setStatus(INVOICE);
        order03.setGoods(goodsSet03);

//        Order order04 = new Order(customer02,  "2017-10-04", INVOICE, goodsSet01);
        Order order04 = new Order(customer02, INVOICE, goodsSet01);

//        Iterator entries = goodsSet03.entrySet().iterator();
//        int i=0;
//        while (entries.hasNext()) {
//            Map.Entry thisEntry = (Map.Entry) entries.next();
//            Goods gds = (Goods) thisEntry.getKey();
//            Integer qty = (Integer) thisEntry.getValue();
//            System.out.println(" - "+(++i)+". Кол-во: "+qty+"\t"+gds.toString());
//        }

//        Invoice invoice01 = new Invoice(order01,LocalDate.of(2017, Month.SEPTEMBER, 5), 144900, 0, "Шишов М.А.");
        invoice01 = new Invoice();
        invoice01.setId(1);
        invoice01.setOrder(order01);
//        invoice01.setCreated(LocalDate.of(2017, Month.SEPTEMBER, 5));
        invoice01.setCreated("2017-11-07");
        invoice01.setTotalMoney(144900.0);
        invoice01.setPaidMoney(0.0);
        invoice01.setManager("Шишов М.А.");

//        Invoice invoice02 = new Invoice(order02,LocalDate.of(2017, Month.SEPTEMBER, 10), 123900, 0, "Макаров И.П.");
        Invoice invoice02 = new Invoice();
        invoice02.setId(2);
        invoice02.setOrder(order02);
//        invoice02.setCreated(LocalDate.of(2017, Month.SEPTEMBER, 10));
        invoice02.setCreated("2017-11-10");
        invoice02.setTotalMoney(123900.0);
        invoice02.setPaidMoney(0.0);
        invoice02.setManager("Макаров И.П.");

//        Invoice invoice03 = new Invoice(order03,LocalDate.of(2017, Month.SEPTEMBER, 19), 148900, 0, "Шишов М.А.");
        Invoice invoice03 = new Invoice();
        invoice03.setId(3);
        invoice03.setOrder(order03);
//        invoice03.setCreated(LocalDate.of(2017, Month.SEPTEMBER, 19));
        invoice03.setCreated("2017-11-19");
        invoice03.setTotalMoney(148900.0);
        invoice03.setPaidMoney(0.0);
        invoice03.setManager("Шишов М.А.");
    }

    @Test
    public void testMarshalling() throws JAXBException {
//        File file = new File("ISSaleMarshalling.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(Order.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        try {
            jaxbMarshaller.marshal(customer01, System.out);
//            jaxbMarshaller.marshal(customer01, new File("c:/Ren/ISSaleCustomer01.xml"));
            jaxbMarshaller.marshal(customer01, new File("ISSaleCustomer.xml"));

            jaxbMarshaller.marshal(goods02, System.out);
            jaxbMarshaller.marshal(goods02, new File("ISSaleGoods.xml"));

            jaxbMarshaller.marshal(order03, System.out);
            jaxbMarshaller.marshal(order03, new File("ISSaleOrder.xml"));

//            jaxbMarshaller.marshal(invoice01, System.out);
//            jaxbMarshaller.marshal(invoice01, new File("ISSaleInvoice.xml"));

        } catch (JAXBException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void testUnMarshalling() throws JAXBException
    {
        System.out.println("\ntestUnMarshalling\n=================");

        JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        Customer customer = (Customer) jaxbUnmarshaller.unmarshal( new File("ISSaleCustomer.xml") );
        System.out.println("\nПокупатель:\n"+customer.toString());

        Assert.assertEquals(customer,customer01);

        jaxbContext = JAXBContext.newInstance(Goods.class);
        jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        Goods goods = (Goods) jaxbUnmarshaller.unmarshal( new File("ISSaleGoods.xml") );
        System.out.println("\nТовар:\n"+goods.toString());

        Assert.assertEquals(goods,goods02);

        jaxbContext = JAXBContext.newInstance(Order.class);
        jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        Order order = (Order) jaxbUnmarshaller.unmarshal( new File("ISSaleOrder.xml") );
        System.out.println("\nЗаказ:\n"+order.toString());
        Assert.assertEquals(order,order03);

//        Map<Goods, Integer>  map = order.getGoods();
//        int si = 0;
//        for (Object element :map) {
//            Goods goodss = (Goods) element;
//            System.out.println(goodss.toString());
////            writer.write("\n" + (++si) + ". \t<" + map.getKey() + "> - \t" + mapEntry.getValue());
//        }

        Iterator entries = order.getGoods().entrySet().iterator();
        int i=0;
        while (entries.hasNext()) {
            Map.Entry thisEntry = (Map.Entry) entries.next();
            Goods gds = (Goods) thisEntry.getKey();
            Integer qty = (Integer) thisEntry.getValue();
            System.out.println("("+(++i)+") Кол-во: "+qty+"\tТовар:\t"+gds.toString());
        }

//        Invoice invoice = (Invoice) jaxbUnmarshaller.unmarshal( new File("ISSaleInvoice.xml") );
//        System.out.println("\nСчет на оплату:\n"+invoice.toString());
//        Assert.assertEquals(invoice,invoice01);

    }

}