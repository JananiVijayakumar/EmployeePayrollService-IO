package com.bridgelabz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.bridgelabz.EmployeePayrollService.IOService.FILE_IO;

public class EmployeePayrollService {
    public EmployeePayrollService() {
    }

    public long readEmployeePayrollData(IOService ioService) {
        if (ioService.equals(FILE_IO))
            new EmployeePayrollFileIOService().readData();
        return employeePayrollList.size();
    }

    public enum IOService {CONSOLE_IO, FILE_IO, DB_IO, REST_IO;
        public void add(EmployeePayrollData employeePayrollData) {
        }

        public long size() {
            return 0;
        }
    }
    private IOService employeePayrollList;
    public EmployeePayrollService(List<EmployeePayrollData> employeePayrollList) {}
    public static void main(String[] args) {
        ArrayList<EmployeePayrollData> employeePayrollList = new ArrayList<>();
        EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollList);
        Scanner consoleInputReader = new Scanner(System.in);
        employeePayrollService.readEmployeePayrollData(consoleInputReader);
        employeePayrollService.writeEmployeePayrollData(IOService.CONSOLE_IO);
    }

    public void readEmployeePayrollData(Scanner consoleInputReader) {
        System.out.println("Enter Employee ID :");
        int id = consoleInputReader.nextInt();
        System.out.println("Enter Employee Name :");
        String name = consoleInputReader.next();
        System.out.println("Enter Employee Salary :");
        double salary = consoleInputReader.nextDouble();
        employeePayrollList.add(new EmployeePayrollData(id, name, salary));
    }

    public void writeEmployeePayrollData(IOService ioService) {
        if (ioService.equals(IOService.CONSOLE_IO))
            System.out.println("\n Writing Employee Details to console\n" + employeePayrollList);
        else if (ioService.equals(FILE_IO))
            new EmployeePayrollService().writeEmployeePayrollData(employeePayrollList);
    }

    public void printData(IOService ioService){
        if (ioService.equals(FILE_IO))
            new EmployeePayrollFileIOService().printData();
    }
    public long countEntries(IOService ioService) {
        if (ioService.equals(FILE_IO))
            return new EmployeePayrollFileIOService().countEntries();
        return  0;
    }
}
