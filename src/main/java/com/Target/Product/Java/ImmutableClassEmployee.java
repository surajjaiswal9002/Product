package com.Target.Product.Java;

import java.util.ArrayList;
import java.util.List;

public final class ImmutableClassEmployee {

    private final String name;
    private final int id;
    private final List<Details> details;

    public ImmutableClassEmployee(String name, int id, List<Details> details) {
        this.name = name;
        this.id = id;

        // Defensive copy — prevents modification of original list reference
        // But assumes Details objects themselves are immutable (as above)
        this.details = details == null ? List.of() : List.copyOf(details);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    // Returns an unmodifiable list (List.copyOf ensures immutability)
    public List<Details> getDetails() {
        return details;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', id=" + id + ", details=" + details + "}";
    }
    
    public static void main(String[] args) {
		
    	Details d = new Details(1001, "sjwater");
    	Details d1 = new Details(1002, "sjwater");
    	List<Details> list = new ArrayList<Details>();
    	list.add(d);
    	list.add(d1);
    	
    	
    	ImmutableClassEmployee ice = new ImmutableClassEmployee("Suraj", 101, list);
    	
    	System.out.println(ice.getId());
    	System.out.println(ice.getName());
    	System.out.println(ice.getDetails().get(0).getDetailsId());
    	System.out.println(ice.getDetails().get(0).getProductDetail());
    	
	}
}



 final class Details {

    private final int detailsId;
    private final String productDetail;

    public Details(int detailsId, String productDetail) {
        this.detailsId = detailsId;
        this.productDetail = productDetail;
    }

    public int getDetailsId() {
        return detailsId;
    }

    public String getProductDetail() {
        return productDetail;
    }

    @Override
    public String toString() {
        return "Details{id=" + detailsId + ", productDetail='" + productDetail + "'}";
    }
}
