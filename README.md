# First_Exercise_Spring_Boot
First Exercise of Spring Boot to Highscore.

# API

## Overall API

### Read All
     #### API - /overall - GET
     Return all information from the users with the sum of all categories.

## Attacks API
   
   ### Read All
    #### API - /attacks - GET
    Return all information from the users
   
   ### Top 10 Category
    #### API - /attacks/topAttacks - GET
    Return all information from the best 10 users
   
   ### Find By Id
    #### API - /attacks/{id} - GET
    Return a specific user by his id
   
   ### Create
    #### API - /attacks - POST
    JSON Expected
      { 
        name: "String",
        level: "Integer",
        xp: "Long"
      }
    Create a new user in category and return the user saved
   
   ### Update
    #### API - /attacks/{id} - PUT
    JSON Expected
      { 
        name: "String",
        level: "Integer",
        xp: "Long"
      }
    Update a specific user and return the user updated
   
   ### Delete
    #### API - /attacks/{id} - DELETE
    Delete a specific user and return true
   
   ### Find By Name
    #### API - /attacks/name/{name} - GET
    Return a specific user by his name
    
## Defense API

  ### Read All
    #### API - /defenses - GET
    Return all information from the users
  
  ### Top 10 Category
    #### API - /defenses/topDefenses - GET
    Return all information from the best 10 users
    
   ### Find By Id
    #### API - /defenses/{id} - GET
    Return a specific user by his id
    
   ### Create
    #### API - /defenses - POST
    JSON Expected
      { 
        name: "String",
        level: "Integer",
        xp: "Long"
      }
    Create a new user in category and return the user saved
    
   ### Update
    #### API - /defenses/{id} - PUT
    JSON Expected
      { 
        name: "String",
        level: "Integer",
        xp: "Long"
      }
    Update a specific user and return the user updated
    
   ### Delete
    #### API - /defenses/{id} - DELETE
    Delete a specific user and return true
    
   ### Find By Name
    #### API - /defenses/name/{name} - GET
    Return a specific user by his name

## Magic API

   ### Read All
    #### API - /magics - GET
    Return all information from the users
    
   ### Top 10 Category
    #### API - /magics/topMagics - GET
    Return all information from the best 10 users
    
   ### Find By Id
    #### API - /magics/{id} - GET
    Return a specific user by his id
    
   ### Create
    #### API - /magics - POST
    JSON Expected
      { 
        name: "String",
        level: "Integer",
        xp: "Long"
      }
    Create a new user in category and return the user saved
    
   ### Update
    #### API - /magics/{id} - PUT
    JSON Expected
      { 
        name: "String",
        level: "Integer",
        xp: "Long"
      }
    Update a specific user and return the user updated
    
   ### Delete
    #### API - /magics/{id} - DELETE
    Delete a specific user and return true
    
   ### Find By Name
    #### API - /magics/name/{name} - GET
    Return a specific user by his name
    
## Crafting API

   ### Read All    
    #### API - /craftings - GET
    Return all information from the users
   
   ### Top 10 Category    
    #### API - /craftings/topCraftings - GET
    Return all information from the best 10 users
    
   ### Find By Id
    #### API - /craftings/{id} - GET
    Return a specific user by his id
    
   ### Create
    #### API - /craftings - POST
    JSON Expected
      { 
        name: "String",
        level: "Integer",
        xp: "Long"
      }
    Create a new user in category and return the user saved
    
   ### Update
    #### API - /craftings/{id} - PUT
    JSON Expected
      { 
        name: "String",
        level: "Integer",
        xp: "Long"
      }
    Update a specific user and return the user updated
    
   ### Delete
    #### API - /craftings/{id} - DELETE
    Delete a specific user and return true
    
   ### Find By Name
    #### API - /craftings/name/{name} - GET
    Return a specific user by his name

## Cooking API
    
   ### Read All
    #### API - /cookings - GET
    Return all information from the users
   
   ### Top 10 Category 
    #### API - /cookings/topCookings - GET
    Return all information from the best 10 users
    
   ### Find By Id
    #### API - /cookings/{id} - GET
    Return a specific user by his id
    
   ### Create
    #### API - /cookings - POST
    JSON Expected
      { 
        name: "String",
        level: "Integer",
        xp: "Long"
      }
    Create a new user in category and return the user saved
    
   ### Update
    #### API - /cookings/{id} - PUT
    JSON Expected
      { 
        name: "String",
        level: "Integer",
        xp: "Long"
      }
    Update a specific user and return the user updated
    
   ### Delete
    #### API - /cookings/{id} - DELETE
    Delete a specific user and return true
   
   ### Find By Name
    #### API - /cookings/name/{name} - GET
    Return a specific user by his name
