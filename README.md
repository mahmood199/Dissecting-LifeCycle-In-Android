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

Difference between add and replace transactions
https://stackoverflow.com/questions/18634207/difference-between-add-replace-and-addtobackstack 

## First fragment added without backstack. Second fragment added via replace method but without backstack
*Note -* See how onDestroyView(), onDestroy() and OnDetach() method of Fragment1 is also called. 
![image](https://user-images.githubusercontent.com/58071934/220916177-52d28a4b-e098-4b05-99b5-cbbf3e2343c3.png)



## First fragment added without backstack. Second fragment added via replace method with backstack
*Note -* See how onDestroyView() method of Fragment1 is also called. 
![image](https://user-images.githubusercontent.com/58071934/220919843-2fe334b3-5ab2-4456-9a8f-e64d542d02ea.png)

## When back button is pressed(just from above state)
![image](https://user-images.githubusercontent.com/58071934/220922418-4a80e973-a082-410d-a321-e7930d3bf602.png)

## 2 fragments(Fragment 1 and Fragment2) added without backstack. Third fragment added via replace method but without backstack
 Also Observe the LIFO order pausing of previously added fragments.
![image](https://user-images.githubusercontent.com/58071934/220982896-25fe598e-0ecc-4da3-ad14-0d28991cf01c.png)

## 2 fragments(Fragment 1 and Fragment2) added without backstack. Third fragment added via replace method with backstack
*Note -* See how onDestroyView() method of Fragment1 is also called. Also Observe the LIFO order pausing of previously added fragments.
![image](https://user-images.githubusercontent.com/58071934/220985419-4449a984-43db-49d4-b722-8655ce92e315.png)

## When back button is pressed(just from above state)
*Note -* Also Observe the FIFO order resuming of previously added fragments. understand that fragment 1 was added before fragment 2. and then replace with backstack with 3rd fragment and then back press on third fragment.
![image](https://user-images.githubusercontent.com/58071934/220987597-9bf11c44-09e5-4606-bcc0-336a3d4c10a6.png)


Very Very Important -
1) When there are multiple fragments added on a screen then if back is pressed
2) or the user returns to the screen from recents tab of device 
3) or if user goes to new activity 
4) or returns back from another activity ............. Then the fragment lifecycle will be  
Then the framgent lifecycle callback methods are called in FIFO order that the order in which they were added on screen.
Example - Fragment1 added , Fragment2 added, Fragment3 added  then their lifecycle methods will be called IN THAT ORDER.

Logs for point 1
![image](https://user-images.githubusercontent.com/58071934/220991618-b8b76a9c-58b5-48e5-b8fc-4e0a3c96fe66.png)

Logs for point 2
![image](https://user-images.githubusercontent.com/58071934/220991717-3aced5dd-ab4f-4d5a-b934-7bd95cbb2b25.png)

Logs for point 3
![image](https://user-images.githubusercontent.com/58071934/220991232-89e620bd-c8df-4411-9ada-e084c0d612e5.png)

Logs for point 4
![image](https://user-images.githubusercontent.com/58071934/220991507-c887c888-197e-46bb-a427-037969b28abf.png)




## 2 fragments(Fragment 1 and Fragment2) added with backstack. Third fragment added via replace method with or without backstack <--- both will produce same results
 Also Observe the LIFO order pausing of previously added fragments. And also that only the views were destroyed of previous fragments no fragments instance.
 pressing back button on third fragment will cause LIFO order callbacks for fragment 1 and 2
![image](https://user-images.githubusercontent.com/58071934/220996528-91c5ff70-7a13-4729-b5af-a09d10b00052.png)
















