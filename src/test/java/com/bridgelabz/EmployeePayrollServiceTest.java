package com.bridgelabz;
import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import static com.bridgelabz.EmployeePayrollService.IOService.FILE_IO;
public class EmployeePayrollServiceTest {
    @Test
    public void givenEmployeeDetailsShouldMatchWithEmployeeEntries() {
        EmployeePayrollData[] arrayOfEmployees = {
                new EmployeePayrollData(1, "janu", 450000),
                new EmployeePayrollData(2, "prema", 400000),
                new EmployeePayrollData(3, "sri", 350000)
        };
        EmployeePayrollService employeePayrollService;
        employeePayrollService = new EmployeePayrollService(Arrays.asList(arrayOfEmployees));
        employeePayrollService.writeEmployeePayrollData(FILE_IO);
        employeePayrollService.printData(FILE_IO);
        long entries = employeePayrollService.countEntries(FILE_IO);
        Assert.assertEquals(3, entries);
    }

    @Test
    public void givenEmployeeDetailsShouldMatchWithEmployeeConts(EmployeePayrollService.IOService ioService){
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        long entries = employeePayrollService.readEmployeePayrollData(ioService);
        Assert.assertEquals(3, entries);
    }
}