import java.util.*;

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
    }
}

// Voter class
class Voter {
    int id;
    String name;
    boolean voted;
    Voter next;
    Voter prev;

    public Voter(int id, String name) {
        this.id = id;
        this.name = name;
        this.voted = false;
    }
}

// Main class
public class Main {
    private Candidate candidateHead = null;
    private Voter voterHead = null;
    private HashMap<Integer, Candidate> candidateMap = new HashMap<>();
    private HashMap<Integer, Voter> voterMap = new HashMap<>();
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
                case 1 -> addCandidate();
                case 2 -> addVoter();
                case 3 -> deleteCandidate();
                case 4 -> deleteVoter();
                case 5 -> vote();
                case 6 -> displayCandidates();
                case 7 -> displayVoters();
                case 8 -> System.out.println("Exiting program.");
                default -> System.out.println("Invalid choice! Please enter a number between 1 and 8.");
            }
        } while (choice != 8);
    }

    private void addCandidate() {
        System.out.print("Enter Candidate ID: ");
        int id = scanner.nextInt();
        if (candidateMap.containsKey(id)) {
            System.out.println("Candidate ID already exists!");
            return;
        }
        System.out.print("Enter Candidate Name: ");
        String name = scanner.next();

        Candidate newCandidate = new Candidate(id, name);
        candidateMap.put(id, newCandidate);

        // Doubly Linked List insertion
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
        if (voterMap.containsKey(id)) {
            System.out.println("Voter ID already exists!");
            return;
        }
        System.out.print("Enter Voter Name: ");
        String name = scanner.next();

        Voter newVoter = new Voter(id, name);
        voterMap.put(id, newVoter);

        // Doubly Linked List insertion
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
        System.out.print("Enter Candidate ID to delete: ");
        int id = scanner.nextInt();

        Candidate toDelete = candidateMap.get(id);
        if (toDelete == null) {
            System.out.println("Candidate with ID " + id + " not found.");
            return;
        }

        candidateMap.remove(id);

        // Remove from doubly linked list
        if (toDelete.next == toDelete) { // only one candidate
            candidateHead = null;
        } else {
            toDelete.prev.next = toDelete.next;
            toDelete.next.prev = toDelete.prev;
            if (toDelete == candidateHead) candidateHead = toDelete.next;
        }

        System.out.println("Candidate with ID " + id + " deleted successfully.");
    }

    private void deleteVoter() {
        System.out.print("Enter Voter ID to delete: ");
        int id = scanner.nextInt();

        Voter toDelete = voterMap.get(id);
        if (toDelete == null) {
            System.out.println("Voter with ID " + id + " not found.");
            return;
        }

        voterMap.remove(id);

        // Remove from doubly linked list
        if (toDelete.next == toDelete) { // only one voter
            voterHead = null;
        } else {
            toDelete.prev.next = toDelete.next;
            toDelete.next.prev = toDelete.prev;
            if (toDelete == voterHead) voterHead = toDelete.next;
        }

        System.out.println("Voter with ID " + id + " deleted successfully.");
    }

    private void vote() {
        System.out.print("Enter Voter ID: ");
        int voterID = scanner.nextInt();
        System.out.print("Enter Candidate ID to vote for: ");
        int candidateID = scanner.nextInt();

        Voter voter = voterMap.get(voterID);
        if (voter == null) {
            System.out.println("Voter with ID " + voterID + " not found.");
            return;
        }
        if (voter.voted) {
            System.out.println("Voter with ID " + voterID + " has already voted.");
            return;
        }

        Candidate candidate = candidateMap.get(candidateID);
        if (candidate == null) {
            System.out.println("Candidate with ID " + candidateID + " not found.");
            return;
        }

        candidate.votes++;
        voter.voted = true;
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
