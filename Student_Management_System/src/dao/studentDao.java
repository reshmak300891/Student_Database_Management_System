package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import db.dbconnection;
import model.student;

public class studentDao implements StudentDAOInterface {

	@Override
	public boolean insertStudent(student s) {
		boolean flag=false;
		try
		{ 
			Connection con=dbconnection.createConnection();
			String query="insert into student_details(Sname, Clgname, City, Per)values(?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1, s.getName());
			pst.setString(2, s.getClgName());
			pst.setString(3, s.getCity());
			pst.setDouble(4, s.getPercentage());
			pst.executeUpdate();
			flag=true;

		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean deleteStudent(int roll) {
	boolean flag= false;
		try
		{ 
			Connection con=dbconnection.createConnection();
			String query="delete from student_details where rollno="+roll;
			PreparedStatement pst=con.prepareStatement(query);
			int i=pst.executeUpdate();
			if(i>0)
			{
			flag=true;
			}else {
				flag=false;
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return flag;
		
	}

	@Override
	public boolean update(int rollno, String update, int ch, student s) {
         int choice=ch;
         boolean flag=false;
         try {
        	 if(choice==1)
     		{
     			Connection con=dbconnection.createConnection();
     			String query="update student_details set sname=? where rollno=?";
     			PreparedStatement ps=con.prepareStatement(query);
     			ps.setString(1, update);
     			ps.setInt(2, rollno);
     			ps.executeUpdate();
     			flag=true;
     		}
        	 if(choice==2)
      		{
      			Connection con=dbconnection.createConnection();
      			String query="update student_details set clgname=? where rollno=?";
      			PreparedStatement ps=con.prepareStatement(query);
      			ps.setString(1, update);
      			ps.setInt(2, rollno);
      			ps.executeUpdate();
      			flag=true;
      		}
         }catch(Exception e)
         {
        	 
         }
		
return flag;
	}

	public void showAllStudent() {
		try {
		Connection con=dbconnection.createConnection();
		String query="select * from student_details";
		Statement st=con.createStatement();
         ResultSet rs= st.executeQuery(query);
         while(rs.next())
         {
        	 System.out.println("RollNo"+rs.getInt(1)+"\n"+"Name: "+rs.getString(2)+"\n"+
        			 
        			 "Clg Name:" +rs.getString(3)+"\n"+
        			 "city:" +rs.getString(4)+"\n"+
        			 "Per:"+rs.getString(5)+"\n");
        	 System.out.println("----------------------------------------------");
         }
	}catch(Exception e)
		{
		
		}
		}

	@Override
	public boolean showStudentsById(int roll) {
		try {
			Connection con=dbconnection.createConnection();
			String query="select * from student_details where rollno="+roll;
			Statement st=con.createStatement();
	         ResultSet rs= st.executeQuery(query);
	         while(rs.next())
	         {
	        	 System.out.println("RollNo"+rs.getInt(1)+"\n"+"Name: "+rs.getString(2)+"\n"+
	        			 
	        			 "Clg Name:" +rs.getString(3)+"\n"+
	        			 "city:" +rs.getString(4)+"\n"+
	        			 "Per:"+rs.getString(5)+"\n");
	        	 System.out.println("----------------------------------------------");
	         }
		}catch(Exception e)
			{
			e.printStackTrace();
			}
			

		return false;
	}

}
