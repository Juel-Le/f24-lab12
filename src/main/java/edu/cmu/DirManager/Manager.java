package edu.cmu.DirManager;

public class Manager {
    private DirOps dirOps;
    
    /**
     * Creates a new directory at the specified path.
     *
     * @param path the path where the new directory should be created
     * @return 0 if the directory creation was successful
     *        -1 if the directory already exists,
     *        -2 if the path is invalid
     */
    public void newDirectory(String path) throws DirectoryExistsException, InvalidPathException {
        if (dirOps.checkDirectoryExists(path)) {
            throw new DirectoryExistsException("Directory already exists: " + path);
        } else if (!dirOps.checkPathValid(path)) {
            throw new InvalidPathException("Invalid path: " + path);
        }
        dirOps.createDirectory(path);
    }
}

