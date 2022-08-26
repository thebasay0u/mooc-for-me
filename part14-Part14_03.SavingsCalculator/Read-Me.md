# SavingsCalculatorApplication.java 

# Using the observer pattern 

# Class responsibilities: 
    
1. **SavingsCalculatorApplication** --> extends Application and serves as the launchpad for the app (has references to other classes)

2. **NumberCruncher** --> helper class for calculating values added as data points to LineChart (might refactor different class)



3. **SavingsAmount** --> implements ChangeListener<Number>
    * waits for savings slider changes 

