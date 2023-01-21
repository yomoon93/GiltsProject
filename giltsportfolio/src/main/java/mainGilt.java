import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class mainGilt {
    static GiltPortfolio giltPort;
    static MallonGiltPricingEngine mallonGiltPricingEngine;
//
    static Gilt gilt;
    static List<Gilt> giltArray = new ArrayList<>();
    static List<Gilt> giltCus = new ArrayList<>();

    

    public static void main(String[] args) {
        mallonGiltPricingEngine = new MallonGiltPricingEngine(2.35,3.02,3.56, 4.06);
        giltPort =new GiltPortfolio(mallonGiltPricingEngine,giltCus,10000);
        randomGilt();

        String command;
        Scanner myScanner;
        do{
            myScanner = new Scanner(System.in);
            System.out.println("\nWelcome to Gilt!");
            System.out.println("1. Buy Gilt.");
            System.out.println("2. Sell Gilt.");
            System.out.println("3. Tick Gilt.");
            System.out.println("4. View portfolio.");
           command = myScanner.nextLine();

            switch(command){
                case"1":
                    buyGilt();
                    break;
                case "2":
                    sellGilt();
                    break;
                case "3":
                   displayTick();
                    break;
                case "4":
                    display();
                    break;
                    default:
            }
          }while(!command.equals("exit"));
        }

    public static void display(){
        System.out.println("Display Portfolio: ");
        for (Gilt x: giltPort.getPortfolio()){
            System.out.println("Coupon: " + x.getCoupon() + ",  Principal:  " + x.getPrincipal() + ", Years Remaining: " + x.getYearsRemaining());

        }
        System.out.format("Your balance is: %.2f" ,giltPort.getBalance());
    }



    public static void randomGilt(){
        for(int i = 0; i < 10; i++ ) {
            int coupon = (int) Math.floor(Math.random() * 100);
            int principal = (int) Math.floor(Math.random() * 10000);
            int yearsRemain = (int) Math.floor(Math.random() * 20 + 1);
            gilt = new Gilt(coupon, principal, yearsRemain);
            giltArray.add(gilt);
//            System.out.println(gilt);
        }

    }
    public static void buyGilt(){
        try{
            Scanner myScanner= new Scanner(System.in);
            int counter = 0;
            for (Gilt p : giltArray){
                System.out.println( counter++ +": "+p);
            }
            System.out.println("Please select which gilt you would like to buy");
            System.out.format("Your balance is: %.2f \n",giltPort.getBalance());
            int index = myScanner.nextInt();
            giltPort.buyGilt(giltArray.get(index));
            System.out.format("Your balance after the buy is: %.2f", giltPort.getBalance());
        }catch(CantAffordGiltException e){
            System.out.println(e);
        }
    }
    public static void displayTick(){
        giltPort.tick();
        for (Gilt x: giltPort.getPortfolio()){
            System.out.println("Coupon: " + x.getCoupon() + ",  Principal:  " + x.getPrincipal() + ", Years Remaining: " + x.getYearsRemaining());
        }
        System.out.format("%.2f", giltPort.getBalance());
    }

    public static void sellGilt(){
        Scanner myScanner= new Scanner(System.in);
        int counter = 0;
        for (Gilt p : giltPort.getPortfolio()){
            System.out.println( counter++ +": "+p);
        }
        System.out.println("Please select which gilt you would like to sell");
        int index = myScanner.nextInt();
        giltPort.sellGilt(giltPort.getPortfolio().get(index));

        System.out.format("Your balance after the sell is: %.2f",giltPort.getBalance());
    }




}
