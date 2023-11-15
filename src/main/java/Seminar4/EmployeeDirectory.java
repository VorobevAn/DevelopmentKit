package Seminar4;

import java.util.*;

public class EmployeeDirectory {

    public List<Employee> listEmployee = new ArrayList<>();


    /**
     * Метод поиска сотрудника по стажу
     *
     * @param experience Стаж для поиска
     * @return Список сотрудников удовлетровяющих поиску
     */
    public List<Employee> employeeBySeniority(int experience) {
        List<Employee> resultList = new ArrayList<>();
        for (Employee worker : listEmployee) {
            if (worker.getExperience() == experience) resultList.add(worker);
        }
        return resultList;
    }

    /**
     * Поиск по имени
     *
     * @param name
     * @return
     */
    public Map<Integer, String> employeePhoneNumber(String name) {
        Map<Integer, String> employee = new HashMap<>();
        for (Employee worker : listEmployee) {
            if (worker.getName().equals(name)) {
                employee.put(worker.getPhone(), worker.getName());
            }
        }
        return employee;
    }

    /**
     * Поиск по табельному номеру
     *
     * @param number
     * @return
     */
    public Employee employeeByPersonnelNumber(Integer number) {
        for (Employee worker : listEmployee) {
            if (worker.getPersonnelNumber() == number) {
                return worker;
            }
        }
        return null;
    }

    /**
     * Добавление нового сотрудника
     * @param personnelNumber Табельный номер
     * @param phone телефон
     * @param name имя
     * @param experience стаж
     */
    public void addingANewEmployee(int personnelNumber, int phone, String name, int experience) {
        Employee employee = new Employee(personnelNumber, phone, name, experience);
        listEmployee.add(employee);


    }

}