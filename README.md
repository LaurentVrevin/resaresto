# ResaResto: REST API in Java with SpringBoot

ResaResto is a restaurant table reservation system designed to help restaurant employees manage reservations received over the phone. The system allows employees to log the number of people, date, and time, and add comments for special requests (e.g., dietary restrictions, baby, disabled access, etc.). Reservations can be modified or deleted, and users can view all reservations for the current day or week.

## Table of Contents
- [Technologies](#technologies)
- [Features](#features)
- [Installation](#installation)
- [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [Contributing](#contributing)
- [License](#license)

## Technologies

- **Backend**: Spring Boot, Java
- **Frontend**: Angular, Angular Material
- **Database**: H2 (in-memory for development)
- **Build Tool**: Gradle
- **IDE**: IntelliJ IDEA Community Edition

## Features

- Add, update, and delete reservations
- Add comments for special requests
- View all reservations for the current day or week
- Responsive UI using Angular Material

## Result
List of reservation and button to create
<br>
![Capture d’écran 2024-06-04 090334](https://github.com/LaurentVrevin/resaresto/assets/94620399/a33fb17a-d74e-4698-a3bf-31b375e154e9)

Form to create a reservation
<br>
![Capture d’écran 2024-06-04 090425](https://github.com/LaurentVrevin/resaresto/assets/94620399/3ff4ae80-8cf1-4f60-b74d-7c10db4dbcbe)


## Installation

### Prerequisites

- Java 17
- Node.js and npm
- Angular CLI
- Git

### Backend Setup
1. Clone the repository:

   ```sh
   git clone https://github.com/LaurentVrevin/resa-resto.git


2. Build and run the app for the backend:
   <br>
 ![run back end](https://github.com/LaurentVrevin/resaresto/assets/94620399/b4fcd92d-ddd4-4334-85c7-eb93e24158dd)

3. To run frontend:

   ```sh
   resaresto> cd frontend/frontend
   

4. Install dependencies and run:

   ```sh
   np install
   
   ng serve


The frontend server will start at http://localhost:4200.

# API Endpoints
* GET /api/reservations: Get all reservations
* POST /api/reservations: Create a new reservation
* PUT /api/reservations/{id}: Update a reservation
* DELETE /api/reservations/{id}: Delete a reservation
* GET /api/reservations/today: Get reservations for the current day
* GET /api/reservations/week: Get reservations for the current week



   
