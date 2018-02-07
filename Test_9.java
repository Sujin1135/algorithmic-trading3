import static java.lang.System.out;

public class Test_9 {
    public static void main(String[] args) {
        out.println(dialPhone("UNUCIC"));
    }
    public static int dialPhone (String number) {
        int sum = 0;

        /*
            각 번호마다 해당되는 알파벳을 입력시켰다.
         */

        for(int i = 0; i < number.length(); i++) {
            String ch = number.substring(i, i+1);
            if (!ch.matches("(^[A-Z10]*$)")) {
                out.println("해당하는 값은 다이얼에 존재하지 않습니다.");
                System.exit(0);
            }

            if (ch.matches("(^[1]*$)")) {
                sum += 2;
            } else if (ch.matches("(^[A-C]*$)")) {
                sum += 3;
            } else if (ch.matches("(^[D-F]*$)")) {
                sum += 4;
            } else if (ch.matches("(^[G-I]*$)")) {
                sum += 5;
            } else if (ch.matches("(^[J-L]*$)")) {
                sum += 6;
            } else if (ch.matches("(^[M-O]*$)")) {
                sum += 7;
            } else if (ch.matches("(^[P-S]*$)")) {
                sum += 8;
            } else if (ch.matches("(^[T-V]*$)")) {
                sum += 9;
            } else if (ch.matches("(^[W-Z]*$)")) {
                sum += 10;
            } else if (ch.matches("(^[0]*$)")) {
                sum += 11;
            } else {
                out.println("입력 범위를 초과하였습니다.");
                return 0;
            }
        }

        return sum;
    }
}
