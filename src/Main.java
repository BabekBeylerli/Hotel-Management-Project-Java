import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

class Food implements Serializable
{
    int itemNo;
    int quantity;
    float price;

    Food(int itemNo,int quantity)
    {
        this.itemNo=itemNo;
        this.quantity=quantity;
        switch(itemNo)
        {
            case 1:price=quantity*50;
                break;
            case 2:price=quantity*60;
                break;
            case 3:price=quantity*70;
                break;
            case 4:price=quantity*30;
                break;
        }
    }
}
class SingleRoom implements Serializable
{
    String name;
    String contact;
    String gender;
    ArrayList<Food> food =new ArrayList<>();


    SingleRoom()
    {
        this.name="";
    }
    SingleRoom(String name,String contact,String gender)
    {
        this.name=name;
        this.contact=contact;
        this.gender=gender;
    }
}
class DoubleRoom extends SingleRoom implements Serializable
{
    String name2;
    String contact2;
    String gender2;

    DoubleRoom()
    {
        this.name="";
        this.name2="";
    }
    DoubleRoom(String name,String contact,String gender,String name2,String contact2,String gender2)
    {
        this.name=name;
        this.contact=contact;
        this.gender=gender;
        this.name2=name2;
        this.contact2=contact2;
        this.gender2=gender2;
    }
}
class NotAvailable extends Exception
{
    @Override
    public String toString()
    {
        return "Not Available !";
    }
}

class Holder implements Serializable
{
    DoubleRoom luxury_doubleroom[]=new DoubleRoom[10]; //Luxury
    DoubleRoom deluxe_doubleroom[]=new DoubleRoom[20]; //Deluxe
    SingleRoom luxury_singleroom[]=new SingleRoom[10]; //Luxury
    SingleRoom deluxe_singleroom[]=new SingleRoom[20]; //Deluxe
}

class Hotel
{
    static Holder h_ob=new Holder();
    static Scanner sc = new Scanner(System.in);
    static void CustomerDetails(int i,int rn)
    {
        String name, contact, gender;
        String name2 = null, contact2 = null;
        String gender2="";
        System.out.print("\nEnter customer name: ");
        name = sc.next();
        System.out.print("Enter contact number: ");
        contact=sc.next();
        System.out.print("Enter gender: ");
        gender = sc.next();
        if(i<3)
        {
            System.out.print("Enter second customer name: ");
            name2 = sc.next();
            System.out.print("Enter contact number: ");
            contact2=sc.next();
            System.out.print("Enter gender: ");
            gender2 = sc.next();
        }

        switch (i) {
            case 1:h_ob.luxury_doubleroom[rn]=new DoubleRoom(name,contact,gender,name2,contact2,gender2);
                break;
            case 2:h_ob.deluxe_doubleroom[rn]=new DoubleRoom(name,contact,gender,name2,contact2,gender2);
                break;
            case 3:h_ob.luxury_singleroom[rn]=new SingleRoom(name,contact,gender);
                break;
            case 4:h_ob.deluxe_singleroom[rn]=new SingleRoom(name,contact,gender);
                break;
            default:System.out.println("Wrong option");
                break;
        }
    }

