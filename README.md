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


## Task Modes in Android
1. standard  --|--
2. singleTop --|--
3. singleTask --||--
4. singleInstance --||--
5. singleInstancePerTask --||--

## 1. standard
- Creates and launches new instance of the activity every time.

## 2. singleTop
- If an instance of the activity already exists at the top of the current task and the system routes the intent to this activity, no new instance will be created because it will fire off an onNewIntent() method instead of creating a new object. If there is no instance of this at the top then it relaunches the activity.

TaskAffinity - Preference of the activity regarding with which task it will associate itself. Basically the task in which they will be launched. By default all activities have the same affinity. Hence they belong to the same task. This affinity is package affinity, basically package name.
To change taskAffinity for an activity we specify the android:taskAffinity="some random name". 
This enables us to switch between different tasks of the same application from recents tab of device.

## 3. singleTask
1. with taskAffinity - if we launch our activity with a task affinity then it will open up in new task. Any activity launched by this activity will be kept in its task as it shares the affinity of the root activity ![image](https://github.com/mahmood199/Dissecting-LifeCycle-In-Android/assets/58071934/e18fd105-7017-4907-90b4-a8849f53b6c9)
In a nutshell, it means that
singleTask activity will always be at the root of task.
there will be only one instance of activity across tasks.
Also in the recents tab, we will see 2 tasks of same application.

2. without taskAffinity - if there is no instance of activity in the task then a new instance is created and launched. But if its there then it will simply intercept the intent via onNewIntentn() method.
If there are some actvities stacked on top of singleTask activity and it is launched again then all above activities gets popped off the task. Also if there's no affinity then it isn't necessary that it will be present at the root of the task

## 4. singleInstance
1. with taskAffinity - new activity is launched in a new task. if new activities are launched from this activity then those activities will be launched in original task. Also this activity will be the only activity instance in the new task
Also in the recents tab, we will see 2 tasks of same application.

2. without taskAffinity - new activity is launched in a new task. if new activities are launched from this activity then those activities will be launched in original task. Also this activity will be the only activity instance in the new task. Also in the recents tab, we will see only 1 task of same application.


## Fragment Transaction actions
Intro - Committing fragment transaction via commit() after onSaveInstanceState() will throw IllegalStateException.

#### commit() -
Asynchronous
Schedules a commit of this transaction. The commit does not happen immediately; it will be scheduled as work on the main thread to be done the next time that thread is ready.
A transaction can only be committed with this method prior to its containing activity saving its state. If the commit is attempted after that point, an exception will be thrown. This is because the state after the commit can be lost if the activity needs to be restored from its state. 

#### commitNow()
Synchronous
cant add fragment to backstack with this method. However it immediately schedules the work by placing it at the front of the queue. 
Transactions committed in this way may not be added to the FragmentManager's back stack,as doing so would break other expected ordering guarantees for other asynchronously committed transactions.
cant add fragment to backstack with this method. However it immediately schedules the work by placing it at the front of the queue. 

#### commitAllowingStateLoss()
Asynchronous
Schedules a commit of this transaction. The commit does not happen immediately; it will be scheduled as work on the main thread to be done the next time that thread is ready.
A transaction can be committed with this method after its containing activity saving its state. If the commit is attempted after that point it wont be saved to fragment manager so state would be lost. So whether it is adding/removing/replacing fragment it wont happen take place.

#### commitNowAllowingStateLoss()
Synchronous
Like commitNow but allows the commit to be executed after an activity's state is saved. Remaining is similar to commitAllowinfStateLoss()


### Difference between commitNow() vs commit() followed by executePendingTransactions()
Calling commitNow is preferable to calling commit() followed by FragmentManager.executePendingTransactions() as the latter will have the side effect of attempting to commit all currently pending transactions


# Fragments

Note - Create new fragment transaction every time before adding/replacing fragment otherwise while committing on an already committed transaction will throw `commint Already called on transaction exception`. This is because each transaction can be committed only once

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
1) When there are multiple fragments added on a screen then if device home button is pressed
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

## Back pressed from above state
![image](https://user-images.githubusercontent.com/58071934/220999452-24ad92a4-3a36-460b-ab6f-569e58e1275e.png)


## Going to new activity from above state
![image](https://user-images.githubusercontent.com/58071934/221000417-e9e83eda-86a0-4a02-bf7a-d77f974d087d.png)



## 2 fragments (Fragment1 and Fragment2) Added without backstack and another fragment (Fragment3) is added with backstack. Then Fragment1 is added via replace without backstack. So the previously added fragments which didn't add up to backstack just got completely destroyed(view and fragment instance both + detach). And only the vide of fragment 3 is destroyed and fragment1 is brought to the screen. 
*Note -* Notice the LIFO order is still maintained while replacing existing fragments with new one.
![image](https://user-images.githubusercontent.com/58071934/221019813-9b35db7a-915d-4f14-87b6-e558e435bcc8.png)

## Same as above but 1 fragment(Fragment1) was Added without backstack and another 2 fragments (Fragment2 and Fragment3) are added with backstack.
*Note -* Notice the LIFO order is still maintained while replacing existing fragments with new one.
![image](https://user-images.githubusercontent.com/58071934/221024540-a168f557-bd55-4e47-b248-851952ced439.png)


## Fragment1 and Fragment2 added with backstack and Fragment3 added without backstack. And replaced by fragment 1 without backstack
*Note -* Notice the LIFO order is still maintained while replacing existing fragments with new one.
![image](https://user-images.githubusercontent.com/58071934/221026429-dfa10119-ec3f-46f7-8f50-9a22a50ff6df.png)

## Fragment1 added with backstack then Fragment2 and Fragment3  added without backstack. And replaced by fragment 1 without backstack
*Note -* Notice the LIFO order is still maintained while replacing existing fragments with new one.
![image](https://user-images.githubusercontent.com/58071934/221028870-24cad06a-ed39-4f58-9226-2ed0267c71ad.png)

## When calling replace with backstack. No fragments will be destroyed completely irrespective of whether they were added with or without back stack. Only their view will be destroyed on replacing with new fragment.
*Note -* Notice the LIFO order is still maintained while replacing existing fragments with new one.
![image](https://user-images.githubusercontent.com/58071934/221030996-93221dcd-013b-449b-9bf2-01f689834077.png)

