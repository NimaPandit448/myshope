package com.myshope.myshope.controller;

public class ExceptionExample {

	public static void main(String[] args) {

		try {
			String string = "asdss";
			System.out.println(string.length());

			int a = 20 / 0;
			System.out.println(a);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			// TODO: handle exception
		
	}

}
}
