# COSC 351 Grocery Inventory System

This was semester long project for my Object Oriented Programming class. The goal of this project was to create a simple Grocery Store Inventory System. This was project was broken up in 4 sections.

# Section 1: Encapsulation
For the first section, all that was needed was to create a simple class called FoodItem to start doing basic encapsulation. The food item class contained the following private attributes:
- Name 
- Brand 
- UPC Code 
- Production Date
- Unit Weight 

# Section 2
Section 2 focused on creating classes for each type of food items and inheritance. The FoodItem class became an abstract class that would be inherited by FreshFood and ProcessedFood classes. These two classes were then inherited by their respective food type. Fruits, Vegetables, and Protien inherited the FreshFood class. Cheese and Precooked food inherited the Processed food class. 

This is where I also implemented error/exception handling with regular expressions.

# Section 3
Section 3 required me to create an interface called Stackable and define the conditions for an item should be stacked on shelves. The user would be prompted if the item they were entering was stackable. If it was, then the user would be asked how many items could be stacked at one time and also instructions on how they should be stacked. 

The FruitsandVegetables and ProcessedFood classes implemented this interface. 

# Section 4 
The last part of this project involved creating user interaction. The user had the choice of creating an iteming, viewing the items they had already created, or editing an item. When creating an item, the user would select what type of food item they wanted to add and then follow prompts associated with that item. If the user wanted to edit an item, they would be shown all the items and then they would select which item to change and what they wanted to change about the item. Choosing to view all the items would display all the items to the user

# Concepts Learned:
- Inheritance
- Polymorphism
- Interfaces
- Abstract Classes
- Encapsulation
- Error/Exception Handling
