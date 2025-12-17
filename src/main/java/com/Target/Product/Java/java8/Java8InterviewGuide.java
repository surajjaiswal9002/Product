package com.Target.Product.Java.java8;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;

public class Java8InterviewGuide {
    
    static class Employee {
        String name;
        double salary;
        int age;
        String department;
        
        Employee(String name, double salary, int age, String department) {
            this.name = name;
            this.salary = salary;
            this.age = age;
            this.department = department;
        }
        
        @Override
        public String toString() {
            return name + " (₹" + salary + ", " + age + "y, " + department + ")";
        }

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public double getSalary() {
			return salary;
		}

		public void setSalary(double salary) {
			this.salary = salary;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getDepartment() {
			return department;
		}

		public void setDepartment(String department) {
			this.department = department;
		}
        
        
    }
    
    // ============================================
    // 1. FIND DUPLICATES
    // ============================================
    public static void findDuplicates() {
        System.out.println("=== 1. FIND DUPLICATES ===");
        List<Integer> nums = Arrays.asList(1, 2, 3, 2, 4, 5, 3, 6, 1);
        List<String> fruits = Arrays.asList("apple", "mango", "apple","banana");
        
        // Solution 1: Using Set
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = nums.stream()
            .filter(n -> !seen.add(n))
            .collect(Collectors.toSet());
        
        // Solution 2: Using frequency map
        Map<Integer, Long> frequency = nums.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        
        Map<Character, Long> fruitFrequency = fruits.stream().collect(Collectors.groupingBy(e -> e.charAt(0), Collectors.counting()));
        
        System.out.println(" fruitFrequency : "+fruitFrequency);
        List<Integer> dups = frequency.entrySet().stream()
            .filter(e -> e.getValue() > 1)
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
        
        System.out.println("Input: " + nums);
        System.out.println("Duplicates (Method 1): " + duplicates);
        System.out.println("Duplicates (Method 2): " + dups);
        System.out.println();
    }
    
    // ============================================
    // 2. FIRST NON-REPEATED CHARACTER
    // ============================================
    public static void findFirstNonRepeated() {
        System.out.println("=== 2. FIRST NON-REPEATED CHARACTER ===");
        String str = "programming";
        
        Character result = str.chars()
            .mapToObj(c -> (char) c)
            .collect(Collectors.groupingBy(Function.identity(), 
                     LinkedHashMap::new, Collectors.counting()))
            .entrySet().stream()
            .filter(e -> e.getValue() == 1)
            .map(Map.Entry::getKey)
            .findFirst()
            .orElse(null);
        
        System.out.println("String: " + str);
        System.out.println("First non-repeated: " + result);
        System.out.println();
    }
    
    // ============================================
    // 3. SECOND HIGHEST NUMBER
    // ============================================
    public static void findSecondHighest() {
        System.out.println("=== 3. SECOND HIGHEST NUMBER ===");
        List<Integer> nums = Arrays.asList(10, 20, 30, 40, 50, 40, 30);
        
        // Solution 1: Using distinct, sorted, skip
        Integer secondHighest = nums.stream()
            .distinct()
            .sorted(Comparator.reverseOrder())
            .skip(1)
            .findFirst()
            .orElse(null);
        
        // Solution 2: Nth highest (change skip value)
        Integer thirdHighest = nums.stream()
            .distinct()
            .sorted(Comparator.reverseOrder())
            .skip(2)
            .findFirst()
            .orElse(null);
        
        System.out.println("Numbers: " + nums);
        System.out.println("Second highest: " + secondHighest);
        System.out.println("Third highest: " + thirdHighest);
        System.out.println();
    }
    
    // ============================================
    // 4. SORT BY MULTIPLE FIELDS
    // ============================================
    public static void sortByMultipleFields() {
        System.out.println("=== 4. SORT BY MULTIPLE FIELDS ===");
        List<Employee> emps = Arrays.asList(
            new Employee("Alice", 50000, 25, "IT"),
            new Employee("Bob", 60000, 30, "HR"),
            new Employee("Charlie", 50000, 28, "IT"),
            new Employee("David", 50000, 22, "Finance")
        );
        
        // Sort by salary (asc), then by name (asc)
        List<Employee> sorted = emps.stream()
            .sorted(Comparator.comparing(Employee::getSalary)
                    .thenComparing(Employee::getName))
            .collect(Collectors.toList());
        
        // Sort by salary (desc), then by age (asc)
        List<Employee> sorted2 = emps.stream()
            .sorted(Comparator.comparing(Employee::getSalary).reversed()
                    .thenComparing(Employee::getAge))
            .collect(Collectors.toList());
        
        System.out.println("Original: " + emps);
        System.out.println("Sorted by salary, name: " + sorted);
        System.out.println("Sorted by salary(desc), age: " + sorted2);
        System.out.println();
    }
    
