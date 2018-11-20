package sda;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Student st = new Student(null,"Marian", "Kowalski", "123");

StudentDao studentDao = new StudentDao();
//studentDao.saveStudentIntoDatabase(st);
//System.out.println(studentDao.getAllStudentsFromDatabase());



        Scanner wybor= new Scanner(System.in);
        System.out.println("Co chcesz zrobic, dodaj, listuj, exit");

        if(wybor.equals("dodaj")){
            System.out.println("Podaj imie:");
            Student student = new Student(null,wybor.next(),wybor.next(),wybor.next());
            studentDao.saveStudentIntoDatabase(student);
        }



    }
}
