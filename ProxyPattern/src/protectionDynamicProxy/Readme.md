# 🛡️ Dynamic Protection Proxy – Java Reflection & Dynamic Proxies

A practical demonstration of **Java Dynamic Proxies** using `java.lang.reflect.Proxy` and `InvocationHandler`.

Unlike the traditional Proxy Pattern where developers manually write proxy classes, Java generates the proxy **dynamically at runtime**. Every intercepted method call is delegated to an `InvocationHandler`, allowing us to inject additional behavior like **security**, **logging**, **validation**, **transactions**, or **caching** without modifying the original business class.

This project simulates the core idea behind how modern frameworks like **Spring** implement cross-cutting concerns.

---

# 🚀 Features

* Runtime Proxy Generation
* Java Reflection API
* `InvocationHandler`
* Security Checks
* Logging
* Method Interception
* Delegation
* Reflection-based Method Invocation
* Generic Proxy Factory
* Spring AOP Concept Demonstration

---

# 🏦 Scenario

The application simulates a banking system.

There are two types of users:

* 👤 Account Holder
* 👨‍💼 Bank Manager (Admin)

Both interact with the **same BankAccount object**.

Instead of directly invoking methods on the real object, every call goes through a **Dynamic Proxy**.

The proxy performs

* Security Validation
* Logging

before delegating execution to the actual object.

---

# 📂 Project Structure

```text
protectionDynamicProxy
│
├── BankAccount
│     ├── Account.java
│     └── BankAccountImpl.java
│
├── users
│     ├── User.java
│     ├── AccountHolder.java
│     └── BankManager.java
│
├── constants
│     └── Role.java
│
├── SecurityAndLogHandler.java
│
└── Test.java
```

---

# ⚙️ How It Works

## Step 1 — Create the Real Object

```java
Account account = new BankAccountImpl(100);
```

This is the real business object.

It knows nothing about

* Logging
* Security
* Authorization
* Validation

It only contains business logic.

---

## Step 2 — Generate a Dynamic Proxy

```java
Account proxyAccount = getProxyFactory(account);
```

Using

```java
Proxy.newProxyInstance(...)
```

Java creates a **new class dynamically at runtime**.

You never write this class yourself.

Conceptually Java generates something similar to

```java
class ProxyAccount implements Account {

    private InvocationHandler handler;

    @Override
    public void withdraw(User user,int amount){
        handler.invoke(this, withdrawMethod, args);
    }

    @Override
    public void deposit(User user,int amount){
        handler.invoke(this, depositMethod, args);
    }

    ...
}
```

Every interface method simply forwards the call to the handler.

---

## Step 3 — Client Calls the Proxy

Instead of

```java
account.withdraw(user,100);
```

the client calls

```java
proxyAccount.withdraw(user,100);
```

Flow

```text
Client

↓

Generated Proxy

↓

SecurityAndLogHandler.invoke(...)

↓

Security Check

↓

Logging

↓

Real BankAccountImpl

↓

Logging

↓

Return Result
```

---

# 🔐 Security

Certain banking operations require administrator privileges.

Restricted methods

* approveLoan()
* blockAccount()

Inside the handler

```java
if ((method.getName().equals("approveLoan")
        || method.getName().equals("blockAccount"))
        && user.getRole() != Role.ADMIN) {

    throw new RuntimeException("Access Denied");
}
```

If permission is denied,

the actual method is **never executed**.

---

# 📝 Logging

Every intercepted method prints logs before and after execution.

```text
Logging before withdraw

↓

Actual Method

↓

Logging After withdraw
```

Notice that the real business class contains **zero logging code**.

The logging concern is completely separated from business logic.

---

# 🧠 Reflection

The proxy delegates every intercepted call to

```java
invoke(
    Object proxy,
    Method method,
    Object[] args
)
```

where

**proxy**

The dynamically generated proxy object.

**method**

The actual method that was invoked.

**args**

Arguments supplied by the caller.

The handler executes the real method using reflection.