    // ============================================
    // 5. COUNT CHARACTER OCCURRENCES
    // ============================================
    public static void countCharacters() {
        System.out.println("=== 5. COUNT CHARACTER OCCURRENCES ===");
        String str = "hello world";
        
        Map<Character, Long> charCount = str.chars()
            .filter(c -> c != ' ')
            .mapToObj(c -> (char) c)
            .collect(Collectors.groupingBy(Function.identity(), 
                     Collectors.counting()));
        
        // Find most frequent character
        Map.Entry<Character, Long> mostFrequent = charCount.entrySet().stream()
            .max(Map.Entry.comparingByValue())
            .orElse(null);
        
        System.out.println("String: " + str);
        System.out.println("Character counts: " + charCount);
        System.out.println("Most frequent: " + mostFrequent);
        System.out.println();
    }
    
    // ============================================
    // 6. SUM OF NUMBERS
    // ============================================
    public static void sumOfNumbers() {
        System.out.println("=== 6. SUM OF NUMBERS ===");
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        
        // Method 1: Using sum()
        int sum1 = nums.stream()
            .mapToInt(Integer::intValue)
            .sum();
        
        // Method 2: Using reduce with lambda
        int sum2 = nums.stream()
            .reduce(0, (a, b) -> a + b);
        
        // Method 3: Using reduce with method reference
        int sum3 = nums.stream()
            .reduce(0, Integer::sum);
        
        // Sum of squares
        int sumOfSquares = nums.stream()
            .map(n -> n * n)
            .reduce(0, Integer::sum);
        
        System.out.println("Numbers: " + nums);
        System.out.println("Sum (method 1): " + sum1);
        System.out.println("Sum (method 2): " + sum2);
        System.out.println("Sum (method 3): " + sum3);
        System.out.println("Sum of squares: " + sumOfSquares);
        System.out.println();
    }
    
    // ============================================
    // 7. AVERAGE CALCULATION
    // ============================================
    public static void averageCalculation() {
        System.out.println("=== 7. AVERAGE CALCULATION ===");
        List<Integer> nums = Arrays.asList(10, 20, 30, 40, 50);
        
        // Method 1: Using average()
        double avg1 = nums.stream()
            .mapToInt(Integer::intValue)
            .average()
            .orElse(0.0);
        
        // Method 2: Using reduce
        double avg2 = nums.stream()
            .mapToDouble(Integer::doubleValue)
            .reduce(0, Double::sum) / nums.size();
        
        // Average of employee salaries
        List<Employee> emps = Arrays.asList(
            new Employee("Alice", 50000, 25, "IT"),
            new Employee("Bob", 60000, 30, "HR")
        );
        
        double avgSalary = emps.stream()
            .mapToDouble(e -> e.salary)
            .average()
            .orElse(0.0);
        
        System.out.println("Numbers: " + nums);
        System.out.println("Average (method 1): " + avg1);
        System.out.println("Average (method 2): " + avg2);
        System.out.println("Average salary: ₹" + avgSalary);
        System.out.println();
    }
    
    // ============================================
    // 8. FILTER BY MULTIPLE CONDITIONS
    // ============================================
    public static void filterByMultipleConditions() {
        System.out.println("=== 8. FILTER BY MULTIPLE CONDITIONS ===");
        List<Employee> emps = Arrays.asList(
            new Employee("Alice", 50000, 25, "IT"),
            new Employee("Bob", 60000, 30, "HR"),
            new Employee("Charlie", 70000, 28, "IT"),
            new Employee("David", 40000, 22, "Finance")
        );
        
        // Filter: age > 25 AND salary > 55000
        List<Employee> filtered1 = emps.stream()
            .filter(e -> e.age > 25 && e.salary > 55000)
            .collect(Collectors.toList());
        
        // Filter: (age > 25 OR salary > 65000) AND department = "IT"
        List<Employee> filtered2 = emps.stream()
            .filter(e -> (e.age > 25 || e.salary > 65000) && e.department.equals("IT"))
            .collect(Collectors.toList());
        
        System.out.println("All employees: " + emps);
        System.out.println("age > 25 AND salary > 55000: " + filtered1);
        System.out.println("Complex condition: " + filtered2);
        System.out.println();
    }
    
    // ============================================
    // 9. LIST TO MAP CONVERSION
    // ============================================
    public static void listToMapConversion() {
        System.out.println("=== 9. LIST TO MAP CONVERSION ===");
        List<Employee> emps = Arrays.asList(
            new Employee("Alice", 50000, 25, "IT"),
            new Employee("Bob", 60000, 30, "HR"),
            new Employee("Charlie", 70000, 28, "IT")
        );
        
        // Map: name -> salary
        Map<String, Double> nameToSalary = emps.stream()
            .collect(Collectors.toMap(
                e -> e.name,
                e -> e.salary
            ));
        
        // Map: name -> Employee object
        Map<String, Employee> nameToEmployee = emps.stream()
            .collect(Collectors.toMap(
                e -> e.name,
                Function.identity()
            ));
        
        // Map: name -> age (handling duplicates)
        Map<String, Integer> nameToAge = emps.stream()
            .collect(Collectors.toMap(
                e -> e.name,
                e -> e.age,
                (existing, replacement) -> existing  // Keep existing on duplicate
            ));
        
        System.out.println("Name to Salary: " + nameToSalary);
        System.out.println("Name to Employee: " + nameToEmployee);
        System.out.println();
    }
    
