import org.kohsuke.github.GHIssueState;
import org.kohsuke.github.GHPullRequest;
import org.refactoringminer.api.GitHistoryRefactoringMiner;
import org.refactoringminer.api.Refactoring;
import org.refactoringminer.api.RefactoringHandler;
import org.refactoringminer.rm1.GitHistoryRefactoringMinerImpl;
import utils.AppUtils;
import utils.GitHubUtils;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.List;

public class RefactorTest {

    GitHistoryRefactoringMiner miner = new GitHistoryRefactoringMinerImpl();

    //Get the repo from file
    List<String> repos = AppUtils.repoList();
    GitHubUtils gitHubUtils = new GitHubUtils();

    public RefactorTest() throws IOException {
    }

    public void start() throws IOException {
        getRefactoringsOnPullRequest();
    }

    private void getRefactoringsOnPullRequest() throws IOException {
        List<GHPullRequest> pullRequests = gitHubUtils.getPullRequestsInRepo(repos.get(0), GHIssueState.ALL);
        File directory = new File("data/");
        if (!directory.exists()) {
            if(directory.mkdir()){
                System.out.println("data directory created");
            };
        }
//        File csvFile = new File(directory + "/Refactoring-" + LocalDateTime.now() + ".csv");
//        PrintWriter out = new PrintWriter(csvFile);

        pullRequests.forEach(pr -> {
            int prId = pr.getNumber();
            System.out.println("ProjectName: " + pr.getRepository().getName() + "PrID: " + prId);
            System.out.println("-------------------------------------------------------");

            try {
                miner.detectAtPullRequest(repos.get(0), prId, new RefactoringHandler() {
                    @Override
                    public void handle(String commitId, List<Refactoring> refactorings) {
                        System.out.println("Refactorings at " + commitId);
                        for (Refactoring ref : refactorings) {
//                            out.printf("%s, %s, %d, %s, %s\n", repos.get(0), pr.getRepository().getName(), prId, ref.getRefactoringType(), ref.getName());
                            System.out.println(ref.toString());
                        }
                    }
                }, 10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

//        out.close();
    }
}
