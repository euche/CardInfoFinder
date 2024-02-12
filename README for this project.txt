 My Approach for this Card Info Finder is to create a textfield in which the user types in their cardnumber and the app returns a dialog that displays the:

 1=> Card brand
 2=> Card type
 3=> Bank
 4=> Country

or an Error message in the course of Usage.

I used clean architecture which comprises of Domain(which contains the business data or logic), presentation(Views for the user) and service(layer which interacts with the web API server).

There is also a Utility part of the project which holds classes used through the project(Class to check Network connection on the device and Dialogmessage for responses).

There are UI Tests and Unit Tests written to test some features implemented in the com.example.cardinfofinder test folders.

There is an Android APK in the Debug folder called app-debug. To test the app, it is copied into an android phone via USB and select to run.


