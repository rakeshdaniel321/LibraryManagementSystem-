package modules;
public class StudentEntity{
private int  studentId ;
private String studentName;

public StudentEntity(int studentId,String studentName)
{
this.studentId=studentId;
this.studentName=studentName;
}

public int getStudentId() {return studentId;}
public String getStudentName(){return studentName;}

public void setStudentName(String studentName){this.studentName=studentName;}

  @Override
    public String toString() {
        return "{" + studentId + " - " + studentName + "}";
    }
}

