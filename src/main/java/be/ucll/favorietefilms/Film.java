package be.ucll.favorietefilms;

public class Film {
    private int year, score, IMDBscore;
    private String title, review, IMDBreview;
    public void setTitle(String pTitle){
        this.title = pTitle;
    }
    public String getTitle(){
        return this.title;
    }
    public void setYear(int pYear){
        this.year = pYear;
    }
    public int getYear(){
        return this.year;
    }
    public void setScore(int pScore){
        this.score = pScore;
    }
    public int getScore(){
        return this.score;
    }
    public void setReview(String pReview){
        this.review = pReview;
    }
    public String getReview(){
        return this.review;
    }

    public String getIMDBreview() {
        return this.IMDBreview;
    }

    public void setIMDBreview(String pIMDBreview) {
        this.IMDBreview = pIMDBreview;
    }

    public int getIMDBscore() {
        return this.IMDBscore;
    }

    public void setIMDBscore(int pIMDBscore) {
        this.IMDBscore = pIMDBscore;
    }
}