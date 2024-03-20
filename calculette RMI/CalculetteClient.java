import java.rmi.Naming;
import java.util.Scanner;

public class CalculetteClient {
    public static void main(String[] args) {
        try {
            CalculetteInterface calc = (CalculetteInterface) Naming.lookup("rmi://localhost/CalcServer");
            Scanner scanner = new Scanner(System.in);
            String choix;
            do {
                System.out.print("Entrez le code de l'opération (+, -, *, /) : ");
                choix = scanner.nextLine();
                System.out.print("Entrez le premier operand : ");
                double a = scanner.nextDouble();
                System.out.print("Entrez le deuxième operand : ");
                double b = scanner.nextDouble();
                double resultat = 0;
                switch (choix) {
                    case "+":
                        resultat = calc.addition(a, b);
                        break;
                    case "-":
                        resultat = calc.soustraction(a, b);
                        break;
                    case "*":
                        resultat = calc.multiplication(a, b);
                        break;
                    case "/":
                        resultat = calc.division(a, b);
                        break;
                    default:
                        System.out.println("Code d'opération invalide.");
                        continue;
                }
                System.out.println("Résultat : " + resultat);
                scanner.nextLine(); // Pour consommer la nouvelle ligne
                System.out.print("Voulez-vous continuer (O/N) ? ");
                choix = scanner.nextLine();
            } while (choix.equalsIgnoreCase("O"));
            System.out.println("Fin de l'exécution.");
        } catch (Exception e) {
            System.err.println("Erreur client : " + e.toString());
            e.printStackTrace();
        }
    }
}
