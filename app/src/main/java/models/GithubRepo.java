package models;

public class GithubRepo {
    String repoName, repoDescription, repoStars, repoIssues, repoForks, repoUpdatedAt;

    public GithubRepo(String repoName, String repoDescription, String repoStars, String repoIssues, String repoForks, String repoUpdatedAt) {
        this.repoName = repoName;
        this.repoDescription = repoDescription;
        this.repoStars = repoStars;
        this.repoIssues = repoIssues;
        this.repoForks = repoForks;
        this.repoUpdatedAt = repoUpdatedAt;
    }

    public String getRepoName() {
        return repoName;
    }

    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }

    public String getRepoDescription() {
        return repoDescription;
    }

    public void setRepoDescription(String repoDescription) {
        this.repoDescription = repoDescription;
    }

    public String getRepoStars() {
        return repoStars;
    }

    public void setRepoStars(String repoStars) {
        this.repoStars = repoStars;
    }

    public String getRepoIssues() {
        return repoIssues;
    }

    public void setRepoIssues(String repoIssues) {
        this.repoIssues = repoIssues;
    }

    public String getRepoForks() {
        return repoForks;
    }

    public void setRepoForks(String repoForks) {
        this.repoForks = repoForks;
    }

    public String getRepoUpdatedAt() {
        return repoUpdatedAt;
    }

    public void setRepoUpdatedAt(String repoUpdatedAt) {
        this.repoUpdatedAt = repoUpdatedAt;
    }
}


