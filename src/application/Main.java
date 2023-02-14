package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.BusinessException;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			int number = scan.nextInt();
			
			System.out.print("Holder: ");
			String holder = scan.next();
			
			System.out.print("Initial balance: ");
			double balance = scan.nextDouble();
			
			System.out.print("Withdraw Limit: ");
			double withdrawLimit = scan.nextDouble();
			
			Account acc = new Account(number, holder, balance, withdrawLimit);
			
			System.out.println();
			
			System.out.print("Enter amount for withdraw: ");
			double withdrawAmount = scan.nextDouble();
			
			acc.withdraw(withdrawAmount);
			
			System.out.println("New balance: " + acc.getBalance());
			
		} 
		catch (BusinessException e) {
			System.out.println("Error: " + e);
		}
		catch (InputMismatchException e) {
			System.out.println("Error input");
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}
	}

}
