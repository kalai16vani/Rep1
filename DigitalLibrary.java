/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitallibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author kalaivani
 */
public class DigitalLibrary {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DigitalLibrary d=new DigitalLibrary();
        int num_visitors=d.no_of_visitors();
        System.out.println("Number of visitors :"+num_visitors);
    }
    

public int no_of_visitors()
{
    
    String userName,book_name,author;
    int no_of_visitors=0,bk1=0,bk2=0,bk3=0,bk4=0,bk5=0,bk6=0,bk7=0,bk8=0,bk9=0,bk10=0,bk11=0;
    int a1=0,a2=0,a3=0,a4=0,a5=0,a6=0,a7=0,a8=0,a9=0;
    Scanner sn=new Scanner(System.in);
    String choice="yes";
    while(choice.equalsIgnoreCase("yes"))
    {
    
    
    System.out.println("Please eneter trhe user name");
            
    
    userName=sn.next();
    if(userName.equals(null))
    {
        System.out.println("Please enter the user name");
    }else
    {
        String username="root";
        String password="root";
        Connection con;
        try
             {
                Class.forName("com.mysql.jdbc.Driver");  
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb",username,password);   
                Statement st=con.createStatement();
                String query="SELECT * FROM librarydb.books;";
                ResultSet rt=st.executeQuery(query);
                while(rt.next())
                {      
                    System.out.println(rt.getString(1)+" "+rt.getString(2)+" "+rt.getString(3));           
                }     
                con.close();
              }
        catch(Exception e)
              {
               System.out.println("Sorry!!!!");
              }
       
    
        
        no_of_visitors++;
        
        System.out.println("Enter the book name to be searches and the author name");
        book_name=sn.next();
        author=sn.next();
 
        switch(book_name)
        {
            case "Book1":
                bk1++;
                break;
           case "Book2":
                bk2++;
                break;
           case "Book3":
                bk3++;
                break;
           case "Book4":
                bk4++;
                break;
           case "Book5":
                bk5++;
                break;     
           case "Book6":
                bk6++;
                break;
            case "Book7":
                bk7++;
                break;
            case "Book8":
                bk8++;
                break;
            case "Book9":
                bk9++;
                break;
             case "Book10":
                bk10++;
                break;
             case "Book11":
                bk11++;
                break;
              default:System.out.println("No books in "+book_name+" name");
        }
        switch(author)
        {
            case "Author1":
               a1++;
               break;
            case "Author2":
               a2++;
               break;
            case "Author3":
               a3++;
               break;
            case "Author4":
               a4++;
               break;
            case "Author5":
               a5++;
               break;
            case "Author6":
               a6++;
               break;
            case "Author7":
               a7++;
               break;
            case "Author8":
               a8++;
               break;
            case "Author9":
               a9++;
               break;
             default:
                 System.out.println("NO author in name "+author);
        }
        
    }

    System.out.println("Any other visitors Yes Or no");
        choice=sn.next();
    
        
    }
    
    return  no_of_visitors;
}
}