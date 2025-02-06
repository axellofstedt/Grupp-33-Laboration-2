// ska kunna skapa verkstad för EN specifik bil men också
// en verkstad för alla möjliga sorters bilar
// vet it hur man gör detta ÄN!
// keep on fighting you got it

public class AutoRepairShop<T extends Car> {
    protected AutoRepairShop(){
        System.out.println();
    }

    public static void main(String[] args) {
        AutoRepairShop<Volvo240> rs = new AutoRepairShop<>();
        // System.out.println(rs instanceof Volvo240);
    }
}
