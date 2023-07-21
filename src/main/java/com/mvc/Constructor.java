package com.mvc;

public class Constructor {
	// 규칙 : 생성자는 다른 메서드보다 위에 있어야, 멤버변수는 가장 위에 있어야 함
	int num;
	
	// 생성자는 데이터 타입이 없고 클래스 명과 대소문자까지 동일함
	public Constructor() {
		// 메모리를 생성할 때 무언가를 실행, 호출해야 할 때 사용함
		System.out.println(num);
	}
	
	public Constructor(int num) {
		this.num = num;
		System.out.println(num);
	}
	
	void test() {
		System.out.println("나 이미 머릿속에 있어서 생성자에서 호출됨~");
	}
}

class Execute{
	public static void main(String[] arg) {
		Constructor c = new Constructor(10);
		System.out.println(c.num);
	}
}