    static void BookRoom(int i)
    {
        int j;
        int rn;
        System.out.println("\nChoose room number from : ");
        switch (i) {
            case 1:
                for(j=0;j<h_ob.luxury_doubleroom.length;j++)
                {
                    if(h_ob.luxury_doubleroom[j]==null)
                    {
                        System.out.print(j+1+",");
                    }
                }
                System.out.print("\nEnter room number: ");
                try{
                    rn=sc.nextInt();
                    rn--;
                    if(h_ob.luxury_doubleroom[rn]!=null)
                        throw new NotAvailable();
                    CustomerDetails(i,rn);
                }
                catch(Exception e)
                {
                    System.out.println("Invalid Option");
                    return;
                }
                break;
            case 2:
                for(j=0;j<h_ob.deluxe_doubleroom.length;j++)
                {
                    if(h_ob.deluxe_doubleroom[j]==null)
                    {
                        System.out.print(j+11+",");
                    }
                }
                System.out.print("\nEnter room number: ");
                try{
                    rn=sc.nextInt();
                    rn=rn-11;
                    if(h_ob.deluxe_doubleroom[rn]!=null)
                        throw new NotAvailable();
                    CustomerDetails(i,rn);
                }
                catch(Exception e)
                {
                    System.out.println("Invalid Option");
                    return;
                }
                break;
            case 3:
                for(j=0;j<h_ob.luxury_singleroom.length;j++)
                {
                    if(h_ob.luxury_singleroom[j]==null)
                    {
                        System.out.print(j+31+",");
                    }
                }
                System.out.print("\nEnter room number: ");
                try{
                    rn=sc.nextInt();
                    rn=rn-31;
                    if(h_ob.luxury_singleroom[rn]!=null)
                        throw new NotAvailable();
                    CustomerDetails(i,rn);
                }
                catch(Exception e)
                {
                    System.out.println("Invalid Option");
                    return;
                }
                break;
            case 4:
                for(j=0;j<h_ob.deluxe_singleroom.length;j++)
                {
                    if(h_ob.deluxe_singleroom[j]==null)
                    {
                        System.out.print(j+41+",");
                    }
                }
                System.out.print("\nEnter room number: ");
                try{
                    rn=sc.nextInt();
                    rn=rn-41;
                    if(h_ob.deluxe_singleroom[rn]!=null)
                        throw new NotAvailable();
                    CustomerDetails(i,rn);
                }
                catch(Exception e)
                {
                    System.out.println("Invalid Option");
                    return;
                }
                break;
            default:
                System.out.println("Enter valid option");
                break;
        }
        System.out.println("Room Booked");
    }

    static void features(int i)
    {
        switch (i) {
            case 1:System.out.println("Number of double beds : 1\nAC : Yes\nFree breakfast : Yes\nCharge per day:4000 ");
                break;
            case 2:System.out.println("Number of double beds : 1\nAC : No\nFree breakfast : Yes\nCharge per day:3000  ");
                break;
            case 3:System.out.println("Number of single beds : 1\nAC : Yes\nFree breakfast : Yes\nCharge per day:2200  ");
                break;
            case 4:System.out.println("Number of single beds : 1\nAC : No\nFree breakfast : Yes\nCharge per day:1200 ");
                break;
            default:
                System.out.println("Enter valid option");
                break;
        }
    }

    static void availability(int i)
    {
        int j,count=0;
        switch (i) {
            case 1:
                for(j=0;j<10;j++)
                {
                    if(h_ob.luxury_doubleroom[j]==null)
                        count++;
                }
                break;
            case 2:
                for(j=0;j<h_ob.deluxe_doubleroom.length;j++)
                {
                    if(h_ob.deluxe_doubleroom[j]==null)
                        count++;
                }
                break;
            case 3:
                for(j=0;j<h_ob.luxury_singleroom.length;j++)
                {
                    if(h_ob.luxury_singleroom[j]==null)
                        count++;
                }
                break;
            case 4:
                for(j=0;j<h_ob.deluxe_singleroom.length;j++)
                {
                    if(h_ob.deluxe_singleroom[j]==null)
                        count++;
                }
                break;
            default:
                System.out.println("Enter valid option");
                break;
        }
        System.out.println("Number of rooms available : "+count);
    }

