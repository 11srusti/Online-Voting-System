# Online-Voting-System
## Online Voting System
A Java-based command-line application that simulates an online voting system with candidate and voter management.
This version uses a hybrid data structure combining HashMap and Circular Doubly Linked List for efficient ID-based operations.

## Overview
This Online Voting System is implemented in Java and provides a complete solution for managing elections.
It features a hybrid data structure:
 - HashMap for O(1) search, insertion, and deletion by ID.
 - Circular Doubly Linked List for ordered traversal of voters and candidates.

This combination allows fast operations while retaining efficient list traversal.

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
    - Hybrid Structure:
        - HashMap: Maps candidate/voter IDs to their respective nodes. O(1) operations for searching, inserting, and deleting by ID.
        - Circular Doubly Linked List: Stores candidates and voters for ordered traversal and management. O(n) traversal for displaying all voters or candidates.

    - Benefits:
       -Constant-time lookup and deletion by ID.
       - Efficient insertion and deletion at known positions
        - Bi-directional traversal of lists
        - Circular structure ensures no null reference at the end

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
3. Main Class<br>
The main class drives the application with a menu-driven interface and manages candidates     and voters using a hybrid HashMap + Circular Doubly Linked List structure.

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
### Main Menu Options
1. Add Candidate: Register a new candidate with ID and name

2. Add Voter: Register a new voter with ID and name

3. Delete Candidate: Remove a candidate by ID

4. Delete Voter: Remove a voter by ID

5. Vote: Cast a vote (requires voter ID and candidate ID)

6. Display Candidates: Show all candidates with their vote counts

7. Display Voters: Show all voters with their voting status

8. Exit: Close the application


## Key Algorithms
1. Hybrid Data Structure
    - Uses HashMaps for fast ID-based access
    - Uses Circular Doubly Linked Lists for ordered traversal

2. Circular List Traversal
    - Uses do-while loops to traverse until returning to the head node

3. Node Insertion
    - Maintains circular references when adding new nodes

4. Node Deletion
    - Efficient removal via HashMap lookup
    - Updates linked list references
    - Handles edge cases (single node, head node deletion)

5. Search Operations
    - Constant-time lookup via HashMap

## Error Handling
The system includes validation for:

- Duplicate voting attempts

- Invalid voter/candidate IDs
- Duplicate voter/candidate IDs

- Empty list display

- Input validation

- Empty lists display

- Input validation
