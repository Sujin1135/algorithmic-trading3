import static java.lang.System.out;

public class Test_10 {
    public static void main(String[] args) {
        out.println(assign(6, 12, 10));
        out.println(assign(30, 50, 72));
    }

    public static int assign (int height, int width, int num) {
        if ((height * width) < num ) {
            out.println("빈 객실이 없습니다.");
            return 0;
        }

        int x = 0;
        int y = 0;

        x = (num % height) * 100;
        y = (num / height) +1;

        return x + y;
    }
}
