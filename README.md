# multipage-form-app
Made as an exercise to learn about data binding and ViewModels, but you can use it however you wish.

An application to recieve user text input across multiple fragments using the navigation buttons onClick listeners. A ViewModel is used to store the text data and retrieve it.
If the user navigates back and forth, the edittext will automatically be set to the users past input which is stored in the ViewModel.
In the final fragment, data is retrieved from the ViewModel via the onClick method. 
This application simply displays a toast message with the users input data, however you can use the getAnswer*number*() methods from the ViewModel to store the inidividual answers to a DB!
