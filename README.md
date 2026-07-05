# Design-Patterns
Every pattern is a lesson written by someone else's bug


Object Ortiented Basics

     Encapsulation
     Abstraction
     Inheritance
     Polymorphism


Object Oriented Principles | which patterns introduced it to me | what problem made us to do this

     Encapsulate what varies.  (statergy) -> 
     we saw some code got frequently changed so we encapsulated it by making an common interface and implementations for it

     Favor composition over inheritance.  (statergy) -> 
     we saw inhertiance was forcing all childs to have same code while some dont need it so we used has a relation for
     those code

     Program to interfaces, not implementations.  (statergy)-> 
     program to interface means using the refrence of parent so we are not coupled with the child or implementation we can make use of abstraction so we dont worry even if implementation changed

     Strive for loosely coupled designs between objects that interact (observer) -> By communicating through interfaces, the Subject and Observers became loosely coupled (object coupling). The Subject knows only the Observer interface, so Observers can be added or removed without modifying the Subject. However, in the initial push model, the update() method was still tightly coupled to the Subject's data (API coupling). Whenever new data was added, the Observer interface, the Subject, and all Observer implementations had to change. To reduce this API coupling, we changed from notify and push to notify and pull. Now the Subject simply notifies that something changed, and each Observer pulls only the data it needs through the Subject's public interface.