package Classes.RawData;

public class Car {
    String model;
    int engineSpeed;
    int enginePower;
    int cargoWeight;
    String cargoType;
    double tire1Pressure;
    int tire1Age;
    double tire2Pressure;
    int tire2Age;
    double tire3Pressure;
    int tire3Age;
    double tire4Pressure;
    int tire4Age;

    public Car(String model, int engineSpeed, int enginePower, int cargoWeight, String cargoType, double tire1Pressure
            , int tire1Age, double tire2Pressure,
               int tire2Age, double tire3Pressure, int tire3Age, double tire4Pressure, int tire4Age) {
            this.model = model;
            this.engineSpeed = engineSpeed;
            this.enginePower = enginePower;
            this.cargoWeight = cargoWeight;
            this.cargoType = cargoType;
            this.tire1Pressure = tire1Pressure;
            this.tire1Age=tire1Age;
            this.tire2Pressure = tire2Pressure;
            this.tire2Age=tire2Age;
            this.tire3Pressure=tire3Pressure;
            this.tire3Age=tire3Age;
            this.tire4Pressure=tire4Pressure;
            this.tire4Age=tire4Age;
    }
}
