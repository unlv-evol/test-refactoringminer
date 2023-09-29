package utils;

import org.kohsuke.github.GHIssueState;
import org.kohsuke.github.GHPullRequest;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class GitHubUtils {
    private static final String GITHUB_URL = "https://github.com/";
    private static final String BITBUCKET_URL = "https://bitbucket.org/";
    private GitHub gitHub;

    public GitHubUtils() {

    }

    private static String extractRepositoryName(String cloneURL) {
        int hostLength = 0;
        if (cloneURL.startsWith(GITHUB_URL)) {
            hostLength = GITHUB_URL.length();
        } else if (cloneURL.startsWith(BITBUCKET_URL)) {
            hostLength = BITBUCKET_URL.length();
        }
        int indexOfDotGit = cloneURL.length();
        if (cloneURL.endsWith(".git")) {
            indexOfDotGit = cloneURL.indexOf(".git");
        } else if (cloneURL.endsWith("/")) {
            indexOfDotGit = cloneURL.length() - 1;
        }
        return cloneURL.substring(hostLength, indexOfDotGit);
    }

    private GitHub connectToGitHub() {
        if (gitHub == null) {
            try {
                Properties prop = new Properties();
                InputStream input = new FileInputStream("github-oauth.properties");
                prop.load(input);
                String oAuthToken = prop.getProperty("OAuthToken");
                if (oAuthToken != null) {
                    gitHub = GitHub.connectUsingOAuth(oAuthToken);
                    if (gitHub.isCredentialValid()) {
                        System.out.println("Connected......");
                    }
                } else {
                    gitHub = GitHub.connect();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return gitHub;
    }

    public List<GHPullRequest> getPullRequestsInRepo(String cloneURL, GHIssueState status) throws IOException {

        GitHub gitHub = connectToGitHub();

        String repoName = extractRepositoryName(cloneURL);
        GHRepository repository = gitHub.getRepository(repoName);

        return repository.getPullRequests(status);
    }

}