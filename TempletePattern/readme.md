
---

# ☕ Template Method Pattern – Beverage Example

## 🧠 Overview

This project demonstrates the **Template Method Design Pattern** using a simple beverage preparation flow.

The base class defines a **fixed algorithm (template)**, while subclasses customize specific steps.

---

## 📌 What is Template Method Pattern?

> Define the skeleton of an algorithm in a base class and let subclasses override specific steps without changing the overall structure.

---

## ⚙️ How it works here

The abstract class:

👉 `CaffineBeverage`

controls the full process:

```java
public void prepare(){
    boilWater();
    brew();
    pourInCup();
    if(hook()) {
        addCondiments();
    }
}
```

### Flow:

```text
Boil Water → Brew → Pour → (Optional) Add Condiments
```

---

## 🧩 Components Breakdown

### 1️⃣ Abstract Class → `CaffineBeverage`

Defines:

* Template method → `prepare()`
* Concrete steps:

    * `boilWater()`
    * `pourInCup()`
* Abstract steps:

    * `brew()`
    * `addCondiments()`
* Hook method:

    * `hook()` → controls optional behavior

---

### 2️⃣ Concrete Class → `CoffeeBeverage`

```java
@Override
protected void brew() {
    System.out.println("Brewing coffee");
}

@Override
protected void addCondiments() {
    System.out.println("Adding milk and sugar");
}
```

👉 Always adds condiments (default hook = true)

---

### 3️⃣ Concrete Class → `TeaBeverage`

```java
@Override
public boolean hook() {
    System.out.println("Do you want to add lemon (y/n)");
    // user decides
}
```

👉 Uses **hook method** to decide dynamically
👉 Adds condiments only if user agrees

---

## 🔥 Key Concepts

### ✅ Template Method

* `prepare()` defines the algorithm flow

---

### ✅ Abstract Methods

* `brew()`
* `addCondiments()`

👉 Must be implemented by subclasses

---

### ✅ Hook Method

```java
public boolean hook(){
    return true;
}
```

* Optional override
* Allows conditional behavior

---

## 💡 Why use this pattern?

* Enforces **consistent workflow**
* Allows **flexibility in steps**
* Prevents duplication of common logic

---

## 🔁 Real-world analogy

Making beverages:

* Steps are mostly same
* Only preparation differs

👉 Same as:

* JDBC Template
* Spring processing pipelines
* Servlet filters/interceptors flow

---

## 🧠 Pattern Insight

This pattern combines:

* **Inheritance** → reuse structure
* **Polymorphism** → customize behavior

---

## ⚠️ Small Improvement Suggestion

In `TeaBeverage`, instead of:

```java
boolean input = sc.nextBoolean();
```

👉 Use:

```java
String input = sc.nextLine();
return input.equalsIgnoreCase("y");
```

---

## 🎯 Summary

> The Template Method Pattern lets you define a fixed process while allowing subclasses to customize certain steps — giving both structure and flexibility.

---
