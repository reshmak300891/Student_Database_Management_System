package model;

public class student {
private int rollno;
private String name;
private String clgName;
private String city;
private double percentage;
public student(int rollno, String name, String clgName, String city, double percentage) {
	super();
	this.rollno = rollno;
	this.name = name;
	this.clgName = clgName;
	this.city = city;
	this.percentage = percentage;
}

public student() {
	super();
}

public student(String name, String clgName, String city, double percentage) {
	super();
	this.name = name;
	this.clgName = clgName;
	this.city = city;
	this.percentage = percentage;
}

public int getRollno() {
	return rollno;
}
public void setRollno(int rollno) {
	this.rollno = rollno;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getClgName() {
	return clgName;
}
public void setClgName(String clgName) {
	this.clgName = clgName;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public double getPercentage() {
	return percentage;
}
public void setPercentage(double percentage) {
	this.percentage = percentage;
}


public String toString() {
	return "student [rollno=" + rollno + ", name=" + name + ", clgName=" + clgName + ", city=" + city + ", percentage="
			+ percentage + "]";
}

}
