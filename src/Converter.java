public class Converter {
    double oneStepKmDistance = 0.00075;
    double oneStepKCalorie = 0.05;
    int resultKm;
    int resultKcal;

    int convertToKm(int steps) {
        double value = (double)steps * oneStepKmDistance;
        resultKm = (int) Math.round(value);
        return resultKm;
    }

    int convertToKilocalories(int steps) {
        double value = (double)steps * oneStepKCalorie;
        resultKcal = (int) Math.round(value);
        return resultKcal;
    }
}



