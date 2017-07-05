import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Podaj liczbę punktów do wygenerowania:");
        final int ipoints = input.nextInt();

        System.out.println("Podaj maksymalna wartosc dla wspolrzednych punktów:");
        final int max = input.nextInt();

        Random generator = new Random();
        ArrayList<Point> points = new ArrayList<>();
        for (int i = 0; i < ipoints; i++) {
            Double x = generator.nextDouble()*max;
            Double y = generator.nextDouble()*max;
            points.add(new Point(x, y));
        }
        System.out.println("Wygenerowane punkty:");
        Point[] tPoints = new Point[points.size()];
        for (int i = 0; i < points.size(); i++) {
            tPoints[i] = points.get(i);
            tPoints[i].printPoint();
        }
        points.clear();
        points = Jarvis.jarvis(tPoints);

        System.out.println("Punkty tworzące otoczkę to:");
        for (int i = 0; i < points.size(); i++) {
            points.get(i).printPoint();
        }

        int i = 0;

        for (int j = 0; j < 1000000; j++) {
            Double xTmp = generator.nextDouble()*100;
            Double yTmp = generator.nextDouble()*100;
            Point tmp = new Point(xTmp, yTmp);

            if(Functions.isInside(tmp, points)) i++;
        }
        System.out.println("Pole utworzonego wielokąta wynosi: " + (i/100) + " jednostek kwadratowych");
    }




}
