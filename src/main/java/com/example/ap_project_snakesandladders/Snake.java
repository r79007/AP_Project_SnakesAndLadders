package com.example.ap_project_snakesandladders;

import javafx.scene.shape.Polyline;

import java.util.ArrayList;

public class Snake {
    private int translate_X;
    private int translate_y;
    private int pos;
    private int f_pos;
    ArrayList<Polyline> lines = new ArrayList<>();

    public ArrayList<Polyline> getLines() {
        return lines;
    }

    public void setLines(Polyline l){
        lines.add(l);
    }

    public int getF_pos() {
        return f_pos;
    }

    public void setF_pos(int f_pos) {
        this.f_pos = f_pos;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public int getTranslate_X() {
        return translate_X;
    }

    public void setTranslate_X(int translate_X) {
        this.translate_X = translate_X;
    }

    public int getTranslate_y() {
        return translate_y;
    }

    public void setTranslate_y(int translate_y) {
        this.translate_y = translate_y;
    }
}
