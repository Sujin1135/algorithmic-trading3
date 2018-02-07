import java.util.List;
import java.util.ArrayList;

import static java.lang.System.out;

public class Test_5 {
    public static void main(String[] args) {
           List<Student> list = new ArrayList<Student>();

           for(int i=0; i < 10; i++) {
               // 사용자 값을 입력받아서 수학점수를 입력받을 수도 있지만 빠른 실행을 위해 Math.random()을 사용하였습니다.
               list.add(new Student((int)(Math.random() * 100) + 1));
           }

           out.println(average(list)); // 평균값을 콘솔창에 찍는다.
    }

    public static double average (List<Student> list) { // list안의 학생의 수학점수 평균을 구하는 메서드
        double sum = 0; // 총점을 더하기 위해 만든 변수
        int i = 0; // 점수중 0~100점에 충족하지 않는 값이 있을 경우 그 값을 제외하기 위한 카운트
        int count = 0; // 학생 수를 세는 카운트

        if(list.size() == 0) { // list에 아무 값도 없을 경우 0을 반환한다.
            out.println("list에 저장된 수학점수가 없습니다.");
            return 0;
        }

        for(Student stu : list) {
            int math = stu.getMath(); // 학생의 수학점수를 math 변수에 저장한다.

            if (math > 100 || math < 0) { // math 밸리데이션 체크
                out.println("점수가 잘못 입력되었습니다. 수학 점수의 범위는 0~100 입니다.");
                i++;
                continue;
            }

            out.println("학생"+ ++count + " 의 점수" + math);
            sum += math;
        }

        return sum / list.size() - i; // 총점 / 학생 수 - 밸리데이션 값에 충족하지 못한 학생수
    }
}

class Student {
    private int math;

    Student () {
        this(0);
    }

    Student (int math) {
        this.math = math;
    }

    int getMath () {
        return math;
    }

    Student setMath (int math) {
        this.math = math;
        return this;
    }
}