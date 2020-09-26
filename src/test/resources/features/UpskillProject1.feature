@signUp
Feature: Test Upskills My organisation 
This Feature contains Sign up of a user and verify the User name on successfull signup
1.I navigate to the application 
2.I click on sign UP
3.I Click on teach courses
4.I enter first name
5.I enter Last name and email id
6.I enter unique  username
7.I enter password and I enter confirmpassword
8.I enter phone number
9.I select Language
10.I enter Code
11.I enter skpe
12.I enter linkdin profile Url
13.I clicked on Register
14.I Verify that the user is registered successully 
15.I Verify that mail id is same in user dropdown
16.I Click on Home page
17 I Click on Compose
18.I Write a mail and send it to User 2
19.I verify that the message is sent "The message has been sent to 'Username'"

Background: 


Scenario Outline:
Given I navigate to the application in browser "<browser>"
When I click on sign UP
And I Fill the registration form and click on register "<firstName>","<lastName>","<email>","<username>","<password>","<confirmPass>","<phone>","<code>","<skype>","<linkdin>"
Then I Verify user is registered successully 
And I verify user's mail ID "<confirmEmail>"
Then I Click on Home page
And I Compose mail and send to one user "<toSend>"
Then I verify sent message 


Examples:
|browser|firstName|lastName|email           |username  |password    |confirmPass|phone     |code    |skype          |linkdin             |confirmEmail    |toSend  |
|chrome |Linda    |Anderson|linda@gmail.com |Krishna22|Linda!@#123 |Linda!@#123|0987654321|Upskills|Linda@skype.in |Linda@linkdin.co.in |linda@gmail.com |naveen1 |
|firefox|Andrew   |Symond  |symond@gmail.com|Radha22|Andrew@#123 |Andrew@#123|0987654321|Upskills|Andrew@skype.in|Andrew@linkdin.co.in|symond@gmail.com|naveen1 |




 

