package System;

import java.util.Stack;

public class Memento {
	Stack<Item> previous = new Stack<>();
	MySystem current = new MySystem();
	Stack<Item> successors = new Stack<>();
	
	public void add(){
		push();
		try {
			current.addEmployees();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public void remove() {
		push();
		try {
			current.removeEmployees();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void hours() {
		push();
		try {
			current.addHours();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void sell(){
		push();
		try {
			current.addSell();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void debit(){
		push();
		try {
			current.addDebit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void edit() {
		push();
		try {
			current.editUser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void undo() {
		try {
			successors.push(new Item(current));
			current = previous.pop().getMySystem();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	public void payroll() {
		push();
		try {
			current.payroll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void rendo() {
		try {
			previous.push(new Item(current));
			current = previous.pop().getMySystem();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	private void push(){
		previous.push(new Item(current));
		successors.clear();
	}
	
}
