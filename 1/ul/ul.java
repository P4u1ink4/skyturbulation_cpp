import java . util . Scanner ;
public class ul {
    private int amountofbees;
    private int honey;
    private int priceofkg;
    private int bill;
    private int count;
    private String position;
    private String nameofhive;
    private String nameofqueen;

    public void setAmountofBees(int amountofbees) { this.amountofbees = amountofbees; }       
    public int getAmountofBees() { return amountofbees; }

    public void setHoney(int honey) { this.honey = honey; this.count += 1; }       
    public int getHoney(){ return honey; }

    public void setPriceofkg(int price){ this.priceofkg = price; }
    public int getPticeofkg(){ return priceofkg; }

    public void setBill(int kg){ this.bill = getPticeofkg()*kg; }
    public int getBill(){ return bill; }

    public int getAverageHoney() { return honey/count; }

    public void setPosition(String position) { this.position = position; }       
    public String getPosition() { return position; }

    public void setNameofHive(String nameofhive) { this.nameofhive = nameofhive; }       
    public String getNameofHive() { return nameofhive; }

    public void setNameofQueen(String nameofqueen) { this.nameofqueen = nameofqueen; }       
    public String getNameofQueen() { return nameofqueen; }

    public static void main(String[] args) {
        ul ul = new ul();
    	Scanner s = new Scanner(System.in); 
        int amount = 0;
        double amount2 = 0;
        String whattodo = ""; 
        String name = "";
        String position = "";
        String menu = "\nWybierz opcję co chcesz zrobić:\n1 - zmiana liczby pszczół\n2 - odczytanie liczby pszczół\n3 - określenie połozenia ula\n4 - aktualna pozycja ula\n5 - dodanie aktualnej rocznej ilości wyprodukowanego przez ul miodu\n6 - nadanie nazwy pasiecie\n7 - odczytanie nazwy pasieki\n8 - ustalenie nazwy królowej\n9 - odczytanie nazwy królowej\n10 - ustalenie ceny za kg miodu\n11 - obliczenie rachunku za daną ilość miodu\nJeśli chcesz zakończyć program - exit\n\n";
        System.out.printf("Hej! Witamy w ulu, najpierw ustaw startową liczbę pszczół: ");
        while (true) {
            name = s.nextLine();
            try {
                amount = Integer.parseInt(name); 
                ul.setAmountofBees(amount);
                break;
            } 
            catch (NumberFormatException e)  { System.out.printf("Nie wpisano liczby "); }
        }
        while (true) {
            System.out.printf(menu);
            whattodo = s.nextLine();
            switch(whattodo){
                case "1":
                    System.out.printf("Wprowadź o ile chcesz zmienić liczbę pszczół: ");
                    while (true) {
                        name = s.nextLine();
                        try {
                            amount = Integer.parseInt(name); 
                            if(amount>100 || amount<-100 || ul.getAmountofBees()+amount<0){ System.out.printf("\nWartość zmiany nie powinna roznic się o +/- 100 oraz docelowa wartość pszczół nie powinna być mniejsza od 0 "); }
                            else{ ul.setAmountofBees(ul.getAmountofBees()+amount); break; }
                        } 
                        catch (NumberFormatException e)  { System.out.printf("Nie wpisano liczby\n"); }
                    }
                    break;
                case "2":
                    System.out.printf("Ilość pszczół: %d\n",ul.getAmountofBees());
                    break;
                case "3":
                    System.out.printf("wprowadź szerokość geograficzną ula: ");
                    while (true) {
                        name = s.nextLine();
                        try {
                            amount2 = Double.parseDouble(name);
                            if(amount2<-90 || amount2>90){ System.out.printf("\nSzerokość nie mieści się w przedziale -90;90 "); }
                            else{ position = "X: " + String.valueOf(amount2); break; }
                        } 
                        catch (NumberFormatException e)  { System.out.printf("Nie wpisano liczby\n"); }
                    }
                    System.out.printf("wprowadź długość geograficzną ula: ");
                    while (true) {
                        name = s.nextLine();
                        try {
                            amount2 = Double.parseDouble(name);
                            if(amount2<-180 || amount2>180){ System.out.printf("\nDługość nie mieści się w przedziale -180;180 "); }
                            else{ position = position + " Y: " + String.valueOf(amount2); break; }
                        } 
                        catch (NumberFormatException e) { System.out.printf("Nie wpisano liczby\n"); }
                    }
                    ul.setPosition(position);
                    break;
                case "4":
                    System.out.printf("Współrzędne geograficzne: %s\n",ul.getPosition());
                    break;
                case "5":
                    System.out.printf("wprowadź ilość wyprodukowanego przez rok miodu: ");
                    while (true) {
                        name = s.nextLine();
                        try {
                            amount = Integer.parseInt(name); 
                            ul.setHoney(ul.getHoney()+amount);
                            break;
                        } 
                        catch (NumberFormatException e)  { System.out.printf("Nie wpisano liczby\n"); }
                    }
                    System.out.printf("Średnia ilość produkowanego miodu: %d\n",ul.getAverageHoney());
                    break;
                case "6":
                    System.out.printf("wprowadź nazwe pasieki: ");
                    name = s.nextLine();
                    while(name.charAt(0)<65 || name.charAt(0)>90){
                        System.out.printf("Nazwa musi zaczynać się wielką literą!\n");
                        name = s.nextLine();
                    }
                    ul.setNameofHive(name);
                    break;
                case "7":
                    System.out.printf("Nazwa pasieki: %s\n",ul.getNameofHive());
                    break;
                case "8":
                    System.out.printf("wprowadź nazwe królowej: ");
                    name = s.nextLine();
                    ul.setNameofQueen(name);
                    break;
                case "9":
                    System.out.printf("Nazwa królowej: %s\n",ul.getNameofQueen());
                    break;
                case "10":
                    System.out.printf("wprowadź cenę za kg: ");
                    while (true) {
                        name = s.nextLine();
                        try {
                            amount = Integer.parseInt(name); 
                            if(amount>0){ ul.setPriceofkg(amount); break; }
                            else{ System.out.printf("Cena musi być dodatnia\n"); }
                        } 
                        catch (NumberFormatException e)  { System.out.printf("Nie wpisano liczby\n"); }
                    }
                    break;
                case "11":
                    System.out.printf("wprowadź ilość miodu w kg: ");
                    while (true) {
                        name = s.nextLine();
                        try {
                            amount = Integer.parseInt(name); 
                            ul.setBill(amount);
                            if(ul.getBill()!=0) { System.out.printf("Rachunek wynosi: %d\n",ul.getBill()); break; }
                            else { System.out.printf("Najpierw ustal cenę miodu\n"); break; }
                        } 
                        catch (NumberFormatException e) { System.out.printf("Nie wpisano liczby\n"); }
                    }
                    break;
                case "exit":
                    s.close();
                    return;
                default:
                    System.out.printf("Brak wybranej opcji\n");
                    break;
            }
        } 
    }
}
