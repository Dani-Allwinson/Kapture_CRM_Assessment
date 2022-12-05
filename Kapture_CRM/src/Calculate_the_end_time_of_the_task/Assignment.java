package Calculate_the_end_time_of_the_task;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Empolyee_Details {

	int emp_id;
	int task_no;
	String login_date;
	int start_time;
	int working_hours_start;
	int working_hours_end;
	int task_completion_time;
	int no_of_leaves_taken;

}

public class Assignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

		List<String> leaves = new ArrayList<String>();
		Empolyee_Details Emp_d = new Empolyee_Details();
		Emp_d.emp_id = 0;
		boolean a = true;
		while (a) {
			System.out.print("1. Enter the Empolyee id.\n" + "2. Enter the task number.\n"
					+ "3. Enter the Login Date.\n" + "4. Enter the working hours start time [AM] and end time [PM].\n"
					+ "5. Time taken to complete the task.\n"
					+ "6. Enter the date that the employee want leave [DD-MMM] .\n"
					+ "7. Number of Leaves empolyee took.\n"
					+ "8. How many days that the empolyee spend to complete the task\n" + "9. Exit.");
			System.out.print("\n\nEnter the choice: ");
			int choice = in.nextInt();
			switch (choice) {
			case 1: {
				System.out.print("Enter the employee id number: ");
				Emp_d.emp_id = in.nextInt();
				System.out.print("\n");
			}
				break;
			case 2: {
				System.out.print("Enter the employee " + Emp_d.emp_id + " task number: ");
				Emp_d.task_no = in.nextInt();
				System.out.print("\n");
			}
				break;
			case 3: {

				Emp_d.login_date = Real_date();
				in.nextLine();
				if (leaves.contains(Emp_d.login_date)) {
					System.out.println("Today you are in holiday!!\n");
				} else {
					System.out.println("\nWelcome to Code!!!!!");
					System.out.print("Enter the login Date: ");
					System.out.print(Emp_d.login_date);
				}
				System.out.print("\nEnter the login time: ");
				Emp_d.start_time = Real_time();
				System.out.println(Emp_d.start_time);
				System.out.print("\n");
			}
				break;
			case 4: {
				System.out.print("Enter the working hours start time: ");
				Emp_d.working_hours_start = in.nextInt();
				System.out.print("Enter the working hours end time: ");
				Emp_d.working_hours_end = in.nextInt();
				System.out.print("\n");
			}
				break;
			case 5: {

				System.out.print("Time taken to complete the task:");
				Emp_d.task_completion_time = in.nextInt();
				System.out.print("\n");

			}
				break;
			case 6: {
				System.out.print("Enter the dates the employee took leave: ");
				int n = 1;
				for (int i = 0; i <= n; i++) {
					leaves.add(in.nextLine());
				}
				System.out.print("\n");
			}
				break;
			case 7:
				for (String l : leaves) {
					System.out.print(l + "\n");
				}
				System.out.print("\n");
				break;
			case 8: {
				getEndTime(Emp_d.start_time, Emp_d.task_completion_time, Emp_d.working_hours_start,
						Emp_d.working_hours_end, leaves);
			}
				break;
			case 9: {
				a = false;
				System.out.println("Thank You!!!!");
			}
				break;
			default:
				System.out.println("Enter the correct option");
				break;
			}
		}

	}

	static void getEndTime(int a, int b, int c, int d, List<String> l) {

		int d_pm = d + 12;
		int min = 0, max = 0;
		if (c > d_pm) {
			min = d_pm;
			max = c;
		} else {
			min = c;
			max = d_pm;
		}
		int hours = max - min;
		//System.out.println("Number of hours the empolyyee spend to the task: " + hours);
		//System.out.print("\n");
		
		// final function to find how much days empolyee spend.
		System.out.println("Empolyee took time to complete the task: "+func(hours,b)+" Days\n");
	}
	static int func(int a , int b) {
		int aa=1;
		if(b<=a) {
			return aa;
		}else {
			return b/a;
		}
	}
	static int Real_time() {
		LocalTime time = LocalTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH");
		String formattedDate = time.format(myFormatObj);
		int t = Integer.parseInt(formattedDate) % 12;
		return t;
	}

	static String Real_date() {
		LocalDate date = LocalDate.now();
		DateTimeFormatter date_format = DateTimeFormatter.ofPattern("dd-MMM");
		String date1 = date.format(date_format);
		return date1;
	}

}
