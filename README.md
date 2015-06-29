# Common
Contains reusable platform independant code for all SwiftSMS client applications (hopefully).

##  Warning
This project is still very much a WIP.  Because of this, you shouldn't depend on stability within this project.  It may go through large changes.

## Background
The code here is based off the original Android client but it needed to be slightly modified to remove references to Android code.

The intention here is to provide a single place where the operator specific logic needed to send webtexts is stored.  This can then be reused by any other client, i.e. desktop client or Android client.  I plan to start by using this library from a desktop client, once I get it working I will then replace the Android code with a dependency on this library too.

## How to contribute
It's a simple Maven Java project, import the project into your favourite IDE and start working.

For Eclipse,
* File > Import
* Maven > Existing Maven Projects
* Browse to where you cloned the repo and import the project.
