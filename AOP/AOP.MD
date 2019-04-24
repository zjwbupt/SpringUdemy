## AOP
### Benefits of AOP
- Code for aspect is defined in a single class
    - Much better than being scattered evertwhere
    - Promotes code reuse and easier to change

- Business code in your application is cleaner
    - Only applies to business functionality: addAccount
    - Reduces code complexity

- Configurable
  - Based on config, apply Aspects selectively to different parts of app
  - No Need to make changes to main app code !!!


### Additional AOP Use Cases
- Most common
  - logging, security, transactions

- Audit logging
  - who, what, when

- Exception Handleing
- API Management


### Adv vs Disadv
- Adv 
  - Reusable modeules.
  - Resolve code tangling
  - applied selectively based on config.

- Disadv
  - Too manyaspects and app flow is hard to flow.
  - Minor performance cost for aspect execution

----
## AOP Terminology
- Aspect: module of code for a cross-cutting concern.
- Advice: What action is taken and then it should be applied.
- Join Point: When to apply code during program execution.
- Pointcut: A predicate expression for where advice should be applied.

### Advice Types:
-  Before advice: run before the method.
-  After finally advice: run after the method(finally).
-  After returning advice
-  After thworing advice
-  Around advice

### Weaving
- Connecting aspects to target objects to create an advised object.
- Different types of weaving.


### AOP Framework
- Spring AOP vs. AspectJ

#### Compare
- Spring AOP only supports:
  - Method-level Join Points
  - Run-time code weaving

- AspectJ supports
  - join points: method-level, constructor, field
  - weaving: complie-time, post compile-time and load-time





### PointCut Expression

#### Mathcing on method names

- Matching only *AddAccount()* method in *AccountDAO* class

  ```java
  @Before("execution(public void com.zjw.dao.AccountDAO.addAccount())");
  ```

- Match Any *AddAccount()* method in any class

  ```java
  @Before("execution(pulibc void addAccount())");
  ```

  