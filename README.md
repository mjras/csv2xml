cvs2xml
=======

converter for ADX input files

##Usage
###prepare the EXCEL file  using the template provided
- the title of the case goes on the top line
- the column heading "descriptor" goes above the column where the options are listed
- the other column headings can be edited to any kind of attribute name
- if you are working on several "cases" these should each have a separate sheet or separate file

##save each sheet as text csv format
- no text delimiter
- ; as field delimiter

###run the program using command line with the following command
- java -jar csv2xml.jar myfile1.csv
- include as many arguments as files you wish to convert
- rename the xml files
