Dynamic Framework 
This is repository of Dynamic Framework API testing framework.
The public API used for this example is - https://reqres.in.
This framework is developed using Rest-Assured library for Rest API testing For JSON Parsing. 
This project is capable to automate execution and validation:
	a) Rest: POST, PUT, PATCH and GET.
This project is built on the concepts of data driven and keyword driven.
I have divided the project into 4 packages
	a) Request Repository 
	b) Common Method
	c) Test Classes
	d) Driver Package
The test execution is driven by Dynamic Classes.
User can also construct the request body using parameters fed from an excelFile.I have created a utility using ApachePOI to read data from excel.
The project is capable of saving the evidences of the execution into text files which contains details of request sent, endpoint and response received
