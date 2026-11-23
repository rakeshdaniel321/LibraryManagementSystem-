package com.rakesh.lms.modules;

public class StudentEntity{
private int  studentId ;
private String studentName;
private String mobileNumber;

public StudentEntity(int studentId,String studentName,String mobileNumber)
{
  this.studentId=studentId;
  this.studentName=studentName;
  this.mobileNumber=mobileNumber;
}

public StudentEntity(String studentName,String mobileNumber)
{
  this.studentName=studentName;
  this.mobileNumber=mobileNumber;
}

public int getStudentId()     {return studentId;}
public String getStudentName(){return studentName;}
public String getMobileNumber(){return mobileNumber;}

public void setStudentName(String studentName)  {this.studentName=studentName;}
public void setMobileNumber(String mobileNumber)  {this.mobileNumber=mobileNumber;}

  @Override
    public String toString() {
        return "{" + studentId + " - " + studentName + "-"+"+91"+mobileNumber+"}";
    }
}

