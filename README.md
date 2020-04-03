# Object Orientation Design Pattern - CA1 Assignment 04 April 2020

# Objective

• Bullet list Determine which design pattern should be used and how design patterns can be tailored for custom use.
 
• Bullet list Understand how design patterns are used in industry code to aid the design process on larger projects.
 
• Bullet list Utilise their knowledge of design patterns to assess the limitations of an existing application. 

# Specification Functionality

The design pattern acquires the application able to querying and retrieving data from database but client has no direct access to the database to extracting the data.

• Bullet list Extracting all recorded country from database.


• Bullet list Searching a specific country by entering its full country name.
• Bullet list Searching a specific country by entering its country code.

• Bullet list Adding a new country into the database.

## Specific Requirements 

I have chose a creational of factory and abstract factory design patterns.
The factory design simply just implement the define method in the interface's package, where in abstract factory design pattern it just invoke its paren    t methods without creating a direct constructor.
When running the programming, a client will be displayed a list of menu selection by invoking the class menu object and the client will be able to select any optional selection from the menu and once a selection is being selected, a call of connection to the database will be establish and once connected successfully, a communication between client test program will be able to querying and the database will be returned the data that extracted from the database.
Since the connection will keep running until the client terminate (or refresh) the connected database by selecting the option 5 from the menu selection.
