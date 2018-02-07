import java.math.*;

public class Test_4 {
    public static void main(String[] args) {
        Person stu1 = new Person("홍길동", 19, 80);
        Person stu2 = new Person("임꺽정", 19, 91);
        Person stu3 = new Person("신사임당", 19, 95);

        System.out.println(stu1);
        System.out.println(stu2);
        System.out.println(stu3);

        score(stu1, stu2, stu3);
    }

    public static void score(Person stu1, Person stu2, Person stu3) {
        int[] mathArr = new int[]{stu1.math, stu2.math, stu3.math};
        double ever;

        int high = (int)Math.max(stu1.math, stu2.math);
        high = (int)Math.max(high, stu3.math);

        ever = stu1.math + stu2.math + stu3.math;

        System.out.println("최고 점수: "+ high);
        System.out.println("평균 점수: "+ ever / 3);
    }
}

class Person {
    String name;
    int age;
    int math;

    Person (String name, int age, int math) {
        this.name = name;
        this.age = age;
        this.math = math;
    }

    String myScore () {
        return name + "=>" + math;
    }
    public String toString() {
        return "name= "+ name + ",age= "+ age+ ",math= "+ math;
    }
}
