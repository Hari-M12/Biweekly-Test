public class DayOfTheProgrammer {
    public static String dayOfProgrammer(int year) {
        int [] monthInYear = {31,28,31,30,31,30,31,31,30,31,30,31};
        if (year == 1918) {
            monthInYear[1] = 15;
        } else {
            boolean leap = isLeap(year);
            monthInYear[1] = leap ? 29 : 28;
        }
        int sum = 0;
        for(int i=0;i<8;i++){
            sum+=monthInYear[i];
        }
        int day = 256 - sum ;
        // int month = 9;
        String dayInString = day<10 ? "0"+day : ""+day;
        String month = "09";
        String yearInStr = ""+year;
        return dayInString+"."+month+"."+yearInStr;
    }

    static boolean isLeap(int y){
        if (y < 1918) {
            return y % 4 == 0;
        } else {
            return (y % 400 == 0) || (y % 4 == 0 && y % 100 != 0);
        }
    }

    public static void main(String[] args) {
        int year1 = 2017;
        System.out.println(dayOfProgrammer(year1)); // 13.09.2017

        int year2 = 2016;
        System.out.println(dayOfProgrammer(year2)); // 12.09.2016

        int year3 = 1800;
        System.out.println(dayOfProgrammer(year3)); // 12.09.1800
    }
}
