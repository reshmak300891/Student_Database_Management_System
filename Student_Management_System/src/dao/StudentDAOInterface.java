package dao;

import model.student;

public interface StudentDAOInterface {
public boolean insertStudent(student s);
public boolean deleteStudent(int roll);
public boolean update(int roll, String update, int ch, student s);
public void showAllStudent();
public boolean showStudentsById(int roll);

}
