import java.util.Scanner;

import static java.lang.System.out;

public class Test_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        out.println("0 ~ 99 사이의 정수를 입력하세요.");
        int num = scanner.nextInt();
        out.println(cycle(num));
    }

    public static int cycle (int num) {
        if (num < 0 || num > 99) { // 입력값이 조건에 맞지 않을 경우.
            out.println("0~99 사이의 정수를 입력하세요.");
            return 0;
        }

        int i = 1; // 카운트
        int input1 = num / 10; // num의 10의 자릿수
        int input2 = num % 10; // num의 1의 자릿수
        int sum = input1 + input2; // input1 + input2 의 값
        int tmp = 0; // input1, input2, sum 의 자리를 바꾸기 위한 변수

        while(true) { // 초기의 값이 나올때까지 돌리는 반복문
            if (sum >= 10) { // sum의 값이 10 이상일 경우 sum의 10의 자릿수를 없앤 후 input2에 대입한다.
                tmp = input2;
                input1 = input2;
                input2 = sum % 10;
            } else { // sum의 10 이하인 경우 input2에 그대로 sum을 대입한다.
                tmp = input2;
                input1 = tmp;
                input2 = sum;
            }

            sum = input1 + input2;

            out.println("input1: " + input1 + "input2: " + input2);

            if((input1*10) + input2 == num) { // input1과 input2가 초기값이 맞으면 while문을 벗어난다.
                break;
            }

            i++; // 카운트를 1 증가시킨다.
        }

        return i; // 카운트 값을 반환한다.
    }
}