    // ============================================
    // 10. GROUP BY FIELD
    // ============================================
    public static void groupByField() {
        System.out.println("=== 10. GROUP BY FIELD ===");
        List<Employee> emps = Arrays.asList(
            new Employee("Alice", 50000, 25, "IT"),
            new Employee("Bob", 60000, 30, "HR"),
            new Employee("Charlie", 50000, 28, "IT"),
            new Employee("David", 70000, 35, "IT"),
            new Employee("Eve", 60000, 27, "HR")
        );
        
        // Group by department
        Map<String, List<Employee>> byDept = emps.stream()
            .collect(Collectors.groupingBy(e -> e.department));
        
        // Group by salary
        Map<Double, List<Employee>> bySalary = emps.stream()
            .collect(Collectors.groupingBy(e -> e.salary));
        
        // Count employees by department
        Map<String, Long> countByDept = emps.stream()
            .collect(Collectors.groupingBy(
                e -> e.department,
                Collectors.counting()
            ));
        
        // Average salary by department
        Map<String, Double> avgSalaryByDept = emps.stream()
            .collect(Collectors.groupingBy(
                e -> e.department,
                Collectors.averagingDouble(e -> e.salary)
            ));
        
        System.out.println("Group by department: " + byDept);
        System.out.println("Group by salary: " + bySalary);
        System.out.println("Count by department: " + countByDept);
        System.out.println("Avg salary by dept: " + avgSalaryByDept);
        System.out.println();
    }
    
    // ============================================
    // 11. FILTER BY STRING PATTERN
    // ============================================
    public static void filterByStringPattern() {
        System.out.println("=== 11. FILTER BY STRING PATTERN ===");
        List<Integer> nums = Arrays.asList(10, 15, 20, 100, 150, 200, 1000);
        
        // Numbers starting with 1
        List<Integer> startsWith1 = nums.stream()
            .filter(n -> String.valueOf(n).startsWith("1"))
            .collect(Collectors.toList());
        
        // Numbers ending with 0
        List<Integer> endsWith0 = nums.stream()
            .filter(n -> String.valueOf(n).endsWith("0"))
            .collect(Collectors.toList());
        
        // String operations
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Anna");
        
        // Names starting with 'A'
        List<String> startsWithA = names.stream()
            .filter(s -> s.startsWith("A"))
            .collect(Collectors.toList());
        
        // Names with length > 4
        List<String> longNames = names.stream()
            .filter(s -> s.length() > 4)
            .collect(Collectors.toList());
        
        System.out.println("Numbers: " + nums);
        System.out.println("Starting with 1: " + startsWith1);
        System.out.println("Ending with 0: " + endsWith0);
        System.out.println("Names starting with A: " + startsWithA);
        System.out.println("Names length > 4: " + longNames);
        System.out.println();
    }
    
    // ============================================
    // 12. JOIN STRINGS
    // ============================================
    public static void joinStrings() {
        System.out.println("=== 12. JOIN STRINGS ===");
        List<String> words = Arrays.asList("Java", "Python", "JavaScript", "Go");
        
        // Simple join with comma
        String joined1 = words.stream()
            .collect(Collectors.joining(", "));
        
        // Join with prefix and suffix
        String joined2 = words.stream()
            .collect(Collectors.joining(", ", "[", "]"));
        
        // Join with pipe separator
        String joined3 = words.stream()
            .collect(Collectors.joining(" | "));
        
        // Join employee names
        List<Employee> emps = Arrays.asList(
            new Employee("Alice", 50000, 25, "IT"),
            new Employee("Bob", 60000, 30, "HR")
        );
        
        String empNames = emps.stream()
            .map(e -> e.name)
            .collect(Collectors.joining(", "));
        
        System.out.println("Words: " + words);
        System.out.println("Joined (comma): " + joined1);
        System.out.println("Joined (with brackets): " + joined2);
        System.out.println("Joined (pipe): " + joined3);
        System.out.println("Employee names: " + empNames);
        System.out.println();
    }
    
    // ============================================
    // 13. SKIP AND LIMIT (PAGINATION)
    // ============================================
    public static void skipAndLimit() {
        System.out.println("=== 13. SKIP AND LIMIT (PAGINATION) ===");
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // Skip first 3, take next 4
        List<Integer> page1 = nums.stream()
            .skip(3)
            .limit(4)
            .collect(Collectors.toList());
        
        // Pagination example
        int pageSize = 3;
        int pageNumber = 2; // 0-indexed
        
        List<Integer> page = nums.stream()
            .skip((long) pageNumber * pageSize)
            .limit(pageSize)
            .collect(Collectors.toList());
        
        // Get first 5 elements
        List<Integer> first5 = nums.stream()
            .limit(5)
            .collect(Collectors.toList());
        
        System.out.println("All numbers: " + nums);
        System.out.println("Skip 3, Limit 4: " + page1);
        System.out.println("Page 2 (size 3): " + page);
        System.out.println("First 5: " + first5);
        System.out.println();
    }
    
