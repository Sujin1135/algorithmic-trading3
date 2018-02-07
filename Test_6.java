import java.util.Scanner;

import static java.lang.System.out;

public class Test_6 {
    public static void main(String[] args) {
        int count = -1;
        Scanner scanner = new Scanner(System.in);
        out.println("입력하신 정수값의 횟수만큼 별을 출력합니다 0 ~ 50 사이의 값을 입력해 주세요.");
        out.println("입력 범위를 초과할 경우 별을 출력하지 않습니다.");
        while(count < 0 || count > 50) {
            out.println("값을 입력하세요. 99를 입력하면 종료됩니다.");
            count = scanner.nextInt();
            if (count == 99) {
                System.exit(0);
            } else if (count < 0 || count > 50) {
                out.println("잘못된 입력값입니다. 0~50 사이의 정수를 입력하세요.");
            }
        }

        star(count, '*');
    }

    public static void star(int count, char c) {
        for (int i = count; i > 0; i--) {
            for (int x = 0; x < count - i; x++) {
                out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                out.print(c);
            }
            out.println();
        }
    }
}
