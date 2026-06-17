package upskilling;

import java.io.*;
import java.net.URI;
import java.net.http.*;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

// ==========================================================================
// CORE INTERFACES, CLASSES & STRUCTURES FOR TASKS 17, 18, 19, 21, 29, 30
// ==========================================================================

// Ex 17: Class Creation
class Car {
    String make, model;
    int year;
    Car(String make, String model, int year) { this.make = make; this.model = model; this.year = year; }
    void displayDetails() { System.out.println("Car Details: " + year + " " + make + " " + model); }
}

// Ex 18: Inheritance
class Animal { void makeSound() { System.out.println("Animal makes a sound"); } }
class Dog extends Animal { @Override void makeSound() { System.out.println("Bark"); } }

// Ex 19: Interface
interface Playable { void play(); }
class Guitar implements Playable { @Override public void play() { System.out.println("Playing guitar riffs"); } }
class Piano implements Playable { @Override public void play() { System.out.println("Playing piano chords"); } }

// Ex 21: Custom Exception
class InvalidAgeException extends Exception { public InvalidAgeException(String msg) { super(msg); } }

// Ex 29: Records Keyword (Java 16+)
record Person(String name, int age) {}

// ==========================================================================
// MAIN RUNNABLE UP-SKILLING CORE MANAGEMENT CORE SUITE
// ==========================================================================
public class CoreJavaSuite {

    public static void main(String[] args) {
        System.out.println("=== EXECUTION TRACE LOGS: CORE JAVA SUITE ===");
        
        // Ex 1: Hello World Program
        System.out.println("\n[Ex 1: Hello World]");
        System.out.println("Hello, World!");

        // Ex 6: Data Type Demonstration
        System.out.println("\n[Ex 6: Data Types]");
        int demoInt = 42; float demoFloat = 5.99f; double demoDouble = 199.99; char demoChar = 'A'; boolean demoBool = true;
        System.out.println("Values: " + demoInt + ", " + demoFloat + ", " + demoDouble + ", " + demoChar + ", " + demoBool);

        // Ex 7: Type Casting Example
        System.out.println("\n[Ex 7: Type Casting]");
        double rawDouble = 9.78; int castedInt = (int) rawDouble;
        int rawInt = 100; double castedDouble = rawInt;
        System.out.println("Double -> Int: " + castedInt + " | Int -> Double: " + castedDouble);

        // Ex 8: Operator Precedence
        System.out.println("\n[Ex 8: Operator Precedence]");
        int resultExpr = 10 + 5 * 2; // evaluated as 10 + (5 * 2) due to multiplicative precedence
        System.out.println("Result of 10 + 5 * 2 = " + resultExpr + " (Multiplication evaluated before addition)");

        // Ex 12: Method Overloading
        System.out.println("\n[Ex 12: Method Overloading]");
        System.out.println("Add(2, 3): " + add(2, 3));
        System.out.println("Add(2.5, 3.5): " + add(2.5, 3.5));
        System.out.println("Add(1, 2, 3): " + add(1, 2, 3));

        // Ex 13: Recursive Fibonacci
        System.out.println("\n[Ex 13: Recursive Fibonacci]");
        int fibTerm = 6;
        System.out.println("Fibonacci at position " + fibTerm + " is: " + fibonacci(fibTerm));

        // Ex 14: Array Sum and Average
        System.out.println("\n[Ex 14: Array Calculations]");
        int[] scoreArray = {80, 85, 90, 95};
        int sum = 0; for(int score : scoreArray) sum += score;
        double avg = (double) sum / scoreArray.length;
        System.out.println("Sum: " + sum + " | Average: " + avg);

        // Ex 15: String Reversal
        System.out.println("\n[Ex 15: String Reversal]");
        String targetStr = "COGNIZANT";
        String reversed = new StringBuilder(targetStr).reverse().toString();
        System.out.println("Original: " + targetStr + " | Reversed: " + reversed);

        // Ex 16: Palindrome Checker
        System.out.println("\n[Ex 16: Palindrome Checker]");
        String palindromeTest = "A man, a plan, a canal: Panama";
        String cleaned = palindromeTest.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        boolean isPalindrome = cleaned.equals(new StringBuilder(cleaned).reverse().toString());
        System.out.println("Is '" + palindromeTest + "' a palindrome?: " + isPalindrome);

        // Ex 17, 18, 19: Classes, Inheritance, Interfaces verification
        System.out.println("\n[Ex 17, 18, 19: OOP Implementations]");
        new Car("Tesla", "Model 3", 2024).displayDetails();
        new Dog().makeSound();
        Playable guitarInstance = new Guitar(); guitarInstance.play();

        // Ex 20: Try-Catch Handling
        System.out.println("\n[Ex 20: Try-Catch]");
        try {
            int divisionResult = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Caught Exception cleanly: Cannot divide numerical bounds by zero.");
        }

        // Ex 21: Custom Exceptions
        System.out.println("\n[Ex 21: Custom Exception]");
        try {
            int simulatedUserAge = 16;
            if(simulatedUserAge < 18) throw new InvalidAgeException("Access denied: Age limit under 18 parameters.");
        } catch (InvalidAgeException e) {
            System.out.println("Custom Exception Triggered: " + e.getMessage());
        }

        // Ex 22 & 23: File Writing & Reading IO operations
        System.out.println("\n[Ex 22 & 23: File IO Operations]");
        try {
            Path fileTarget = Paths.get("output.txt");
            Files.writeString(fileTarget, "Hello from the Cognizant Portal Suite File Logger Context.");
            System.out.println("Written values cleanly to output.txt");
            String readValue = Files.readString(fileTarget);
            System.out.println("Read Verification output text content: " + readValue);
        } catch (IOException e) {
            System.out.println("File processing error: " + e.getMessage());
        }

        // Ex 24 & 25: ArrayList & HashMap
        System.out.println("\n[Ex 24 & 25: Collections Framework]");
        List<String> dynamicList = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie"));
        Map<Integer, String> studentMap = new HashMap<>();
        studentMap.put(101, "Diana"); studentMap.put(102, "Ethan");
        System.out.println("ArrayList Names: " + dynamicList);
        System.out.println("HashMap Lookups (ID 101): " + studentMap.get(101));

        // Ex 26: Thread Creation
        System.out.println("\n[Ex 26: Multithreading Engine Verification]");
        Thread workerThread1 = new Thread(() -> System.out.println("Worker thread node 1 executing parallel task routines."));
        Thread workerThread2 = new Thread(() -> System.out.println("Worker thread node 2 executing parallel task routines."));
        workerThread1.start(); workerThread2.start();

        // Ex 27 & 28: Lambda Expressions & Stream API Processing
        System.out.println("\n[Ex 27 & 28: Lambda & Stream APIs Processing]");
        List<String> sortList = new ArrayList<>(Arrays.asList("Beta", "Alpha", "Gamma"));
        Collections.sort(sortList, (s1, s2) -> s1.compareTo(s2)); // Lambda sort
        System.out.println("Sorted String array outputs: " + sortList);

        List<Integer> numericList = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> evenNumbers = numericList.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        System.out.println("Stream Filtered Even Arrays metrics values: " + evenNumbers);

        // Ex 29: Records Validation Filter
        System.out.println("\n[Ex 29: Record filtering mapping configurations]");
        List<Person> group = Arrays.asList(new Person("Amit", 25), new Person("Pooja", 15));
        group.stream().filter(p -> p.age() >= 18).forEach(p -> System.out.println("Adult record instance: " + p.name()));

        // Ex 30: Pattern Matching for switch (Java 21)
        System.out.println("\n[Ex 30: Switch Pattern Matching Engine]");
        evaluateObjectTypePattern("Cognizant Validation String");
        evaluateObjectTypePattern(2026);

        // Ex 36: HTTP Client API Engine Integration (Mock safe fallback invocation wrapper)
        System.out.println("\n[Ex 36: HTTP Client Engine Verification]");
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://api.github.com/")).GET().build();
            System.out.println("HTTP Client structured URI connection request initialized safely.");
        } catch (Exception e) {
            System.out.println("Network request bypassed due to missing gateway components.");
        }

