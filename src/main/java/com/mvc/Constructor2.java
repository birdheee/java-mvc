package com.mvc;

class test{
	public String name;
	
	public test(String name) {
		this.name = name;
		this.printName();
	}
	
	public void printName() {
		System.out.println("아빠 : " + name);
	}
}

public class Constructor2 extends test {
	public Constructor2(String name){
		super(name); // 부모의 생성자
	}
	
	// 오버라이딩
	public void printName() {
		super.printName(); // 아빠 : 안녕
		System.out.println("아들 : " + name); // 아들 : 안녕
	}
}

class Execute2{
	public static void main(String[] args) {
		Constructor2 c2 = new Constructor2("안녕");
	}
}