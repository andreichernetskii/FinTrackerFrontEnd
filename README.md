## Financial Tracker Web-Application (Frontend Side)

### The Genesis
This project emerged as a personal challenge for me to create a web application for tracking my financial transactions while living in a foreign country. The application serves as a practical test of my Java skills and demonstrates my ability to learn new concepts quickly and efficiently.

### Features
- Adding new transactions: incomes and expences (amount, date, category).
- Adding categories for expences or incomes (automaticly adds to Data Base while adding new transaction).
- Sorting exists transactions by year, month type (income or expence), category.
- Adding limits depend on timeline or timeline and category (for example day limit or day limit for groceries).
- Editing or deleting transactions and limits.
- When limit is expired, you will get a notiwication in field on right bottom.
- User registration, login and logout with using JSON Web Token (JWT) on backend side.

### UI
_Main page_

![main](https://github.com/andreichernetskii/FinMangerFrontEnd/assets/73879364/cc4091b5-25a6-499c-9340-eab7e64f5efe)

_Login page_

![login_page](https://github.com/andreichernetskii/FinMangerFrontEnd/assets/73879364/56d554d1-ca70-4596-93cb-78a4825421e6)

_Registration page_

![registration_page](https://github.com/andreichernetskii/FinMangerFrontEnd/assets/73879364/bc34290a-0635-4ff4-acde-6d54f1e7f112)

_Edit dialog_ 

![edit-dialog](https://github.com/andreichernetskii/FinMangerFrontEnd/assets/73879364/0cf6fa72-ccce-437c-9eeb-6aa88eed8d26)

### How it works
- Client adress - localhost:8081 .
- Client side of application conects to server side (localhost:8080) via RestTemplate object. 
