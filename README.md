## Financial Tracker Web-Application (Client Side)
> [!IMPORTANT]
> [Website for testing](http://23.94.117.251:8081)

> [!IMPORTANT]
> Current Enhancements:
> - Expanding test coverage with JUnit and Mockito.
> - Initiating migration to microservices architecture to enhance scalability and modularity.
> - Implementing Kafka for asynchronous messaging and event-driven communication between microservices.


Backend side: https://github.com/andreichernetskii/FinManagerBackEnd

### The Genesis
This project emerged as a personal challenge for me to create a web application for tracking my financial transactions while living in a foreign country. The application serves as a practical test of my Java skills and demonstrates my ability to learn new concepts quickly and efficiently.

### Features
- **Adding New Transactions**: Incomes and expenses can be added with details such as amount, date, and category.
- **Category Management**: Automatic addition of categories for expenses or incomes to the database when adding a new transaction.
- **Sorting Transactions**: Existing transactions can be sorted by year, month, and type (income or expense), as well as by category.
- **Setting Limits**: Users can set limits based on the timeline or both timeline and category (e.g., daily limit or daily limit for groceries).
- **Transaction Management**: Users can edit or delete transactions and limits as needed.
- **Limit Notifications**: Receive notifications in the bottom right corner when a limit expires.
- **User Authentication**: The application provides user registration, login, and logout functionality using JSON Web Token (JWT) on the backend.e.

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
Now the project works with Docker Compose. To run the project, simply grab the docker-compose.yml file from the project's backend repository and execute `docker-compose up`.

Backend side: https://github.com/andreichernetskii/FinManagerBackEnd
 
