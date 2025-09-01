# Online-Voting-System
## Online Voting System
A Java-based command-line application that simulates an online voting system with candidate and voter management.

## Overview
This Online Voting System is implemented in Java and provides a complete solution for managing elections. It features a circular doubly-linked list data structure for efficient management of candidates and voters, allowing for basic CRUD operations and voting functionality.

## Features
1. Candidate Management
    - Add new candidates with unique IDs
    - Delete existing candidates
   - View all candidates with their vote counts
   - Each candidate has: ID, Name, Vote count

2. Voter Management
    - Register new voters with unique IDs
    - Delete voter records
    - View all voters and their voting status
    - Each voter has: ID, Name, Voting status (voted/not voted)

3. Voting System
   - Secure voting process that prevents duplicate voting
   -  Validation to ensure only registered voters can vote
    - Validation to ensure votes are cast for valid candidates
    - Real-time vote counting

4. Data Structure
    - Circular Doubly-Linked List implementation for both candidates and voters
    - Efficient traversal and management of records
    - Memory efficient design

## Technical Details
### Classes
1. Candidate Class
    ```
    class Candidate {
        int id;          // Unique candidate identifier
        String name;     // Candidate name
        int votes;       // Number of votes received
        Candidate next;  // Reference to next candidate
        Candidate prev;  // Reference to previous candidate
    }
2. Voter Class
   ```
    class Voter {
        int id;          // Unique voter identifier
        String name;     // Voter name
        boolean voted;   // Voting status (true if voted)
        Voter next;      // Reference to next voter
        Voter prev;      // Reference to previous voter
    }
3. Main Class
The main class that drives the application with menu-driven interface.

### Data Structure
- Circular Doubly-Linked List: Both candidates and voters are stored in this structure

- Benefits:

    - Efficient insertion and deletion (O(1) for known nodes)
    
    - Bi-directional traversal

    - No end nodes (circular nature)

## Installation & Setup
### Prerequisites
  - Java Development Kit (JDK) 8 or higher
  
  - Git (for version control)

### Steps to Run
1. Clone the repository:

    ```
    git clone https://github.com/11srusti/Online-Voting-System.git
    cd Online-Voting-System
2. Compile the Java code:

    ```
    javac Main.java
3. Run the application:

    ```
    java Main
## Usage Guide
###Main Menu Options
1. Add Candidate: Register a new candidate with ID and name

2. Add Voter: Register a new voter with ID and name

3. Delete Candidate: Remove a candidate by ID

4. Delete Voter: Remove a voter by ID

5. Vote: Cast a vote (requires voter ID and candidate ID)

6. Display Candidates: Show all candidates with their vote counts

7. Display Voters: Show all voters with their voting status

8. Exit: Close the application


## Key Algorithms
1. Circular List Traversal: Using do-while loops with current != head condition

2.Node Insertion: Maintaining circular references when adding new nodes

3. Node Deletion: Handling edge cases (single node, head node deletion)

4. Search Operations: Linear search through circular lists

## Error Handling
The system includes validation for:

- Duplicate voting attempts

- Invalid voter/candidate IDs

- Empty lists display

- Input validation
