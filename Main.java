
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.out;

/**
 * this is main mehod
 */
public class Main {


    public static void main(String[] args)
    {

        int x=0;//choice to performe verious operations and handle the loop

        String file=null;
     /*   Scanner sc=new Scanner(System.in);*/

        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        Opration opr=new Opration();

      try {
          do {
              out.println("Enter 1:Add Student \n"+
                              "Enter 2:Remove Student\n"+
                              "Enter 3:Display student\n"+
                              "Enter 4:update\n"+"exit\n");
              out.println("Enter your choice:");
              try {
              int ch=0;
                 try {
                      ch=Integer.parseInt( bufferedReader.readLine());
                  }catch (NumberFormatException e){
                     e.printStackTrace();
                 }
                  x = ch;
              }
              catch (InputMismatchException e)
              {
                  e.printStackTrace();
              }
              if (x == 1) {
                  opr.addstudent();
                  /*out.println("data store");*/
              }
              else if (x == 2) {
                  System.out.println("enter the student Id ");
                  int id =Integer.parseInt(bufferedReader.readLine());

                  opr.Removestudent(id);

              } else if (x == 3) {
                  opr.display();
              } else if (x == 4) {
                  out.println("ENTER THE ID OF STUDENT");
                  int id = Integer.parseInt(bufferedReader.readLine());
                  opr.updatestudent(id);
              } else if (x == 5) {
                  System.exit(0);
              } else {

                  out.println("Wrong Input");
              }

          } while (x!=5 );
      }catch (Exception ex)
      {

         System.out.println(" choice is not good");
      }


    }
}
