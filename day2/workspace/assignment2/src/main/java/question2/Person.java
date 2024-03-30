package day2.question2;

public class Person {
    public String name;
    public String address;
    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address){
        if(address.length() == 0){
            throw new RuntimeException("Invalid adress");
        }
        this.address = address;
    }
    public String toString() {
        return "Person [name = " + name + " ,address = " + address + " ]";
    }
}
