import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class RepositoryTest {
    private Repository repo1;
    private Repository repo2;

    /**
     * NOTE: The following test suite assumes that getRepoHead(), commit(), and size()
     *       are implemented correctly.
     */

    @BeforeEach
    public void setUp() {
        repo1 = new Repository("repo1");
        repo2 = new Repository("repo2");
        Repository.Commit.resetIds();
    }

    @Test
    @DisplayName("Test Constructor()")
    public void testConstructor() {
        // Test for IllegalArgumentException if repo name is null or "".
        assertThrows(IllegalArgumentException.class, () -> {
            new Repository(null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Repository("");
        });

        // Check that constructor head is null.
        assertNull(repo1.getRepoHead());
        assertNull(repo2.getRepoHead());
    }

    @Test
    @DisplayName("Test commit()")
    public void testCommit() {
        // Check repo size and head for an empty repo.
        assertEquals(0, repo1.getRepoSize());
        assertNull(repo1.getRepoHead());

        // Create a commit and check repo size, head, and return commit ID.
        String commitId1 = repo1.commit("Test Commit 1");
        assertEquals(commitId1, repo1.getRepoHead());
        assertEquals(1, repo1.getRepoSize());
        assertTrue(repo1.contains(commitId1));

        // Create second commit and check repo size, head, and return commit ID.
        String commitId2 = repo1.commit("Test Commit 2");
        assertEquals(commitId2, repo1.getRepoHead());
        assertEquals(2, repo1.getRepoSize());
        assertTrue(repo1.contains(commitId2));
    }

    @Test
    @DisplayName("Test getRepoHead()")
    public void testGetRepoHead() {
        // Check 'getRepoHead' for an empty repository.
        assertNull(repo1.getRepoHead());

        // Create a commit and check for repo head.
        String commitId1 = repo1.commit("Test Commit");
        assertEquals(commitId1, repo1.getRepoHead());

        // Create a second commit and check for repo head.
        String commitId2 = repo1.commit("Test Commit");
        assertEquals(commitId2, repo1.getRepoHead());

        // Drop most recent commit and check for repo head.
        repo1.drop(commitId2);
        assertEquals(commitId1, repo1.getRepoHead());
    }

    @Test
    @DisplayName("Test getRepoSize()")
    public void testGetRepoSize() {
        // Check 'getRepoSize' for an empty repo.
        assertEquals(0, repo1.getRepoSize());

        // Create a commit and check for size.
        String commitId = repo1.commit("Test Commit 1");
        assertEquals(1, repo1.getRepoSize());

        // Create another commit and check for size.
        repo1.commit("Test Commit 2");
        assertEquals(2, repo1.getRepoSize());

        // Drop a commit and check for size.
        repo1.drop(commitId);
        assertEquals(1, repo1.getRepoSize());
    }

    @Test
    @DisplayName("Test toString()")
    public void testToString() {
        // Check 'toString' for an empty repo.
        assertEquals("repo1 - No commits", repo1.toString());

        // Create a new commit and check 'toString'.
        String commitId1 = repo1.commit("First commit");
        assertTrue(repo1.toString().startsWith("repo1 - Current head: " + commitId1 + " at "));

        // Create a second commit.
        String commitId2 = repo1.commit("Second commit");
        assertTrue(repo1.toString().startsWith("repo1 - Current head: " + commitId2 + " at "));
    }

    @Test
    @DisplayName("Test contains()")
    public void testContains() {
        // Check 'contains' for an empty repo.
        assertFalse(repo1.contains("0"));

        // Create a commit and check if it is contained.
        String commitId1 = repo1.commit("Test Commit 1");
        assertTrue(repo1.contains(commitId1));

        // Create another commit and check if both are contained.
        String commitId2 = repo1.commit("Test Commit 2");
        assertTrue(repo1.contains(commitId1));
        assertTrue(repo1.contains(commitId2));

        // Drop a commit and test that it doesn't contain it.
        repo1.drop(commitId1);
        assertFalse(repo1.contains(commitId1));

        // Check for a non-existent ID.
        assertFalse(repo1.contains("NULL"));
    }

    @Test
    @DisplayName("Test getHistory()")
    public void getHistory() {
        // Test that `getHistory` throws an IllegalArgumentException if n <= 0.
        assertThrows(IllegalArgumentException.class, () -> {
            repo1.getHistory(0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            repo1.getHistory(-1);
        });

        // Initialize commit messages
        String[] commitMessages = new String[]{"Initial commit.", "Updated method documentation.",
                                                "Removed unnecessary object creation."};

        // Commit the commit messages to repo1
        for (int i = 0; i < commitMessages.length; i++) {
            String commitMessage = commitMessages[i];
            repo1.commit(commitMessage);

            // Assert that the current commit id is at the repository's head
            // We know our ids increment from 0, meaning we can just use i as our id
            assertEquals("" + i, repo1.getRepoHead());
        }

        assertEquals(repo1.getRepoSize(), commitMessages.length);

        // This is the method we are testing for. First, we'll obtain the 2 most recent commits
        // that have been made to repo1.
        String repositoryHistory = repo1.getHistory(2);
        String[] commits = repositoryHistory.split("\n");

        // Verify that getHistory() only returned 2 commits.
        assertEquals(commits.length, 2);

        // Verify that the 2 commits have the correct commit message and commit id
        for (int i = 0; i < commits.length; i++) {
            String commit = commits[i];

            // Old commit messages/ids are on the left and the more recent commit messages/ids are
            // on the right so need to traverse from right to left to ensure that 
            // getHistory() returned the 2 most recent commits.
            int backwardsIndex = (commitMessages.length - 1) - i;
            String commitMessage = commitMessages[backwardsIndex];

            assertTrue(commit.contains(commitMessage));
            assertTrue(commit.contains("" + backwardsIndex));
        }
    }

        @Test
    @DisplayName("Test drop()")
    public void testDrop() {
        // Try to drop a commit from an empty repo.
        assertFalse(repo1.drop("0"));

        // Check if repo size is 0.
        assertEquals(repo1.getRepoSize(), 0);

        // Create a commit and try to drop non-existent commit
        String commitId1 = repo1.commit("Test Commit 1");
        assertFalse(repo1.drop("NULL"));

        // Check that repo size is 1.
        assertEquals(repo1.getRepoSize(), 1);

        // Create second commit and drop it (Drop first commit).
        String commitId2 = repo1.commit("Test Commit 2");
        assertTrue(repo1.drop(commitId2));

        // Check that repo size is still 1.
        assertEquals(repo1.getRepoSize(), 1);

        // Create a third commit, drop the first (Drop last commit).
        repo1.commit("Third Commit");
        assertTrue(repo1.drop(commitId1));
        assertFalse(repo1.contains(commitId1));

        // Check that repo size is still 1.
        assertEquals(repo1.getRepoSize(), 1);

        // Test dropping the middle commit.
        String commitId4 = repo1.commit("Fourth Commit");
        repo1.commit("Fifth Commit");
        assertTrue(repo1.drop(commitId4));
        assertFalse(repo1.contains(commitId4));
    }

    /**
     * Test synchronize when repo 2 has no commits.
     */
    @Test
    @DisplayName("Test synchronize() (Other Empty)")
    public void testSynchronizeOtherEmpty() {
        String commitId = repo1.commit("Commit 1");
        repo1.synchronize(repo2);
        assertEquals(1, repo1.getRepoSize());
        assertEquals(0, repo2.getRepoSize());
        assertEquals(commitId, repo1.getRepoHead());
    }

    /**
     * Test synchronize when repo 1 has no commits.
     */
    @Test
    @DisplayName("Test synchronize() (This Empty)")
    public void testSynchronizeThisEmpty() {
        String commitId = repo2.commit("Commit 1");
        repo1.synchronize(repo2);
        assertEquals(1, repo1.getRepoSize());
        assertEquals(0, repo2.getRepoSize());
        assertEquals(commitId, repo1.getRepoHead());
    }

    /**
     * Test synchronize when repo 2 has earlier commits.
     */
    @Test
    @DisplayName("Test synchronize() (Earlier)")
    public void testSynchronizeEarlier() throws InterruptedException {
        // Set up commits.
        String[] commitIds = new String[4];
        commitIds[3] = commitAndWait(repo2, "Commit 1");
        commitIds[2] = commitAndWait(repo2, "Commit 2");
        commitIds[1] = commitAndWait(repo1, "Commit 3");
        commitIds[0] = commitAndWait(repo1, "Commit 4");
        repo1.synchronize(repo2);

        // Test for size after synchronize.
        assertEquals(4, repo1.getRepoSize());
        assertEquals(0, repo2.getRepoSize());

        // Test for correct order of commits.
        String repositoryHistory = repo1.getHistory(4);
        String[] commits = repositoryHistory.split("\n");
        for (int i = 0; i < 4; i++) {
            assertTrue(commits[i].startsWith(commitIds[i]));
        }
    }

    /**
     * Test synchronize when repo 2 has later commits.
     */
    @Test
    @DisplayName("Test synchronize() (Later)")
    public void testSynchronizeLater() throws InterruptedException {
        // Set up commits.
        String[] commitIds = new String[4];
        commitIds[3] = commitAndWait(repo1, "Commit 1");
        commitIds[2] = commitAndWait(repo1, "Commit 2");
        commitIds[1] = commitAndWait(repo2, "Commit 3");
        commitIds[0] = commitAndWait(repo2, "Commit 4");
        repo1.synchronize(repo2);

        // Test for size after synchronize.
        assertEquals(4, repo1.getRepoSize());
        assertEquals(0, repo2.getRepoSize());

        // Test for correct order of commits.
        String repositoryHistory = repo1.getHistory(4);
        String[] commits = repositoryHistory.split("\n");
        for (int i = 0; i < 4; i++) {
            assertTrue(commits[i].startsWith(commitIds[i]));
        }
    }

    /**
     * Test for a combination of commits in both repos.
     */
    @Test
    @DisplayName("Test synchronize()")
    public void testSynchronize() throws InterruptedException {
        // Set up commits.
        String[] commitIds = new String[6];
        commitIds[5] = commitAndWait(repo2, "Commit 1");
        commitIds[4] = commitAndWait(repo2, "Commit 2");
        commitIds[3] = commitAndWait(repo1, "Commit 3");
        commitIds[2] = commitAndWait(repo1, "Commit 4");
        commitIds[1] = commitAndWait(repo2, "Commit 5");
        commitIds[0] = commitAndWait(repo1, "Commit 6");
        repo1.synchronize(repo2);

        // Test for size after synchronize.
        assertEquals(6, repo1.getRepoSize());
        assertEquals(0, repo2.getRepoSize());

        // Test for correct order of commits.
        String repositoryHistory = repo1.getHistory(6);
        String[] commits = repositoryHistory.split("\n");
        for (int i = 0; i < 6; i++) {
            assertTrue(commits[i].startsWith(commitIds[i]));
        }
    }

    private String commitAndWait(Repository repo, String message) throws InterruptedException {
        String commitId = repo.commit(message);
        Thread.sleep(1);
        return commitId;
    }
}
