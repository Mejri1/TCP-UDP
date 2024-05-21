import java.rmi.Naming;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            CalcInterface calculatrice = (CalcInterface) Naming.lookup("//localhost/Calculatrice");
            Scanner scanner = new Scanner(System.in);
            boolean continuer = true;

            while (continuer) {
                System.out.println("Opérations disponibles :");
                System.out.println("1. Addition");
                System.out.println("2. Soustraction");
                System.out.println("3. Multiplication");
                System.out.println("4. Division");
                System.out.println("5. Quitter");

                System.out.print("Choisissez une opération : ");
                int choix = scanner.nextInt();

                if (choix == 5) {
                    continuer = false;
                    break;
                }

                System.out.print("Entrez le premier opérande : ");
                double a = scanner.nextDouble();
                System.out.print("Entrez le deuxième opérande : ");
                double b = scanner.nextDouble();

                double resultat;
                switch (choix) {
                    case 1:
                        resultat = calculatrice.addition(a, b);
                        break;
                    case 2:
                        resultat = calculatrice.soustraction(a, b);
                        break;
                    case 3:
                        resultat = calculatrice.multiplication(a, b);
                        break;
                    case 4:
                        resultat = calculatrice.division(a, b);
                        break;
                    default:
                        System.out.println("Choix invalide !");
                        continue;
                }

                System.out.println("Résultat : " + resultat);
            }
            System.out.println("Fin de la session.");
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
