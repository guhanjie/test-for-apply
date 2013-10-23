package test;

class Base {
	private String name = "base";
	
	public Base() {
		tellName();
		printName(name);
	}
	
	public void tellName() {
		System.out.println("Base tell name: "+name);
	}
	
	public void printName(String name) {
		System.out.println("Base print name: "+name);
	}
}

public class Derived extends Base {
	private String name = "derived";
	
	public Derived() {
		tellName();
		printName(name);
	}
	
	public void tellName() {
		System.out.println("Derived tell name: "+name);
	}
	
	public void printName(String name) {
		System.out.println("Derived print name: "+name);
	}
	
	public static void main(String[] args) {
		new Derived();
	}
}
