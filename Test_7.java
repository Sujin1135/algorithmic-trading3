import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class Test_7 {
    public static void main(String[] args) {
        WealthyPerson person1 = new WealthyPerson("최민규");
        WealthyPerson person2 = new WealthyPerson("유수진");

        person1.addEstate(new House("춘천시 거두리 1125-8", 100000, 15, 3));
        person1.addStock(new Stock("XVG", 1, 50000, 38, 390));

        person2.addEstate(new House("춘천시 거두리 1125-8", 2500000, 15, 3));
        person2.addStock(new Stock("IOTA", 2, 200000, 1200, 9700));

        person1.richCompare(person2);
    }
}

class Stock {
    private String name;
    private int code;
    private int currentPrice;
    private int lowestPrice;
    private int highestPrice;

    Stock (String name, int code, int currentPrice, int lowestPrice, int highestPrice) {
        this.name = name;
        this.code = code;
        this.currentPrice = currentPrice;
        this.lowestPrice = lowestPrice;
        this.highestPrice = highestPrice;
    }

    public String getName() {
        return name;
    }

    public Stock setName(String name) {
        this.name = name;
        return this;
    }

    public int getCode() {
        return code;
    }

    public Stock setCode(int code) {
        this.code = code;
        return this;
    }

    public int getCurrentPrice() {
        return currentPrice;
    }

    public Stock setCurrentPrice(int currentPrice) {
        this.currentPrice = currentPrice;
        return this;
    }

    public int getLowestPrice() {
        return lowestPrice;
    }

    public Stock setLowestPrice(int lowestPrice) {
        this.lowestPrice = lowestPrice;
        return this;
    }

    public int getHighestPrice() {
        return highestPrice;
    }

    public Stock setHighestPrice(int highestPrice) {
        highestPrice = highestPrice;
        return this;
    }

    public String toString() {
        return "종목: " + name + ", 코드: " + code + " 현재가: " + currentPrice
                + "만 최고가: " + highestPrice + "만 최저가: " + lowestPrice + "만";
    }
}

abstract class Estate {
    protected String adress; // 주소지
    protected int price; // 가격
    protected int py; // 평수

    Estate (String adress, int price, int py) {
        this.adress = adress;
        this.price = price;
        this.py = py;
    }

    Estate (String adress, int price) {
        this.adress = adress;
        this.price = price;
    }

    public String getAdress() {
        return adress;
    }

    public Estate setAdress(String adress) {
        this.adress = adress;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public Estate setPrice(int price) {
        this.price = price;
        return this;
    }

    public int getPy() {
        return py;
    }

    public Estate setPy(int py) {
        this.py = py;
        return this;
    }

    public String toString() {
        if (py != 0) {
            return "가격: " + price + "원, 주소: " + adress + ", 면적: " + py + "평";
        } else {
            return "가격: " + price + "원, 주소: " + adress + ", 면적: ";
        }
    }
}

class House extends Estate { // 주택(부동산)
    int room;

    House (String adress, int price, int py, int room) {
        super(adress, price, py);
        this.room = room;
    }

    public int getRoom() {
        return room;
    }

    public House setRoom(int room) {
        this.room = room;
        return this;
    }

    public String toString() {
        return "주택, " + super.toString() + ", 방수: " + room;
    }
}

class StudioApartment extends Estate { // 오피스텔(부동산)
    int monthly;

    StudioApartment (String adress, int price, int py, int monthly) {
        super(adress, price, py);
        this.monthly = monthly;
    }

    public int getMonthly() {
        return monthly;
    }

    public StudioApartment setMonthly(int monthly) {
        this.monthly = monthly;
        return this;
    }

    public String toString() {
        return "오피스텔, " + super.toString() + " ,월세: " + monthly;
    }
}

class SmallApartment extends Estate {
    int room;
    int floor;

    SmallApartment (String adress, int price, int py, int room, int floor) {
        super(adress, price, py);
        this.room = room;
        this.floor = floor;
    }

    public String toString() {
        return "빌라, " + super.toString() + ", 방수: " + room + ", 층: " + floor;
    }
}

class Apart extends Estate {
    int room;
    int jeonse;

    Apart (String adress, int price, int room, int jeonse) {
        super(adress, price);
        this.room = room;
        this.jeonse = jeonse;
    }

    public String toString() {
        return "아파트, " + super.toString() + ", 방수: " + room + ", 전세: " + jeonse;
    }
}

class Land extends Estate {
    int tree;

    Land (String adress, int price, int py, int tree) {
        super(adress, price, py);
        this.tree = tree;
    }

    public String toString() {
        return "토지, " + super.toString() + ", 나무수: " + tree + "그루";
    }
}

class WealthyPerson implements Wealthy {
    private String name;
    private int money = 0;
    private int averagePrice = 0;

    List<Stock> stockList = new ArrayList<Stock>();
    List<Estate> estateList = new ArrayList<Estate>();

    WealthyPerson (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public WealthyPerson setName(String name) {
        this.name = name;
        return this;
    }

    public int getMoney() {
        return money;
    }

    public int getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(int averagePrice) {
        this.averagePrice = averagePrice;
    }

    public WealthyPerson addStock (Stock stock) {
        stockList.add(stock);
        money += stock.getCurrentPrice();
        averagePrice = money / stockList.size();
        return this;
    }

    public WealthyPerson addEstate (Estate estate) {
        estateList.add(estate);
        money += estate.getPrice();
        averagePrice = money / estateList.size();
        return this;
    }

    public WealthyPerson richCompare (WealthyPerson person) {
        out.println(this);
        out.println(person);
        out.println(this.money - person.getMoney() > 0 ? this.getName() : person.getName()
                + "(이)가 더 자산이 많습니다.");
        return this;
    }

    public void listStock () {
        for(Stock stock : stockList) {
            out.println(stock);
        }
    }

    public void listEstate () {
        for(Estate estate : estateList) {
            out.println(estate);
        }
    }

    public String toString() {
        return "이름: " + name + ", 총 자산: " + money + ", 평균 자산: " + averagePrice;
    }
}

interface Wealthy {
    public WealthyPerson richCompare(WealthyPerson person);
}
