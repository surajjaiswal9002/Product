package com.Target.Product.Java;


/// 1st way
final class ExampleImmutable{
	private final int age;
	private final String name;
	
	ExampleImmutable(int age, String name){
		this.age = age;
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getName() {
		return name;
	}
}



// 2nd way
 record Person1(int age, String name) { }

 class TestRecord {
    public static void main(String[] args) {
        Person1 p = new Person1(27, "Suraj");
        System.out.println(p.age());   // 27
        System.out.println(p.name());  // Suraj
    }
}


// 3rd way
 final class Person {
	    private final int age;
	    private final String name;

	    private Person(Builder builder) {
	        this.age = builder.age;
	        this.name = builder.name;
	    }

	    public int getAge() { return age; }
	    public String getName() { return name; }

	    // Builder
	    public static class Builder {
	        private int age;
	        private String name;

	        public Builder age(int age) { this.age = age; return this; }
	        public Builder name(String name) { this.name = name; return this; }

	        public Person build() {
	            return new Person(this);
	        }
	    }
	}

	 class TestBuilder {
	    public static void main(String[] args) {
	        Person p = new Person.Builder().age(27).name("Suraj").build();
	        System.out.println(p.getName());
	    }
	}

 
public class StringImmutable {
	public static void main(String[] args) {
		ExampleImmutable e1 = new ExampleImmutable(27, "suraj");
		e1.getAge();
		e1.getName();
	}
}
