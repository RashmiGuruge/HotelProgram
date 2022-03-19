package Task_4;
//https://www.youtube.com/watch?v=UoM7SqWIrtA

public class Person {

    private  String customerFirstName;
    private  String customerLastName;
    private  String customerCardNumber;

    public Person(int x) {

    }

    public String getCustomerFirstName() {

        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {

        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {

        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {

        this.customerLastName = customerLastName;
    }

    public String getCustomerCardNumber() {

        return customerCardNumber;
    }

    public void setCustomerCardNumber(String customerCardNumber) {

        this.customerCardNumber = customerCardNumber;
    }

    public Person(String customerFirstName, String customerLastName, String customerCardNumber) {
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerCardNumber = customerCardNumber;
    }
}

