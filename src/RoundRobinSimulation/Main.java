package RoundRobinSimulation;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Random random;
    public static void main(String[] args) throws InterruptedException, IOException {
        random = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la duracion de la simulacion: ");
        int time = sc.nextInt();
        System.out.print("Ingrese el intervalo de generacion de trabajos: ");
        int interval = sc.nextInt();
        ProcessList list = new ProcessList();
        int timeSinceLastInsertion = 0;
        list.insert(newRandomJob());
        while(time > 0){
            Runtime.getRuntime().exec("clear");
            time -= 1;
            timeSinceLastInsertion++;
            if(timeSinceLastInsertion == interval){
                list.insert(newRandomJob());
                timeSinceLastInsertion = 0;
            }
            list.process();
            list.print();
            Thread.sleep(1000);//sleep half a second
        }
    }

    private static Job newRandomJob() {
        return new Job(random.nextInt(50) + 1);
    }

}
