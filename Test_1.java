import static java.lang.System.out;

import java.util.Scanner;

public class Test_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        out.println("원하는 직사각형의 수를 입력해 주세요!(1이상 100이하의 정수)");
        int user = scanner.nextInt();
        out.println("직사각형의 갯수는 " + user + "개 이 직사각형의 둘레는 " + fibonacci(user) + "입니다.");
    }

    static int fibonacci(int number) { // 피보나치 수열로 이루어진 직사각형의 둘레를 구하는 메서드
        int n1 = 1;
        int n2 = 0;
        int tmp = 0;
        int result =0;
        if(number < 1 || number > 100) {
            out.println("1이상 100이하의 정수값이 아닙니다! 프로그램을 종료합니다.");
            System.exit(0);
        }
        for(int i=0; i < number; i++) {
            if(i == number - 1) {
                int sum = n1 + n2;
                result = (sum + n1)  * 2;
            } else {
               tmp = n1;
               n1 += n2;
               n2 = tmp;
               out.println("n1 = "+ n1 + " n2 = " + n2);
            }
        }
        return result;
    }
}
