# CB_Exercises
 
 You are tasked with building a configuration framework that enables the developers to accept the user preferences and take application decisions based on the configuration value.
References:
Chrome configuration page : chrome://settings/ Firefox configuration page : about:config
Framework Requirements:
1) The framework should support different type of preference values
a) String
b) Boolean
c) Number - Integer, Double
d) Date
e) Timestamp
2) The developers should be able to define a default value for a preference
3) The preference definition and retrieval should be strongly typed
4) There can be dependencies between two different preferences. For instance, If we have two preferences P1<Boolean>, P2<String>; P2 can be functionally dependent on P1.
P2 -> P1, (i.e) P2 is relevant only if P1 evaluates to true
5) The developers should also be able to define custom dependency conditions. For instance, If I have two preferences P1<String>, P2<String>, the developer should be able to define a custom condition such that P2 is relevant only if P1 evaluates to a specified value
P2 -> C -> P1, (i.e) P2 is relevant only if P1 evaluates to C
Example:
P2 -> “Hello” -> P1, (i.e) P2 is relevant only if P1 evaluates to “Hello”
6) The developers should be able to associate a criteria with the preference.
The criteria comprises one or more conditions. Each condition evaluates to either “True” or “False”. All the conditions must be true for a criteria to be evaluated “True”.
The criteria follow the below format
Criteria: And:
 Fact0: <variable_name>
Condition0: <EQ | NEQ | IN | BETWEEN | GT | GTE | LT | LTE> Value0: <value_to_match1>, <value_to_match2>.....
Fact1: <variable_name>
Condition1: <EQ | NEQ | IN | BETWEEN | GT | GTE | LT | LTE> Value1: <value_to_match1>, <value_to_match2>....
Example: If I have a preference P1<String>, the developer can attach the following criteria to the preference P1
Note:
Criteria: And:
Fact0: “customer_plan”
Condition0: “EQ”
Value0: <value_resolved_in_runtime>
Fact1: “customer_plan_amount” Condition1: “GT”
Value1: <value_resolved_in_runtime>
● The developer would be providing only the criteria definition. The “Value” for the criteria is provided by the end-user and will be resolved in the runtime
● Only a simple ‘Logical AND’ operator is supported. The criteria won’t have any nested ‘Logical AND’ or ‘Logical OR’ conditions.
7) Anytime the end-user changes the preference value, the framework should automatically generate the audit logs for the change

# Artifacts to be submitted:
1) A design document with a UML diagram of all the classes
2) Data model for the preference & audits storage
3) A sample client code for preference definition for the following cases
a) Simple preference
b) Preference with a dependency on another preference
c) Preference with a custom dependency on another preference
d) Preference with a criteria
4) Thoughts on non-functional requirements
5) A concrete implementation of the criteria
a) Object model
b) Condition evaluation
