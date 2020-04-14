import java.util.Scanner;

class Agenda {
    public static void main(String args[]) {
        String next = "";
        Scanner input = new Scanner(System.in);

        while(!next.equals("exit")) {
            next = input.nextLine();
            System.out.println(next);
        }

        input.close();
    }
}