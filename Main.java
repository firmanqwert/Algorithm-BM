import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner string = new Scanner(System.in);
        String str, pattern;

        //считывает исходную строку и подстроку
        str = string.nextLine();
        pattern = string.nextLine();

        AlgorithmBoyerMoore.AlgorithmBoyerMoore(str, pattern);
    }


}
