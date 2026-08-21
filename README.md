# Design-Patterns
Every pattern is a lesson written by someone else's bug


Design patterns
1.Statergy  :The Strategy Pattern defines a family of algorithms,
             encapsulates each one, and makes them interchangeable.
             Strategy lets the algorithm vary independently from
             clients that use it.

2.Observer  : The Observer Pattern defines a one-to-many
              dependency between objects so that when one
              object changes state, all of its dependents are
              notified and updated automatically.

3.Decorator : The Decorator Pattern attaches additional
              responsibilities to an object dynamically.
              Decorators provide a flexible alternative to
              subclassing for extending functionality

4.Factory : The Factory Method Pattern defines an interface
            for creating an object, but lets subclasses decide which
            class to instantiate. Factory Method lets a class defer
            instantiation to subclasses.
            (We made abstract pizza store and abstract createpizza factory method
             which must be implemented by sub classes)
5.Singleton : The Singleton Pattern ensures a class has only one
              instance, and provides a global point of access to it

6.Builder : The Builder Pattern separates the construction of a complex object from its representation.

7.Proxy : The Proxy Pattern provides a surrogate or placeholder for another object to control access to it.

8.Templete : Define the skeleton of an algorithm in a base class and let subclasses override specific steps without changing the overall structure.

Object Oriented Principles | which patterns introduced it to me | what problem made us to do this

     1.Encapsulate what varies.  (statergy) -> 
     we saw some code got frequently changed so we encapsulated it by making an common interface and implementations for it
     "Use composition and interchangeable implementations." this is wt statergy says 

     2.Favor composition over inheritance.  (statergy) -> 
     we saw inhertiance was forcing all childs to have same code while some dont need it so we used has a relation for
     those code

     3.Program to interfaces, not implementations.  (statergy)-> 
     program to interface means using the refrence of parent so we are not coupled with the child or implementation
     we can make use of abstraction so we dont worry even if implementation changed

     4.Strive for loosely coupled designs between objects that interact (observer) ->
      By communicating through interfaces, the Subject and Observers became loosely coupled (object coupling). 
     The Subject knows only the Observer interface, so Observers can be added or removed without modifying the Subject.
    However, in the initial push model, the update() method was still tightlycoupled to the Subject's data(API coupling).
     Whenever new data was added,the Observer interface, the Subject, and all Observer implementations had to change.
     To reduce this API coupling, we changed from notify and push to notify and pull. Now the Subject simply notifies 
     that something changed,and each Observer pulls only the data it needs through the Subject's public interface.


     5.Open closed Principle : Classes should be open for extension, but closed for modification. (decorator)->
     here we learn inheritence is the only was for extension we have other best ways also
     this open close principle is also implemented in stategry and observer but decorator do this in different way ,
     decorators are there for extension and reduced modification , we saw abstract beverage and concrete coffees 
     when we need all combination of add ons to coffe we end up creating more classes when using inheritence , 
     so instead we create a abstract decorator same type as beverage using inhertience to match the type,  
     the decorator doesn't use inheritance to decorate the object.It uses inheritance to maintain the same type (Beverage)
     and composition (holding a Beverage reference) to actually perform the decoration and also have a reference of the
     beverage we are going to decorate as instance variable to delegate the responsibility or to get data from decorated
     objects ,then we create concrete decorators by exteding our abstract decorator then whenever we need to decorate we
     just wrap by creating instance of decorator and passing the ref of object to be decorated in contructor , 
     by this by this calling the method from top most decorator it delegates and combines result from all its decorator
     until the object with its calculation or logic and returns combined output
     Two problems ->1. If client code depends on a concrete class (for example, using instanceof HouseBlend to 
                       apply a HouseBlend-specific discount),it will break after decoration because the outermost 
                       object is now a decorator.To avoid this, always program to interfaces (abstractions),
                       not concrete types. If client code needs to know the coffee type,
                       expose it through the Beverage abstraction (for example, getCoffeeType()) 
                       instead of checking concrete classes.
                   2.  Another prboblem as decoractor adds tiny classes upon objects its difficult
                      to read and understand example java io decorators 

     6.(Dependency Inversion) Depend upon abstractions. Do not depend upon concrete classes. : (factory) ->
     we saw how pizza stores were dependent on concrete pizza classes , they were instanciating concerete pizza in store,
     they were coupled to it , so we created a simple factory class we encapsulated objected creation , we encapsulated 
     the coupling with concrete classes , it was just like an composition of factory to store , then we made a
     abstract store with abstract factory method , all common operation on product produced by factory is in abstract store 
     and the logic to create product must be implemented by sub classes,by this user only knows create product method 
     but not its implementation,we can just code to its interface or abstraction rather than concrete classes
     Before high level component like pizzastore was dependent on concrete pizza now we have inverted the dependecies 
     both pizza store and concrete pizza are dependent on interface means on an abstraction thus is Dependency Inversion
