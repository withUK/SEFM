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
