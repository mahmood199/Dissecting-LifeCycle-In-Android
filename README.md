# Dissecting-LifeCycle-In-Android
A repository dedicated to logging and understanding the lifecycle of activities, fragments and both of them combined. This can be referred for revision purpose before interviews. README contains good QnA for interviews

## Lifecycle callbacks of activities when launching new activity from another
![image](https://user-images.githubusercontent.com/58071934/219962533-cfa0c6e2-0859-4372-80cb-a3f21b17fe11.png)

## and when back button is pressed from new activity
![image](https://user-images.githubusercontent.com/58071934/219965981-9cbf5985-b729-412e-98e2-4739e96986a8.png)


## Lifecycle callbacks of activity when screen is rotated
![image](https://user-images.githubusercontent.com/58071934/219963005-cb98f4ad-e578-41f6-af5f-9676bbde8e96.png)

## When device home button is pressed
![image](https://user-images.githubusercontent.com/58071934/219965709-28e9a0de-3daf-4a04-afa7-1c1ee6adaf1c.png)

## When User returns back to app from recents tab
![image](https://user-images.githubusercontent.com/58071934/219965767-d4ae152a-57ad-4180-8807-e575f71874b3.png)



# Fragments

## When fragment is added due to any action 
Context value is the activity object context which is printed in onAttach
![image](https://user-images.githubusercontent.com/58071934/220451373-6332327f-154b-4d5a-bf98-a208cdb7245d.png)

## When more fragments are added on top of existing fragment.
### Note how the lifecycle of previously added fragment is not affected when new fragments are *ADDED*
![image](https://user-images.githubusercontent.com/58071934/220456137-83f73f44-f936-4e21-8398-4a21e98cd68b.png)

## User navigating away from screen which contained fragment and then returning back (Single Fragment) (With or without backstack same result)
![image](https://user-images.githubusercontent.com/58071934/220458472-afced65f-74b4-408b-ae22-ebc570272cde.png)

## User navigating away from screen which contained fragment and then returning back (Mutiple Fragment) (With or without backstack same result)
![image](https://user-images.githubusercontent.com/58071934/220461834-637a42f7-0c05-4283-b73b-7ed3f9daad56.png)

## Fragment popped from backstack
![image](https://user-images.githubusercontent.com/58071934/220466777-46795670-116c-4997-a877-f8178c79a63e.png)



