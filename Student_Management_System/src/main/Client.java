package main;

import java.util.Scanner;

import dao.StudentDAOInterface;
import dao.studentDao;
import model.student;
// 1. Create Student Class
//2. Create DbConnection Class
//3. Create Client Class

public class Client  {

	public static void main(String[] args) {

		StudentDAOInterface dao=new studentDao();
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome to Student Management System");
		while(true)
		{
			System.out.println("1. Add Student");
			System.out.println("\n2. Show Student");
			System.out.println("\n3. Get Student by Roll No");
			System.out.println("\n4. Delete Student");
			System.out.println("\n5. Update Student");
			System.out.println("\n6. Exit");
			System.out.println("Enter Choice:");
			int ch=sc.nextInt();
			switch(ch)
			{
			case 1: 
				System.out.println("1. Add Student");
//                System.out.println("Enter student Name:");
//                String name=sc.next();
				System.out.println("Enter student Name:");
				String Sname=sc.next();
				System.out.println("Enter student College Name:");
				String CollegeName=sc.next();
				System.out.println("Enter student City:");
				String City=sc.next();
				System.out.println("Enter student Percentage:");
				double Per=sc.nextDouble();
				student st=new student(Sname, CollegeName, City, Per);
				boolean ans=dao.insertStudent(st);
				if(ans)
				{
					System.out.println("Record Inserted Successfully");
				}else
				{
					System.out.println("NOT Inserted Successfully");

				}
				break;
			case 2:
				System.out.println("2.Show Student");
				dao.showAllStudent();
				break;
			case 3: 
				System.out.println("3. Get Student by Roll No:");
				System.out.println("Enter Roll No:");
				int roll=sc.nextInt();
				boolean f=dao.showStudentsById(roll);
				if(!f)
				{
					System.out.println("Student is not available");
				}
				
				break;
			case 4:
				System.out.println("4. Delete student");
				System.out.println("Enter Roll No to delete:");
				int rollno=sc.nextInt();
			boolean f1= dao.deleteStudent(rollno);
			System.out.println(f1);
			if(f1)
			{
				System.out.println("Deleted Successfully");
			}else
			{
				System.out.println("Not Deleted");
			}
				break;
			case 5: 
				System.out.println("5. Update student");
				System.out.println("\n1. Update Name\n 2. Update Clg Name:");
				System.out.println("Enter your choice");
				int ch1=sc.nextInt();
				if(ch1==1)
				{
				System.out.println("Enter roll No");
				int rnum=sc.nextInt();
				System.out.println("Enter new Name");
				String sname=sc.next();
				student std=new student();
				std.setName(sname);
				boolean flag=dao.update(rnum,sname,ch1,std);
				if(flag)
				{
					System.out.println("Updated Successfully");
				}else
				{
					System.out.println("Not Updated");
				}
				}
				if(ch1==2)
				{
				System.out.println("Enter roll No");
				int rnum1=sc.nextInt();
				System.out.println("Enter new Name");
				String cname=sc.next();
				student std1=new student();
				std1.setName(cname);
				boolean flag1=dao.update(rnum1,cname,ch1,std1);
				if(flag1)
				{
					System.out.println("Updated Successfully");
				}else
				{
					System.out.println("Not Updated");
				}
				}
				break;
			case 6: 
				System.out.println("6. Exit");
				break;
			case 7:
				break;
			}
		}
	}

}