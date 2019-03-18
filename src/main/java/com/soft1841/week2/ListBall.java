package com.soft1841.week2;

public class ListBall {
    private String name;
    private String nickname;
    private Double score;
    private Double rebounds;  //篮板
    private Double assists;   //助攻

    public ListBall(String name, String nickname, Double score, Double rebounds, Double assists) {
        this.name = name;
        this.nickname = nickname;
        this.score = score;
        this.rebounds = rebounds;
        this.assists = assists;
    }

    public ListBall() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Double getRebounds() {
        return rebounds;
    }

    public void setRebounds(Double rebounds) {
        this.rebounds = rebounds;
    }

    public Double getAssists() {
        return assists;
    }

    public void setAssists(Double assists) {
        this.assists = assists;
    }

    @Override
    public String toString() {
        return "ListBall{" +
                "name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", score='" + score + '\'' +
                ", rebounds='" + rebounds + '\'' +
                ", assists='" + assists + '\'' +
                '}';
    }
}
