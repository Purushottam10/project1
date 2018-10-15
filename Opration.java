


import java.io.*;
import java.lang.String;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.nio.file.*;

/**
 * Perform  different operation accourding to user
 */


public class Opration {

    private ArrayList<Student> arrayList = new ArrayList<>();
    private FileReader fileReader;
    private FileWriter fileWriter;
    //   List ls;
    private File file;
    private static int id = 0;
    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private String name = null;
    private Student student = null;

    /**
     * In this method we add student data in list
     */
    public void addstudent() {

        id = id + 1;
        int age = 0;


        System.out.println("Enter the name ");
        try {
            name = bufferedReader.readLine();
            System.out.println("Enter the age ");
            try {
                age = Integer.parseInt(bufferedReader.readLine());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }


            Student student = new Student(id, name, age);
            writedata(student);
        } catch (IOException ex) {
            System.out.println(ex);

        }
    }


    /**
     * in this method we remove data from arraylist
     *
     * @param id take student id and remove it
     */
    public void Removestudent(int id) {
        //filecreation();

        int found = 0;

        ArrayList<Student> arrayList = readdata("student.txt");
        //PrintWriter writer = new PrintWriter(file);

        try {

            PrintWriter writer = new PrintWriter("student.txt");
            writer.write("");
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i).getId() == id) {
                    found = 1;
                    arrayList.remove(i);
                } else {
                    writedata(arrayList.get(i));
                }

            }
            if (found == 1) {
                System.out.println(" student record  deleted from file");
            } else {
                System.out.println(" Student not Found ");
            }

            writer.close();
        } catch (Exception e) {
            e.getStackTrace();
        }


    }


    /**
     * In this method we display the record
     * read data from arraylist and display
     */

    public void display() {

        ArrayList list = readdata("student.txt");
        for (Iterator i = list.iterator(); i.hasNext(); ) {
            System.out.println(i.next());

        }
    }

    public void updatestudent(int id) throws IOException {

        int found = 0;

        ArrayList<Student> arrayList = readdata("student.txt");

        try {
            PrintWriter writer = new PrintWriter("student.txt");
            writer.write("");
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i).getId() == id) {
                    found = 1;
                    System.out.println("Enter the Student Name");
                    String name = bufferedReader.readLine();
                    System.out.println("Enter the Student age");
                    int age = Integer.parseInt(bufferedReader.readLine());
                    arrayList.get(i).setName(name);
                    arrayList.get(i).setAge(age);
                    writedata(arrayList.get(i));

                }

            }
            if (found == 1) {
                System.out.println(" student record updated from file");
            } else {
                System.out.println(" Student not Found ");
            }

            writer.close();
        } catch (Exception e) {
            e.getStackTrace();
        }

    }

    /**
     *In this method we write a data in arraylist
     * @param student In this we call student file to write data
     * @return null
     */

    public String writedata(Student student) {
        int age = 0;

        try {

            File file1 = new File("student.txt");
            FileWriter fw = new FileWriter("student.txt");

            if (!file1.exists()) {
                fw.write(student.toString());
                System.out.println("create file and write data ");
            } else {
                try {

                    // Open given file in append mode.
                    BufferedWriter out = new BufferedWriter(new FileWriter("student.txt", true));

                    out.write(student.toString());

                    System.out.println("data added ");
                    out.close();
                }
                //to handle exception
                catch (IOException e) {
                    System.out.println("exception occoured" + e);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        int a = arrayList.size();
        for (int i = 0; i < a; i++) {

            System.out.println(arrayList.get(i).toString());
        }
        return null;
    }

    /**
     *
     * @param file In  this we read from file
     * @return and return list
     */
    public ArrayList<Student> readdata(String file) {

        ArrayList<Student> list = new ArrayList<Student>();

        try {
            // System.out.println("gjjbj");

            BufferedReader bufferedReader = new BufferedReader(new FileReader("student.txt"));
            String s = bufferedReader.readLine();

            while (s != null) {

                //String line = s1.next();
                String s1 = s.toString();
                String s2[] = s1.split(" +");
                String name = s2[1];
                int id = Integer.parseInt(s2[0]);
                int age = Integer.parseInt(s2[2]);
                Student student = new Student(id, name, age);

                list.add(student);
                s = bufferedReader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;

    }
}














