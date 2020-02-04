import java.sql.Date;
import java.util.ArrayList;

public class HRDepartment {
	
	ArrayList<Employee> employeeList;

	public void addEmployee(int employeeId, String name, int role) {
		Employee employee = new Employee(employeeId, name, role);
		employeeList.add(employee);
	}
	public void printAllEmployees() {
		String printEmployees = "";
		for(int i=0; i<employeeList.size(); i++) {
			Employee employee = employeeList.get(i);
//			String name = employee.getName(); 
//			Date promotionDate = (Date) employee.getPromotionDate();
//			int employeeId = employee.getEmployeeId();
			printEmployees+=employee.toString();
		}
		System.out.println(printEmployees);
	}
	public Employee findEmployee(int employeeId) {
		//Employee employee = null;
		for(int i=0; i<employeeList.size(); i++) {
			if(employeeId == employeeList.get(i).getEmployeeId()) {
				return employeeList.get(i);
			}
		}
		return null;
	}
	public boolean recordEmployeeAppraisal(int employeeId, Date appraisalDate, int score) {
		Employee employee = findEmployee(employeeId);
		if(employee!=null) {
			EmployeeAppraisal appraisal = new EmployeeAppraisal(appraisalDate, score);
			ArrayList<EmployeeAppraisal> appraisalHistory = employee.getAppraisalHistory();
			appraisalHistory.add(appraisal);
			employee.setAppraisalHistory(appraisalHistory);
			return true;
		}
		return false;
	}
	public boolean promoteEmployee(int employeeId) {
		Employee employee = findEmployee(employeeId);
		ArrayList<EmployeeAppraisal> appraisalHistory = employee.getAppraisalHistory();
		EmployeeAppraisal lastAppraisal = appraisalHistory.get(appraisalHistory.size()-1);
		int lastScore = lastAppraisal.getAppraisalScore();
		EmployeeAppraisal secondLastAppraisal = appraisalHistory.get(appraisalHistory.size()-2);
		int secondLastScore = secondLastAppraisal.getAppraisalScore();
		if(lastScore == HRCodes.EXCEEDED_EXPECTATIONS && secondLastScore == HRCodes.EXCEEDED_EXPECTATIONS) {
			Date lastPromoDate = (Date) employee.getPromotionDate();
			
		}
		
	}
}