    static void bill(int rn,int rtype)
    {
        double amount=0;
        String list[]={"Sandwich","Pasta","Noodles","Coke"};
        System.out.println("\n*******");
        System.out.println(" Bill:-");
        System.out.println("*******");

        switch(rtype)
        {
            case 1:
                amount+=4000;
                System.out.println("\nRoom Charge - "+4000);
                System.out.println("\n===============");
                System.out.println("Food Charges:- ");
                System.out.println("===============");
                System.out.println("Item   Quantity    Price");
                System.out.println("-------------------------");
                for(Food obb:h_ob.luxury_doubleroom[rn].food)
                {
                    amount+=obb.price;
                    String format = "%-10s%-10s%-10s%n";
                    System.out.printf(format,list[obb.itemNo-1],obb.quantity,obb.price );
                }

                break;
            case 2:amount+=3000;
                System.out.println("Room Charge - "+3000);
                System.out.println("\nFood Charges:- ");
                System.out.println("===============");
                System.out.println("Item   Quantity    Price");
                System.out.println("-------------------------");
                for(Food obb:h_ob.deluxe_doubleroom[rn].food)
                {
                    amount+=obb.price;
                    String format = "%-10s%-10s%-10s%n";
                    System.out.printf(format,list[obb.itemNo-1],obb.quantity,obb.price );
                }
                break;
            case 3:amount+=2200;
                System.out.println("Room Charge - "+2200);
                System.out.println("\nFood Charges:- ");
                System.out.println("===============");
                System.out.println("Item   Quantity    Price");
                System.out.println("-------------------------");
                for(Food obb:h_ob.luxury_singleroom[rn].food)
                {
                    amount+=obb.price;
                    String format = "%-10s%-10s%-10s%n";
                    System.out.printf(format,list[obb.itemNo-1],obb.quantity,obb.price );
                }
                break;
            case 4:amount+=1200;
                System.out.println("Room Charge - "+1200);
                System.out.println("\nFood Charges:- ");
                System.out.println("===============");
                System.out.println("Item   Quantity    Price");
                System.out.println("-------------------------");
                for(Food obb: h_ob.deluxe_singleroom[rn].food)
                {
                    amount+=obb.price;
                    String format = "%-10s%-10s%-10s%n";
                    System.out.printf(format,list[obb.itemNo-1],obb.quantity,obb.price );
                }
                break;
            default:
                System.out.println("Not valid");
        }
        System.out.println("\nTotal Amount- "+amount);
    }

    static void deallocate(int rn,int rtype)
    {
        int j;
        char w;
        switch (rtype) {
            case 1:
                if(h_ob.luxury_doubleroom[rn]!=null)
                    System.out.println("Room used by "+h_ob.luxury_doubleroom[rn].name);
                else
                {
                    System.out.println("Empty Already");
                    return;
                }
                System.out.println("Do you want to checkout ?(y/n)");
                w=sc.next().charAt(0);
                if(w=='y'||w=='Y')
                {
                    bill(rn,rtype);
                    h_ob.luxury_doubleroom[rn]=null;
                    System.out.println("Deallocated successfully");
                }

                break;
            case 2:
                if(h_ob.deluxe_doubleroom[rn]!=null)
                    System.out.println("Room used by "+h_ob.deluxe_doubleroom[rn].name);
                else
                {
                    System.out.println("Empty Already");
                    return;
                }
                System.out.println(" Do you want to checkout ?(y/n)");
                w=sc.next().charAt(0);
                if(w=='y'||w=='Y')
                {
                    bill(rn,rtype);
                    h_ob.deluxe_doubleroom[rn]=null;
                    System.out.println("Deallocated successfully");
                }

                break;
            case 3:
                if(h_ob.luxury_singleroom[rn]!=null)
                    System.out.println("Room used by "+h_ob.luxury_singleroom[rn].name);
                else
                {
                    System.out.println("Empty Already");
                    return;
                }
                System.out.println(" Do you want to checkout ? (y/n)");
                w=sc.next().charAt(0);
                if(w=='y'||w=='Y')
                {
                    bill(rn,rtype);
                    h_ob.luxury_singleroom[rn]=null;
                    System.out.println("Deallocated succesfully");
                }

                break;
            case 4:
                if(h_ob.deluxe_singleroom[rn]!=null)
                    System.out.println("Room used by "+h_ob.deluxe_singleroom[rn].name);
                else
                {
                    System.out.println("Empty Already");
                    return;
                }
                System.out.println(" Do you want to checkout ? (y/n)");
                w=sc.next().charAt(0);
                if(w=='y'||w=='Y')
                {
                    bill(rn,rtype);
                    h_ob.deluxe_singleroom[rn]=null;
                    System.out.println("Deallocated succesfully");
                }
                break;
            default:
                System.out.println("\nEnter valid option : ");
                break;
        }
    }

