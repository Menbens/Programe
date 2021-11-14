import java.util.Scanner;
import java.util.ArrayList;

class elem {
    String animal;
    String name;
    int age;
    String specific;

    elem(String a, String n, int v) {  //sa tai la final daca vrei un animal?
        animal = a;
        name = n;
        age = v;
        switch(a){
            case "Caine":
                specific = "E rapid";
                break;
            case "Pisica":
                specific = "Are Gheare";
                break;
            case "Maimuta":
                specific = "E paroasa";
                break;
            case "Sarpe":
                specific = "E alunecos";
                break;
            case "Cameleon":
                specific = "Poate sa se camufleze";
                break;

        }
    }

    public String toString() {
        return "Animal : " + animal + " | Nume : " + name + " | Varsta : " + age + " | Proprietate : " + specific + "\n";
    }
}

class Main {
    public static void main(String[] args) {
        ArrayList<elem> gigi = new ArrayList<elem>();
        ArrayList<String> animalele = new ArrayList<String>();
        animalele.add("Caine");
        animalele.add("Pisica");
        animalele.add("Maimuta");
        animalele.add("Sarpe");
        animalele.add("Cameleon");
        Integer varsta1;
        int i = 0;

        while (i < 5) {
            Integer q;
            for (q = 0; q < animalele.size(); q++) {
                System.out.println((q+1) +"." + animalele.get(q));
            }
            Scanner ceanimal = new Scanner(System.in);
            System.out.println("\nCe animal alegi? ");
            String animal = ceanimal.nextLine();

            for (q = 1; q-1 < animalele.size(); q++) {
                if (animal.compareTo(animalele.get(q-1)) == 0) {
                    break;
                }
                if (animal.compareTo(q.toString()) == 0){
                    animal = animalele.get(q-1);
                    break;
                }

            }
            if (q-1 == animalele.size()) {
                System.out.println("\nA aparut o eroare, dorim sa raspunzi din nou la intrebare:\n");
                continue;
            }
            animalele.remove(animal);

            Scanner cenume = new Scanner(System.in);
            System.out.println("Cum o sa il numesti?");
            String nume1 = cenume.nextLine();

            Scanner cevarsta = new Scanner(System.in);
            System.out.println("Cati ani are?");
            try {
                varsta1 = cevarsta.nextInt();
            }catch (Exception e){
                varsta1=0;
            }

            elem ab = new elem(animal , nume1, varsta1);
            gigi.add(ab);
            if(i==4) {
                break;
            }
            Scanner x = new Scanner(System.in);
            System.out.println("Vrei sa mai alegi un animal? (Y/N)");
            while (true) {
                String x1 = x.nextLine();
                if (x1.compareToIgnoreCase("n") == 0){
                    i = 5;
                    break;
                } else if (x1.compareToIgnoreCase("y") == 0) {
                    i += 1;
                    break;
                } else{
                    System.out.println("Raspundeti cu Y sau N!");
                }
            }
        }

        while (true) {
            for(i=0; i<gigi.size(); i++) {
                System.out.println(gigi.get(i).toString());
            }
            Scanner p = new Scanner(System.in);
            System.out.println("Vrei sa scoti un animal? (Y/N)");
            String poate;
            while(true){
                poate = p.nextLine();
                if(poate.compareToIgnoreCase("n") == 0 || poate.compareToIgnoreCase("y") == 0 ){
                    break;
                }
                System.out.println("Raspundeti cu Y sau N!");
            }
            if (poate.compareToIgnoreCase("n") == 0){
                break;

            } else if (poate.compareToIgnoreCase("y") == 0) {
                Scanner sters = new Scanner(System.in);
                System.out.println("Ce animal vrei sa scoti?");
                String scos = sters.nextLine();
                boolean corect = false;
                for(i=0; i<gigi.size(); i++) {
                    String arr = gigi.get(i).toString();
                    corect = arr.contains(scos);
                    if (corect == true) {
                        gigi.remove(i);
                    }
                }
                if (i == gigi.size() && corect == false){
                    System.out.println("Nu s-a gasit\n");
                }
            }
        }
    }
}
