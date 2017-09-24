package com.example;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name="EmailDomainTrust.getAllStudent",
                query="SELECT e FROM Student e")
})
public class Student {
    @Id
    @GeneratedValue
    @Column(name = "STUDENT_ID")
    private long studentId;
    @Column(name = "STUDENT_NAME", nullable = false, length = 100)
    private String studentName;

    @PrimaryKeyJoinColumn
   @OneToOne
    private Address studentAddress;

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentAddress=" + studentAddress +
                '}';
    }

    public Student() {
    }

    public Student(String studentName, Address studentAddress) {
        this.studentName = studentName;
        this.studentAddress = studentAddress;
    }


    public long getStudentId() {
        return this.studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }


    public String getStudentName() {
        return this.studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @OneToOne(cascade = CascadeType.ALL)
    public Address getStudentAddress() {
        return this.studentAddress;
    }

    public void setStudentAddress(Address studentAddress) {
        this.studentAddress = studentAddress;
    }


}
