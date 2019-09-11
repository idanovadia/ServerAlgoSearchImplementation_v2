package com.example.demo.model.ArrayFunc;


/**
 * 0 - EMPTY ROAD
 * 1 - WALL (CANT GO THERE )
 */

public class AState implements Comparable<AState> {
    private String x;
    private String y;
    private AState father ;
    private String content;
    private int weight=1;
    private double distance = 0 ;
    private double sumDis=0;



    public AState(String x, String y) {
        this.x = x;
        this.y = y;
    }
    public AState(String x, String y, String content) {
        this.x = x;
        this.y = y;
        this.content = content;
    }
    public AState(String x, String y, String content,int weight) {
        this.x = x;
        this.y = y;
        this.content = content;
        this.weight = weight;
    }



    public int compareTo(AState employee) {
        if(this.getSumDis() > employee.getSumDis()) {
            return 1;
        } else if (this.getSumDis() < employee.getSumDis()) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public int hashCode() {
        String pos = x+" "+y;
        return pos.hashCode();
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public double getSumDis() {
        return sumDis;
    }

    public void setSumDis(double sumDis) {
        this.sumDis = sumDis;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public AState getFather() {
        return father;
    }

    public void setFather(AState father) {
        this.father = father;
    }

    @Override
    public boolean equals(Object tmp) {
        return this.x.equals(((AState)tmp).getX()) && this.y.equals(((AState)tmp).getY());

    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "\n{" +
                "x='" + getX() + '\'' +
                ", y='" + getY() + '\''+"}";
    }
}
