# 🍕 Pizza Vendor - Decorator Design Pattern

## Overview

This project demonstrates the implementation of the **Decorator Design Pattern** using a pizza ordering system. The objective is to dynamically add toppings to a pizza without modifying the existing pizza classes.

Instead of creating a separate class for every possible combination of pizza and add-ons, decorators allow toppings to be layered at runtime, making the system flexible, scalable, and easy to extend.

---

# Project Structure

```text
Pizza
│
├── AbstractPizza
│      ├── VegLoaded
│      ├── ChickenSausage
│      ├── VideshiHotSauce
│      └── ...
│
└── PizzaDecorator
       ├── Cheese
       ├── Corn
       ├── Ketchup
       └── ...
```

---

# Design Decisions

## Pizza Interface

The `Pizza` interface represents the common contract for every pizza object in the system.

Both the base pizzas and the decorators implement this interface, allowing them to be treated as the same type throughout the application.

This design makes it possible to wrap one pizza inside another decorator while still referring to the final object simply as a `Pizza`.

---

## Why AbstractPizza?

Every base pizza contains common information such as:

* Pizza name
* Pizza type
* Pizza size

Instead of repeating these fields in every concrete pizza class, they are stored in `AbstractPizza`.

Each concrete pizza is then responsible only for its own pricing logic, while all shared properties remain centralized.

This reduces duplication and makes adding new pizza types much easier.

---

## Why PizzaDecorator?

Every add-on behaves like a pizza while also containing another pizza.

`PizzaDecorator` exists to hold the wrapped pizza object and to provide common delegation logic shared by all add-ons.

Rather than duplicating this logic in every topping class, all decorators inherit it from `PizzaDecorator`.

Each individual add-on only implements the behavior that changes, such as modifying the pizza name or adding its own cost.

---

# Decorator is the Same Type as Pizza

One of the core ideas of the Decorator pattern is that a decorator should behave exactly like the object it decorates.

A decorator is both:

* **A Pizza** (because it implements the `Pizza` interface)
* **A wrapper around another Pizza** (because it stores a reference to another `Pizza`)

This combination allows decorators to wrap other decorators repeatedly, creating a chain of objects while exposing only a single `Pizza` reference to the client.

---

# Delegation

The decorator does not own information such as:

* Pizza name
* Pizza size
* Pizza type

Instead, it delegates these responsibilities to the wrapped pizza.

This ensures that the original pizza remains the single source of truth while decorators only contribute additional behavior.

Delegation avoids code duplication and keeps decorators lightweight.

---

# How PizzaDecorator Uses Add-on Methods

`PizzaDecorator` contains common functionality such as displaying pizza details.

Although this functionality is implemented only once, it automatically works for every add-on because of **runtime polymorphism**.

When methods like the pizza name or cost are requested, Java executes the overridden implementation of the actual decorator object.

As a result:

* Cheese contributes its own name and cost.
* Corn contributes its own name and cost.
* Ketchup contributes its own name and cost.

The abstract decorator never needs to know which specific add-on is being used. It simply calls the interface methods, and Java invokes the appropriate implementation at runtime.

This makes the system highly extensible because new toppings can be added without modifying any existing classes.

---



# Design Principles Used

* Program to an interface.
* Favor composition over inheritance.
* Open/Closed Principle.
* Single Responsibility Principle.
* Delegation.
* Runtime Polymorphism.
* Dynamic behavior extension using the Decorator pattern.

---
