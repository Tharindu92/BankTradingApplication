# Signal Two Handler

This Service is to Handle  signals 2 provided by third parties.

Entry point of the service is a REST Controller. 

Once the endpoint is invoked by the request, request will  go to Controller.

Controller will invoke the service layer

Service layer will call the algo library

This service contain following parts

* SignalHandleController
  
* SignalHandlerService
  

