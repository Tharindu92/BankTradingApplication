# Bank Trading Application

## Drawbacks in the originally given solution

* When the no of Signals increases the size of the switch case increases. This decreases the readability.
* This also cause a Single point of failure as the solution is a monolithic deployment
* If there are50 changes in a month, the number of deployments will be increased and since solution is monolithic there will be continuous downtimes

## High Level Solution Architecture Design

![Screenshot](Trading%20Application%20Flow.jpeg)

## Design Decisions

* Based on the Signal , we modularized the solution where Signal 1 will be deployed as a separate service while Signal N will be deployed as a separate service. 
  This will remove the Single point of Failure issue whenever there is an issue with a Signal, 
  only service with the issue will be down while rest of the services are still up and running 
* Deploying the modules as microservices to reduce the tight coupling by practising SOLID principles
* A modularized solution is designed where the proposed solution has multiple services. 
  There is a core module which contain all the common classes, util classes and model classes, Separate module for each Signal, Application module which act as a Gateway between Third parties and Signals
* Every Signal microservice is exposed as a REST API so that it is easily reachable
* Endpoint urls of the Signals are stored currently within an internal cache system (Map). And this is also deployed as separate module so that in future cache handling can be refactored easily.
  Caching is introduced in order to make the System robust so that it doesn't have to always handle I/O operations with the database
* For Signals, we are using Factory pattern. This was decided as the number of new Signals grows, this will help to do the changes easily. This reduces the tight coupling of the system
* For Algo module Factory pattern is used as in future Algo team may use different types of Algorithms.
* Reflection is used in order to instantiate the Signal classes. This is decided to reduce the number of If conditions within the Factory class of the Factory pattern
* If the system which sends the Signal changes their implementation, then only the Gateway implementation needs to be changes.
* If there will be a new Signal, then we need to change the core module to create the Signal model class and a new microservice for the Signal. 
  Also we will need to add the new endpoint url to the cache/database. While doing these changes, none will affect the up and running services. 
  Furthermore services need not to face any downtime when adding the new URL endpoint to database there need not be any downtime for the other services.
* If the TPS for a specific Signal is increasing over time number of nodes/pods of that specific microservice can be increased as the solution is deployed as modules rather than a monolithic one.
* When an unidentified Signal is passed ,we are routing to an endpoint to which invalidate the request and cancel the Trade.


## Future Improvements

* Current solution can be designed for an event driven solution where we can use our Gateway and a messaging queue like Kafka
* Endpoint url storage should be changed into a data storage and system's cache should be consumed properly inorder to reduce unnecessary I/O operations to the database.
* Solution should be deployed either in Cloud or in a clustered environment in order to avoid Single point of Failure and to handle High traffic.






  

