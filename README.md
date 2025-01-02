# Array Searches and Sorts

## Overview
The **Array Searches and Sorts** project demonstrates:
- Parsing and processing data from a CSV file.
- Sorting and searching algorithms (Insertion Sort, Selection Sort, Bubble Sort, and Binary Search).
- Computing statistical measures like Case Fatality Rate (CFR), GDP per capita, and population density.
- Calculating Kendall's Tau Correlation matrix to evaluate relationships between different country attributes.

This project processes data for 145 countries and regions, performing analysis and reporting based on user-defined criteria.

## Objectives
- Parse a CSV file containing country data (`Countries1.csv`) into an array of `Country` objects.
- Implement and demonstrate sorting algorithms (Insertion Sort, Selection Sort, Bubble Sort).
- Search for specific countries using Binary Search or Sequential Search.
- Compute statistical relationships between attributes using Kendall's Tau Correlation.
- Display formatted reports and allow user interaction via a menu system.

## Features
1. **Country Class**:
   - Fields: `name`, `capital`, `population`, `GDP`, `COVID cases`, `COVID deaths`, and `area`.
   - Methods:
     - Getters and setters for all fields.
     - Constructor for initialization.
     - Method to print a `Country` object in a formatted style.

2. **Sorting Algorithms**:
   - **Insertion Sort**: Sorts countries alphabetically by name.
   - **Selection Sort**: Sorts countries by Case Fatality Rate (CFR).
   - **Bubble Sort**: Sorts countries by GDP per capita.

3. **Search Algorithms**:
   - **Binary Search**: Finds a country by name if the data is sorted by name.
   - **Sequential Search**: Finds a country by name if the data is unsorted.

4. **Statistical Calculations**:
   - Case Rate: Number of COVID cases per 100,000 people.
   - Death Rate: Number of COVID deaths per 100,000 people.
   - Population Density: Population per square kilometer.
   - Kendall's Tau Correlation: Calculates correlations between rankings (e.g., Case Rate vs GDP per capita).

5. **User Interaction**:
   - Menu-driven interface with the following options:
     1. Print a report of all countries.
     2. Sort by name (Insertion Sort).
     3. Sort by CFR (Selection Sort).
     4. Sort by GDP per capita (Bubble Sort).
     5. Find a country by name.
     6. Print Kendall's Tau Correlation matrix.
     7. Quit the program.

## Requirements
- **Java Development Kit (JDK) 8 or higher**
- Input File: `Countries1.csv` (containing country data)
- Output:
  - Reports of countries and computed statistics.
  - Kendall's Tau Correlation matrix.

## Implementation Details
### CSV Parsing:
1. Prompts the user to input the name of the CSV file (e.g., `Countries1.csv`).
2. Parses the file to create an array of `Country` objects.
3. Does not modify the input CSV file.

### Sorting Algorithms:
1. **Insertion Sort**:
   - Sorts countries alphabetically by name.
2. **Selection Sort**:
   - Sorts countries by Case Fatality Rate (CFR) in ascending order.
3. **Bubble Sort**:
   - Sorts countries by GDP per capita in ascending order.

### Search Algorithms:
1. **Binary Search**:
   - Finds a country by name if the data is sorted alphabetically.
2. **Sequential Search**:
   - Finds a country by name if the data is not sorted.

### Kendall's Tau Correlation:
1. Computes correlation coefficients for:
   - Case Rate vs GDP per capita.
   - Case Rate vs Population Density.
   - Death Rate vs GDP per capita.
   - Death Rate vs Population Density.
2. Outputs results in a matrix format.

### User Menu:
- Provides the following options:
  1. Print a formatted country report.
  2. Sort data alphabetically by name (Insertion Sort).
  3. Sort data by CFR (Selection Sort).
  4. Sort data by GDP per capita (Bubble Sort).
  5. Search for a country by name.
  6. Print Kendall's Tau Correlation matrix.
  7. Quit.

### Report Formatting:
- Example Country Report (Option 1):
  ```plaintext
  Name: Brazil
  Capital: Brasília
  GDPPC: 6774.576
  CFR: 0.019878
  CaseRate: 16176.534
  DeathRate: 321.554
  PopDensity: 24.961

 
