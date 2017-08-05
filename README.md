# LoansAggregator
*Goal of project*  
This project is used to calculate the aggregate loans by the tuple of (Network, Product, Month) from a CSV file input 
and writes the resulting aggregation to a CSV.

*Assumptions*  
1.CSV input wil always be in the same format of MSISDN,Network,Date,Product,Amount.  
2.Formating of the output csv might change in the future.  
3.Inputs and outputs could be swapped out in the future to read or write to or rom a stream or something similar.  
4.Output file should not be overwritten if it exists.  
5.Filepaths and filenames of input and output could change in the future.  

*Motivation for use of language, plugins and 3rd party libraries*  
I used java because it is widely known and I have experience in coding it.  
The libraries and plugins I used is mainly for unit testing to help in making changing the code easier.  

*Getting started*  
Open the CreateValidationCSV.java.   
Set the file path of the input csv in the createCSVReader method.  
Set the file path of the output csv in the createCSVWriter method.  
Compile the code.  
Run CreateValidationCSV.




