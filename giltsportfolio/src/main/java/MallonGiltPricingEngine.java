public class MallonGiltPricingEngine implements GiltPricingEngine {
    private double twoYear, fiveYear, tenYear, twentyYear;
    public MallonGiltPricingEngine(double twoYear, double fiveYear, double tenYear, double twentyYear) {
        this.twoYear = twoYear;
        this.fiveYear = fiveYear;
        this.tenYear = tenYear;
        this.twentyYear = twentyYear;
    }
    @Override
    public double getPrice(Gilt g) {
        return ((2*g.getYearsRemaining() *g.getCoupon())-(g.getYearsRemaining()*g.getPrincipal()*getYield(g)/100)+(2*g.getPrincipal()))/ (g.getYearsRemaining()*getYield(g)/100+2);

    }

    public double getYield(Gilt g) {
        if(g.getYearsRemaining() == 1 || g.getYearsRemaining()  == 2){
          return  this.twoYear;
        }else if(g.getYearsRemaining() >= 3 && g.getYearsRemaining() <= 5){
            return this.fiveYear;
        } else if (g.getYearsRemaining() >= 6 && g.getYearsRemaining() <= 10) {
            return this.tenYear;
        }else return this.twentyYear;
    }

    @Override
    public String toString() {
        return "MallonGiltPricingEngine{" +
                "twoYear=" + twoYear +
                ", fiveYear=" + fiveYear +
                ", tenYear=" + tenYear +
                ", twentyYear=" + twentyYear +
                '}';
    }
}
