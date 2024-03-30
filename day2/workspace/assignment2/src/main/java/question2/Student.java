package day2.question2;

public class Student extends Person {
    public String program;
    public int year;
    public double fee;
    public Student(String name, String address, String program,int year, double fee) {
        super(name, address);
        this.program = program;
        this.fee = fee;
        this.year = year;

    }
    public String getProgram() {
        return program;
    }
    public void setProgram(String program){
        if(program.length() == 0){
            throw new RuntimeException("Invalid program");
        }
        this.program = program;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year){
        if(year < 0){
            throw new RuntimeException("Invalid year");
        }
        this.year = year;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        if(fee < 0){
            throw new RuntimeException("Invalid fee");
        }
        this.fee = fee;
    }
    public String toString() {
        return "Student[Person[name=" + name+ " ,address="+ address +" ], program = " + program +" ,year = " + year + ", fee = "+fee +" ]";
    }
}