    // ============================================
    // 14. FIND MAX AND MIN
    // ============================================
    public static void findMaxMin() {
        System.out.println("=== 14. FIND MAX AND MIN ===");
        List<Integer> nums = Arrays.asList(10, 5, 20, 15, 30, 8);
        
        // Max and min numbers
        Optional<Integer> max = nums.stream().max(Integer::compareTo);
        Optional<Integer> min = nums.stream().min(Integer::compareTo);
        
        // Max and min using Comparator
        Integer max2 = nums.stream().max(Comparator.naturalOrder()).orElse(null);
        Integer min2 = nums.stream().min(Comparator.naturalOrder()).orElse(null);
        
        // Employee with max salary
        List<Employee> emps = Arrays.asList(
            new Employee("Alice", 50000, 25, "IT"),
            new Employee("Bob", 60000, 30, "HR"),
            new Employee("Charlie", 70000, 28, "IT")
        );
        
        Employee maxSalaryEmp = emps.stream()
            .max(Comparator.comparing(e -> e.salary))
            .orElse(null);
        
        Employee minAgeEmp = emps.stream()
            .min(Comparator.comparing(e -> e.age))
            .orElse(null);
        
        System.out.println("Numbers: " + nums);
        System.out.println("Max: " + max.orElse(null));
        System.out.println("Min: " + min.orElse(null));
        System.out.println("Max salary employee: " + maxSalaryEmp);
        System.out.println("Min age employee: " + minAgeEmp);
        System.out.println();
    }
    
    // ============================================
    // 15. ANY/ALL/NONE MATCH
    // ============================================
    public static void anyAllNoneMatch() {
        System.out.println("=== 15. ANY/ALL/NONE MATCH ===");
        List<Integer> allEven = Arrays.asList(2, 4, 6, 8, 10);
        List<Integer> mixed = Arrays.asList(1, 2, 3, 4, 5);
        
        // Check all even
        boolean allEvenCheck = allEven.stream().allMatch(n -> n % 2 == 0);
        boolean anyOdd = allEven.stream().anyMatch(n -> n % 2 != 0);
        boolean noneOdd = allEven.stream().noneMatch(n -> n % 2 != 0);
        
        // Employee checks
        List<Employee> emps = Arrays.asList(
            new Employee("Alice", 50000, 25, "IT"),
            new Employee("Bob", 60000, 30, "HR"),
            new Employee("Charlie", 70000, 28, "IT")
        );
        
        boolean anySalaryAbove65k = emps.stream().anyMatch(e -> e.salary > 65000);
        boolean allAgeAbove20 = emps.stream().allMatch(e -> e.age > 20);
        boolean noneInFinance = emps.stream().noneMatch(e -> e.department.equals("Finance"));
        
        System.out.println("All even numbers: " + allEven);
        System.out.println("All even? " + allEvenCheck);
        System.out.println("Any odd? " + anyOdd);
        System.out.println("None odd? " + noneOdd);
        System.out.println("\nEmployee checks:");
        System.out.println("Any salary > 65k? " + anySalaryAbove65k);
        System.out.println("All age > 20? " + allAgeAbove20);
        System.out.println("None in Finance? " + noneInFinance);
        System.out.println();
    }
    
    // ============================================
    // 16. PARTITION DATA
    // ============================================
    public static void partitionData() {
        System.out.println("=== 16. PARTITION DATA ===");
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // Partition into even and odd
        Map<Boolean, List<Integer>> evenOdd = nums.stream()
            .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        
        // Partition employees by salary
        List<Employee> emps = Arrays.asList(
            new Employee("Alice", 50000, 25, "IT"),
            new Employee("Bob", 60000, 30, "HR"),
            new Employee("Charlie", 70000, 28, "IT"),
            new Employee("David", 40000, 22, "Finance")
        );
        
        Map<Boolean, List<Employee>> highLowSalary = emps.stream()
            .collect(Collectors.partitioningBy(e -> e.salary > 55000));
        
        // Count in each partition
        Map<Boolean, Long> countBySalary = emps.stream()
            .collect(Collectors.partitioningBy(
                e -> e.salary > 55000,
                Collectors.counting()
            ));
        
        System.out.println("Numbers: " + nums);
        System.out.println("Even: " + evenOdd.get(true));
        System.out.println("Odd: " + evenOdd.get(false));
        System.out.println("\nHigh salary (>55k): " + highLowSalary.get(true));
        System.out.println("Low salary (<=55k): " + highLowSalary.get(false));
        System.out.println("Count by salary: " + countBySalary);
        System.out.println();
    }
    
