# Currency-Converter

This is a simple desktop application built using Java Swing for converting currencies based on real-time exchange rates. The application allows users to select two currencies, input an amount in the base currency, and then convert it to the target currency. The exchange rates are fetched dynamically using the ExchangeRate-API.

# Features

1. User-friendly Interface: The application features an intuitive GUI designed with Java Swing.
2. Real-time Conversion: Exchange rates are fetched in real-time from the ExchangeRate-API.
3. Wide Range of Currencies: Supports conversion between a large number of currencies from around the world.
4. Error Handling: Includes error handling for missing inputs or invalid selections.
5. Reset Functionality: Users can easily reset the selections and input fields.

# Prerequisites

Java: Ensure that you have Java Development Kit (JDK) installed on your machine.

# Usage

1. Launch the application, and you will see a graphical user interface.
2. Select the base currency from the "From" dropdown menu.
3. Select the target currency from the "To" dropdown menu.
4. Enter the amount you want to convert in the text field.
5. Click the Convert button to perform the conversion.
6. The converted amount will be displayed in the second text field.
7. You can reset the selections and input fields by clicking the Reset button.

# Configuration

API Key: The application uses the ExchangeRate-API for fetching real-time exchange rates. The API key is hardcoded in the application (API_KEY), but you can replace it with your own key by editing the CurrencyConverter class.

# Dependencies

Java Swing: Used for building the graphical user interface.
ExchangeRate-API: Used for fetching exchange rates.
