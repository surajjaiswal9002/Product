package com.Target.Product.designpattern.creational;



public class BulderDesignPatter {

    private final int id;
    private final String name;
    private final int age;
    private final String address;

    private BulderDesignPatter(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.age = builder.age;
        this.address = builder.address;
    }

    // ✅ Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    // ✅ Builder class
    public static class Builder {
        private int id;
        private String name;
        private int age;
        private String address;

        // mandatory fields can go in Builder constructor
        public Builder(int id, String name) {
            if (name == null) {
                throw new IllegalArgumentException("Name cannot be null");
            }
            this.id = id;
            this.name = name;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public BulderDesignPatter build() {
            if (id <= 0) {
                throw new IllegalArgumentException("Id must be positive");
            }
            return new BulderDesignPatter(this);
        }
    }

    public static void main(String[] args) {
        BulderDesignPatter bp = new BulderDesignPatter.Builder(1, "Suraj")
                .setAge(27)
                .setAddress("Bangalore")
                .build();

        // ✅ using getters
        System.out.println(bp.getId());
        System.out.println(bp.getName());
        System.out.println(bp.getAge());
        System.out.println(bp.getAddress());
    }
}
