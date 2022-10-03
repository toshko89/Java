package Classes.CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputN = Integer.parseInt(scanner.nextLine());
        Map<String, Engine> allEngines = new HashMap<>();
        Map<String, Car> allCars = new LinkedHashMap<>();

        while (inputN-- > 0) {
            String[] engine = scanner.nextLine().split(" ");
            if (engine.length == 4) {
                String model = engine[0];
                int power = Integer.parseInt(engine[1]);
                String displacement = engine[2];
                String efficiency = engine[3];
                Engine newEngine = new Engine(model, power, displacement, efficiency);
                allEngines.put(model, newEngine);
            } else if (engine.length == 3) {
                try {
                    String model = engine[0];
                    int power = Integer.parseInt(engine[1]);
                    int displacement = Integer.parseInt(engine[2]);
                    Engine newEngine = new Engine(model, power, Integer.toString(displacement), "n/a");
                    allEngines.put(model, newEngine);
                } catch (Exception e) {
                    String model = engine[0];
                    int power = Integer.parseInt(engine[1]);
                    String efficiency = engine[2];
                    Engine newEngine = new Engine(model, power, "n/a", efficiency);
                    allEngines.put(model, newEngine);
                }
            } else if (engine.length == 2) {
                String model = engine[0];
                int power = Integer.parseInt(engine[1]);
                Engine newEngine = new Engine(model, power, "n/a", "n/a");
                allEngines.put(model, newEngine);
            }
        }

        int inputM = Integer.parseInt(scanner.nextLine());

        while (inputM-- > 0) {
            String[] car = scanner.nextLine().split(" ");
            if (car.length == 4) {
                String model = car[0];
                String engine = car[1];
                String weigth = car[2];
                String color = car[3];
                Car newCar = new Car(model, allEngines.get(engine), weigth, color);
                allCars.put(model, newCar);
            } else if (car.length == 3) {
                try {
                    String model = car[0];
                    String engine = car[1];
                    int weigth = Integer.parseInt(car[2]);
                    Car newCar = new Car(model, allEngines.get(engine), Integer.toString(weigth), "n/a");
                    allCars.put(model, newCar);
                } catch (Exception e) {
                    String model = car[0];
                    String engine = car[1];
                    String color = car[2];
                    Car newCar = new Car(model, allEngines.get(engine), "n/a", color);
                    allCars.put(model, newCar);
                }
            } else if (car.length == 2) {
                String model = car[0];
                String engine = car[1];
                Car newCar = new Car(model, allEngines.get(engine), "n/a", "n/a");
                allCars.put(model, newCar);
            }
        }

        allCars.forEach((s, car) -> {
            System.out.printf("%s:%n%s:%nPower: %d%nDisplacement: %s%nEfficiency: %s%nWeight: %s%nColor: %s%n"
                    , car.model, car.engine.model
                    , car.engine.power
                    , car.engine.displacement
                    , car.engine.efficiency
                    , car.weight
                    , car.color);
        });
    }
}