```java
Object result = method.invoke(target,args);
```

This single line allows one generic handler to invoke **any method** of the target object.

---

# 🔄 Return Values

`Method.invoke()` always returns an `Object`.

Examples

| Original Return Type | Reflection Returns |
| -------------------- | ------------------ |
| void                 | null               |
| int                  | Integer            |
| boolean              | Boolean            |
| String               | String             |
| User                 | User               |

Because of this,

the same handler works for every method regardless of return type.

---

# 🏭 Proxy Factory

The project exposes a small factory.

```java
public static Account getProxyFactory(Account account)
```

Internally it creates

```java
Proxy.newProxyInstance(...)
```

and returns the generated proxy.

The client never interacts with the real object directly.

---

# 🎯 Concepts Demonstrated

* Dynamic Proxy Pattern
* Runtime Class Generation
* Reflection API
* InvocationHandler
* Method Interception
* Cross-Cutting Concerns
* Logging
* Authorization
* Delegation
* Proxy Factory
* Separation of Concerns

---

# 🔥 Relation with Spring Framework

This project demonstrates the exact architectural idea used by Spring.

The only difference is **how interception is implemented**.

## In this project

Java creates a **JDK Dynamic Proxy**.

Every intercepted method is delegated to

```java
InvocationHandler
```

which performs

* Security
* Logging

before invoking the real object.

Flow

```text
Client

↓

Generated Dynamic Proxy

↓

InvocationHandler

↓

Real Object
```

---

## In Spring

Spring also creates proxies around beans.

However,

instead of directly using an `InvocationHandler` for all cases, Spring typically uses **interceptors**.

If the bean implements an interface:

* Spring can create a **JDK Dynamic Proxy**
* The proxy infrastructure eventually delegates to Spring AOP interceptors.

If the bean does **not** implement an interface:

* Spring creates a **CGLIB subclass proxy**
* Method interception is performed using `MethodInterceptor`.

Conceptually

```text
Client

↓

Spring Generated Proxy

↓

MethodInterceptor

↓

Actual Service Bean
```

---

# Features in Spring that use this idea

The same proxy mechanism powers many Spring features.

## `@Transactional`

```text
Client

↓

Proxy

↓

Begin Transaction

↓

Real Method

↓

Commit / Rollback
```

---

## `@Cacheable`

```text
Client

↓

Proxy

↓

Check Cache

↓

Cache Miss

↓

Real Method

↓

Store Result

↓

Return
```

---

## `@Async`

```text
Client

↓

Proxy

↓

Create Background Thread

↓

Execute Method
```

---

## Method Security

```text
Client

↓

Proxy

↓

Check User Permissions

↓

Allow / Deny

↓

Real Method
```

---

## Logging Aspects

```text
Client

↓

Proxy

↓

Before Advice

↓

Real Method

↓

After Advice
```

---

# Comparing This Project with Spring

| This Project                 | Spring Framework                            |
| ---------------------------- | ------------------------------------------- |
| `Proxy.newProxyInstance()`   | ProxyFactory / Auto Proxy Creation          |
| `InvocationHandler`          | AOP Interceptor Chain (`MethodInterceptor`) |
| `method.invoke(target,args)` | `MethodInvocation.proceed()`                |
| Security Check               | Spring Security Method Interceptor          |
| Logging                      | AOP Advice                                  |
| Proxy Factory                | ApplicationContext returning proxied beans  |
| Real Account Object          | Spring Bean                                 |
| Dynamic Proxy                | Spring Generated Proxy                      |

---

# Key Takeaway

This project demonstrates the fundamental principle behind proxy-based frameworks.

The business class focuses only on business logic, while additional concerns like logging and authorization are injected transparently by a proxy.

Although this project uses Java's `InvocationHandler`, the overall architecture is the same one used by Spring. Spring wraps beans with generated proxies and applies interceptor chains to provide features such as transactions, caching, asynchronous execution, method security, and logging—all without changing the original service implementation.
