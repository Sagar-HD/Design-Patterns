# 🎭 Proxy Design Pattern (Java)

A collection of hands-on implementations of the **Proxy Design Pattern** in Java.

Instead of just reading about proxy patterns, I wanted to build them from scratch to understand **where they are used, how they work internally, and why they exist.**

This repository demonstrates three different types of proxies:

- 🌐 Remote Proxy (Java RMI)
- 🔒 Virtual Proxy (Lazy Initialization)
- 🛡️ Protection Proxy (Java Dynamic Proxy)

---

# 🌐 Remote Proxy (My Favorite One 😄)

When I first heard about Java RMI, I assumed I'd have to manually deal with sockets, networking, serialization, and low-level communication.

Instead, the client simply calls:

```java
camera.getCapturedData();
```

The interesting part?

The actual `Camera` object is running inside **another JVM**, yet the code feels exactly like invoking a normal local Java object.

That was the moment the **Remote Proxy** pattern finally clicked for me.

---

## How it works

```text
                 CLIENT JVM

            MyMobile Application
                     │
                     ▼
        ScheduledExecutorService
                     │
                     ▼
            RMI Stub (Proxy)
                     │
══════════════════ Network ══════════════════
                     │
                     ▼
          Camera Implementation
                     │
                     ▼
             Camera Hardware
```

The client never communicates directly with the real object.

Instead, the **RMI Stub** acts as a proxy. It forwards the request over the network, invokes the real object, receives the response, and returns it back while making everything feel like an ordinary local method call.

---

## Making it a little more interesting

Instead of making just one remote call, I decided to use **ScheduledExecutorService**.

Every few seconds it automatically executes

```java
camera.getCapturedData();
```

and prints the latest data received from the remote camera.

This combines **Java Concurrency** with **Java RMI**, making the example feel much closer to a real monitoring application.

---

## Things I learned

- Remote objects can feel exactly like local Java objects.
- Client and server only need the shared interface.
- Java automatically handles serialization.
- RMI Stubs hide all networking details.
- `ScheduledExecutorService` is a clean way to periodically invoke remote methods.

---

# 🔒 Virtual Proxy

After working with distributed objects, I wanted to build something lighter.

So I created a **Super Secure Locker** 😄

Imagine someone built a locker that's a little *too* secure.

You enter the correct password...

Nothing happens.

You enter it again...

Only then is the actual locker created.

After that, every request simply reuses the same locker instance.

Not the most user-friendly locker ever 😂, but it helped me understand **lazy initialization**.

---

## Flow

```text
User
 │
 ▼
ProxyLocker
 │
 ├── Wrong Password
 │      │
 │      ▼
 │   Access Denied
 │
 └── Correct Password
        │
        ▼
 Verification...
        │
        ▼
 Second Successful Attempt
        │
        ▼
 Create RealLocker
        │
        ▼
 Open Locker
        │
        ▼
 Future Requests
        │
        ▼
 Reuse Existing Locker
```

The important part isn't the password verification.

The key takeaway is that the expensive object (**RealLocker**) isn't created until it's actually required.

That's exactly what a **Virtual Proxy** is designed to do.

---

## Things I learned

- Lazy initialization
- Object creation on demand
- Delegation
- Memory optimization
- Reusing existing objects

---

# 🛡️ Protection Proxy (Java Dynamic Proxy)

For the third implementation, I wanted to explore something used heavily in real Java frameworks like **Spring Security**, **Spring AOP**, and many middleware libraries.

Instead of writing a proxy class manually, I used Java's built-in **Dynamic Proxy API**.

The proxy intercepts every method call before it reaches the real object.

Inside the proxy I implemented two cross-cutting concerns:

- ✅ Authorization
- 📝 Logging

The real `BankAccount` class contains only business logic.

The proxy decides **who is allowed to execute which operation**.

---

## Scenario

There are two users.

### 👨‍💼 Bank Manager

Can

- Deposit
- Withdraw
- Approve Loan
- Block Account

### 👤 Account Holder

Can

- Deposit
- Withdraw

Cannot

- Approve Loan
- Block Account

If an account holder tries to perform an unauthorized operation, the proxy blocks the request before it reaches the real object.

---

## Architecture

