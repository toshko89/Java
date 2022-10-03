package Classes.RawData;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();
        List<Car> allCars = new LinkedList<>();

        while (!command.equals("fragile") && !command.equals("flamable")) {
            String[] car = command.split(" ");
            String model = car[0];
            int engineSpeed = Integer.parseInt(car[1]);
            int enginePower = Integer.parseInt(car[2]);
            int cargoWeight = Integer.parseInt(car[3]);
            String cargoType = car[4];
            double tire1Pressure = Double.parseDouble(car[5]);
            int tire1Age = Integer.parseInt(car[6]);
            double tire2Pressure = Double.parseDouble(car[7]);
            int tire2Age = Integer.parseInt(car[8]);
            double tire3Pressure = Double.parseDouble(car[9]);
            int tire3Age = Integer.parseInt(car[10]);
            double tire4Pressure = Double.parseDouble(car[11]);
            int tire4Age = Integer.parseInt(car[12]);
            Car currentCar = new Car(model, engineSpeed, enginePower, cargoWeight, cargoType, tire1Pressure, tire1Age, tire2Pressure, tire2Age, tire3Pressure, tire3Age, tire4Pressure, tire4Age);
            allCars.add(currentCar);
            command = scanner.nextLine();
        }
        if (command.equals("fragile")) {
            List<Car> cars = allCars.stream()
                    .filter(a -> a.cargoType.equals("fragile"))
                    .filter(a -> a.tire1Pressure < 1 || a.tire2Pressure < 1 || a.tire3Pressure < 1 || a.tire4Pressure < 1)
                    .collect(Collectors.toList());
            for (Car car : cars) {
                System.out.println(car.model);
            }
        } else if (command.equals("flamable")) {
            List<Car> cars = allCars.stream()
                    .filter(a -> a.cargoType.equals("flamable"))
                    .filter(a -> a.enginePower > 250)
                    .collect(Collectors.toList());
            for (Car car : cars) {
                System.out.println(car.model);
            }
        }
    }
}
