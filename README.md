# SEFM
Leeds Beckett University module for Software Engineering for Mobile.

The path for lab exercises follows the android code labs found on https://developer.android.com/
### Android fundamentals 01.2 Part A: Your first interactive UI
- Task 1: Create and explore a new project <br>
Held on branch : <span style="color:blue">Task-1-Create-and-explore-a-new-project</span>
- Task 2: Add View elements in the layout editor <br>
Held on branch : Task-2-Add-View-elements-in-the-layout-editor
- Task 3: Change UI element attributes <br>
Held on branch : Task-3-Change-UI-element-attributes
- Task 4: Add a TextEdit and set its attributes <br>
Held on branch : Task-4-Add-a-TextEdit-and-set-its-attributes
- Task 5: Edit the layout in XML <br>
Held on branch : Task-5-Edit-the-layout-in-XML
- Task 6: Add onClick handlers for the buttons <br>
Held on branch : Task-6-Add-onClick-handlers-for-the-buttons <br>
Additional learning to add extra button to reduce count held on : Task-6a-Add-new-button-and-onClick-handlers
- Coding challenge <br>
Held on branch : Your-first-interactive-UI-Coding-challenge

### Android fundamentals 01.2 Part B:The layout editor
- Task 1: Create layout variants <br>
Held on branch : <span style="color:blue">Task-1-Create-layout-variants</span>
- Coding Challenge 1 <br>
Held on branch : <span style="color:blue">The-layout-editor-Coding-challenge-1</span>
- Task 2: Change the layout to LinearLayout <br>
Held on branch : <span style="color:blue">Task-2-Change-the-layout-to-LinearLayout</span>
- Task 3: Change the layout to RelativeLayout <br>
Held on branch : <span style="color:blue">Task-3-Change-the-layout-to-RelativeLayout</span>

