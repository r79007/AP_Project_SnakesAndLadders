package com.example.ap_project_snakesandladders;

public class Player {
    private String name;
    private Token token;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Token getToken() {
        return this.token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    private boolean isWinner;

    public boolean isWinner() {
        return this.isWinner;
    }

    public void setWinner(boolean winner) {
        isWinner = winner;
    }

    public Player(String name, Token token) {
        this.name = name;
        this.token = token;
    }


}
