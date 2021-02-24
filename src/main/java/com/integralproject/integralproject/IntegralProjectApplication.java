package com.integralproject.integralproject;

import com.integralproject.integralproject.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class IntegralProjectApplication {
	public static User currentUser; //to be used to "login" and verify who is currently performing actions to db

	public static void main(String[] args) {
		SpringApplication.run(IntegralProjectApplication.class, args);

		Scanner scanner = new Scanner(System.in);
	System.out.println("Who are you?");
	String response = scanner.nextLine();
	System.out.println("Cool");
	//need to start calling jdbc, making list of users to choose from, and giving options menu
	}

}
