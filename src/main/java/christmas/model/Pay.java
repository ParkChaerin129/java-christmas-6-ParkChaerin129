package christmas.model;

public class Pay {

    private Integer allPrice=0;
    private boolean giveaway = false;
    private Integer xmasDDaySale=0;
    private Integer daySale=0;
    private Integer starDaySale=0;
    private Integer benefitPrice=0;
    private String badge="없음";

    public Pay(Integer allPrice,Integer xmasDDaySale,Integer daySale,boolean starDay){
        this.allPrice = allPrice;
        if(allPrice>=100000){
            this.giveaway=true;
            this.benefitPrice+=25000;
        }
        this.xmasDDaySale=xmasDDaySale;
        this.daySale=daySale;
        if(starDay){
            this.starDaySale=1000;
        }
        this.benefitPrice += xmasDDaySale+daySale+starDaySale;
        this.badge = calculateBadge(benefitPrice);
    }

    private String calculateBadge(Integer benefitPrice){
        if(benefitPrice>=20000){
            return "산타";
        }
        if(benefitPrice>=10000){
            return "트리";
        }
        if(benefitPrice>=5000){
            return "별";
        }
        return "없음";
    }

    public Integer getAllPrice(){
        return allPrice;
    }

    public Integer getResultPrice(){
        Integer resultPrice = allPrice;
        allPrice-=(xmasDDaySale+daySale+starDaySale);
        return allPrice;
    }

    public Integer getBenefitPrice(){
        return benefitPrice;
    }

    public boolean isGiveaway() {
        return giveaway;
    }

    public Integer getXmasDDaySale(){
        return xmasDDaySale;
    }

    public Integer getDaySale() {
        return daySale;
    }

    public Integer getStarDaySale() {
        return starDaySale;
    }

    public String getBadge(){
        return badge;
    }

}