### Related concepts
Further information around layouts for UI are found within the Android fundamentals [documentation](https://google-developer-training.github.io/android-developer-fundamentals-course-concepts-v2/unit-1-get-started/lesson-1-build-your-first-app/1-2-c-layouts-and-resources-for-the-ui/1-2-c-layouts-and-resources-for-the-ui.html)

### Further learning
Further learning resouces for [android development](https://google-developer-training.github.io/android-developer-fundamentals-course-concepts-v2/unit-1-get-started/lesson-1-build-your-first-app/1-2-c-layouts-and-resources-for-the-ui/1-2-c-layouts-and-resources-for-the-ui.html)

### TO DO : Homework
> Change the app
<br>
> Answer these questions
<br>

#### Question 1
Which two layout constraint attributes on the Zero Button position it vertically equal distance between the other two Button elements? (Pick 2 answers.)
- `app:layout_constraintBottom_toTopOf="@+id/button_count"`
- `android:layout_marginBottom="8dp"`
- `android:layout_marginStart="16dp"`
- `app:layout_constraintTop_toBottomOf="@+id/button_toast"`
- `android:layout_marginTop="8dp"`

#### Question 2
Which layout constraint attribute on the Zero Button positions it horizontally in alignment with the other two Button elements?
- `app:layout_constraintLeft_toLeftOf="parent"`
- `app:layout_constraintBottom_toTopOf="@+id/button_count"`
- `android:layout_marginBottom="8dp"`
- `app:layout_constraintTop_toBottomOf="@+id/button_toast"`

#### Question 3
What is the correct signature for a method used with the android:onClick XML attribute?
- `public void callMethod()`
- `public void callMethod(View view)`
- `private void callMethod(View view)`
- `public boolean callMethod(View view)`

#### Question 4
The click handler for the Count Button starts with the following method signature: <br>
`public void countUp(View view)` <br>

Which of the following techniques is more efficient to use within this handler to change the Button element's background color? Choose one:
- Use findViewById to find the Count Button. Assign the result to a View variable, and then use setBackgroundColor().
- Use the view parameter that is passed to the click handler with setBackgroundColor(): view.setBackgroundColor()

### Android fundamentals 01.3: Text and scrolling views
- Task 1: Add and edit TextView elements <br>
Held on branch : <span style="color:blue">Task-1-Add-and-edit-TextView-elements</span>
- Task 2: Add a ScrollView and an active web link <br>
Held on branch : <span style="color:blue">Task-2-Add-a-ScrollView-and-an-active-web-link</span>
- Coding challenge <br>
Held on branch : <span style="color:blue">Coding-challenge</span>

### Related concepts
Further information around text and scrolling views are found within the Android fundamentals [documentation](https://google-developer-training.github.io/android-developer-fundamentals-course-concepts-v2/unit-1-get-started/lesson-1-build-your-first-app/1-3-c-text-and-scrolling-views/1-3-c-text-and-scrolling-views.html)

### Further learning
Further learning resouces for [android development](https://developer.android.com/codelabs/android-training-text-and-scrolling-views#9)

### TO DO : Homework
> Change the app
<br>
> Answer these questions
<br>

#### Question 1
How many views can you use within a ScrollView? Choose one:
- `One view only`
- `One view or one view group`
- `As many as you need`

#### Question 2
Which XML attribute do you use in a LinearLayout to show views side by side? Choose one:
- `android:orientation="horizontal"`
- `android:orientation="vertical"`
- `android:layout_width="wrap_content"`

#### Question 3
Which XML attribute do you use to define the width of the LinearLayout inside the scrolling view? Choose one:
- `android:layout_width="wrap_content"`
- `android:layout_width="match_parent"`
- `android:layout_width="200dp"`

### Android fundamentals 02.1: Activities and intents
- Task 1: Create the TwoActivities project
Held on branch : <span style="color:blue">Task-1-Create-the-TwoActivities-project</span>
- Task 2: Create and launch the second Activity
Held on branch : <span style="color:blue">Task-2-Create-and-launch-the-second-Activity</span>
- Task 3: Send data from the main Activity to the second Activity
Held on branch : <span style="color:blue">Task-3-Send-data-from-the-main-Activity-to-the-second-Activity</span>
- Task 4: Return data back to the main Activity
Held on branch : <span style="color:blue">Task-4-Return-data-back-to-the-main-Activity</span>
- Coding challenge
Held on branch : <span style="color:blue">Activities-and-Intents-Coding-Challenge</span>

### Related concepts
Further information around text and scrolling views are found within the Android fundamentals [documentation](https://google-developer-training.github.io/android-developer-fundamentals-course-concepts-v2/unit-1-get-started/lesson-2-activities-and-intents/2-1-c-activities-and-intents/2-1-c-activities-and-intents.html)

### Further learning
Further learning resouces for [android development](https://developer.android.com/codelabs/android-training-create-an-activity#10)

### TO DO : Homework
> Answer these questions
#### Question 1
What changes are made when you add a second Activity to your app by choosing File > New > Activity and an Activity template? Choose one:
- The second Activity is added as a Java class. You still need to add the XML layout file.
- The second Activity XML layout file is created and a Java class added. You still need to define the class signature.
- The second Activity is added as a Java class, the XML layout file is created, and the AndroidManifest.xml file is changed to declare a second Activity.
- The second Activity XML layout file is created, and the AndroidManifest.xml file is changed to declare a second Activity.

#### Question 2
What happens if you remove the android:parentActivityName and the <meta-data> elements from the second Activity declaration in the AndroidManifest.xml file? Choose one:
- The second Activity no longer appears when you try to start it with an explicit Intent.
- The second Activity XML layout file is deleted.
- The Back button no longer works in the second Activity to send the user back to the main Activity.
- The Up button in the app bar no longer appears in the second Activity to send the user back to the parent Activity.

#### Question 3
Which constructor method do you use to create a new explicit Intent? Choose one:
- `new Intent()`
- `new Intent(Context context, Class<?> class)`
- `new Intent(String action, Uri uri)`
- `new Intent(String action)`

#### Question 4
In the HelloToast app homework, how do you add the current value of the count to the Intent? Choose one:
- As the Intent data
- As the Intent TEXT_REQUEST
- As an Intent action
- As an Intent extra

#### Question 5
In the HelloToast app homework, how do you display the current count in the second "Hello" Activity? Choose one:
- Get the Intent that the Activity was launched with.
- Get the current count value out of the Intent.
- Update the TextView for the count.
- All of the above.
