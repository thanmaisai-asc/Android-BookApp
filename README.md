# My Books App

## Project Overview

This Android app fetches book data from the [Stephen King API](https://stephen-king-api.onrender.com/api/books), focusing on specific fields like Title, Publisher, ISBN, and Year. The data is stored in a local Room database and displayed in a RecyclerView using the MVVM architectural pattern.

## Technologies Used

- Android SDK
- JAVA | Kotlin
- Retrofit
- Room Database
- RecyclerView
- MVVM

## Project Structure

The project follows a standard MVVM architecture with the following package structure:

- `com.example.mybooksapp`
  - **Adapter**: Contains the `BookAdapter` for displaying book data in the RecyclerView.
  - **Dao**: Includes the `BookDao` interface for database operations.
  - **Database**: Defines the `BookDatabase` class for managing the Room database.
  - **Model**: Contains the `Book` data class representing a book entity with the following fields:
    - `id` (Int)
    - `Title` (String)
    - `Publisher` (String)
    - `ISBN` (String)
    - `Year` (String)
  - **Network**: Handles network requests using Retrofit with the Api interface (likely named `StephenKingApi` or similar).
  - **Repository**: The `BookRepository` class mediates data access between the network and database.
  - **ViewModel**: The `BookViewModel` exposes data to the UI and handles business logic.
  - **MainActivity**: The main activity of the app.

## API Integration

The app utilizes Retrofit to consume the Stephen King API, specifically targeting the fields mentioned in the `Book` data class. The fetched book data is parsed and mapped to `Book` objects for further processing.

## Room Database

A Room database is employed to store book data locally. Data Access Objects (DAOs) provide methods for inserting, querying, and updating book information based on the defined fields in the `Book` class.

# Architecture 
![](https://github.com/thanmaisai-asc/Android-BookApp/blob/master/Screenshot%202024-08-11%20003140.png)
*Working Architecture of the Application*

## Screenshots
![](https://github.com/thanmaisai-asc/Android-BookApp/blob/master/cat.log.png?raw=true)
*Fetching Data from API and displaying in cat log*

![](https://github.com/thanmaisai-asc/Android-BookApp/blob/master/output.png?raw=true)
*Displaying Books using RecyclerView*

