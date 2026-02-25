import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double numero;

        while (true) {
            System.out.print("Digite um número: ");
            numero = sc.nextDouble();

            if (numero < 0) {
                System.out.println("Número negativo detectado. Programa encerrado.");
                break;
            }
        }

        sc.close();
    }
}