    // ============================================
    // 17. FLATMAP - FLATTEN NESTED COLLECTIONS
    // ============================================
    public static void flatMapExample() {
        System.out.println("=== 17. FLATMAP - FLATTEN NESTED COLLECTIONS ===");
        
        // Flatten List<List<Integer>>
        List<List<Integer>> nested = Arrays.asList(
            Arrays.asList(1, 2, 3),
            Arrays.asList(4, 5),
            Arrays.asList(6, 7, 8, 9)
        );
        
        List<Integer> flattened = nested.stream()
            .flatMap(List::stream)
            .collect(Collectors.toList());
        
        // Flatten array of arrays
        String[][] names = {
            {"Alice", "Bob"},
            {"Charlie", "David", "Eve"}
        };
        
        List<String> allNames = Arrays.stream(names)
            .flatMap(Arrays::stream)
            .collect(Collectors.toList());
        
        // FlatMap on strings - get all characters
        List<String> words = Arrays.asList("Hello", "World");
        List<Character> allChars = words.stream()
            .flatMap(word -> word.chars().mapToObj(c -> (char) c))
            .collect(Collectors.toList());
        
        // Real world example - departments with employees
        Map<String, List<String>> deptEmployees = new HashMap<>();
        deptEmployees.put("IT", Arrays.asList("Alice", "Bob"));
        deptEmployees.put("HR", Arrays.asList("Charlie", "David"));
        
        List<String> allEmployees = deptEmployees.values().stream()
            .flatMap(List::stream)
            .collect(Collectors.toList());
        
        System.out.println("Nested: " + nested);
        System.out.println("Flattened: " + flattened);
        System.out.println("All names: " + allNames);
        System.out.println("All characters: " + allChars);
        System.out.println("All employees: " + allEmployees);
        System.out.println();
    }
    
    // ============================================
    // 18. REMOVE DUPLICATES
    // ============================================
    public static void removeDuplicates() {
        System.out.println("=== 18. REMOVE DUPLICATES ===");
        List<Integer> nums = Arrays.asList(1, 2, 3, 2, 4, 3, 5, 1, 6);
        
        // Using distinct()
        List<Integer> unique = nums.stream()
            .distinct()
            .collect(Collectors.toList());
        
        // Remove duplicate employees based on name
        List<Employee> emps = Arrays.asList(
            new Employee("Alice", 50000, 25, "IT"),
            new Employee("Bob", 60000, 30, "HR"),
            new Employee("Alice", 70000, 28, "IT")
        );
        
        List<Employee> uniqueEmps = emps.stream()
            .collect(Collectors.toMap(
                e -> e.name,
                Function.identity(),
                (existing, replacement) -> existing
            ))
            .values()
            .stream()
            .collect(Collectors.toList());
        
        // Distinct by custom field using filter
        Set<String> seen = new HashSet<>();
        List<Employee> distinctByName = emps.stream()
            .filter(e -> seen.add(e.name))
            .collect(Collectors.toList());
        
        System.out.println("Original: " + nums);
        System.out.println("Unique: " + unique);
        System.out.println("\nEmployees with duplicate names: " + emps);
        System.out.println("Distinct by name: " + distinctByName);
        System.out.println();
    }
    
    // ============================================
    // BONUS: ADDITIONAL COMMON QUESTIONS
    // ============================================
    
    // 19. Reverse a string
    public static void reverseString() {
        System.out.println("=== 19. REVERSE STRING ===");
        String str = "hello";
        
        String reversed = new StringBuilder(str).reverse().toString();
        
        // Using streams
        String reversed2 = str.chars()
            .mapToObj(c -> (char) c)
            .reduce("", (s, c) -> c + s, (s1, s2) -> s2 + s1);
        
        System.out.println("Original: " + str);
        System.out.println("Reversed: " + reversed);
        System.out.println();
    }
    
    // 20. Find longest string
    public static void findLongestString() {
        System.out.println("=== 20. FIND LONGEST STRING ===");
        List<String> words = Arrays.asList("Java", "JavaScript", "Python", "Go", "TypeScript");
        
        String longest = words.stream()
            .max(Comparator.comparing(String::length))
            .orElse(null);
        
        System.out.println("Words: " + words);
        System.out.println("Longest: " + longest);
        System.out.println();
    }
    
    // 21. Check if string is palindrome
    public static void checkPalindrome() {
        System.out.println("=== 21. CHECK PALINDROME ===");
        String str = "radar";
        
        boolean isPalindrome = str.equals(new StringBuilder(str).reverse().toString());
        
        // Using streams
        boolean isPalindrome2 = IntStream.range(0, str.length() / 2)
            .allMatch(i -> str.charAt(i) == str.charAt(str.length() - 1 - i));
        
        System.out.println("String: " + str);
        System.out.println("Is palindrome? " + isPalindrome);
        System.out.println();
    }
    
    // 22. Find common elements between two lists
    public static void findCommonElements() {
        System.out.println("=== 22. FIND COMMON ELEMENTS ===");
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(4, 5, 6, 7, 8);
        
        List<Integer> common = list1.stream()
            .filter(list2::contains)
            .collect(Collectors.toList());
        
        System.out.println("List 1: " + list1);
        System.out.println("List 2: " + list2);
        System.out.println("Common: " + common);
        System.out.println();
    }
    
