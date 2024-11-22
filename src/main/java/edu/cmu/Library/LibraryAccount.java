package edu.cmu.Library;

import javax.management.RuntimeErrorException;

public class LibraryAccount {
    private LibraryService libraryService;
 
    /**
     * Retrieves an array of checked out books associated with the specified user ID. If the user
     * has no books checked out, the returned list will be empty. Since multiple households may
     * share a single account, the user ID is of the form "libraryID:userName".
     * e.g., "12345:John Doe"
     *
     * @param userId the ID of the user whose books are to be retrieved
     * @return an array of Book objects the user has checked out
     */
    public Book[] getBooks(String userId) {
        if (userId == null) {
            throw new IllegalArgumentException("User ID cannot be null");   
        }
        if (!userId.contains(":")) {
            throw new IllegalArgumentException("Invalid user ID format");
        }
        try {
            String[] parts = userId.split(":");
            String name = parts[0];
            String id = parts[1];
            return libraryService.getBooks(name, id); 
        } catch (Exception e) {
            throw new RuntimeErrorException(new Error("An error occurred while retrieving books"));
        }
    }
}
