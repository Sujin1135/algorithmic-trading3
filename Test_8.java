import static java.lang.System.out;

public class Test_8 {
    public static void main(String[] args) {
        System.out.println(getPosition(3, 7, 7));
    }
    public static int getPosition(int n, int x, int y) {
        int oneSquareLength = (int) Math.pow(2, n - 1); // 1사분면의 길이
        System.out.println("1사분면의 길이: "+oneSquareLength);
        int answer = 0; // 리턴값
        int countOneSqure = oneSquareLength * oneSquareLength; // 1사분면당 넓이.
        System.out.println("길이: " + oneSquareLength);

        /*
            좌표값 유효성 검사
         */
        if ((oneSquareLength*2)-1 < x) {
            out.println("x좌표 입력값이 최대값을 초과하였습니다. 최대값은 " + (countOneSqure * 4) + " 입니다.");
            System.exit(0);
        } else if ((oneSquareLength*2)-1 < y) {
            out.println("y좌표 입력값이 최대값을 초과하였습니다. 최대값은 " + (countOneSqure * 4) + " 입니다.");
            System.exit(0);
        }

        if (x < oneSquareLength && y < oneSquareLength) {
            // 1사분면일 경우 경우의 수
            out.println("1사 분면");
            answer = x * oneSquareLength + y;
        } else if (x < oneSquareLength && y >= oneSquareLength) {
            // 2사분면일 경우 경우의 수
            out.println("2사 분면");
            answer = countOneSqure + x * oneSquareLength + (y - oneSquareLength);
        } else if (x >= oneSquareLength && y < oneSquareLength) {
            // 3사분면일 경우 경우의 수
            out.println("3사 분면");
            answer = countOneSqure * 2 + (x - oneSquareLength) * oneSquareLength + y;
        } else if (x >= oneSquareLength && y >= oneSquareLength) {
            // 4사분면일 경우 경우의 수
            out.println("4사 분면");
            answer = countOneSqure * 3 + (x - oneSquareLength) * oneSquareLength + (y - oneSquareLength);
        }
        return answer;
    }
}