 // ============================================
    // 23. SORT STRINGS BY LENGTH
    // ============================================
    public static void sortByLength() {
        System.out.println("=== 23. SORT STRINGS BY LENGTH ===");
        List<String> words = Arrays.asList("Java", "Python", "Go", "JavaScript", "C");
        
        // Sort by length (ascending)
        List<String> sorted = words.stream()
            .sorted(Comparator.comparing(String::length))
            .collect(Collectors.toList());
        
        // Sort by length (descending)
        List<String> sortedDesc = words.stream()
            .sorted(Comparator.comparing(String::length).reversed())
            .collect(Collectors.toList());
        
        // Sort by length, then alphabetically
        List<String> sortedLengthThenAlpha = words.stream()
            .sorted(Comparator.comparing(String::length)
                    .thenComparing(String::compareTo))
            .collect(Collectors.toList());
        
        System.out.println("Original: " + words);
        System.out.println("Sorted by length (asc): " + sorted);
        System.out.println("Sorted by length (desc): " + sortedDesc);
        System.out.println("By length then alpha: " + sortedLengthThenAlpha);
        System.out.println();
    }
    
    // ============================================
    // 24. CONVERT LIST TO ARRAY
    // ============================================
    public static void listToArray() {
        System.out.println("=== 24. CONVERT LIST TO ARRAY ===");
        List<String> list = Arrays.asList("Java", "Python", "JavaScript");
        
        // Method 1: toArray()
        String[] array1 = list.toArray(new String[0]);
        
        // Method 2: Using Stream
        String[] array2 = list.stream()
            .toArray(String[]::new);
        
        // Integer list to int array
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        int[] intArray = nums.stream()
            .mapToInt(Integer::intValue)
            .toArray();
        
        System.out.println("List: " + list);
        System.out.println("Array: " + Arrays.toString(array1));
        System.out.println("Int array: " + Arrays.toString(intArray));
        System.out.println();
    }
    
    // ============================================
    // 25. FIND FIRST AND LAST ELEMENT
    // ============================================
    public static void findFirstAndLast() {
        System.out.println("=== 25. FIND FIRST AND LAST ELEMENT ===");
        List<Integer> nums = Arrays.asList(10, 20, 30, 40, 50);
        
        // First element
        Optional<Integer> first = nums.stream()
            .findFirst();
        
        // Last element
        Optional<Integer> last = nums.stream()
            .reduce((a, b) -> b);
        
        // Another way to get last
        Optional<Integer> last2 = nums.stream()
            .skip(nums.size() - 1)
            .findFirst();
        
        System.out.println("List: " + nums);
        System.out.println("First: " + first.orElse(null));
        System.out.println("Last: " + last.orElse(null));
        System.out.println();
    }
    
    // ============================================
    // 26. FIBONACCI SERIES
    // ============================================
    public static void fibonacciSeries() {
        System.out.println("=== 26. FIBONACCI SERIES ===");
        
        // Generate first 10 Fibonacci numbers
        List<Integer> fibonacci = Stream.iterate(new int[]{0, 1}, f -> new int[]{f[1], f[0] + f[1]})
            .limit(10)
            .map(f -> f[0])
            .collect(Collectors.toList());
        
        System.out.println("First 10 Fibonacci: " + fibonacci);
        System.out.println();
    }
    
    // ============================================
    // 27. FACTORIAL USING REDUCE
    // ============================================
    public static void factorial() {
        System.out.println("=== 27. FACTORIAL USING REDUCE ===");
        int n = 5;
        
        int fact = IntStream.rangeClosed(1, n)
            .reduce(1, (a, b) -> a * b);
        
        System.out.println("Factorial of " + n + " = " + fact);
        System.out.println();
    }
    
    // ============================================
    // 28. SQUARE OF EACH NUMBER
    // ============================================
    public static void squareNumbers() {
        System.out.println("=== 28. SQUARE OF EACH NUMBER ===");
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        
        List<Integer> squares = nums.stream()
            .map(n -> n * n)
            .collect(Collectors.toList());
        
        // Sum of squares
        int sumOfSquares = nums.stream()
            .map(n -> n * n)
            .reduce(0, Integer::sum);
        
        System.out.println("Numbers: " + nums);
        System.out.println("Squares: " + squares);
        System.out.println("Sum of squares: " + sumOfSquares);
        System.out.println();
    }
    
    // ============================================
    // 29. FILTER NULL VALUES
    // ============================================
    public static void filterNulls() {
        System.out.println("=== 29. FILTER NULL VALUES ===");
        List<String> words = Arrays.asList("Java", null, "Python", null, "JavaScript");
        
        List<String> nonNull = words.stream()
            .filter(Objects::nonNull)
            .collect(Collectors.toList());
        
        System.out.println("With nulls: " + words);
        System.out.println("Without nulls: " + nonNull);
        System.out.println();
    }
    
