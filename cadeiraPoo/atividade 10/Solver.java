import java.util.Scanner;

class Time {
    private int hour = 0;
    private int minute = 0;
    private int second = 0;



    public Time(int hour, int minute, int second); // todo 

    public void setHour(int hour); // todo 

    public void setMinute(int minute); // todo 


    public void setSecond(int second); // todo 

    public int getHour(); // todo 

    public int getMinute(); // todo 

    public int getSecond(); // todo 

    //avança o tempo em um segundo
    public void nextSecond(); // todo 

    public String toString() {
        return String.format("%02d", hour) + ":" + 
               String.format("%02d", minute) + ":" + 
               String.format("%02d", second);
    }
}


class Solver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Time time = new Time(0, 0, 0);
        while (true) {
            String line = scanner.nextLine();
            System.out.println("$" + line);

            String[] ui = line.split(" ");
            String cmd = ui[0];

            if (cmd.equals("end")) {
                break;
            } else if (cmd.equals("set")) {
                time.setHour(Integer.parseInt(ui[1]));
                time.setMinute(Integer.parseInt(ui[2]));
                time.setSecond(Integer.parseInt(ui[3]));
            } else if (cmd.equals("show")) {
                System.out.println(time);
            } else if (cmd.equals("next")) {
                time.nextSecond();
            } else {
                System.out.println("fail: comando inválido");
            }
        }

        scanner.close();
    }
}