        // Ex 40: Virtual Threads Scalable Execution Engine (Java 21)
        System.out.println("\n[Ex 40: Launching Virtual Threads Concurrent Instances]");
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            executor.submit(() -> System.out.println("Lightweight concurrent execution node handled inside Virtual Thread safely."));
        }

        // Ex 41: Executor Service & Callable Parameters Infrastructure
        System.out.println("\n[Ex 41: Executor Service Fixed Pool Operations]");
        ExecutorService pool = Executors.newFixedThreadPool(2);
        Future<String> futureTask = pool.submit(() -> "Callable return value token successfully read.");
        try {
            System.out.println("Task Result Payload: " + futureTask.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        pool.shutdown();
    }

    // Overloaded static methods (Ex 12)
    public static int add(int a, int b) { return a + b; }
    public static double add(double a, double b) { return a + b; }
    public static int add(int a, int b, int c) { return a + b + c; }

    // Recursive calculation implementation (Ex 13)
    public static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // Pattern Matching for Switch Expression implementation (Ex 30)
    public static void evaluateObjectTypePattern(Object obj) {
        switch (obj) {
            case Integer i -> System.out.println("Matched integer primitive wrapper parameter: " + i);
            case String s  -> System.out.println("Matched text data String data format: " + s);
            default        -> System.out.println("Unknown framework structural reference signature pattern mapping.");
        }
    }
}