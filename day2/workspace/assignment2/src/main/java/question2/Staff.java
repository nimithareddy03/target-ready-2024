package day2.question2;

public class Staff extends Person {
    public String school;
    public double pay;

    public Staff(String name, String address, String school, double pay) {
        super(name, address);
        this.school = school;
        this.pay = pay;
    }
    public String getSchool(){
        return school;
    }

    public void setSchool(String school) {
        if(school.length() == 0){
            throw new RuntimeException("Invalid school name");
        }
        this.school = school;
    }
    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        if(pay < 0){
            throw new RuntimeException("Invalid pay");
        }
        this.pay = pay;
    }
    public String toString() {
        return "Staff[Person[name=" + name+ " ,address="+ address +" ], school = " +school +" ,pay = " +pay + " ]";
    }
}
