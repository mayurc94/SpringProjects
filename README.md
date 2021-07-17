# SpringProjects

Hi, this is a simple spring boot project to display covid19 daily cases and Vaccine data in india using httpClient and thymeleaf to render the data on the browser.

This project not only fetches the covid cases in india but also from around the world.

Sources used to fetch the data
Covid data worldwide-> https://github.com/CSSEGISandData/COVID-19

Covid data specific to India -> https://github.com/covid19india/api

URL to display data on browser->
Data worldwide-http://localhost:8080/home,
Date India-http://localhost:8080/india

I have shown how to process two types of data,
-For Worldwide, the data is received in the CSV format.
-For India, the data received in Json format.


In this project I have also tried to fetch data regarding Vaccine availability.For now you can fetch the vaccine availability data by Pincode and Date.

For vaccination data there is no view. You can use an API client like Postman/Insomnia to view the data.

Url to find vaccination data by pincode -> http://localhost:8080/findByPin

Vaccination data source-
https://apisetu.gov.in/public/api/cowin

Please feel free to add more to it.

