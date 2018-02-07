import static java.lang.System.out;

import java.util.Scanner;

public class Test_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        out.println("기원후 년도를 입력해 주세요.");
        int user = scanner.nextInt();
        if(user < 0) {
            out.println("잘못된 입력입니다. 프로그램을 종료합니다.");
            System.exit(0);
        }
        checkLeapYear(user);
    }

    static void checkLeapYear(int year) {
        int check = year % 4;
        if(check == 0) {
            if(year % 100 ==0 && year % 400 != 0) {
                out.println("평년입니다.");
            } else {
                out.println("윤년입니다.");
            }
        } else {
            out.println("평년입니다.");
        }
    }
}
