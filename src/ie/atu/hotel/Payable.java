package ie.atu.hotel;

public interface Payable {
	double calculatePay(double taxPercentage);
	double incrementSalary(double incrementAmount);
}
