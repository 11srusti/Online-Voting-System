import java.util.Scanner;

// Candidate class
class Candidate {
    int id;
    String name;
    int votes;
    Candidate next;
    Candidate prev;
    
    public Candidate(int id, String name) {
        this.id = id;
        this.name = name;
        this.votes = 0;
        this.next = null;
        this.prev = null;
    }
}

// Voter class
class Voter {
    int id;
    String name;
    boolean voted;  // false if not voted, true if voted
    Voter next;
    Voter prev;
    
    public Voter(int id, String name) {
        this.id = id;
        this.name = name;
        this.voted = false;
        this.next = null;
        this.prev = null;
    }
}

// Main class for the voting system
public class Main {
    private Candidate candidateHead = null;
    private Voter voterHead = null;
    private Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        Main system = new Main();
        system.run();
    }
    
    public void run() {
        int choice;
        
        do {
            System.out.println("\nOnline Voting System Menu:");
            System.out.println("1. Add Candidate");
            System.out.println("2. Add Voter");
            System.out.println("3. Delete Candidate");
            System.out.println("4. Delete Voter");
            System.out.println("5. Vote");
            System.out.println("6. Display Candidates");
            System.out.println("7. Display Voters");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    addCandidate();
                    break;
                case 2:
                    addVoter();
                    break;
                case 3:
                    deleteCandidate();
                    break;
                case 4:
                    deleteVoter();
                    break;
                case 5:
                    vote();
                    break;
                case 6:
                    displayCandidates();
                    break;
                case 7:
                    displayVoters();
                    break;
                case 8:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 8.");
            }
        } while (choice != 8);
    }
    
    private void addCandidate() {
        System.out.print("Enter Candidate ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter Candidate Name: ");
        String name = scanner.next();
        
        Candidate newCandidate = new Candidate(id, name);
        
        if (candidateHead == null) {
            candidateHead = newCandidate;
            candidateHead.next = candidateHead;
            candidateHead.prev = candidateHead;
        } else {
            Candidate last = candidateHead.prev;
            last.next = newCandidate;
            newCandidate.prev = last;
            newCandidate.next = candidateHead;
            candidateHead.prev = newCandidate;
        }
        
        System.out.println("Candidate added successfully.");
    }
    
    private void addVoter() {
        System.out.print("Enter Voter ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter Voter Name: ");
        String name = scanner.next();
        
        Voter newVoter = new Voter(id, name);
        
        if (voterHead == null) {
            voterHead = newVoter;
            voterHead.next = voterHead;
            voterHead.prev = voterHead;
        } else {
            Voter last = voterHead.prev;
            last.next = newVoter;
            newVoter.prev = last;
            newVoter.next = voterHead;
            voterHead.prev = newVoter;
        }
        
        System.out.println("Voter added successfully.");
    }
    
    private void deleteCandidate() {
        if (candidateHead == null) {
            System.out.println("Candidate list is empty.");
            return;
        }
        
        System.out.print("Enter Candidate ID to delete: ");
        int id = scanner.nextInt();
        
        Candidate current = candidateHead;
        Candidate prev = null;
        
        do {
            if (current.id == id) {
                if (current.next == current) { // Only one node
                    candidateHead = null;
                } else {
                    if (current == candidateHead) {
                        candidateHead = current.next;
                    }
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                System.out.println("Candidate with ID " + id + " deleted successfully.");
                return;
            }
            prev = current;
            current = current.next;
        } while (current != candidateHead);
        
        System.out.println("Candidate with ID " + id + " not found.");
    }
    
    private void deleteVoter() {
        if (voterHead == null) {
            System.out.println("Voter list is empty.");
            return;
        }
        
        System.out.print("Enter Voter ID to delete: ");
        int id = scanner.nextInt();
        
        Voter current = voterHead;
        Voter prev = null;
        
        do {
            if (current.id == id) {
                if (current.next == current) { // Only one node
                    voterHead = null;
                } else {
                    if (current == voterHead) {
                        voterHead = current.next;
                    }
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                System.out.println("Voter with ID " + id + " deleted successfully.");
                return;
            }
            prev = current;
            current = current.next;
        } while (current != voterHead);
        
        System.out.println("Voter with ID " + id + " not found.");
    }
    
    private void vote() {
        System.out.print("Enter Voter ID: ");
        int voterID = scanner.nextInt();
        System.out.print("Enter Candidate ID to vote for: ");
        int candidateID = scanner.nextInt();
        
        // Find voter
        if (voterHead == null) {
            System.out.println("No voters registered.");
            return;
        }
        
        Voter currentVoter = voterHead;
        do {
            if (currentVoter.id == voterID) {
                break;
            }
            currentVoter = currentVoter.next;
        } while (currentVoter != voterHead);
        
        if (currentVoter.id != voterID) {
            System.out.println("Voter with ID " + voterID + " not found.");
            return;
        }
        
        if (currentVoter.voted) {
            System.out.println("Voter with ID " + voterID + " has already voted.");
            return;
        }
        
        // Find candidate
        if (candidateHead == null) {
            System.out.println("No candidates registered.");
            return;
        }
        
        Candidate currentCandidate = candidateHead;
        do {
            if (currentCandidate.id == candidateID) {
                break;
            }
            currentCandidate = currentCandidate.next;
        } while (currentCandidate != candidateHead);
        
        if (currentCandidate.id != candidateID) {
            System.out.println("Candidate with ID " + candidateID + " not found.");
            return;
        }
        
        // Cast vote
        currentCandidate.votes++;
        currentVoter.voted = true;
        System.out.println("Vote cast successfully.");
    }
    
    private void displayCandidates() {
        if (candidateHead == null) {
            System.out.println("Candidate list is empty.");
            return;
        }
        
        Candidate current = candidateHead;
        do {
            System.out.println("ID: " + current.id + ", Name: " + current.name + ", Votes: " + current.votes);
            current = current.next;
        } while (current != candidateHead);
    }
    
    private void displayVoters() {
        if (voterHead == null) {
            System.out.println("Voter list is empty.");
            return;
        }
        
        Voter current = voterHead;
        do {
            System.out.println("ID: " + current.id + ", Name: " + current.name + ", Voted: " + (current.voted ? "Yes" : "No"));
            current = current.next;
        } while (current != voterHead);
    }
}