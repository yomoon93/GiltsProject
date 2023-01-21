import java.util.ArrayList;
import java.util.List;

public class GiltPortfolio {
    public List<Gilt> getPortfolio() {
        return portfolio;
    }

    public double getBalance() {
        return balance;
    }

    private GiltPricingEngine pricingEngine;
    private List<Gilt> portfolio;
    private double balance;
// something to give us a price, a array thats a list, balance,
    public GiltPortfolio(GiltPricingEngine pricingEngine, List<Gilt> portfolio, double balance) {
        this.pricingEngine = pricingEngine;
        this.portfolio = portfolio;
        this.balance = balance;
    }

    public GiltPortfolio(GiltPricingEngine pricingEngine, double balance) {
        this(pricingEngine, new ArrayList<>(), balance);
    }

    public void buyGilt(Gilt g) {
        if (this.balance < pricingEngine.getPrice(g)){
            throw new CantAffordGiltException();
        }else{
            portfolio.add(g);
            this.balance-=pricingEngine.getPrice(g);
        }


    }

    public void sellGilt(Gilt g) {
        portfolio.remove(g);
        this.balance+=pricingEngine.getPrice(g);
    }

    public void tick() {
        // make
        List<Gilt> expireCopy = new ArrayList<>();
        for(Gilt i : this.portfolio){
            this.balance += i.tick();
            if (i.expired()){
                expireCopy.add(i);
            }
        }
        this.portfolio.removeAll(expireCopy);
    }

    @Override
    public String toString() {
        return "GiltPortfolio{" +
                "pricingEngine=" + pricingEngine +
                ", portfolio=" + portfolio +
                ", balance=" + balance +
                '}';
    }
}
