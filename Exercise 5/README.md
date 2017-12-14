GitHub Visualisation Assignment

The following folder contains all of the files relevent to the final two assignments in CS3012:

1) Interrogate the GitHub API to retrieve and display data regarding the logged in developer.
2) Interrogate the GitHub API to build visualisation of data available tht elucidates some aspect of the softare engineering      process, such as a social graph of developers and projects, or a visualisation of indiviudal of team performance. Provide a visualisation of this using the d3js library.

This assignment maps the connections within my own personal network to two degrees of seperation. The data collected as part of this assignment as such stems from the root user 'oboyle-mikey'. 

For part 1 of the assignment I used Python and the PyGithub package to collect basic levels of information and assert my ability to access information through the GitHub REST API. These files are laid out in the folder labeled 'Basic Access'. From accessing this information I was able to gain an understanding as to the entities and fields contained in Github data.

For part 2 of the assignment I set out to visualise and map the connections within my own personal network to two degrees of seperation. Files for this part of the assignment are in the 'Access and Processing' folder.  In terms of visualising this type of network data it became apparent that there would be two possible avenues to persue. 
 - A linear linking network that would map my network directionally, visualised in a dendogram.  
 - A dynamic linking network that would map my network complexly, visulised in a hierarchical edge cluster.

 Step 1: Data Preperation
 - Files for this part of the assignment are in the 'Access and Processing' folder. These files outline the process by which data was collected and processed. The folder also contains the data files that accrued from the scripts. 
 
 Step 2: Data Visualisation
 - Files for this part of the assignment re in the 'd3_Files' area. These files outline the visualisation scripts and techniques used to display the data in the d3 enviornment. 
 
 The resulting graphics are available on my macneill server at:
 - http://macneill.scss.tcd.ie/~oboylemi
