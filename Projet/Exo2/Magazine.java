package Exo2;

public class Magazine extends LibraryItem {
    private int issueNumber ;

    public Magazine(String title, int publicationYear , int issueNumber) {
        super(title, publicationYear);
        this.issueNumber = issueNumber;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

}