```text
                    Client
                      │
                      ▼
           Dynamic Proxy Instance
                      │
                      ▼
         SecurityAndLogHandler
          (InvocationHandler)
          ┌──────────────┐
          │ Authorization│
          │    Logging   │
          └──────────────┘
                      │
                      ▼
             BankAccountImpl
```

The client only communicates with the proxy.

Every method call passes through the `InvocationHandler`, which

- checks permissions,
- logs the operation,
- forwards the call to the real object if authorized.

---

## Creating the Dynamic Proxy

```java
Account proxyAccount = (Account) Proxy.newProxyInstance(
        Account.class.getClassLoader(),
        new Class[]{Account.class},
        new SecurityAndLogHandler(account)
);
```

The proxy implements the same interface (`Account`) as the real object.

Whenever a method is invoked, Java automatically calls the `invoke()` method of `SecurityAndLogHandler`.

---

## Request Flow

```text
Client
   │
   ▼
Proxy
   │
   ▼
InvocationHandler
   │
   ├── Authorization Check
   │
   ├── Logging
   │
   ├── Allowed?
   │      │
   │      ├── No
   │      │      ▼
   │      │  Access Denied
   │      │
   │      └── Yes
   │             ▼
   ▼
Real Bank Account
```

The real object remains completely unaware of security checks or logging.

Its only responsibility is implementing banking operations.

---

## Why Dynamic Proxy?

Without a proxy, every business method would need to contain authorization and logging code.

Example:

```java
public void withdraw(...) {
    checkPermission();
    log();
    ...
}
```

This mixes business logic with infrastructure code.

Using a Dynamic Proxy keeps responsibilities separated.

- Business class → Business logic
- Proxy → Security
- Proxy → Logging

This is one of the core ideas behind **Aspect-Oriented Programming (AOP).**

---

## Things I learned

- Java Reflection
- Dynamic Proxy API
- `InvocationHandler`
- Method interception
- Cross-cutting concerns
- Authorization
- Logging
- Separation of concerns
- Why Spring AOP uses proxies internally

---

# 📂 Project Structure

```text
ProxyPattern
│
├── remoteProxy
│   ├── client
│   ├── server
│   └── shared
│
├── virtualProxy
│   ├── Locker.java
│   ├── ProxyLocker.java
│   ├── RealLocker.java
│   ├── User.java
│   └── SecuredLockerDemo.java
│
└── protectionDynamicProxy
    ├── BankAccount
    │   ├── Account.java
    │   └── BankAccountImpl.java
    │
    ├── users
    │   ├── User.java
    │   ├── BankManager.java
    │   └── AccountHolder.java
    │
    ├── SecurityAndLogHandler.java
    └── Test.java
```

---

# 📚 Concepts Covered

## 🌐 Remote Proxy

- Java RMI
- Remote Interfaces
- RMI Registry
- Serialization
- Stub (Remote Proxy)
- Communication between different JVMs
- ScheduledExecutorService

### 🔒 Virtual Proxy

- Lazy Initialization
- Object creation on demand
- Delegation
- Reusing existing objects

### 🛡️ Protection Proxy

- Java Reflection
- Dynamic Proxy API
- InvocationHandler
- Authorization
- Logging
- Method Interception
- Cross-cutting Concerns
- Separation of Concerns
- Aspect-Oriented Programming (AOP)

---

# 🛠️ Technologies Used

- Java
- Java Reflection API
- Java Dynamic Proxy
- Java RMI
- Java Concurrency (`ScheduledExecutorService`)
- Serialization
- Object-Oriented Programming
- Design Patterns

---

# 🎯 Key Takeaways

This repository demonstrates how the **same Proxy Design Pattern** can solve very different problems.

| Proxy Type | Purpose |
|------------|---------|
| 🌐 Remote Proxy | Access objects located in another JVM or machine. |
| 🔒 Virtual Proxy | Delay creation of expensive objects until needed. |
| 🛡️ Protection Proxy | Control access to objects by adding security, logging, auditing, or other cross-cutting concerns. |

Building these implementations helped me understand not only the Proxy pattern itself, but also how concepts like **Java RMI**, **Reflection**, **Dynamic Proxies**, and frameworks such as **Spring AOP** rely on the same underlying design principles.