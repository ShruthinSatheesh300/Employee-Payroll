
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;





public class EmployeePayrollServiceTest {
    @Test
    public void given3Employees_WhenWrittenToFile_ShouldMatchEmployeeEntries() {
        EmployeePayrollData[] arrayOfEmployees = {
                new EmployeePayrollData(1, "Shruthin Satheesh", 100000.0),
                new EmployeePayrollData(2, "Anitha Satheesh ", 200000.0),
                new EmployeePayrollData(3, "M.G Satheesh", 300000.0)
        };
        EmployeePayrollService employeePayrollService;
        employeePayrollService = new EmployeePayrollService(Arrays.asList(arrayOfEmployees));
        employeePayrollService.writeEmployeePayrollData(EmployeePayrollService.IOService.FILE_IO);

        employeePayrollService.printData(EmployeePayrollService.IOService.FILE_IO);
        long entries = employeePayrollService.countEntries(EmployeePayrollService.IOService.FILE_IO);
        Assertions.assertEquals(12, entries);

    }

    @Test
    public void givenFile_WhenRead_ShouldReturnNumberOfEntries() {
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        long entries = employeePayrollService.readDataFromFile(EmployeePayrollService.IOService.FILE_IO);
        Assertions.assertEquals(12, entries);
    }
}