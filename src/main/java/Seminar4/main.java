package Seminar4;

public class main {
    public static void main(String[] args) {
        EmployeeDirectory employeeDirectory = new EmployeeDirectory();
        employeeDirectory.addingANewEmployee(23,445637,"Vasily",4);
        employeeDirectory.addingANewEmployee(24,432427,"Olga",4);
        System.out.println(employeeDirectory.employeePhoneNumber("Vasily"));
        System.out.println(employeeDirectory.employeeBySeniority(4));
        System.out.println(employeeDirectory.employeeByPersonnelNumber(23));
    }
}
