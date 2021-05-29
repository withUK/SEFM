# Software Engineering for Mobile


## First todo app
## Notes
Notes for key 

### MVC
#### Model

#### Controller

#### View


### Manifest


### Activity


### onCreate


### View Objects


### lifecycle


### Listeners


### Anonymous functions


### event handlers


### callbacks


### Bundle


### Resources


## Walk Through
Manifest defines the main activity which has an onCreate callback method
/* call the super class onCreate to complete the creation
of activity with state changes */
`super.onCreate(savedInstanceState);`

/* set the user interface layout for this Activity */
`setContentView(R.layout.activity_todo);`

Questions at this point in the walk-through the code:
- What is R?
- What is savedInstanceState and Bundle?
- What format is the content of activity_todo?
- What attribute defines the view object id?
- Next step is an event and a similar walk-through the event handler
- Complete the walk-through; use breakpoints and comment your code

## Todo detail app
## Notes
Notes for key 

### Intent


### Extra


### Communicating between activities


### Static method


## Walk Through
Manifest defines the main activity which has an onCreate callback method
etc. until detail click event.
Anonymous detail onCick event handler

```
buttonTodoDetail.setOnClickListener(new View.OnClickListener(){
   @Override
   public void onClick(View v) {
      /* Note, the child class being called has a static method 
         determining the parameter to be passed to it in the intent 
         object */
      Intent intent = TodoDetailActivity.newIntent(
         TodoActivity.this, mTodoIndex);

      /* second param requestCode identifies the call as there 
         could be many "intents" */
      startActivityForResult(intent, IS_SUCCESS);
      /* The result will come back through */
      onActivityResult(requestCode, resultCode, Intent) method */

   }
});
```

Questions at this point in the walk-through the code:
- What is a static method? and why use it here?
- What is in newIntent?
- Where is the todo index stored?
- …

Next explanation could be an event and a similar walk-through the event handler in the detail view checkbox for completed todos
Complete the walk-through; use breakpoints and comment your code
Add a new use case to indicate a pending incomplete todo (similar to checkbox for completed todo)
Explain `onActivityResult`