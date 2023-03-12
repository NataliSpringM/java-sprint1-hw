class MonthData {
    int[] days = new int[30];


    void printDaysAndStepsFromMonth() {
        for (int i = 0; i < days.length; i++) {
            System.out.println((i + 1) + " день: " + days[i]);
        }
    }

    int sumStepsFromMonth() {
        int sumSteps = 0;
        for (int day : days) {
            sumSteps = sumSteps + day;
        }
        //System.out.println(sumSteps);
        return sumSteps;
    }
    int maxSteps() {
        int maxNumber = 0;
        for (int day : days) {
            if (day > maxNumber) {
                maxNumber = day;
            }
        }
        return maxNumber;
    }


    int bestSeries(int goalByStepsPerDay) {
        int maxLength = 0;
        int bestLength = 0;
        for (int day : days) {
            if (day >= goalByStepsPerDay) {
                maxLength++;
            } else if (bestLength <= maxLength) {
                bestLength = maxLength;
                maxLength = 0;
            }
        }

        if (bestLength < maxLength) {
            bestLength = maxLength;
        }
        return bestLength;
    }


}



