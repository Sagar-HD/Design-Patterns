# Singleton Pattern (Basic Lazy Initialization)

## Intent

The Singleton Pattern ensures that **only one instance** of a class exists throughout the application's lifetime while providing a global access point to that instance.

Examples:

* Logger
* Database Connection Pool
* Configuration Manager
* Cache Manager
* Printer Service

---

# Basic Implementation

The simplest lazy Singleton consists of three parts:

* A **private constructor** so no other class can create objects.
* A **private static instance** to hold the only object.
* A **public static `getInstance()`** method to provide access.

Example

```java
private static Printer instance;

private Printer() {}

public static Printer getInstance() {
    if (instance == null) {
        instance = new Printer();
    }
    return instance;
}
```

The object is created only when it is first requested (Lazy Initialization).

---

# Why Is This Not Thread Safe?

This implementation works correctly in a **single-threaded** application.

The problem appears when multiple threads call `getInstance()` simultaneously.

Suppose initially

```text
instance = null
```

Now two threads execute at nearly the same time.

```text
Thread 1
---------
if(instance == null)   ---> true

               (context switch)

Thread 2
---------
if(instance == null)   ---> true
instance = new Printer()

               (context switch)

Thread 1
---------
instance = new Printer()
```

Both threads observed `instance == null` before either one assigned it.

As a result,

* Thread 1 creates one object.
* Thread 2 creates another object.

The Singleton guarantee is broken because two different instances are created.

The race occurs during the **first initialization**.

---

# Why Synchronization Is Needed

The critical section is

```java
if(instance == null){
    instance = new Printer();
}
```

Checking whether the instance exists and creating it must happen as **one atomic operation**.

Only one thread should be allowed to execute this block during initialization.

Once the Singleton object has been created, every thread simply returns the existing instance.

---

# Ways to Make Singleton Thread Safe

## 1. Synchronized Method

```java
public static synchronized Printer getInstance()
```

Only one thread can execute `getInstance()` at a time.

Pros

* Very simple.
* Thread safe.

Cons

* Synchronization happens on every call, even after the instance has already been created.

---

## 2. Double Checked Locking

```java
if(instance == null){
    synchronized(Printer.class){
        if(instance == null){
            instance = new Printer();
        }
    }
}
```

Requires

```java
private static volatile Printer instance;
```

The first null check avoids locking after initialization.

Synchronization occurs only once during object creation.

---

## 3. Initialization-on-Demand Holder

Uses a private static inner class.

```java
private static class Holder{
    private static final Printer INSTANCE = new Printer();
}
```

The JVM guarantees that the inner class is initialized only once when it is first accessed.

Pros

* Lazy initialization
* Thread safe
* No explicit synchronization

---

## 4. Eager Initialization

```java
private static final Printer INSTANCE = new Printer();
```

The object is created when the class is loaded.

Pros

* Simple
* Thread safe

Cons

* Object is created even if it is never used.

---

## 5. Enum Singleton (Recommended)

```java
public enum Printer {
    INSTANCE;
}
```

The JVM guarantees that an enum constant is created exactly once.

Advantages

* Thread safe
* Prevents multiple instances during serialization
* Prevents reflection from creating another instance
* Simplest implementation in Java

---

# Which Implementation Should Be Preferred?

| Implementation            | Lazy | Thread Safe | Notes                                                                                                  |
| ------------------------- | ---- | ----------- | ------------------------------------------------------------------------------------------------------ |
| Basic Lazy Initialization | ✅    | ❌           | Suitable only for single-threaded applications.                                                        |
| Synchronized Method       | ✅    | ✅           | Simple but synchronizes every call.                                                                    |
| Double Checked Locking    | ✅    | ✅           | Efficient after initialization. Requires `volatile`.                                                   |
| Holder Pattern            | ✅    | ✅           | Lazy, efficient, and relies on JVM class loading.                                                      |
| Eager Initialization      | ❌    | ✅           | Instance created during class loading.                                                                 |
| Enum Singleton            | ✅*   | ✅           | Recommended for most Java applications. The enum class is initialized lazily when first actively used. |

---

# Key Takeaways

* A Singleton guarantees that only one instance of a class exists.
* The basic lazy implementation is not thread safe because multiple threads can create the instance simultaneously.
* Synchronization is only required during the first initialization.
* Different implementations provide different ways to ensure that initialization happens exactly once.
* In Java, the **Enum Singleton** is generally the safest and most concise implementation.
