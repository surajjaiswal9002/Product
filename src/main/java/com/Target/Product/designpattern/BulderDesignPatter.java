package com.Target.Product.designpattern;

public class BulderDesignPatter {

    private final int id;
    private final String name;
    private final  int age;
    private final String address;

    private BulderDesignPatter(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.age = builder.age;
        this.address = builder.address;
    }

    public static class Builder {
        private int id;
        private String name;
        private int age;
        private String address;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }


        public BulderDesignPatter build(){
            return new BulderDesignPatter(this);
        }
    }


    public static void main(String[] args) {
        BulderDesignPatter bp = new BulderDesignPatter.Builder()
                .setId(1)
                .setName("ghyt")
                .setAge(0)
                .setAddress("bkaskhlua").build();
    }
}
