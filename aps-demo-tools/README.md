# Version
This has been verified against Alfresco Process Services 1.6.3

# Purpose
An Alfresco Consulting component created for the APS Group workshop

APS Artifacts 

- Sample REST Call

Demos the use of a REST task including consuming JSON on the response.  An endpoint needs to be 	defined for this process to work.  A screen shot of this is in the src/main/app folder. 
- Example Process Wait 

This process simulates the method for waiting for communication from an external system.  It uses 	the MessageToos calls to output the execution information for those items waiting for an incoming 	message. I've exported the Postman call I used to simpulate an external system in the src/main/app 	folder.
- Sample ACS Interaction
	
This process would be triggered by a folder rule illustrated by a screen shot in the src/main/acs 	folder.  It will then update the title of the document based on the text entered on the form. 	  
	
