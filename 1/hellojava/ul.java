import java . util . Scanner ;
public class ul {
    private int amountofbees;
    private String position;
    private int averagehoney;
    private String nameofhive;
    private String nameofqueen;

    public void setNameofHive(String nameofhive) {
        this.nameofhive = nameofhive;
    }       
     
    public String getNameofHive() {
        return nameofhive;
    }

    public void setNameofQueen(String nameofqueen) {
        this.nameofqueen = nameofqueen;
    }       
     
    public String getNameofQueen() {
        return nameofqueen;
    }

    public void setAverageHoney(int averagehoney) {
        this.averagehoney = averagehoney;
    }       
     
    public int getAverageHoney() {
        return averagehoney;
    }

    public void setPosition(String position) {
        this.position = position;
    }       
     
    public String getPosition() {
        return position;
    }

    public void setAmountofBees(int amountofbees) {
        this.amountofbees = amountofbees;
    }       
     
    public int getAmountofBees() {
        return amountofbees;
    }

    public void main() {
    	Scanner s = new Scanner(System.in); 
        String whattodo = ""; 
        String name = "";
        int amount = 0;
        int position1 = 0;
        int position2 = 0;
        System.out.printf("Hej! Witamy w ulu, najpierw ustaw startową liczbę pszczół: ");
        amount = s.nextInt();
        setAmountofBees(amount);
        System.out.printf("\nWybierz opcję co chcesz zrobić:");
        System.out.printf("1 - zmiana liczby pszczół\n");
        System.out.printf("2 - odczytanie liczby pszczół\n");
        System.out.printf("3 - określenie połozenia ula\n");
        System.out.printf("4 - aktualna pozycja ula\n");
        System.out.printf("5 - dodanie aktualnej rocznej ilości wyprodukowanego przez ul miodu\n");
        System.out.printf("6 - nadanie nazwy pasiecie\n");
        System.out.printf("7 - odczytanie nazwy pasieki\n");
        System.out.printf("8 - ustalenie nazwy królowej\n");
        System.out.printf("9 - odczytanie nazwy królowej\n");
        System.out.printf("Jeśli chcesz zakończyć program - exit\n");
        whattodo = s.nextLine();
        while (!whattodo.equals("exit")) {
            if(whattodo == "1"){
                System.out.printf("Wprowadź o ile chcesz zmienić liczbę pszczół: ");
                amount = s.nextInt();
                while(amount>100 || amount<-100 || getAmountofBees()+amount<0){
                    System.out.printf("\nWprowadź inną wartość: ");
                    amount = s.nextInt();
                    System.out.printf("\n");
                }
            }
            else if(whattodo == "2"){
                System.out.printf("%d\n",getAmountofBees());
            }
            else if(whattodo == "3"){
                System.out.printf("wprowadź szerokość geograficzną ula: ");
                position1 = s.nextInt();
                while(position1<-90 || position1>90){
                    System.out.printf("\nBłędna szerokość\n");
                    System.out.printf("wprowadź szerokość geograficzną ula: ");
                    position1 = s.nextInt();
                }
                System.out.printf("wprowadź długość geograficzną ula: ");
                position2 = s.nextInt();
                while(position2<-180 || position2>180){
                    System.out.printf("\nBłędna długość\n");
                    System.out.printf("wprowadź długość geograficzną ula: ");
                    position2 = s.nextInt();
                }
                System.out.printf("\n");
                name = String.valueOf(position1) + String.valueOf(position2);
                setPosition(name);
            }
            else if(whattodo == "4"){
                System.out.printf("%s\n",getPosition());
            }
            else if(whattodo == "5"){
                System.out.printf("wprowadź ilość wyprodukowanego przez rok miodu: ");
                amount = s.nextInt();
                setAverageHoney(amount);
                System.out.printf("\n");
            }
            else if(whattodo == "6"){
                System.out.printf("wprowadź nazwe pasieki: ");
                name = s.nextLine();
                setNameofHive(name);
                System.out.printf("\n");
            }
            else if(whattodo == "7"){
                System.out.printf("%s\n",getNameofHive());
            }
            else if(whattodo == "8"){
                System.out.printf("wprowadź nazwe królowej: ");
                name = s.nextLine();
                setNameofQueen(name);
                System.out.printf("\n");
            }
            else if(whattodo == "9"){
                System.out.printf("%s\n",getNameofQueen());
            }
            else {
                System.out.printf("Brak wybranej opcji\n");
            }
            System.out.printf("\nWybierz opcję co chcesz zrobić:");
            System.out.printf("1 - zmiana liczby pszczół\n");
            System.out.printf("2 - odczytanie liczby pszczół\n");
            System.out.printf("3 - określenie połozenia ula\n");
            System.out.printf("4 - aktualna pozycja ula\n");
            System.out.printf("5 - dodanie aktualnej rocznej ilości wyprodukowanego przez ul miodu\n");
            System.out.printf("6 - nadanie nazwy pasiecie\n");
            System.out.printf("7 - odczytanie nazwy pasieki\n");
            System.out.printf("8 - ustalenie nazwy królowej\n");
            System.out.printf("9 - odczytanie nazwy królowej\n");
            System.out.printf("Jeśli chcesz zakończyć program - exit\n");
            whattodo = s.nextLine(); 
        } 
        s.close();
    }
}