    // ============================================
    // 30. CONVERT STRING TO UPPERCASE/LOWERCASE
    // ============================================
    public static void caseConversion() {
        System.out.println("=== 30. CASE CONVERSION ===");
        List<String> words = Arrays.asList("java", "python", "javascript");
        
        List<String> uppercase = words.stream()
            .map(String::toUpperCase)
            .collect(Collectors.toList());
        
        List<String> capitalized = words.stream()
            .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
            .collect(Collectors.toList());
        
        System.out.println("Original: " + words);
        System.out.println("Uppercase: " + uppercase);
        System.out.println("Capitalized: " + capitalized);
        System.out.println();
    }
    
    // ============================================
    // 31. FIND EMPLOYEE WITH HIGHEST SALARY IN EACH DEPARTMENT
    // ============================================
    public static void highestSalaryByDept() {
        System.out.println("=== 31. HIGHEST SALARY BY DEPARTMENT ===");
        List<Employee> emps = Arrays.asList(
            new Employee("Alice", 50000, 25, "IT"),
            new Employee("Bob", 60000, 30, "HR"),
            new Employee("Charlie", 70000, 28, "IT"),
            new Employee("David", 55000, 35, "HR"),
            new Employee("Eve", 80000, 27, "IT")
        );
        
        Map<String, Optional<Employee>> maxSalaryByDept = emps.stream()
            .collect(Collectors.groupingBy(
                e -> e.department,
                Collectors.maxBy(Comparator.comparing(e -> e.salary))
            ));
        
        System.out.println("Highest salary by department:");
        maxSalaryByDept.forEach((dept, emp) -> 
            System.out.println(dept + ": " + emp.orElse(null)));
        System.out.println();
    }
    
    // ============================================
    // 32. PEEK - DEBUG STREAM OPERATIONS
    // ============================================
    public static void peekExample() {
        System.out.println("=== 32. PEEK - DEBUG STREAM ===");
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        
        List<Integer> result = nums.stream()
            .peek(n -> System.out.println("Original: " + n))
            .map(n -> n * 2)
            .peek(n -> System.out.println("After map: " + n))
            .filter(n -> n > 5)
            .peek(n -> System.out.println("After filter: " + n))
            .collect(Collectors.toList());
        
        System.out.println("Final result: " + result);
        System.out.println();
    }
    
    // ============================================
    // 33. SORTED VS UNSORTED STREAM
    // ============================================
    public static void sortedStream() {
        System.out.println("=== 33. SORTED STREAM ===");
        List<String> words = Arrays.asList("Zebra", "Apple", "Mango", "Banana");
        
        // Natural order
        List<String> sorted = words.stream()
            .sorted()
            .collect(Collectors.toList());
        
        // Reverse order
        List<String> reversed = words.stream()
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());
        
        // Custom comparator
        List<String> byLength = words.stream()
            .sorted(Comparator.comparing(String::length).reversed())
            .collect(Collectors.toList());
        
        System.out.println("Original: " + words);
        System.out.println("Sorted: " + sorted);
        System.out.println("Reversed: " + reversed);
        System.out.println("By length: " + byLength);
        System.out.println();
    }
    
    // ============================================
    // 34. COLLECT TO DIFFERENT COLLECTIONS
    // ============================================
    public static void collectToCollections() {
        System.out.println("=== 34. COLLECT TO DIFFERENT COLLECTIONS ===");
        List<Integer> nums = Arrays.asList(1, 2, 3, 2, 4, 3, 5);
        
        // To List
        List<Integer> list = nums.stream().collect(Collectors.toList());
        
        // To Set (removes duplicates)
        Set<Integer> set = nums.stream().collect(Collectors.toSet());
        
        // To LinkedHashSet (maintains order)
        Set<Integer> linkedSet = nums.stream()
            .collect(Collectors.toCollection(LinkedHashSet::new));
        
        // To TreeSet (sorted)
        Set<Integer> treeSet = nums.stream()
            .collect(Collectors.toCollection(TreeSet::new));
        
        System.out.println("Original: " + nums);
        System.out.println("List: " + list);
        System.out.println("Set: " + set);
        System.out.println("LinkedHashSet: " + linkedSet);
        System.out.println("TreeSet: " + treeSet);
        System.out.println();
    }
    
    // ============================================
    // 35. SUMMARIZING STATISTICS
    // ============================================
    public static void summaryStatistics() {
        System.out.println("=== 35. SUMMARY STATISTICS ===");
        List<Integer> nums = Arrays.asList(10, 20, 30, 40, 50);
        
        IntSummaryStatistics stats = nums.stream()
            .mapToInt(Integer::intValue)
            .summaryStatistics();
        
        System.out.println("Numbers: " + nums);
        System.out.println("Count: " + stats.getCount());
        System.out.println("Sum: " + stats.getSum());
        System.out.println("Min: " + stats.getMin());
        System.out.println("Max: " + stats.getMax());
        System.out.println("Average: " + stats.getAverage());
        System.out.println();
    }
    