    static void order(int rn,int rtype)
    {
        int i,q;
        char wish;
        try{
            System.out.println("\n==========\n   Menu:  \n==========\n\n1.Sandwich\tRs.50\n2.Pasta\t\tRs.60\n3.Noodles\tRs.70\n4.Coke\t\tRs.30\n");
            do
            {
                i = sc.nextInt();
                System.out.print("Quantity- ");
                q=sc.nextInt();

                switch(rtype){
                    case 1: h_ob.luxury_doubleroom[rn].food.add(new Food(i,q));
                        break;
                    case 2: h_ob.deluxe_doubleroom[rn].food.add(new Food(i,q));
                        break;
                    case 3: h_ob.luxury_singleroom[rn].food.add(new Food(i,q));
                        break;
                    case 4: h_ob.deluxe_singleroom[rn].food.add(new Food(i,q));
                        break;
                }
                System.out.println("Do you want to order anything else ? (y/n)");
                wish=sc.next().charAt(0);
            }while(wish=='y'||wish=='Y');
        }
        catch(NullPointerException e)
        {
            System.out.println("\nRoom not booked");
        }
        catch(Exception e)
        {
            System.out.println("Cannot be done");
        }
    }
}


class write implements Runnable
{
    Holder hotel_ob;
    write(Holder hotel_ob)
    {
        this.hotel_ob=hotel_ob;
    }
    @Override
    public void run() {
        try{
            FileOutputStream fout=new FileOutputStream("backup");
            ObjectOutputStream oos=new ObjectOutputStream(fout);
            oos.writeObject(hotel_ob);
        }
        catch(Exception e)
        {
            System.out.println("Error in writing "+e);
        }

    }

}

public class Main {
    public static void main(String[] args){

        try
        {
            File f = new File("backup");
            if(f.exists())
            {
                FileInputStream fin=new FileInputStream(f);
                ObjectInputStream ois=new ObjectInputStream(fin);
                Hotel.h_ob=(Holder)ois.readObject();
            }
            Scanner sc = new Scanner(System.in);
            int ch,ch2;
            char wish;
            x:
            do{

                System.out.println("\nEnter your choice :\n1.Display room details\n2.Display room availability \n3.Book\n4.Order food\n5.Checkout\n6.Exit\n");
                ch = sc.nextInt();
                switch(ch){
                    case 1: System.out.println("\nChoose room type :\n1.Luxury Double Room \n2.Deluxe Double Room \n3.Luxury Single Room \n4.Deluxe Single Room\n");
                        ch2 = sc.nextInt();
                        Hotel.features(ch2);
                        break;
                    case 2:System.out.println("\nChoose room type :\n1.Luxury Double Room \n2.Deluxe Double Room \n3.Luxury Single Room\n4.Deluxe Single Room\n");
                        ch2 = sc.nextInt();
                        Hotel.availability(ch2);
                        break;
                    case 3:System.out.println("\nChoose room type :\n1.Luxury Double Room \n2.Deluxe Double Room \n3.Luxury Single Room\n4.Deluxe Single Room\n");
                        ch2 = sc.nextInt();
                        Hotel.BookRoom(ch2);
                        break;
                    case 4:
                        System.out.print("Room Number -");
                        ch2 = sc.nextInt();
                        if(ch2>60)
                            System.out.println("Room doesn't exist");
                        else if(ch2>40)
                            Hotel.order(ch2-41,4);
                        else if(ch2>30)
                            Hotel.order(ch2-31,3);
                        else if(ch2>10)
                            Hotel.order(ch2-11,2);
                        else if(ch2>0)
                            Hotel.order(ch2-1,1);
                        else
                            System.out.println("Room doesn't exist");
                        break;
                    case 5:
                        System.out.print("Room Number -");
                        ch2 = sc.nextInt();
                        if(ch2>60)
                            System.out.println("Room doesn't exist");
                        else if(ch2>40)
                            Hotel.deallocate(ch2-41,4);
                        else if(ch2>30)
                            Hotel.deallocate(ch2-31,3);
                        else if(ch2>10)
                            Hotel.deallocate(ch2-11,2);
                        else if(ch2>0)
                            Hotel.deallocate(ch2-1,1);
                        else
                            System.out.println("Room doesn't exist");
                        break;
                    case 6:break x;

                }

                System.out.println("\nContinue : (y/n)");
                wish=sc.next().charAt(0);
                if(!(wish=='y'||wish=='Y'||wish=='n'||wish=='N'))
                {
                    System.out.println("Invalid Option");
                    System.out.println("\nContinue : (y/n)");
                    wish=sc.next().charAt(0);
                }

            }while(wish=='y'||wish=='Y');

            Thread t=new Thread(new write(Hotel.h_ob));
            t.start();
        }
        catch(Exception e)
        {
            System.out.println("Not a valid input");
        }
    }
}
