package christmas.message;

public enum Menu {

    /*
    <애피타이저>
    양송이수프(6,000), 타파스(5,500), 시저샐러드(8,000)

    <메인>
    티본스테이크(55,000), 바비큐립(54,000), 해산물파스타(35,000), 크리스마스파스타(25,000)

    <디저트>
    초코케이크(15,000), 아이스크림(5,000)

    <음료>
    제로콜라(3,000), 레드와인(60,000), 샴페인(25,000)
     */


    양송이스프(1500, "appetizer"),
    타파스(5500, "appetizer"),
    시저샐러드(8000, "appetizer"),
    티본스테이크(55000, "main"),
    바비큐립(54000, "main"),
    해산물파스타(35000, "main"),
    크리스마스파스타(25000, "main"),
    초코케이크(15000, "dessert"),
    아이스크림(5000, "dessert"),
    제로콜라(3000, "drink"),
    레드와인(60000, "drink"),
    샴페인(25000, "drink");

    private int price;
    private String kind;

    Menu(int price, String kind) {
        this.price = price;
        this.kind = kind;
    }

    public int getPrice() {
        return price;
    }

    public String getKind() {
        return kind;
    }

}
