package Trees;

import java.util.*;

import static java.util.Arrays.asList;

public class EmployeeImportance {

    public static void main(String[] args) {
        Employee employee1 = new Employee();
        employee1.id = 1;
        employee1.importance = 5;
        employee1.subordinates = asList(2, 3);

        Employee employee2 = new Employee();
        employee2.id = 2;
        employee2.importance = 3;
        employee2.subordinates = Arrays.asList(4);

        Employee employee3 = new Employee();
        employee3.id = 3;
        employee3.importance = 4;
        employee3.subordinates = new ArrayList<>();

        Employee employee4 = new Employee();
        employee4.id = 4;
        employee4.importance = 1;
        employee4.subordinates = new ArrayList<>();

        System.out.println(getImportance(asList(employee1, employee2, employee3, employee4), 1));
    }

    public static int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> employeeMap = new HashMap<>();

        for (Employee employee : employees) {
            employeeMap.put(employee.id, employee);
        }

        return getImportanceHelper(employeeMap, id);
    }

    private static int getImportanceHelper(Map<Integer, Employee> employeeMap, int id) {
        if (employeeMap.get(id).subordinates.size() == 0) {
            return employeeMap.get(id).importance;
        }

        int importance = 0;
        for (Integer subordinateId : employeeMap.get(id).subordinates) {
            importance += getImportanceHelper(employeeMap, subordinateId);
        }
        return importance + employeeMap.get(id).importance;
    }
}