    // ============================================
    // 36. PARALLEL STREAM EXAMPLE
    // ============================================
    public static void parallelStreamExample() {
        System.out.println("=== 36. PARALLEL STREAM ===");
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // Sequential stream
        long startSeq = System.currentTimeMillis();
        int sumSeq = nums.stream()
            .map(n -> n * 2)
            .reduce(0, Integer::sum);
        long endSeq = System.currentTimeMillis();
        
        // Parallel stream
        long startPar = System.currentTimeMillis();
        int sumPar = nums.parallelStream()
            .map(n -> n * 2)
            .reduce(0, Integer::sum);
        long endPar = System.currentTimeMillis();
        
        System.out.println("Sequential sum: " + sumSeq + " (Time: " + (endSeq - startSeq) + "ms)");
        System.out.println("Parallel sum: " + sumPar + " (Time: " + (endPar - startPar) + "ms)");
        System.out.println();
    }
    
    // ============================================
    // 37. FIND TOP N ELEMENTS
    // ============================================
    public static void findTopN() {
        System.out.println("=== 37. FIND TOP N ELEMENTS ===");
        List<Integer> nums = Arrays.asList(45, 12, 89, 34, 67, 23, 91, 56);
        
        // Top 3 numbers
        List<Integer> top3 = nums.stream()
            .sorted(Comparator.reverseOrder())
            .limit(3)
            .collect(Collectors.toList());
        
        // Bottom 3 numbers
        List<Integer> bottom3 = nums.stream()
            .sorted()
            .limit(3)
            .collect(Collectors.toList());
        
        System.out.println("Numbers: " + nums);
        System.out.println("Top 3: " + top3);
        System.out.println("Bottom 3: " + bottom3);
        System.out.println();
    }
    
    // ============================================
    // 38. WORDS FREQUENCY COUNT
    // ============================================
    public static void wordFrequency() {
        System.out.println("=== 38. WORD FREQUENCY COUNT ===");
        String text = "java is great and java is powerful and java is fun";
        
        Map<String, Long> wordCount = Arrays.stream(text.split(" "))
            .collect(Collectors.groupingBy(
                Function.identity(),
                Collectors.counting()
            ));
        
        // Find most frequent word
        Map.Entry<String, Long> mostFrequent = wordCount.entrySet().stream()
            .max(Map.Entry.comparingByValue())
            .orElse(null);
        
        System.out.println("Text: " + text);
        System.out.println("Word frequency: " + wordCount);
        System.out.println("Most frequent: " + mostFrequent);
        System.out.println();
    }
    
    // ============================================
    // 39. MERGE TWO LISTS
    // ============================================
    public static void mergeLists() {
        System.out.println("=== 39. MERGE TWO LISTS ===");
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 6);
        
        // Method 1: Using Stream.concat
        List<Integer> merged = Stream.concat(list1.stream(), list2.stream())
            .collect(Collectors.toList());
        
        // Method 2: Using flatMap
        List<Integer> merged2 = Stream.of(list1, list2)
            .flatMap(List::stream)
            .collect(Collectors.toList());
        
        System.out.println("List 1: " + list1);
        System.out.println("List 2: " + list2);
        System.out.println("Merged: " + merged);
        System.out.println();
    }
    
    // ============================================
    // 40. CHECK IF LIST IS EMPTY
    // ============================================
    public static void checkEmpty() {
        System.out.println("=== 40. CHECK IF LIST IS EMPTY ===");
        List<Integer> emptyList = new ArrayList<>();
        List<Integer> nonEmptyList = Arrays.asList(1, 2, 3);
        
        boolean isEmpty1 = emptyList.stream().findAny().isEmpty();
        boolean isEmpty2 = nonEmptyList.stream().findAny().isEmpty();
        
        // Count elements
        long count1 = emptyList.stream().count();
        long count2 = nonEmptyList.stream().count();
        
        System.out.println("Empty list: " + emptyList + " -> isEmpty: " + isEmpty1 + ", count: " + count1);
        System.out.println("Non-empty list: " + nonEmptyList + " -> isEmpty: " + isEmpty2 + ", count: " + count2);
        System.out.println();
    }
    
    // ============================================
    // MAIN METHOD
    // ============================================
    public static void main(String[] args) {
    	
    	findDuplicates();  // 1
    	findFirstNonRepeated();
    	findSecondHighest();
    	groupByField();// 10
    	
        sortByLength(); // 23
        listToArray();
        findFirstAndLast();
        fibonacciSeries();
        factorial();
        squareNumbers();
        filterNulls();
        caseConversion();
        highestSalaryByDept();
        peekExample();
        sortedStream();
        collectToCollections();
        summaryStatistics();
        parallelStreamExample();
        findTopN();
        wordFrequency();
        mergeLists();
        checkEmpty();
        
        System.out.println("=== ALL EXAMPLES COMPLETED ===");
    }
    
    
}
