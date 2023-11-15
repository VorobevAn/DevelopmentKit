package Seminar4;

public class Employee {
    private Integer personnelNumber;
    private Integer phone;
    private String name;
    private Integer experience;

    public Employee(Integer personnelNumber, Integer phone, String name, Integer experience) {
        this.personnelNumber = personnelNumber;
        this.phone = phone;
        this.name = name;
        this.experience = experience;
    }

    public Integer getPersonnelNumber() {
        return personnelNumber;
    }

    public void setPersonnelNumber(Integer personnelNumber) {
        this.personnelNumber = personnelNumber;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "personnelNumber=" + personnelNumber +
                ", phone=" + phone +
                ", name='" + name + '\'' +
                ", experience=" + experience +
                '}';
    }
}
